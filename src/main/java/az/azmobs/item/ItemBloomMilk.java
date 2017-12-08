package az.azmobs.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class ItemBloomMilk extends ItemFood {
    public String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public ItemBloomMilk() {
        super(3, 0.6f, false);
        this.setMaxStackSize(1);
        setUnlocalizedName(ID + "." + "bloom_milk");
        setRegistryName("bloom_milk");
        setCreativeTab(CreativeTabs.FOOD);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        EntityPlayer player = entityLiving instanceof EntityPlayer ? (EntityPlayer) entityLiving : null;

        if (player != null) {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }

        if (player != null && !player.capabilities.isCreativeMode) {
            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.BOWL))) {
                player.dropItem(new ItemStack(Items.BOWL), false);
            }
        }

        if (player == null || !player.capabilities.isCreativeMode) {
            stack.shrink(1);
        }

        return stack;
    }
}
