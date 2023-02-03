package com.ceshm.thrive.item;

import com.ceshm.thrive.Thrive;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup THRIVE_MAIN = FabricItemGroup.builder(new Identifier(Thrive.MOD_ID))
            .displayName(Text.literal("Thrive"))
            .icon(() -> new ItemStack(ModItems.TANZANITE))
            .build();
}
