package az.azmobs.entity;

import az.azmobs.AzMobs;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Azulaloi on 8/18/2017
 */
public class EntityGilded extends EntitySkeleton {
    public EntityGilded(World worldIn) {
        super(worldIn);
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty){
        super.setEquipmentBasedOnDifficulty(difficulty);
        if (this.rand.nextInt(3) == 0) {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
        } else {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation (AzMobs.MODID + ":mobs/gilded");
    }
}
