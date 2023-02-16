package com.ceshm.thrive.world.feature;

import com.ceshm.thrive.Thrive;
import com.ceshm.thrive.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_TANZANITE_ORES = List.of(
        OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TANZANITE_ORE.getDefaultState()),
        OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState())
    );

    public static void register(
        Registerable<ConfiguredFeature<?, ?>> registerable,
        RegistryKey<ConfiguredFeature<?, ?>> key,
        Feature<DefaultFeatureConfig> feature
    ) {
        ConfiguredFeatures.register(registerable, key, feature, FeatureConfig.DEFAULT);
    }

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TANZAINTE_ORE = ConfiguredFeatures.register(
        null,
        OVERWORLD_TANZANITE_ORES,
        Feature.ORE,
        new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 8)
    );

    public static void registerConfiguredFeatures() {
        Thrive.LOGGER.debug("Registering configured features");
    }
}
