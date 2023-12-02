package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.ArkhamAsylumItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ArkhamAsylumModel extends GeoModel<ArkhamAsylumItem> {
    @Override
    public Identifier getModelResource(ArkhamAsylumItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/arkham_asylum.geo.json");
    }

    @Override
    public Identifier getTextureResource(ArkhamAsylumItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/arkham_asylum_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ArkhamAsylumItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
