package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.RobertPattinsonItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class RobertPattinsonModel extends GeoModel<RobertPattinsonItem> {
    @Override
    public Identifier getModelResource(RobertPattinsonItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/robert_pattinson_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(RobertPattinsonItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/robert_pattinson_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(RobertPattinsonItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
