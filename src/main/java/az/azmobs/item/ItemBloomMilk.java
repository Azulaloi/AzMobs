package az.azmobs.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }
}
