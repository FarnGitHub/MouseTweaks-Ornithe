package yalter.mousetweaks.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.slot.InventorySlot;
import yalter.mousetweaks.IGuiScreenHandler;
import yalter.mousetweaks.MouseButton;
import yalter.mousetweaks.api.IMTModGuiContainer2;
import yalter.mousetweaks.accessor.MinecraftAccessor;

import java.util.List;

public class IMTModGuiContainer2Handler implements IGuiScreenHandler {
	protected Minecraft mc;
	protected IMTModGuiContainer2 modGuiContainer;

	public IMTModGuiContainer2Handler(IMTModGuiContainer2 modGuiContainer) {
		this.mc = MinecraftAccessor.getInstance();
		this.modGuiContainer = modGuiContainer;
	}

	@Override
	public boolean isMouseTweaksDisabled() {
		return modGuiContainer.MT_isMouseTweaksDisabled();
	}

	@Override
	public boolean isWheelTweakDisabled() {
		return modGuiContainer.MT_isWheelTweakDisabled();
	}

	@Override
	public List<InventorySlot> getSlots() {
		return modGuiContainer.MT_getContainer().slots;
	}

	@Override
	public InventorySlot getSlotUnderMouse() {
		return modGuiContainer.MT_getSlotUnderMouse();
	}

	@Override
	public boolean disableRMBDraggingFunctionality() {
		return modGuiContainer.MT_disableRMBDraggingFunctionality();
	}

	@Override
	public void clickSlot(InventorySlot slot, MouseButton mouseButton, boolean shiftPressed) {
		mc.interactionManager.clickSlot(modGuiContainer.MT_getContainer().networkId,
		                                slot.id,
		                                mouseButton.getValue(),
		                                shiftPressed,
		                                mc.player);
	}

	@Override
	public boolean isCraftingOutput(InventorySlot slot) {
		return modGuiContainer.MT_isCraftingOutput(slot);
	}

	@Override
	public boolean isIgnored(InventorySlot slot) {
		return modGuiContainer.MT_isIgnored(slot);
	}
}
