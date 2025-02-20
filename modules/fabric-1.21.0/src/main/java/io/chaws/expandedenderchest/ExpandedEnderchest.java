package io.chaws.expandedenderchest;

import io.chaws.expandedenderchest.config.ExpandedEnderchestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

public class ExpandedEnderchest implements ModInitializer {
	@SuppressWarnings("unused")
	public static final Logger logger = LoggerFactory.getLogger("expanded-enderchest");

	@Override
	public void onInitialize() {
		ExpandedEnderchestConfig.initialize();
	}
}
