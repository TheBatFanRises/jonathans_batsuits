package net.jonathan.jonathansbatsuits.entity.client.entity_models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.GrappleHookEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GrappleHookModel extends GeoModel<GrappleHookEntity> {
    @Override
    public Identifier getModelResource(GrappleHookEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/grapple_hook.geo.json");
    }

    @Override
    public Identifier getTextureResource(GrappleHookEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/entity/grapple_hook_texture.png");
    }

    @Override
    public Identifier getAnimationResource(GrappleHookEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/grapple_hook.animation.json");
    }
}
