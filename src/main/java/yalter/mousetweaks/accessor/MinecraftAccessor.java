package yalter.mousetweaks.accessor;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Minecraft.class)
public interface MinecraftAccessor {

	@Accessor("INSTANCE")
	public static Minecraft getInstance() {
		throw new AssertionError();
	}
}
