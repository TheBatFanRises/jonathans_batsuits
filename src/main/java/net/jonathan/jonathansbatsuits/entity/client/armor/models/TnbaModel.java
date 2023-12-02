package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.TnbaItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TnbaModel extends GeoModel<TnbaItem> {
    @Override
    public Identifier getModelResource(TnbaItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/tas.geo.json");
    }

    @Override
    public Identifier getTextureResource(TnbaItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/tnba_texture.png");
    }

    @Override
    public Identifier getAnimationResource(TnbaItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
