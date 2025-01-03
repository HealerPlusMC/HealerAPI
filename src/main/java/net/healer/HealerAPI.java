package net.healer;

import net.fabricmc.api.ModInitializer;

import net.healer.block.HealerBlockSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HealerAPI implements ModInitializer {
	public static final String MOD_ID = "healer_api";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		HealerBlockSettings.register();

	}
}