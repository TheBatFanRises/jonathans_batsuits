package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.ChristianBaleItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ChristianBaleModel extends GeoModel<ChristianBaleItem> {
    @Override
    public Identifier getModelResource(ChristianBaleItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/christian_bale_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChristianBaleItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/christian_bale_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(ChristianBaleItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
