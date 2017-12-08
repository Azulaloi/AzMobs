package az.azmobs;

import az.azmobs.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

    public static boolean loadFirebat = true;
    public static boolean loadGilded = true;
    public static boolean loadViridis = true;
    public static boolean loadGelum = true;
    public static boolean loadMoobloom = true;
    public static boolean loadFrog = true;

    public static boolean verboseLogging = false;

    public static void initConfig() {
        Configuration config = CommonProxy.config;
        try{
            config.load();
            readConfig(config);
        } catch (Exception exception) {
            AzMobs.logger.log(Level.ERROR, "AzMobs: Exception loading config!", exception);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    public static void readConfig(Configuration config) {
        //TODO: More config options? EX. Group sizes, spawn weights, loot drops, stats?, a "hard" mode (eg. suicide bats), etc.
        loadFirebat = config.getBoolean("Enable Inferno Bat", "Inferno Bat", loadFirebat, "Set to false to disable Inferno Bats.");
        loadGilded = config.getBoolean("Enable Gilded", "Gilded Skeleton", loadGilded, "Set to false to disable the Gilded.");
        loadGilded = config.getBoolean("Enable Viridis", "Viridis Spider", loadViridis, "Set to false to disable Viridi.");
        loadGelum = config.getBoolean("Enable Gelum", "Gelum", loadGelum, "Set to false to disable Geluma.");
        loadMoobloom = config.getBoolean("Enable Moobloom", "Moobloom", loadMoobloom, "Set to false to disable Mooblooms.");
        loadFrog = config.getBoolean("Enable Frog", "Frog", loadFrog,"Set to false to disable Frogs");

        verboseLogging = config.getBoolean("Verbose Logging", "Debug", verboseLogging, "Set to true for more log info.");
    }
}
