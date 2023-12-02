package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.TasModel;
import net.jonathan.jonathansbatsuits.item.custom.TasItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TasRenderer extends GeoArmorRenderer<TasItem> {
    public TasRenderer() {
        super(new TasModel());
    }
}
