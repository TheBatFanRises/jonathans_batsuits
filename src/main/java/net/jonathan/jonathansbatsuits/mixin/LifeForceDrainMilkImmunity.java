package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(MilkBucketItem.class)
public class LifeForceDrainMilkImmunity {
    int durationLFD = 0;
    @Inject(at = @At("HEAD"), method = "finishUsing")
    protected void onDrink1(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user.hasStatusEffect(ModEffects.LIFE_FORCE_DRAIN)) {
            this.durationLFD = Objects.requireNonNull(user.getStatusEffect(ModEffects.LIFE_FORCE_DRAIN)).getDuration();
        }
    }
    @Inject(at = @At("TAIL"), method = "finishUsing")
    protected void onDrink2(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (this.durationLFD != 0) {
            user.addStatusEffect(new StatusEffectInstance(ModEffects.LIFE_FORCE_DRAIN, this.durationLFD, 0, false, false,
                    true));
            this.durationLFD = 0;
        }
    }

}
