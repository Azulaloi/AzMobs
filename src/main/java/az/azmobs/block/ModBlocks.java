package az.azmobs.block;

import az.azmobs.AzMobs;
import az.azmobs.block.tile.TileGildedSkull;
import az.azmobs.proxy.ClientProxy;
import az.azmobs.util.AzUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = AzMobs.MODID)
public class ModBlocks {

    public static BlockGildedSkull guildedSkull = new BlockGildedSkull();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
            guildedSkull
        );

        GameRegistry.registerTileEntity(TileGildedSkull.class, AzMobs.MODID + ".gilded_skull");

        guildedSkull.regSpecialModelMapper();
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
//        AzUtil.registerItemBlocks(event.getRegistry(),
//
//        );

        if (AzMobs.proxy instanceof ClientProxy) {
            AzUtil.registerItemModels(

            );
        }
    }
}
