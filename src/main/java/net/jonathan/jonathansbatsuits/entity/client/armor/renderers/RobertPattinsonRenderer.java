package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.RobertPattinsonModel;
import net.jonathan.jonathansbatsuits.item.custom.RobertPattinsonItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RobertPattinsonRenderer extends GeoArmorRenderer<RobertPattinsonItem> {

    public RobertPattinsonRenderer() {
        super(new RobertPattinsonModel());
    }
}
