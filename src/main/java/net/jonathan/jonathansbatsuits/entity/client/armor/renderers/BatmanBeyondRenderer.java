package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.BatmanBeyondModel;
import net.jonathan.jonathansbatsuits.item.custom.BatmanBeyondItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BatmanBeyondRenderer extends GeoArmorRenderer<BatmanBeyondItem> {
    public BatmanBeyondRenderer() {
        super(new BatmanBeyondModel());
    }
}
