package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.ScubaSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ScubaSuitModel extends GeoModel<ScubaSuitItem> {

    @Override
    public Identifier getModelResource(ScubaSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/scuba_suit_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(ScubaSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/scuba_suit_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(ScubaSuitItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
