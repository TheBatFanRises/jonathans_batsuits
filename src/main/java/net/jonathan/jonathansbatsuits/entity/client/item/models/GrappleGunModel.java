package net.jonathan.jonathansbatsuits.entity.client.item.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.GrappleGunItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GrappleGunModel extends GeoModel<GrappleGunItem> {
    @Override
    public Identifier getModelResource(GrappleGunItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/grapple_gun.geo.json");
    }

    @Override
    public Identifier getTextureResource(GrappleGunItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/item/grapple_gun.png");
    }

    @Override
    public Identifier getAnimationResource(GrappleGunItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/grapple_gun.animation.json");
    }
}
