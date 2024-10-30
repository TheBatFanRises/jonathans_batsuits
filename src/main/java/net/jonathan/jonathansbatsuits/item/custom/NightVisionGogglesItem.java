package net.jonathan.jonathansbatsuits.item.custom;

import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NightVisionGogglesItem extends Item {

    public NightVisionGogglesItem(Settings settings) {
        super(settings);
    }
    public static boolean isNightVisionGoggles(ItemStack stack) {
        return stack.getItem() == ModItems.NIGHT_VISION_GOGGLES;
    }
}
