package net.jonathan.jonathansbatsuits.entity.client.armor.models;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.BattleArmorV1Item;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BattleArmorV1Model extends GeoModel<BattleArmorV1Item> {
    @Override
    public Identifier getModelResource(BattleArmorV1Item object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "geo/battle_armor_v1_2.geo.json");
    }

    @Override
    public Identifier getTextureResource(BattleArmorV1Item object) {
        return new Identifier(JonathansBatsuits.MOD_ID, "textures/models/armor/battle_armor_v1_texture_2.png");
    }

    @Override
    public Identifier getAnimationResource(BattleArmorV1Item animatable) {
        return new Identifier(JonathansBatsuits.MOD_ID, "animations/armor_animation.json");
    }
}
