package az.azmobs;

import az.azmobs.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Azulaloi on 8/18/2017
 */
@Mod(modid = AzMobs.MODID, name = AzMobs.MODNAME, version = AzMobs.MODVERSION, useMetadata = true)
public class AzMobs {
    public static final String MODID = "azmod";
    public static final String MODNAME = "AzMod";
    public static final String MODVERSION = "0.0";

    @SidedProxy(clientSide = "az.azmobs.proxy.ClientProxy", serverSide = "az.azmobs.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static AzMobs instance;

    public static final Logger logger = LogManager.getLogger(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(proxy);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
