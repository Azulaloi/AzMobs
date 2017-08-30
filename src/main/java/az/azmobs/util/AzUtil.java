package az.azmobs.util;

import az.azmobs.AzMobs;
import az.azmobs.Config;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import org.apache.logging.log4j.Level;

public class AzUtil {

    public static void verboseLog(org.apache.logging.log4j.Level level, String message) {
        if (Config.verboseLogging) {
            AzMobs.logger.log(level, message);
        }
    }

    public static void verboseLog(String message) {
        if (Config.verboseLogging) {
            AzMobs.logger.log(Level.INFO, message);
        }
    }

    public static void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }

}
