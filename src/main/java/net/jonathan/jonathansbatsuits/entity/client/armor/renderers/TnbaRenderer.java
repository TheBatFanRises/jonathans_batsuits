package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.TnbaModel;
import net.jonathan.jonathansbatsuits.item.custom.TnbaItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TnbaRenderer extends GeoArmorRenderer<TnbaItem> {
    public TnbaRenderer() {
        super(new TnbaModel());
    }
}
