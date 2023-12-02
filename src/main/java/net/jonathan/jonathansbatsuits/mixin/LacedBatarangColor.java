package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.collection.IdList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemColors.class)
public class LacedBatarangColor {
    private final IdList<ItemColorProvider> providers = new IdList(32);
    @Inject(at = @At("HEAD"), method = "register")
    protected void registerBatarangColors(ItemColorProvider provider, ItemConvertible[] items, CallbackInfo ci) {
        for (ItemConvertible itemConvertible : items) {
            this.providers.set((stack, tintIndex) -> tintIndex == 0 ? PotionUtil.getColor(stack) : -1, Item.getRawId(ModItems.LACED_BATARANG));
        }
    }
}
