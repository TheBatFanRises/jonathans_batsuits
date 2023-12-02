package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.HellbatItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class HellbatModel extends GeoModel<HellbatItem> {

    @Override
    public Identifier getModelResource(HellbatItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/hellbat_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(HellbatItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/hellbat_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(HellbatItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/hellbat.animation.json");
    }
}
