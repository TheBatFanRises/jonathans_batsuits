package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.BenAffleckModel;
import net.jonathan.jonathansbatsuits.item.custom.BenAffleckItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BenAffleckRenderer extends GeoArmorRenderer<BenAffleckItem> {
    public BenAffleckRenderer() {
        super(new BenAffleckModel());
    }
}
