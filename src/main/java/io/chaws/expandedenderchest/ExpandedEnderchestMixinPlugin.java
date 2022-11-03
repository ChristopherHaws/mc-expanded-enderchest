package io.chaws.expandedenderchest;

import java.util.List;
import java.util.Set;

import io.chaws.expandedenderchest.config.ExpandedEnderchestConfig;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public final class ExpandedEnderchestMixinPlugin implements IMixinConfigPlugin {
	private final String currentPackageName = ExpandedEnderchestMixinPlugin.class.getPackageName() + ".";

	@Override
	public boolean shouldApplyMixin(
		final String targetClassName,
		final String mixinClassName
	) {
		if (!mixinClassName.startsWith(currentPackageName)) {
			return true;
		}

		return ExpandedEnderchestConfig.getInstance().enabled;
	}

	@Override
	public void onLoad(final String mixinPackage) {	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public void acceptTargets(final Set<String> myTargets, final Set<String> otherTargets) { }

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(
		final String targetClassName,
		final ClassNode targetClass,
		final String mixinClassName,
		final IMixinInfo mixinInfo
	) {	}

	@Override
	public void postApply(
		final String targetClassName,
		final ClassNode targetClass,
		final String mixinClassName,
		final IMixinInfo mixinInfo
	) {	}
}
