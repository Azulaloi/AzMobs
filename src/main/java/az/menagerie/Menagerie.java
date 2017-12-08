package az.menagerie;

import az.menagerie.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Menagerie.MODID, name = Menagerie.MODNAME, version = Menagerie.MODVERSION, useMetadata = true)
public class Menagerie {
    public static final String MODID = "menagerie";
    public static final String MODNAME = "Menagerie";
    public static final String MODVERSION = "0.0.1";

    @SidedProxy(clientSide = "az.menagerie.proxy.ClientProxy", serverSide = "az.menagerie.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Menagerie instance;

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
