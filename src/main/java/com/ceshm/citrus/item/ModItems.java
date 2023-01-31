package com.ceshm.citrus.item;

import com.ceshm.citrus.Citrus;
import com.ceshm.citrus.CitrusClient;
import com.ceshm.citrus.item.custom.EightBallItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_TANZANITE = registerItem(
            "raw_tanzanite",
            new Item(new Item.Settings()),
            ModItemGroup.CITRUS_MAIN
    );

    public static final Item TANZANITE = registerItem(
            "tanzanite",
            new Item(new Item.Settings()),
            ModItemGroup.CITRUS_MAIN
    );
    public static final Item EIGHT_BALL = registerItem(
            "eight_ball",
            new EightBallItem(new Item.Settings().maxCount(1)),
            ModItemGroup.CITRUS_MAIN
    );

    private static Item registerItem(String name, Item item, ItemGroup group) {
        Citrus.LOGGER.info("tryna register: " + name);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(Citrus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Citrus.LOGGER.info("Registering Mod Items for " + Citrus.MOD_ID);
    }
}
