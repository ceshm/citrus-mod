package com.ceshm.thrive;

import com.ceshm.thrive.block.ModBlocks;
import com.ceshm.thrive.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thrive implements ModInitializer {
	public static final String MOD_ID = "thrive";
	public static final Logger LOGGER = LoggerFactory.getLogger("thrive");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
