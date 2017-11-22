package az.azmobs.entity;

import az.azmobs.AzMobs;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityGelum extends EntityOcelot {
    public EntityGelum(World world) {
        super(world);
        this.experienceValue = 5;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
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
