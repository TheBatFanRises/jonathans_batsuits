package net.jonathan.jonathansbatsuits.entity.client.armor.renderers;

import net.jonathan.jonathansbatsuits.entity.client.armor.models.BattleArmorV1Model;
import net.jonathan.jonathansbatsuits.item.custom.BattleArmorV1Item;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BattleArmorV1Renderer extends GeoArmorRenderer<BattleArmorV1Item> {
    public BattleArmorV1Renderer() {
        super(new BattleArmorV1Model());
    }
}
