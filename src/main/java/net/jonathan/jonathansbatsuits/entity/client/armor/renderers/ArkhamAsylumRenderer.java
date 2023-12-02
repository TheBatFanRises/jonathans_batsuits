package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.ArkhamAsylumModel;
import net.jonathan.jonathansbatsuits.item.custom.ArkhamAsylumItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ArkhamAsylumRenderer extends GeoArmorRenderer<ArkhamAsylumItem> {
    public ArkhamAsylumRenderer() {
        super(new ArkhamAsylumModel());
    }
}
