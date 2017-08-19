package az.azmobs.util;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class AzUtil {

    public static void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }

}
