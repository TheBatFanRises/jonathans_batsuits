package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.item.custom.ArcticSuitItem;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public class PowderSnowExemption {
    @Inject(at = @At("RETURN"), method = "canWalkOnPowderSnow", cancellable = true)
    private static void arcticSuitAbility(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof LivingEntity livingEntity) {
            if (ArcticSuitItem.isWearingAll(livingEntity)) {
                cir.setReturnValue(true);
            }
        }
    }
}