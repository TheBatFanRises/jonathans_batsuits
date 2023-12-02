package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.ArcticSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ArcticSuitModel extends GeoModel<ArcticSuitItem> {
    @Override
    public Identifier getModelResource(ArcticSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/arctic_suit_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(ArcticSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/arctic_suit_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(ArcticSuitItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
