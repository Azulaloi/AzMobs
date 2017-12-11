package az.menagerie.entity;

import az.menagerie.Menagerie;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityDuck extends EntityChicken {
    public EntityDuck(World world) {
        super(world);
        this.experienceValue = 3;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(Menagerie.MODID + ":mobs/duck");
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.BEETROOT_SEEDS;
    }

    public EntityDuck createChild(EntityAgeable ageable) {
        return new EntityDuck(this.world);
    }

}
