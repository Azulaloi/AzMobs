package az.azmobs;

import az.azmobs.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

/**
 * Created by Azulaloi on 8/18/2017
 */
public class Config {

    public static boolean loadFirebat = true;

    public static void initConfig() {
        Configuration config = CommonProxy.config;
        try{
            config.load();
            readConfig(config);
        } catch (Exception exception) {
            AzMobs.logger.log(Level.ERROR, "AzMobs: Exception loading config!", exception);
        } finally {
            if (config.hasChanged()){
                config.save();
            }
        }
    }

    public static void readConfig(Configuration config){
        loadFirebat = config.getBoolean("Enable Inferno Bat", "Inferno Bat", loadFirebat, "Set to false to disable Inferno Bats.");
    }
}
