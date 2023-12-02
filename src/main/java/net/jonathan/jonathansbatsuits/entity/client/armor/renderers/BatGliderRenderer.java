package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.BatGliderModel;
import net.jonathan.jonathansbatsuits.item.custom.BatGliderArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BatGliderRenderer extends GeoArmorRenderer<BatGliderArmorItem> {
    public BatGliderRenderer() {
        super(new BatGliderModel());
    }
}
