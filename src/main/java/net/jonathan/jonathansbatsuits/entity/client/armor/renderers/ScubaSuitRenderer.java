package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.ScubaSuitModel;
import net.jonathan.jonathansbatsuits.item.custom.ScubaSuitItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ScubaSuitRenderer extends GeoArmorRenderer<ScubaSuitItem> {
    public ScubaSuitRenderer() {
        super(new ScubaSuitModel());
    }
}
