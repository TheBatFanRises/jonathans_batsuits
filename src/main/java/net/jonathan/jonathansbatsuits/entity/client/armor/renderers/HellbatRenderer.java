package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.HellbatModel;
import net.jonathan.jonathansbatsuits.item.custom.HellbatItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HellbatRenderer extends GeoArmorRenderer<HellbatItem> {
    public HellbatRenderer() {
        super(new HellbatModel());
    }
}
