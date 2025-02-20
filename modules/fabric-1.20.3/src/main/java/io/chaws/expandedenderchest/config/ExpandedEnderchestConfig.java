package io.chaws.expandedenderchest.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@Config(name = "expandedenderchest")
public class ExpandedEnderchestConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip(count = 2)
	@ConfigEntry.Gui.RequiresRestart
	@Comment("Enables or disables the mod")
	public boolean enabled = true;

	@ConfigEntry.Gui.Excluded
	private static boolean initialized = false;
	public static void initialize() {
		if (initialized) {
			return;
		}

		initialized = true;
		AutoConfig.register(ExpandedEnderchestConfig.class, JanksonConfigSerializer::new);
	}

	public static ExpandedEnderchestConfig getInstance() {
		initialize();
		return AutoConfig.getConfigHolder(ExpandedEnderchestConfig.class).getConfig();
	}
}
