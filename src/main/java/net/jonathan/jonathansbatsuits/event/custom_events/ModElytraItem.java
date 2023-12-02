/**
 * The sole purpose of this class is to solve compatibility issues with other mods by making my own elytra item interface rather than using Fabric's
 */
package net.jonathan.jonathansbatsuits.event.custom_events;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.event.GameEvent;

public interface ModElytraItem {
    default boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        if (ElytraItem.isUsable(chestStack)) {
            if (tickElytra) {
                doVanillaElytraTick(entity, chestStack);
            }

            return true;
        }

        return false;
    }
    default void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
        int nextRoll = entity.getRoll() + 1;

        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            if ((nextRoll / 10) % 2 == 0) {
                chestStack.damage(1, entity, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
            }

            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
        }
    }
}
