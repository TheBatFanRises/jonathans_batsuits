package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.BatmanBeyondItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BatmanBeyondModel extends GeoModel<BatmanBeyondItem> {
    @Override
    public Identifier getModelResource(BatmanBeyondItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/batman_beyond.geo.json");
    }

    @Override
    public Identifier getTextureResource(BatmanBeyondItem object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/batman_beyond_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BatmanBeyondItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
