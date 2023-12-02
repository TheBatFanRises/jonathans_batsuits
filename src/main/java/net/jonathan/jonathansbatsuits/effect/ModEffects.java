package net.jonathan.jonathansbatsuits.effect;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect LIFE_FORCE_DRAIN;
    public static void registerEffects() {
        LIFE_FORCE_DRAIN = Registry.register(Registries.STATUS_EFFECT, new Identifier(JonathansBatsuits.MOD_ID, "life_force_drain"),
                new LifeForceDrainEffect(StatusEffectCategory.HARMFUL, 0xff1700));
    }
}
