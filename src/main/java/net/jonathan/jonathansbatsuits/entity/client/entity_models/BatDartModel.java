package net.jonathan.jonathansbatsuits.entity.client.entity_models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatDartEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BatDartModel extends GeoModel<BatDartEntity> {
    @Override
    public Identifier getModelResource(BatDartEntity object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/batarang_entity_vertical.geo.json");
    }

    @Override
    public Identifier getTextureResource(BatDartEntity object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/entity/batarang_entity_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BatDartEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/batarang_vertical.animation.json");
    }
}
