package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.integration.trinkets.ElytraTrinketHandler;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(FireworkRocketItem.class)
public class RocketItemMixin {
    @Inject(at = @At("HEAD"), method = "use", cancellable = true)
    protected void useExcludeBatGlider(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack;
        if (ElytraTrinketHandler.slotProvider == null) {
            stack = user.getEquippedStack(EquipmentSlot.CHEST);
        } else {
            ElytraTrinketHandler.SlotProvider slotProvider = ElytraTrinketHandler.slotProvider;
            Objects.requireNonNull(user);
            stack = slotProvider.getElyra(user, user::getEquippedStack);
        }
        ItemStack itemStack = stack;
        if (user.isFallFlying() && itemStack.getItem() == ModItems.BAT_GLIDER) {
            cir.setReturnValue(TypedActionResult.pass(user.getStackInHand(hand)));
        }
    }
}
