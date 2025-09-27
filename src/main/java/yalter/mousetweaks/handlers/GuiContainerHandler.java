package yalter.mousetweaks.handlers;

import java.util.List;

import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.screen.inventory.menu.InventoryMenuScreen;
import net.minecraft.client.render.Window;
import net.minecraft.inventory.slot.CraftingResultSlot;
import net.minecraft.inventory.slot.FurnaceResultSlot;
import net.minecraft.inventory.slot.InventorySlot;
import org.lwjgl.input.Mouse;

import yalter.mousetweaks.IGuiScreenHandler;
import yalter.mousetweaks.MouseButton;
import yalter.mousetweaks.accessor.InventoryMenuScreenAccessor;
import yalter.mousetweaks.accessor.MinecraftAccessor;

public class GuiContainerHandler implements IGuiScreenHandler {
	protected Minecraft mc;
	protected InventoryMenuScreen guiContainer;

	public GuiContainerHandler(InventoryMenuScreen guiContainer) {
		this.mc = MinecraftAccessor.getInstance();
		this.guiContainer = guiContainer;
	}

	private int getDisplayWidth() {
		return mc.width;
	}

	private int getDisplayHeight() {
		return mc.height;
	}

	private int getRequiredMouseX() {
		Window scaledResolution = new Window(mc.options, getDisplayWidth(), getDisplayHeight());
		return (Mouse.getX() * scaledResolution.getWidth()) / getDisplayWidth();
	}

	private int getRequiredMouseY() {
		Window scaledResolution = new Window(mc.options, getDisplayWidth(), getDisplayHeight());
		int scaledHeight = scaledResolution.getHeight();
		return scaledHeight - ((Mouse.getY() * scaledHeight) / getDisplayHeight()) - 1;
	}

	@Override
	public boolean isMouseTweaksDisabled() {
		return (guiContainer == null);
	}

	@Override
	public boolean isWheelTweakDisabled() {
		return false;
	}

	@Override
	public List<InventorySlot> getSlots() {
		return guiContainer.menu.slots;
	}

	@Override
	public InventorySlot getSlotUnderMouse() {
		return ((InventoryMenuScreenAccessor)guiContainer).getSlotAt(getRequiredMouseX(), getRequiredMouseY());
	}

	@Override
	public boolean disableRMBDraggingFunctionality() {
		return false;
	}

	@Override
	public void clickSlot(InventorySlot slot, MouseButton mouseButton, boolean shiftPressed) {
		mc.interactionManager.clickSlot(guiContainer.menu.networkId,
                    slot.id,
                    mouseButton.getValue(),
                    shiftPressed,
                    mc.player);
	}

	@Override
	public boolean isCraftingOutput(InventorySlot slot) {
		return (slot instanceof CraftingResultSlot
			|| slot instanceof FurnaceResultSlot);
	}

	@Override
	public boolean isIgnored(InventorySlot slot) {
		return false;
	}
}
