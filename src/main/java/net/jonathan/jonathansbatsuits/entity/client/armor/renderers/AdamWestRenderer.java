package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.AdamWestModel;
import net.jonathan.jonathansbatsuits.item.custom.AdamWestItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AdamWestRenderer extends GeoArmorRenderer<AdamWestItem> {
    public AdamWestRenderer() {
        super(new AdamWestModel());
    }
}
