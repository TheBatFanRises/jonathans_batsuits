package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.ChristianBaleModel;
import net.jonathan.jonathansbatsuits.item.custom.ChristianBaleItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ChristianBaleRenderer extends GeoArmorRenderer<ChristianBaleItem> {
    public ChristianBaleRenderer() {
        super(new ChristianBaleModel());
    }
}
