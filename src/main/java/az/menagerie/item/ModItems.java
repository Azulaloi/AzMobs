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

    public static BaseItem gildedBone = new BaseItem("gilded_bone", CreativeTabs.MISC);
    public static ItemGildedSkull gildedSkull = new ItemGildedSkull();
//    public static BaseItem bloomMilk = new BaseItem("bloom_milk", CreativeTabs.FOOD);
    public static ItemBloomMilk bloomMilk = new ItemBloomMilk();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                gildedBone,
                gildedSkull,
                bloomMilk
        );

        if (Menagerie.proxy instanceof ClientProxy) {
            AzUtil.registerItemModels(
                    gildedBone,
                    gildedSkull,
                    bloomMilk
            );

            gildedSkull.regSpecialModel();
        }
    }
}
