package yalter.mousetweaks.accessor;

import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.slot.InventorySlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(InventorySlot.class)
public interface InventorySlotAccessor {

	@Accessor("inventory")
	public Inventory getInv();
}
