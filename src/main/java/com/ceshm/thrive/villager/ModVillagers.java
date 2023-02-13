package com.ceshm.thrive.villager;

import com.ceshm.thrive.Thrive;
import com.ceshm.thrive.block.ModBlocks;
import com.ceshm.thrive.item.ModItems;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType TRAMPO_POI = registePointOfInterest("trampo_poi", ModBlocks.TRAMPO_BLOCK);
    public static final VillagerProfession JUMP_MASTER = registerProsession(
        "jumpmaster",
        RegistryKey.of(
            Registries.POINT_OF_INTEREST_TYPE.getKey(),
            new Identifier(Thrive.MOD_ID, "trampo_poi")
        )
    );

    public static VillagerProfession registerProsession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(
            Registries.VILLAGER_PROFESSION,
            new Identifier(Thrive.MOD_ID, name),
            VillagerProfessionBuilder.create()
                .id(new Identifier(Thrive.MOD_ID, name))
                .workstation(type)
                .build()
        );
    }

    public static PointOfInterestType registePointOfInterest(String name, Block block) {
        return PointOfInterestHelper.register(
            new Identifier(Thrive.MOD_ID, name),
            1,
            1,
            ImmutableSet.copyOf(block.getStateManager().getStates())
        );
    }

    public static void registerVillagers() {

    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(
            JUMP_MASTER,
            1,
            factories -> {
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.EGGPLANT, 5),
                    6,
                    2,
                    0.02f
                ));
            }
        );
    }
}
