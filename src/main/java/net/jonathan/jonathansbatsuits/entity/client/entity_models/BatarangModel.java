package net.jonathan.jonathansbatsuits.entity.client.entity_models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatarangEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BatarangModel extends GeoModel<BatarangEntity> {

    @Override
    public Identifier getModelResource(BatarangEntity object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/batarang_entity_vertical.geo.json");
    }

    @Override
    public Identifier getTextureResource(BatarangEntity object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/entity/batarang_entity_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BatarangEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/batarang_vertical.animation.json");
    }
}
