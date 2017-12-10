package az.menagerie.item;

import az.menagerie.Menagerie;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemDuckMeat extends ItemFood {
    public ItemDuckMeat (String name, boolean isRaw, int hunger, float saturation) {
        super(hunger, saturation, true);
        setRegistryName(Menagerie.MODID, name);
        setUnlocalizedName(Menagerie.MODID + "." + name);
        setCreativeTab(CreativeTabs.FOOD);
        if (isRaw) {
            setPotionEffect(new PotionEffect(Potion.getPotionById(17), 30), 30);
        }
    }
}
