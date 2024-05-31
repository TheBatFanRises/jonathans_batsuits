package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.TheBatmanWhoWeepsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TheBatmanWhoWeepsModel extends GeoModel<TheBatmanWhoWeepsItem> {
    @Override
    public Identifier getModelResource(TheBatmanWhoWeepsItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/the_batman_who_weeps.geo.json");
    }

    @Override
    public Identifier getTextureResource(TheBatmanWhoWeepsItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/the_batman_who_weeps_texture.png");
    }

    @Override
    public Identifier getAnimationResource(TheBatmanWhoWeepsItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/batsuit.animation.json");
    }
}
