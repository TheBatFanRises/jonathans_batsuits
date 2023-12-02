package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.JonathansBatsuitModel;
import net.jonathan.jonathansbatsuits.item.custom.JonathansBatsuitItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class JonathansBatsuitRenderer extends GeoArmorRenderer<JonathansBatsuitItem> {
    public JonathansBatsuitRenderer() {
        super(new JonathansBatsuitModel());
    }
}
