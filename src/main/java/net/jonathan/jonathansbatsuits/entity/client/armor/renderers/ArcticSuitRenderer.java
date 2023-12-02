package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.ArcticSuitModel;
import net.jonathan.jonathansbatsuits.item.custom.ArcticSuitItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ArcticSuitRenderer extends GeoArmorRenderer<ArcticSuitItem> {
    public ArcticSuitRenderer() {
        super(new ArcticSuitModel());
    }
}
