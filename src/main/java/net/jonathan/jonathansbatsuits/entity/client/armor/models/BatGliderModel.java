package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.BatGliderArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BatGliderModel extends GeoModel<BatGliderArmorItem> {
    @Override
    public Identifier getModelResource(BatGliderArmorItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/bat_glider.geo.json");
    }

    @Override
    public Identifier getTextureResource(BatGliderArmorItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/bat_glider_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BatGliderArmorItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/bat_glider.animation.json");
    }
}
