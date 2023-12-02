package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.StealthSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class StealthSuitModel extends GeoModel<StealthSuitItem> {
    @Override
    public Identifier getModelResource(StealthSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/stealth_suit_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(StealthSuitItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/stealth_suit_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(StealthSuitItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
