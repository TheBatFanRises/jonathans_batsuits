package net.jonathan.jonathansbatsuits.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.jonathan.jonathansbatsuits.effect.ModEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class LifeForceDrainEvent implements ServerTickEvents.StartTick {
    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if (player.hasStatusEffect(ModEffects.LIFE_FORCE_DRAIN)) {
                player.setHealth(player.getHealth() - 0.000001f);
                if (player.getHealth() <= 0.000001f) {
                    player.damage(player.getDamageSources().wither(), Float.MAX_VALUE);
                }
            }
        }
    }
}
