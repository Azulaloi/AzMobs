package az.azmobs.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;

public class BaseItem extends Item {
    public String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public BaseItem(String name, CreativeTabs creativeTab) {
        setUnlocalizedName(ID + "." + name);
        setRegistryName(name);
        if (creativeTab != null) {
            setCreativeTab(creativeTab);
        }
    }

    public BaseItem(String name) {
        setUnlocalizedName(ID + "." + name);
        setRegistryName(name);
    }
}
