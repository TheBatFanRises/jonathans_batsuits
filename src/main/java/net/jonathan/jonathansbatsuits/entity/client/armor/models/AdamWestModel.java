package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.AdamWestItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AdamWestModel extends GeoModel<AdamWestItem> {
    @Override
    public Identifier getModelResource(AdamWestItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/adam_west_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(AdamWestItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/adam_west_2_texture.png");
    }

    @Override
    public Identifier getAnimationResource(AdamWestItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/adam_west.animation.json");
    }
}