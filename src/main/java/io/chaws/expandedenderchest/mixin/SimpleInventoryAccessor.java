package io.chaws.expandedenderchest.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

@Mixin(SimpleInventory.class)
public interface SimpleInventoryAccessor {
	@Accessor("size")
	@Mutable
	void setSize(int size);

	@Accessor("heldStacks")
	@Mutable
	void setStacks(DefaultedList<ItemStack> stacks);

	@Accessor("heldStacks")
	DefaultedList<ItemStack> getStacks();
}
