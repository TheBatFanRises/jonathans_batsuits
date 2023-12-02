package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.StealthSuitModel;
import net.jonathan.jonathansbatsuits.item.custom.StealthSuitItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class StealthSuitRenderer extends GeoArmorRenderer<StealthSuitItem> {
    public StealthSuitRenderer() {
        super(new StealthSuitModel());
    }
}
