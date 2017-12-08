package az.menagerie.entity;

import az.menagerie.Menagerie;
import az.menagerie.Config;
import az.menagerie.client.*;
import az.menagerie.util.AzUtil;
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
    static boolean enableGelum;
    static boolean enableMoobloom;
    static boolean enableFrog;

    public static void initConfig() {
        enableFirebat = Config.loadFirebat;
        enableGilded = Config.loadGilded;
        enableViridis = Config.loadViridis;
        enableGelum = Config.loadGelum;
        enableMoobloom = Config.loadMoobloom;
        enableFrog = Config.loadFrog;
    }

    public static void init() {
        //TODO: Method for gathering a list all biomes containing a specific mob spawn
        //TODO: See if there's a way (make one) to replace spawns non-biome-specifically, such as under a certain depth
        int id = 1;
        AzUtil.verboseLog("Registering Entities!");
        if (enableFirebat) {
            AzUtil.verboseLog("Registering Firebat");
            EntityRegistry.registerModEntity(new ResourceLocation(Menagerie.MODID, "firebat"), EntityFireBat.class, "firebat", id++, Menagerie.instance, 64, 3, true, 0x7F0000, 0xCE3D00);
            EntityRegistry.addSpawn(EntityFireBat.class, 60, 1, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).toArray(new Biome[0]));
        }

        if (enableGilded) {
            AzUtil.verboseLog("Registering Gilded");
            EntityRegistry.registerModEntity(new ResourceLocation(Menagerie.MODID, "gilded"), EntityGilded.class, "gilded", id++, Menagerie.instance, 64, 3, true, 0xFFFFFF, 0xFFF71E);
            EntityRegistry.addSpawn(EntityGilded.class, 7, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).toArray(new Biome[0]));
            //TODO: Add these to more biomes less commonly, and make certain biomes (forest, esp roofed) a little more common)
        }

        if (enableViridis) {
            AzUtil.verboseLog("Registering Viridis");
            EntityRegistry.registerModEntity(new ResourceLocation(Menagerie.MODID, "viridis"), EntityViridis.class, "viridis", id++, Menagerie.instance, 64, 3, true, 0x2A700A, 0x69E553);

            Biome[] jungleBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE).toArray(new Biome[0]);
            //This tweaks the existing spawn entry, despite the name.
            EntityRegistry.addSpawn(EntitySpider.class, 10, 4, 4, EnumCreatureType.MONSTER, jungleBiomes);
            EntityRegistry.addSpawn(EntityViridis.class, 90, 2, 3, EnumCreatureType.MONSTER, jungleBiomes);
        }

        if (enableGelum) {
            AzUtil.verboseLog("Registering Gelum");
            EntityRegistry.registerModEntity(new ResourceLocation(Menagerie.MODID, "gelum"), EntityGelum.class, "gelum", id++, Menagerie.instance, 64, 3, true, 0xedf0f4, 0xffaa00);

            EntityRegistry.addSpawn(EntityGelum.class, 15, 2, 3, EnumCreatureType.CREATURE, BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY).toArray(new Biome[0]));
        }

        if (enableMoobloom) {
            AzUtil.verboseLog("Registering Moobloom");
            EntityRegistry.registerModEntity(new ResourceLocation(Menagerie.MODID, "moobloom"), EntityMoobloom.class, "moobloom", id++, Menagerie.instance, 64, 3, true, 0xE5C4E7, 0xE2E2E2);

            EntityRegistry.addSpawn(EntityMoobloom.class, 60, 2, 5, EnumCreatureType.CREATURE, Biome.getBiome(132));
        }

        if (enableFrog) {
            AzUtil.verboseLog("Registering Frog");
            EntityRegistry.registerModEntity(new ResourceLocation(Menagerie.MODID, "frog"), EntityFrog.class, "frog", id++, Menagerie.instance, 64, 3, true, 0xE5C4E7, 0xE2E2E2);


        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        //TODO: Add journeymap icons to each mob
        AzUtil.verboseLog("Registering Entity Models!");
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBat.class, RenderFireBat.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGilded.class, RenderGilded.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityViridis.class, RenderViridis.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGelum.class, RenderGelum.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMoobloom.class, RenderMoobloom.RENDER_FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityFrog.class, RenderFrog.RENDER_FACTORY);
    }
}
