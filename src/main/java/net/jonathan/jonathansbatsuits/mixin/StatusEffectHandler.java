package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.item.custom.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class StatusEffectHandler extends Entity {
    protected StatusEffectHandler(EntityType<?> entityType, World world) {
        super(entityType, world);
    }
    @Inject(at = @At("HEAD"), method = "tickStatusEffects")
    protected void applyEffects(CallbackInfo info) {
        if (!this.getEntityWorld().isClient()) {
            LivingEntity owner = LivingEntity.class.cast(this);
            if (AdamWestItem.isWearingAll(owner)) {
                AdamWestItem.applySetEffect(owner);
            }
            if (ArcticSuitItem.isWearingAll(owner)) {
                ArcticSuitItem.applySetEffect(owner);
            }
            if (BenAffleckItem.isWearingAll(owner)) {
                BenAffleckItem.applySetEffect(owner);
            }
            if (ChristianBaleItem.isWearingAll(owner)) {
                ChristianBaleItem.applySetEffect(owner);
            }
            if (JonathansBatsuitItem.isWearingAll(owner)) {
                JonathansBatsuitItem.applySetEffect(owner);
            }
            if (MichaelKeatonItem.isWearingAll(owner)) {
                MichaelKeatonItem.applySetEffect(owner);
            }
            if (RobertPattinsonItem.isWearingAll(owner)) {
                RobertPattinsonItem.applySetEffect(owner);
            } else if (owner.hasStatusEffect(StatusEffects.HEALTH_BOOST)) {
                if (Objects.requireNonNull(owner.getStatusEffect(StatusEffects.HEALTH_BOOST)).getDuration() == -1) {
                    owner.removeStatusEffect(StatusEffects.HEALTH_BOOST);
                }
            }
            if (ThermalSuitItem.isWearingAll(owner)) {
                ThermalSuitItem.applySetEffect(owner);
            }
            if (BattleArmorV1Item.isWearingAll(owner)) {
                BattleArmorV1Item.applySetEffect(owner);
            }
            if (ScubaSuitItem.isWearingAll(owner)) {
                ScubaSuitItem.applySetEffect(owner);
            }
            if (StealthSuitItem.isWearingAll(owner)) {
                StealthSuitItem.applySetEffect(owner);
            }
            if (HellbatItem.isWearingAll(owner)) {
                HellbatItem.applySetEffect(owner);
            }
            if (BatmanBeyondItem.isWearingAll(owner)) {
                BatmanBeyondItem.applySetEffect(owner);
            }
            if (TasItem.isWearingAll(owner)) {
                TasItem.applySetEffect(owner);
            }
            if (TnbaItem.isWearingAll(owner)) {
                TnbaItem.applySetEffect(owner);
            }
            if (ArkhamAsylumItem.isWearingAll(owner)) {
                ArkhamAsylumItem.applySetEffect(owner);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "canHaveStatusEffect", cancellable = true)
    protected void effectImmunity(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = LivingEntity.class.cast(this);
        StatusEffect statusEffect = effect.getEffectType();
        if (statusEffect == StatusEffects.BLINDNESS && (ChristianBaleItem.isWearingAll(entity) || BenAffleckItem.isWearingAll(entity) ||
                RobertPattinsonItem.isWearingAll(entity) || HellbatItem.isWearingAll(entity) || BatmanBeyondItem.isWearingAll(entity))) {
            cir.setReturnValue(false);
        }
        if (statusEffect == StatusEffects.GLOWING && StealthSuitItem.isWearingAll(entity)) {
            cir.setReturnValue(false);
        }
    }
}