package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.event.custom_events.ModElytraItem;
import net.jonathan.jonathansbatsuits.integration.trinkets.ElytraTrinketHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
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
        
        ItemStack itemStack = (ElytraTrinketHandler.slotProvider == null) ? user.getEquippedStack(EquipmentSlot.CHEST) :
                ElytraTrinketHandler.slotProvider.getElytra(user, user::getEquippedStack);

        /**
            The SlotProvider.getElytra method will return null if the FireworkRocketItem.use method is called and there is nothing in the cape slot, thus crashing the game.
            The way the itemStack variable is instantiated above allows the second if statement to properly check to see if the itemStack is null. That way, instead of crashing
            the game, it can proceed as normal.
        */
        
        if (itemStack != null && user.isFallFlying() && itemStack.getItem() instanceof ModElytraItem) {
            cir.setReturnValue(TypedActionResult.pass(user.getStackInHand(hand)));
        }

        //The following code is mostly copy-pasted from the FireworkRocketItem.use method. I'm basically 'spelling it out' for Minecraft.
        
        if (itemStack == null && user.isFallFlying()) {
            FireworkRocketItem firework = FireworkRocketItem.class.cast(this);
            ItemStack itemStack1 = user.getStackInHand(hand);
            if (!world.isClient) {
                FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world, itemStack1, user);
                world.spawnEntity(fireworkRocketEntity);
                if (!user.getAbilities().creativeMode) {
                    itemStack1.decrement(1);
                }
                user.incrementStat(Stats.USED.getOrCreateStat(firework));
            }
            cir.setReturnValue(TypedActionResult.success(user.getStackInHand(hand), world.isClient()));
        }
    }
}
