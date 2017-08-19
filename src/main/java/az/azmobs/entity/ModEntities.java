package az.azmobs.entity;

import az.azmobs.AzMobs;
import az.azmobs.Config;
import az.azmobs.client.RenderFireBat;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 8/18/2017
 */
public class ModEntities {
    static boolean enableFirebat;
    static boolean enableGilded;

    public static void initConfig() {
        enableFirebat = Config.loadFirebat;
        enableGilded = Config.loadGilded;
    }

    public static void init() {
        int id = 1;
        if (enableFirebat) {
            EntityRegistry.registerModEntity(new ResourceLocation(AzMobs.MODID, "firebat"), EntityFireBat.class, "firebat", id++, AzMobs.instance, 64, 3, true, 0x7F0000, 0xCE3D00);
            EntityRegistry.addSpawn(EntityFireBat.class, 60, 1, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).toArray(new Biome[0]));
        }

        if (enableGilded) {
            EntityRegistry.registerModEntity(new ResourceLocation(AzMobs.MODID, "gilded"), EntityGilded.class, "gilded", id++, AzMobs.instance, 64, 3, true, 0xFFFFFF, 0xFFF71E);
            EntityRegistry.addSpawn(EntityGilded.class, 10, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).toArray(new Biome[0]));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBat.class, RenderFireBat.RENDER_FACTORY);
    }
}
