package net.jonathan.jonathansbatsuits.entity.client.item.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.ResonanceEngineBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ResonanceEngineItemModel extends GeoModel<ResonanceEngineBlockItem> {
    @Override
    public Identifier getModelResource(ResonanceEngineBlockItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/resonance_engine.geo.json");
    }

    @Override
    public Identifier getTextureResource(ResonanceEngineBlockItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/entity/block/resonance_engine_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ResonanceEngineBlockItem animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/resonance_engine.animation.json");
    }
}
