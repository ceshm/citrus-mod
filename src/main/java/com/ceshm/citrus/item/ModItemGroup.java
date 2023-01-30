package com.ceshm.citrus.item;

import com.ceshm.citrus.Citrus;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CITRUS_MAIN = FabricItemGroup.builder(new Identifier(Citrus.MOD_ID))
            .displayName(Text.literal("Citrus"))
            .icon(() -> new ItemStack(ModItems.TANZANITE))
            .build();
}
