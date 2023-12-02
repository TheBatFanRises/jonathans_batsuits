package net.jonathan.jonathansbatsuits.item.custom;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BlueCapeItem extends ElytraItem implements FabricElytraItem {
    public BlueCapeItem(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.BLUE_WOOL);
    }
}