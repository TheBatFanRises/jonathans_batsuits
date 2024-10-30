package net.jonathan.jonathansbatsuits.entity.client;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jonathan.jonathansbatsuits.entity.client.entity_renderers.*;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class EntityClientRegister {
    public static void registerEntities() {
        EntityRendererRegistry.register(EntityRegister.BATARANG_ENTITY, BatarangRenderer::new);
        EntityRendererRegistry.register(EntityRegister.SMOKE_PELLET_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityRegister.BAT_DART_ENTITY, BatDartRenderer::new);
        EntityRendererRegistry.register(EntityRegister.EXPLOSIVE_BATARANG_ENTITY, ExplosiveBatarangRenderer::new);
        EntityRendererRegistry.register(EntityRegister.GRAPPLE_HOOK_ENTITY, GrappleHookRenderer::new);
        BlockEntityRendererFactories.register(EntityRegister.RESONANCE_ENGINE, context -> new ResonanceEngineRenderer());
    }
}
