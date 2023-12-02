package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.integration.trinkets.ElytraTrinketHandler;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(AbstractClientPlayerEntity.class)
public class DisableCape {
    @Inject(at = @At("HEAD"), method = "canRenderCapeTexture", cancellable = true)
    protected void disableCapeRenderer(CallbackInfoReturnable<Boolean> cir) {
        AbstractClientPlayerEntity player = AbstractClientPlayerEntity.class.cast(this);
        ItemStack stack;
        if (ElytraTrinketHandler.slotProvider == null) {
            stack = player.getEquippedStack(EquipmentSlot.CHEST);
        } else {
            ElytraTrinketHandler.SlotProvider slotProvider = ElytraTrinketHandler.slotProvider;
            Objects.requireNonNull(player);
            stack = slotProvider.getElyra(player, player::getEquippedStack);
        }
        ItemStack itemStack = stack;
        if (itemStack != null && itemStack.getItem() == ModItems.BAT_GLIDER)  {
            cir.setReturnValue(false);
        }
    }
}
