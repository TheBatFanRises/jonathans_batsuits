package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class JonathansBatsuitsMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		JonathansBatsuits.LOGGER.info("RIP Kevin Conroy.");
		JonathansBatsuits.LOGGER.info("RIP Adam West.");
	}
}
