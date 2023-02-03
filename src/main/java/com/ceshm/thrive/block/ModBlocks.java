package com.ceshm.thrive.block;

import com.ceshm.thrive.Thrive;
import com.ceshm.thrive.block.custom.EggplantCropBlock;
import com.ceshm.thrive.block.custom.TanzaniteLampBlock;
import com.ceshm.thrive.block.custom.TrampoBlock;
import com.ceshm.thrive.item.ModItemGroup;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock(
        "tanzanite_block",
        new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Block TANZANITE_ORE = registerBlock(
        "tanzanite_ore",
        new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock(
        "deepslate_tanzanite_ore",
        new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Block TRAMPO_BLOCK = registerBlock(
        "trampo_block",
        new TrampoBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Block TANZANITE_LAMP = registerBlock(
        "tanzanite_lamp",
        new TanzaniteLampBlock(
            FabricBlockSettings
                .of(Material.METAL)
                .strength(2f)
                .requiresTool()
                .luminance(state -> state.get(TanzaniteLampBlock.LIT) ? 15 : 0)
        ),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Block EGGPLANT_CROP = registerBlockWithoutItem(
        "eggplant_crop",
        new EggplantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT))
    );

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(
            Registries.BLOCK,
            new Identifier(Thrive.MOD_ID, name),
            block
        );
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(Thrive.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return Registry.register(
            Registries.ITEM,
            new Identifier(Thrive.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void registerModBlocks() {

    }
}
