package az.azmobs.entity;

import az.azmobs.AzMobs;
import az.azmobs.entity.ai.EntityAIFollowOwnerFX;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityGelum extends EntityOcelot {
    private EntityAITempt aiTempt;

    public EntityGelum(World world) {
        super(world);
        this.experienceValue = 5;
    }

    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.aiTempt = new EntityAITempt(this, 0.6D, Items.FISH, true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, this.aiTempt);
        this.tasks.addTask(5, new EntityAIFollowOwnerFX(this, 1.0D, 2.0F, 5.0F));
        this.tasks.addTask(6, new EntityAIOcelotSit(this, 0.8D));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(9, new EntityAIMate(this, 0.8D));
        this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.targetTasks.addTask(1, new EntityAITargetNonTamed(this, EntityChicken.class, false, (Predicate)null));
    }


    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(AzMobs.MODID + ":mobs/gelum");
    }

    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        } else {
            return super.getName();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack.getItem() == Items.GHAST_TEAR;
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        } else if (!(otherAnimal instanceof EntityGelum)) {
            return false;
        } else {
            EntityGelum entityGelum = (EntityGelum)otherAnimal;

            if(!entityGelum.isTamed()) {
                return false;
            } else {
                return this.isInLove() && entityGelum.isInLove();
            }
        }
    }

    @Override
    public EntityGelum createChild(EntityAgeable ageable) {
        EntityGelum entityGelum = new EntityGelum(this.world);

        if (this.isTamed()) {
            entityGelum.setOwnerId(this.getOwnerId());
            entityGelum.setTamed(true);
            entityGelum.setTameSkin(this.getTameSkin());
        }

        return entityGelum;
    }
}
