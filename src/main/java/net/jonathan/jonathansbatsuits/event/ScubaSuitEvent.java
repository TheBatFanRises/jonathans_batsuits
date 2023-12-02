package net.jonathan.jonathansbatsuits.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.jonathan.jonathansbatsuits.item.custom.ScubaSuitItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class ScubaSuitEvent implements ServerTickEvents.StartTick {
    float currentTick = 0;
    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            ServerWorld serverWorld = (ServerWorld)player.getEntityWorld();
            currentTick++;
            if (ScubaSuitItem.isWearingAll(player) && player.isSubmergedInWater() && currentTick >= 100) {
                if (player.isInSwimmingPose()) {
                    for (int i = 0; i < 5; i++) {
                        serverWorld.spawnParticles(ParticleTypes.BUBBLE, (double) player.getX(), (double) player.getEyeY() - 0.1,
                                (double) player.getZ(), 1, 0.0, 0.0, 0.0, 0.2);
                    }
                } else {
                    for (int i = 0; i < 5; i++) {
                        serverWorld.spawnParticles(ParticleTypes.BUBBLE, (double) player.getX() + 0.1, (double) player.getEyeY() - 0.1,
                                (double) player.getZ(), 1, 0.0, 0.0, 0.0, 0.2);
                    }
                }
            }
            if (currentTick > 105) {
                currentTick = 0;
            }
        }
    }
}
