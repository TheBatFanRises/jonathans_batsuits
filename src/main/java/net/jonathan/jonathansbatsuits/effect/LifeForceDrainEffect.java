package net.jonathan.jonathansbatsuits.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class LifeForceDrainEffect extends StatusEffect {

    public LifeForceDrainEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            entity.setHealth(entity.getHealth() - 0.5f);
            if (entity.getHealth() < 0.5f) {
                entity.damage(entity.getDamageSources().wither(), Float.MAX_VALUE);

            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == ModEffects.LIFE_FORCE_DRAIN) {
            int i = 100 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return false;
        }
        return false;
    }
}