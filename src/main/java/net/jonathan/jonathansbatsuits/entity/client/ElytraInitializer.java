package net.jonathan.jonathansbatsuits.entity.client;

import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.render.*;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.jonathan.jonathansbatsuits.item.custom.*;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.util.Identifier;

public class ElytraInitializer {
    public static String MOD_ID = JonathansBatsuits.MOD_ID;
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.BLACK_CAPE, new Identifier(MOD_ID, "torn_black_cape"), ((stack, world, entity, seed) ->
                stack.getItem() == ModItems.BLACK_CAPE && BlackCapeItem.isUsable(stack) ? 0.0F : 1.0F));

        ModelPredicateProviderRegistry.register(ModItems.BLUE_CAPE, new Identifier(MOD_ID, "torn_blue_cape"), ((stack, world, entity, seed) ->
                stack.getItem() == ModItems.BLUE_CAPE && BlueCapeItem.isUsable(stack) ? 0.0F : 1.0F));
    }
    public static void registerFeatureEventHandlers() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {

                registrationHelper.register(new BlackCapeRenderFeature<>(entityRenderer, context.getModelLoader()));

                registrationHelper.register(new BlueCapeRenderFeature<>(entityRenderer, context.getModelLoader()));

                registrationHelper.register(new BatmanBeyondCapeRendererFeature<>(entityRenderer, context.getModelLoader()));
            }
        });
    }
}
