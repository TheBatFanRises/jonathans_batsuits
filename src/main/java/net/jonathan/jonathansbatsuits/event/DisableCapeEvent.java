package net.jonathan.jonathansbatsuits.event;

import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class DisableCapeEvent implements LivingEntityFeatureRenderEvents.AllowCapeRender {
    @Override
    public boolean allowCapeRender(AbstractClientPlayerEntity player) {
        ItemStack stack = player.getEquippedStack(EquipmentSlot.CHEST);
        return stack.getItem() != ModItems.SCUBA_SUIT_WETSUIT && stack.getItem() != ModItems.HELLBAT_CHESTPLATE &&
                stack.getItem() != ModItems.BATMAN_BEYOND_CHESTPLATE;
    }
}
