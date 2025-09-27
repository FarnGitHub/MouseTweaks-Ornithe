package yalter.mousetweaks;

import net.fabricmc.api.ClientModInitializer;
import net.ornithemc.osl.lifecycle.api.MinecraftEvents;
import net.ornithemc.osl.lifecycle.api.WorldEvents;

public class OrnitheInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecraftEvents.START.register(minecraft -> {
			Main.initialize(Constants.EntryPoint.FORGE);
		});
		WorldEvents.TICK_END.register(world -> {
			Main.onUpdateInGame();
		});
	}
}
