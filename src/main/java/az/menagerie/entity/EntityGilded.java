package az.menagerie.entity;

import az.menagerie.Menagerie;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGilded extends EntitySkeleton {
    public EntityGilded(World world) {
        super(world);
        this.experienceValue = 18;
    } //TODO: Make an acceptable texture

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        if (this.rand.nextInt(3) == 0) {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
        } else {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.extinguish();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation (Menagerie.MODID + ":mobs/gilded");
    } //TODO: Add gilded skull
}
