package net.jonathan.jonathansbatsuits.integration.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.jonathan.jonathansbatsuits.event.custom_events.ModElytraItem;
import net.jonathan.jonathansbatsuits.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ElytraTrinketHandler {
    public static SlotProvider slotProvider = null;
    public static BiConsumer<LivingEntity, ItemStack> onBreak = (entity, chestStack) -> {
        entity.sendEquipmentBreakStatus(EquipmentSlot.CHEST);
    };
    private static boolean isElytra(ItemStack stack) {
        return stack.getItem() instanceof ModElytraItem;
    }

    public static void register() {
        slotProvider = (entity, slotGetter) -> {
            ItemStack itemStack = (ItemStack)slotGetter.apply(EquipmentSlot.CHEST);
            if (isElytra(itemStack)) {
                return itemStack;
            } else {
                Optional<TrinketComponent> trinketComponent = TrinketsApi.getTrinketComponent(entity);
                if (trinketComponent.isPresent()) {
                    List<Pair<SlotReference, ItemStack>> equipped = ((TrinketComponent)trinketComponent.get()).getEquipped(ElytraTrinketHandler::isElytra);
                    if (!equipped.isEmpty()) {
                        return (ItemStack)((Pair)equipped.get(0)).getRight();
                    }
                }
                return null;
            }
        };
        onBreak = (entity, chestStack) -> {
            Optional<TrinketComponent> trinketComponent = TrinketsApi.getTrinketComponent(entity);
            if (trinketComponent.isPresent()) {
                List<Pair<SlotReference, ItemStack>> equipped = ((TrinketComponent)trinketComponent.get()).getEquipped(ElytraTrinketHandler::isElytra);

                for (Pair<SlotReference, ItemStack> slot : equipped) {
                    ItemStack slotStack = (ItemStack)slot.getRight();
                    if (slotStack == chestStack) {
                        TrinketsApi.onTrinketBroken(slotStack, (SlotReference) slot.getLeft(), entity);
                    }
                }
            }
        };
        EntityElytraEvents.CUSTOM.register(ElytraTrinketHandler::useElytraTrinket);
        EntityElytraEvents.CUSTOM.register(ElytraTrinketHandler::useElytraChestStack);
    }

    private static boolean useElytraTrinket(LivingEntity entity, boolean tickElytra) {
        Optional<TrinketComponent> trinketComponent = TrinketsApi.getTrinketComponent(entity);
        if (trinketComponent.isPresent()) {
            List<Pair<SlotReference, ItemStack>> equipped = ((TrinketComponent) trinketComponent.get()).getEquipped(ElytraTrinketHandler::isElytra);

            for (Pair<SlotReference, ItemStack> slot : equipped) {
                ItemStack stack = (ItemStack) slot.getRight();
                Item item = stack.getItem();
                if (item instanceof ModElytraItem modElytraItem && AdamWestItem.isWearingAll(entity)) {
                    if (modElytraItem.useCustomElytra(entity, stack, tickElytra)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean useElytraChestStack(LivingEntity entity, boolean tickElytra) {
        ItemStack stack = entity.getEquippedStack(EquipmentSlot.CHEST);
        Item item = stack.getItem();
        if (item instanceof ModElytraItem modElytraItem) {
            if (modElytraItem.useCustomElytra(entity, stack, tickElytra)) {
                return true;
            }
        }
        return false;
    }

    @FunctionalInterface
    public interface SlotProvider {
        ItemStack getElyra(LivingEntity entity, Function<EquipmentSlot, ItemStack> vari2);
    }
}
