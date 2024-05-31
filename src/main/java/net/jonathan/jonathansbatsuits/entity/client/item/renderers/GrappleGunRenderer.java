package net.jonathan.jonathansbatsuits.entity.client.item.renderers;

import net.jonathan.jonathansbatsuits.entity.client.item.models.GrappleGunModel;
import net.jonathan.jonathansbatsuits.item.custom.GrappleGunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GrappleGunRenderer extends GeoItemRenderer<GrappleGunItem> {
    public GrappleGunRenderer() {
        super(new GrappleGunModel());
    }
}
