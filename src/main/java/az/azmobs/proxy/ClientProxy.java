package az.azmobs.proxy;

import az.azmobs.entity.ModEntities;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Azulaloi on 8/18/2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void  preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        ModEntities.initModels();
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
