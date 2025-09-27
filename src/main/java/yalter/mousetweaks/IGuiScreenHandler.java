package yalter.mousetweaks;

import net.minecraft.inventory.slot.InventorySlot;

import java.util.List;

public interface IGuiScreenHandler {
	boolean isMouseTweaksDisabled();

	boolean isWheelTweakDisabled();

	List<InventorySlot> getSlots();

	InventorySlot getSlotUnderMouse();

	boolean disableRMBDraggingFunctionality();

	void clickSlot(InventorySlot slot, MouseButton mouseButton, boolean shiftPressed);

	boolean isCraftingOutput(InventorySlot slot);

	boolean isIgnored(InventorySlot slot);
}
