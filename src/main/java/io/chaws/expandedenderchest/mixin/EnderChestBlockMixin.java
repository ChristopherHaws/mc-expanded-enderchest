package io.chaws.expandedenderchest.mixin;

import java.util.OptionalInt;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.EnderChestBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;

@Mixin(EnderChestBlock.class)
public abstract class EnderChestBlockMixin {
	@Final
	@Shadow
	private static Text CONTAINER_NAME;

	@Redirect(
		method = "onUse",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/player/PlayerEntity;openHandledScreen(Lnet/minecraft/screen/NamedScreenHandlerFactory;)Ljava/util/OptionalInt;"
		),
		require = 0
	)
	private OptionalInt onUse(PlayerEntity playerEntity, NamedScreenHandlerFactory factory) {
		return openHandledScreen(playerEntity);
	}

	@Unique
	private OptionalInt openHandledScreen(PlayerEntity playerEntity) {
		return playerEntity.openHandledScreen(new SimpleNamedScreenHandlerFactory(
			(syncId, playerInventory, playerEntityInner) ->
				GenericContainerScreenHandler.createGeneric9x6(
					syncId,
					playerInventory,
					playerEntityInner.getEnderChestInventory()
				),
			CONTAINER_NAME
		));
	}
}
