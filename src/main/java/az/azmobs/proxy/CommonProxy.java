package az.azmobs.proxy;

import az.azmobs.Config;
import az.azmobs.entity.ModEntities;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

/**
 * Created by Azulaloi on 8/18/2017.
 */
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event){
        File dir = event.getSuggestedConfigurationFile();
        config = new Configuration(new File(dir.getPath()));
        Config.initConfig();

        ModEntities.initConfig();
        ModEntities.init();
    }

    public void init(FMLInitializationEvent event){
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
