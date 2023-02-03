package com.ceshm.thrive.item;

import com.ceshm.thrive.Thrive;
import com.ceshm.thrive.block.ModBlocks;
import com.ceshm.thrive.item.custom.EightBallItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_TANZANITE = registerItem(
        "raw_tanzanite",
        new Item(new Item.Settings()),
        ModItemGroup.THRIVE_MAIN
    );

    public static final Item TANZANITE = registerItem(
        "tanzanite",
        new Item(new Item.Settings()),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Item EIGHT_BALL = registerItem(
        "eight_ball",
        new EightBallItem(new Item.Settings().maxCount(1)),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Item EGGPLANT_SEEDS = registerItem(
        "eggplant_seeds",
        new AliasedBlockItem(
            ModBlocks.EGGPLANT_CROP,
            new FabricItemSettings().maxCount(1)
        ),
        ModItemGroup.THRIVE_MAIN
    );
    public static final Item EGGPLANT = registerItem(
        "eggplant",
        new Item(
            new FabricItemSettings()
                .maxCount(16)
                .food(
                    new FoodComponent.Builder()
                        .hunger(4)
                        .saturationModifier(4f)
                        .build()
                )
        ),
        ModItemGroup.THRIVE_MAIN
    );

    private static Item registerItem(String name, Item item, ItemGroup group) {
        Thrive.LOGGER.info("tryna register: " + name);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(Thrive.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Thrive.LOGGER.info("Registering Mod Items for " + Thrive.MOD_ID);
    }
}
