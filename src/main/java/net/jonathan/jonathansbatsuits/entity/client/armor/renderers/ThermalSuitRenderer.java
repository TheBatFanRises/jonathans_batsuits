package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.ThermalSuitModel;
import net.jonathan.jonathansbatsuits.item.custom.ThermalSuitItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ThermalSuitRenderer extends GeoArmorRenderer<ThermalSuitItem> {
    public ThermalSuitRenderer() {
        super(new ThermalSuitModel());
    }
}
