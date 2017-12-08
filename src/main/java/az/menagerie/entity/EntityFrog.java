package az.menagerie.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class EntityFrog extends EntityAnimal {
    private int jumpTicks;
    private int jumpDuration;
    private boolean wasOnGround;
    private int currentMoveTypeDuration;

    public EntityFrog(World worldIn) {
        super(worldIn);
        this.setSize(0.4F, 0.5F);
        this.jumpHelper = new EntityFrog.FrogJumpHelper(this);
        this.moveHelper = new EntityFrog.FrogMoveHelper(this);
        this.setMovementSpeed(0.0D);
    }

    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityFrog.AIPanic(this, 2.2D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.jumpTicks != this.jumpDuration)
        {
            ++this.jumpTicks;
        }
        else if (this.jumpDuration != 0)
        {
            this.jumpTicks = 0;
            this.jumpDuration = 0;
            this.setJumping(false);
        }
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        EntityFrog frog = new EntityFrog(this.world);
        return frog;
    }

    protected float getJumpUpwardsMotion()
    {
        if (!this.isCollidedHorizontally && (!this.moveHelper.isUpdating() || this.moveHelper.getY() <= this.posY + 0.5D))
        {
            Path path = this.navigator.getPath();

            if (path != null && path.getCurrentPathIndex() < path.getCurrentPathLength())
            {
                Vec3d vec3d = path.getPosition(this);

                if (vec3d.y > this.posY + 0.5D)
                {
                    return 0.5F;
                }
            }

            return this.moveHelper.getSpeed() <= 0.6D ? 0.2F : 0.3F;
        }
        else
        {
            return 0.5F;
        }
    }

    protected void jump()
    {
        super.jump();
        double d0 = this.moveHelper.getSpeed();

        if (d0 > 0.0D)
        {
            double d1 = this.motionX * this.motionX + this.motionZ * this.motionZ;

            if (d1 < 0.010000000000000002D)
            {
                this.moveRelative(0.0F, 0.0F, 1.0F, 0.1F);
            }
        }

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)1);
        }
    }

    @SideOnly(Side.CLIENT)
    public float setJumpCompletion(float p_175521_1_)
    {
        return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + p_175521_1_) / (float)this.jumpDuration;
    }

    public void updateAITasks() {
        if (this.currentMoveTypeDuration > 0) {
            --this.currentMoveTypeDuration;
        }

        if (this.onGround) {
            if (!this.wasOnGround) {
                this.setJumping(false);
                this.checkLandingDelay();
            }


            EntityFrog.FrogJumpHelper entityrabbit$rabbitjumphelper = (EntityFrog.FrogJumpHelper)this.jumpHelper;

            if (!entityrabbit$rabbitjumphelper.getIsJumping()) {
                if (this.moveHelper.isUpdating() && this.currentMoveTypeDuration == 0) {
                    Path path = this.navigator.getPath();
                    Vec3d vec3d = new Vec3d(this.moveHelper.getX(), this.moveHelper.getY(), this.moveHelper.getZ());

                    if (path != null && path.getCurrentPathIndex() < path.getCurrentPathLength()) {
                        vec3d = path.getPosition(this);
                    }

                    this.calculateRotationYaw(vec3d.x, vec3d.z);
                    this.startJumping();
                }
            } else if (!entityrabbit$rabbitjumphelper.canJump()) {
                this.enableJumpControl();
            }
        }

        this.wasOnGround = this.onGround;
    }

    private void calculateRotationYaw(double x, double z) {
        this.rotationYaw = (float)(MathHelper.atan2(z - this.posZ, x - this.posX) * (180D / Math.PI)) - 90.0F;
    }

    public void setMovementSpeed(double newSpeed)
    {
        this.getNavigator().setSpeed(newSpeed);
        this.moveHelper.setMoveTo(this.moveHelper.getX(), this.moveHelper.getY(), this.moveHelper.getZ(), newSpeed);
    }

    public void setJumping(boolean jumping)
    {
        super.setJumping(jumping);

        if (jumping)
        {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
        }
    }

    public void startJumping()
    {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }

    private void checkLandingDelay()
    {
        this.updateMoveTypeDuration();
        this.disableJumpControl();
    }

    private void updateMoveTypeDuration()
    {
        if (this.moveHelper.getSpeed() < 2.2D)
        {
            this.currentMoveTypeDuration = 10;
        }
        else
        {
            this.currentMoveTypeDuration = 1;
        }
    }

    private void enableJumpControl() {
        ((EntityFrog.FrogJumpHelper)this.jumpHelper).setCanJump(true);
    }

    private void disableJumpControl()
    {
        ((EntityFrog.FrogJumpHelper)this.jumpHelper).setCanJump(false);
    }

    public class FrogJumpHelper extends EntityJumpHelper {
        private final EntityFrog frog;
        private boolean canJump;

        public FrogJumpHelper(EntityFrog frog) {
            super(frog);
            this.frog = frog;
        }

        public boolean getIsJumping()
        {
            return this.isJumping;
        }

        public boolean canJump()
        {
            return this.canJump;
        }

        public void setCanJump(boolean canJumpIn)
        {
            this.canJump = canJumpIn;
        }

        /**
         * Called to actually make the entity jump if isJumping is true.
         */
        public void doJump()
        {
            if (this.isJumping)
            {
                this.frog.startJumping();
                this.isJumping = false;
            }
        }
    }

    static class FrogMoveHelper extends EntityMoveHelper
    {
        private final EntityFrog frog;
        private double nextJumpSpeed;

        public FrogMoveHelper(EntityFrog frog)
        {
            super(frog);
            this.frog = frog;
        }

        public void onUpdateMoveHelper()
        {
            if (this.frog.onGround && !this.frog.isJumping && !((EntityFrog.FrogJumpHelper)this.frog.jumpHelper).getIsJumping())
            {
                this.frog.setMovementSpeed(0.0D);
            }
            else if (this.isUpdating())
            {
                this.frog.setMovementSpeed(this.nextJumpSpeed);
            }

            super.onUpdateMoveHelper();
        }

        /**
         * Sets the speed and location to move to
         */
        public void setMoveTo(double x, double y, double z, double speedIn)
        {
            if (this.frog.isInWater())
            {
                speedIn = 1.5D;
            }

            super.setMoveTo(x, y, z, speedIn);

            if (speedIn > 0.0D)
            {
                this.nextJumpSpeed = speedIn;
            }
        }
    }

    static class AIPanic extends EntityAIPanic {
        private final EntityFrog frog;

        public AIPanic(EntityFrog frog, double speedIn) {
            super(frog, speedIn);
            this.frog = frog;
        }

        public void updateTask() {
            super.updateTask();
            this.frog.setMovementSpeed(this.speed);
        }
    }


    //SOUNDS
    protected SoundEvent getJumpSound()
    {
        return SoundEvents.ENTITY_RABBIT_JUMP;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_RABBIT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return SoundEvents.ENTITY_RABBIT_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_RABBIT_DEATH;
    }

    public SoundCategory getSoundCategory()
    {
        return SoundCategory.NEUTRAL;
    }
}
