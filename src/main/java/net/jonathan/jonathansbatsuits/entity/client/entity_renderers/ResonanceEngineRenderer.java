package net.jonathan.jonathansbatsuits.entity.client.entity_renderers;

import net.jonathan.jonathansbatsuits.entity.client.block_entity.ResonanceEngineBlockEntity;
import net.jonathan.jonathansbatsuits.entity.client.entity_models.ResonanceEngineModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ResonanceEngineRenderer extends GeoBlockRenderer<ResonanceEngineBlockEntity> {

    public ResonanceEngineRenderer() {
        super(new ResonanceEngineModel());
    }
}
