package com.pam.bonecraft.worldgen;

import com.pam.bonecraft.Bonecraft;
import com.pam.bonecraft.config.BonecraftConfig;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenPamFossil
{
    private static final CountRangeConfig fossil_cfg = new CountRangeConfig(15, 65, 0, 128);
    private static final int fossil_veinsize = 4;

    public static void setupOreGen()
    {
        for (Biome biome: ForgeRegistries.BIOMES.getValues())
        {
            
            if (BonecraftConfig.enableFossil)
            {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                                     new OreFeatureConfig(
                                                             OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                             Bonecraft.fossil
                                                                     .getDefaultState(),
                                                                     fossil_veinsize),
                                                     Placement.COUNT_RANGE,
                                                     fossil_cfg));
            }
            
        }
    }

}

