package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.JonathansBatsuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class JonathansBatsuitModel extends GeoModel<JonathansBatsuitItem> {
    @Override
    public Identifier getModelResource(JonathansBatsuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/arctic_suit_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(JonathansBatsuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/jonathans_batsuit_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(JonathansBatsuitItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
