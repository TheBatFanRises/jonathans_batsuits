package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.MichaelKeatonModel;
import net.jonathan.jonathansbatsuits.item.custom.MichaelKeatonItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MichaelKeatonRenderer extends GeoArmorRenderer<MichaelKeatonItem> {
    public MichaelKeatonRenderer() {
        super(new MichaelKeatonModel());
    }
}