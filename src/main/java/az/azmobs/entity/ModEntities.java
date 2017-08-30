package az.azmobs.entity;

import az.azmobs.AzMobs;
import az.azmobs.Config;
import az.azmobs.client.RenderFireBat;
import az.azmobs.client.RenderGilded;
import az.azmobs.client.RenderViridis;
import az.azmobs.util.AzUtil;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {
    static boolean enableFirebat;
    static boolean enableGilded;
    static boolean enableViridis;

    public static void initConfig() {
        enableFirebat = Config.loadFirebat;
        enableGilded = Config.loadGilded;
        enableViridis = Config.loadViridis;
    }

    public static void init() {
        //TODO: Method for gathering a list all biomes containing a specific mob spawn
        //TODO: See if there's a way (make one) to replace spawns non-biome-specifically, such as under a certain depth
        int id = 1;
        AzUtil.verboseLog("Registering Entities!");
        if (enableFirebat) {
            AzUtil.verboseLog("Registering Firebat");
            EntityRegistry.registerModEntity(new ResourceLocation(AzMobs.MODID, "firebat"), EntityFireBat.class, "firebat", id++, AzMobs.instance, 64, 3, true, 0x7F0000, 0xCE3D00);
            EntityRegistry.addSpawn(EntityFireBat.class, 60, 1, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).toArray(new Biome[0]));
        }

        if (enableGilded) {
            AzUtil.verboseLog("Registering Gilded");
            EntityRegistry.registerModEntity(new ResourceLocation(AzMobs.MODID, "gilded"), EntityGilded.class, "gilded", id++, AzMobs.instance, 64, 3, true, 0xFFFFFF, 0xFFF71E);
            EntityRegistry.addSpawn(EntityGilded.class, 7, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).toArray(new Biome[0]));
            //TODO: Add these to more biomes less commonly, and make certain biomes (forest, esp roofed) a little more common)
        }

        if (enableViridis) {
            AzUtil.verboseLog("Registering Viridis");
            EntityRegistry.registerModEntity(new ResourceLocation(AzMobs.MODID, "viridis"), EntityViridis.class, "viridis", id++, AzMobs.instance, 64, 3, true, 0x2A700A, 0x69E553);

            Biome[] jungleBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE).toArray(new Biome[0]);
            //This tweaks the existing spawn entry, despite the name.
            EntityRegistry.addSpawn(EntitySpider.class, 10, 4, 4, EnumCreatureType.MONSTER, jungleBiomes);
            EntityRegistry.addSpawn(EntityViridis.class, 90, 2, 3, EnumCreatureType.MONSTER, jungleBiomes);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        //TODO: Add journeymap icons to each mob
        AzUtil.verboseLog("Registering Entity Models!");
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBat.class, RenderFireBat.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGilded.class, RenderGilded.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityViridis.class, RenderViridis.RENDER_FACTORY);
    }
}
