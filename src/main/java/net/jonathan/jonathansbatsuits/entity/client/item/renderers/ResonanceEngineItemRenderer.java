package net.jonathan.jonathansbatsuits.entity.client.item.renderers;

import net.jonathan.jonathansbatsuits.entity.client.item.models.ResonanceEngineItemModel;
import net.jonathan.jonathansbatsuits.item.custom.ResonanceEngineBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ResonanceEngineItemRenderer extends GeoItemRenderer<ResonanceEngineBlockItem> {
    public ResonanceEngineItemRenderer() {
        super(new ResonanceEngineItemModel());
    }
}
