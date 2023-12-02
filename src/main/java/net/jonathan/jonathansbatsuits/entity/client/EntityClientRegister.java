package net.jonathan.jonathansbatsuits.entity.client;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jonathan.jonathansbatsuits.entity.client.entity_renderers.BatarangRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class EntityClientRegister {
    public static void registerEntities() {
        EntityRendererRegistry.register(EntityRegister.BATARANG_ENTITY, BatarangRenderer::new);
        EntityRendererRegistry.register(EntityRegister.SMOKE_PELLET_ENTITY, FlyingItemEntityRenderer::new);
    }
}
