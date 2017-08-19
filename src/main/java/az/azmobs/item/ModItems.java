package az.azmobs.item;

import az.azmobs.AzMobs;
import az.azmobs.proxy.ClientProxy;
import az.azmobs.util.AzUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = AzMobs.MODID)
public class ModItems {

    public static BaseItem gildedBone = new BaseItem("gildedbone", CreativeTabs.MISC);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                gildedBone
        );

        if (AzMobs.proxy instanceof ClientProxy) {
            AzUtil.registerItemModel(gildedBone);
        }
    }
}
