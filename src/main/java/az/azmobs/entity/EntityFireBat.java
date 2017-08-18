package az.azmobs.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Azulaloi on 8/18/2017
 */
public class EntityFireBat extends EntityBat {
    private static final DataParameter<Byte> HANGING = EntityDataManager.<Byte>createKey(EntityBat.class, DataSerializers.BYTE);

    public EntityFireBat(World world){
        super(world);
        this.setSize(0.5F, 0.9F);
        this.isImmuneToFire = true;
    }

    protected void entityInit(){
        super.entityInit();
        this.dataManager.register(HANGING, Byte.valueOf((byte)0));
    }

    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D); //3 hearts
    }

    protected void initEntityAI(){
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
    }

    @Override
    protected void updateAITasks(){
        Entity target = this.getAttackTarget();
        if (target == null || target.isDead){
            super.updateAITasks();
        } else if (target != null) { //Target is not, in fact, always true
            //Based off of vanilla bat pathing.
            double xP = target.posX + 0.0D - posX;
            double yP = target.posY + 0.7D - posY;
            double zP = target.posZ + 0.0D - posZ;
            motionX += (Math.signum(xP) * 0.4D - motionX) * 0.1D; //I doubt 0.00000000149011612 was important
            motionY += (Math.signum(yP) * 0.7D - motionY) * 0.1D;
            motionZ += (Math.signum(zP) * 0.4D - motionZ) * 0.1D;
            rotationYaw += MathHelper.wrapDegrees((float) (Math.atan2(motionZ, motionX) * 180D / Math.PI) - 90F - rotationYaw); //Collapsed is better, right?
            moveForward = 1.5F; //Too fast?
        }
    }

    @Override
    public void onLivingUpdate(){
        super.onLivingUpdate();
        if (this.world.isRemote) {
            if (this.rand.nextInt(5) == 0) { //
                this.world.spawnParticle(EnumParticleTypes.FLAME,
                                         this.posX + (this.rand.nextDouble() * 0.8D) * (double) this.width,
                                         (this.posY + ((double) this.height / 2)) + (this.rand.nextDouble() * 0.6D) * (double) this.height,
                                         this.posZ + (this.rand.nextDouble() * 1.2D) * (double) this.width,
                                         0.0F, 0.0F, 0.0F);
            }
        }
    }
    @Override
    public void setIsBatHanging(boolean isBatHanging){
        //no.
    }

    @Override
    public boolean getIsBatHanging(){
        return false;
    }

    @Override
    public boolean canBePushed(){
        return true;
    }

    @Override
    protected void collideWithNearbyEntities() { //EntityBat is one of only two classes to override this method, so I have to reimplement it.
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());

        if (!list.isEmpty()) {
            for (Entity entity : list) {
                this.collideWithEntity(entity);
            }
        }
    }

    @Override
    protected void collideWithEntity(Entity entity){ //The retardo method of attacking
        entity.applyEntityCollision(this);

        if (entity == this.getAttackTarget()){
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2.0F);
        }
    }
}
