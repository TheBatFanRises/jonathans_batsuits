package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.MichaelKeatonItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class MichaelKeatonModel extends GeoModel<MichaelKeatonItem> {

    @Override
    public Identifier getModelResource(MichaelKeatonItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/michael_keaton_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(MichaelKeatonItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/michael_keaton_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(MichaelKeatonItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}