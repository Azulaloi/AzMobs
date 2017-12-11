package az.menagerie.item;

import az.menagerie.Menagerie;
import az.menagerie.proxy.ClientProxy;
import az.menagerie.util.AzUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Menagerie.MODID)
public class ModItems {

    //Gilded
    public static BaseItem gildedBone = new BaseItem("gilded_bone", CreativeTabs.MISC);
    public static ItemGildedSkull gildedSkull = new ItemGildedSkull();

    //Moobloom
    public static ItemBloomMilk bloomMilk = new ItemBloomMilk();

    //Duck
    public static ItemDuckMeat duckMeatRaw = new ItemDuckMeat("duck_raw", true, 1, 0);
    public static ItemDuckMeat duckMeatCooked = new ItemDuckMeat("duck_cooked", false, 6, 3);
    public static BaseItem fuckDeather = new BaseItem("duck_feather", CreativeTabs.MATERIALS);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                gildedBone,
                gildedSkull,
                bloomMilk,
                duckMeatRaw,
                duckMeatCooked,
                fuckDeather
        );

        if (Menagerie.proxy instanceof ClientProxy) {
            AzUtil.registerItemModels(
                    gildedBone,
                    gildedSkull,
                    bloomMilk,
                    duckMeatRaw,
                    duckMeatCooked,
                    fuckDeather
            );

            gildedSkull.regSpecialModel();
        }
    }
}
