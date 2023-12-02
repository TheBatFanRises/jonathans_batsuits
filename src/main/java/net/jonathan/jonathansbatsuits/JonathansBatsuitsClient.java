package net.jonathan.jonathansbatsuits;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.jonathan.jonathansbatsuits.client.AbilityCooldownOverlay;
import net.jonathan.jonathansbatsuits.client.BeyondJetsCooldownOverlay;
import net.jonathan.jonathansbatsuits.client.DetectiveVisionOverlay;
import net.jonathan.jonathansbatsuits.entity.client.ElytraInitializer;
import net.jonathan.jonathansbatsuits.entity.client.EntityClientRegister;
import net.jonathan.jonathansbatsuits.event.DisableCapeEvent;
import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.integration.trinkets.ElytraTrinketRenderer;
import net.jonathan.jonathansbatsuits.networking.ModPackets;

public class JonathansBatsuitsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //Elytra Initializers
        ElytraInitializer.registerModelPredicates();
        ElytraInitializer.registerFeatureEventHandlers();

        //Entity Registers
        EntityClientRegister.registerEntities();

        //Keybinds
        KeyInputHandler.register();

        //ModPackets
        ModPackets.registerS2CPackets();

        ElytraTrinketRenderer.register();

        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(new DisableCapeEvent());

        HudRenderCallback.EVENT.register(new AbilityCooldownOverlay());
        HudRenderCallback.EVENT.register(new BeyondJetsCooldownOverlay());
        HudRenderCallback.EVENT.register(new DetectiveVisionOverlay());
    }
}
