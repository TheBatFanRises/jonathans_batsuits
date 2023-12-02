package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.TasItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TasModel extends GeoModel<TasItem> {
    @Override
    public Identifier getModelResource(TasItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/tas.geo.json");
    }

    @Override
    public Identifier getTextureResource(TasItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/tas_texture.png");
    }

    @Override
    public Identifier getAnimationResource(TasItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
