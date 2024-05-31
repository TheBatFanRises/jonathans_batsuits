package net.jonathan.jonathansbatsuits.entity.client.entity_models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.block_entity.ResonanceEngineBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class ResonanceEngineModel extends DefaultedBlockGeoModel<ResonanceEngineBlockEntity> {

    public ResonanceEngineModel() {
        super(new Identifier(JonathansBatsuits.MOD_ID, "resonance_engine"));
    }
    @Override
    public Identifier getModelResource(ResonanceEngineBlockEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/resonance_engine.geo.json");
    }

    @Override
    public Identifier getTextureResource(ResonanceEngineBlockEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/entity/block/resonance_engine_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ResonanceEngineBlockEntity animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/resonance_engine.animation.json");
    }

    @Override
    public RenderLayer getRenderType(ResonanceEngineBlockEntity animatable, Identifier texture) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }
}
