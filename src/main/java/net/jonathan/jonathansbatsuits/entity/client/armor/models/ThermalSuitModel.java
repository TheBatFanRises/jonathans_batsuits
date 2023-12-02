package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.ThermalSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ThermalSuitModel extends GeoModel<ThermalSuitItem> {
    @Override
    public Identifier getModelResource(ThermalSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/arctic_suit_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(ThermalSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/thermal_suit_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(ThermalSuitItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
