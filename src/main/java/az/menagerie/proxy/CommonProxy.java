package az.menagerie.proxy;

import az.menagerie.Config;
import az.menagerie.entity.ModEntities;
import az.menagerie.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        File dir = event.getSuggestedConfigurationFile();
        config = new Configuration(new File(dir.getPath()));
        Config.initConfig();

        ModEntities.initConfig();
        ModEntities.init();
    }

    public void init(FMLInitializationEvent event) {
        //This is injected during init, so the amount is set, however, it may
        //be possible to randomize the returned quantity using getresult
        GameRegistry.addSmelting(ModItems.gildedBone, new ItemStack(Items.GOLD_NUGGET, 6), 2);
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
