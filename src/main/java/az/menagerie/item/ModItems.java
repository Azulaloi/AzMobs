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
    public static ItemBloomMilk bloomMilk = new ItemBloomMilk();
    public static ItemDuckMeat duckMeatRaw = new ItemDuckMeat("duck_raw", true, 1, 0);
    public static ItemDuckMeat duckMeatCooked = new ItemDuckMeat("duck_cooked", false, 6, 3);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                gildedBone,
                gildedSkull,
                bloomMilk,
                duckMeatRaw,
                duckMeatCooked
        );

        if (Menagerie.proxy instanceof ClientProxy) {
            AzUtil.registerItemModels(
                    gildedBone,
                    gildedSkull,
                    bloomMilk,
                    duckMeatRaw,
                    duckMeatCooked
            );

            gildedSkull.regSpecialModel();
        }
    }
}
