package az.azmobs.proxy;

import az.azmobs.block.tile.TileGildedSkull;
import az.azmobs.entity.ModEntities;
import az.azmobs.render.tile.TileGildedSkullRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void  preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ModEntities.initModels();
        ClientRegistry.bindTileEntitySpecialRenderer(TileGildedSkull.class, new TileGildedSkullRenderer());
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }
}
