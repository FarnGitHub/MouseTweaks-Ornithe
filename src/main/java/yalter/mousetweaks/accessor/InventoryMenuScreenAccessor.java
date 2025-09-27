package yalter.mousetweaks.accessor;

import net.minecraft.client.gui.screen.inventory.menu.InventoryMenuScreen;
import net.minecraft.inventory.slot.InventorySlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(InventoryMenuScreen.class)
public interface InventoryMenuScreenAccessor {

	@Invoker("getHoveredSlot")
	public InventorySlot getSlotAt(int mouseX, int mouseY);

}
