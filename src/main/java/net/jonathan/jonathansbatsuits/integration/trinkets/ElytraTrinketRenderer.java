package net.jonathan.jonathansbatsuits.integration.trinkets;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;

@Environment(EnvType.CLIENT)
public class ElytraTrinketRenderer {

    public static void register() {
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(player -> {
            return (Boolean) TrinketsApi.getTrinketComponent(player).map(trinketComponent -> {
                return trinketComponent.getEquipped((stack) -> {
                    return stack.getItem() instanceof FabricElytraItem;
                }).size() == 0;
            }).orElse(true);
        });
    }
}
