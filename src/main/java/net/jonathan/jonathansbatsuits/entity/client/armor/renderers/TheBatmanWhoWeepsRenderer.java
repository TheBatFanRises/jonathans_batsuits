package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.TheBatmanWhoWeepsModel;
import net.jonathan.jonathansbatsuits.item.custom.TheBatmanWhoWeepsItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TheBatmanWhoWeepsRenderer extends GeoArmorRenderer<TheBatmanWhoWeepsItem> {
    public TheBatmanWhoWeepsRenderer() {
        super(new TheBatmanWhoWeepsModel());
    }
}
