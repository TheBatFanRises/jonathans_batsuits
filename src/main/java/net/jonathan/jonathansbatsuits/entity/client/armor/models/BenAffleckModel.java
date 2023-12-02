package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.BenAffleckItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BenAffleckModel extends GeoModel<BenAffleckItem> {
    @Override
    public Identifier getModelResource(BenAffleckItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/ben_affleck_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(BenAffleckItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/ben_affleck_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(BenAffleckItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
