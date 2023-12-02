package net.jonathan.jonathansbatsuits.effect;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.jonathan.jonathansbatsuits.event.LifeForceDrainEvent;
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
            ServerTickEvents.START_SERVER_TICK.register(new LifeForceDrainEvent());
        }
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}