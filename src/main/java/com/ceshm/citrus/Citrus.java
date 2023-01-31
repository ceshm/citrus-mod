package com.ceshm.citrus;

import com.ceshm.citrus.block.ModBlocks;
import com.ceshm.citrus.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Citrus implements ModInitializer {
	public static final String MOD_ID = "citrus";
	public static final Logger LOGGER = LoggerFactory.getLogger("citrus");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
