package net.jonathan.jonathansbatsuits.item.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class DetectiveVisionItem extends Item {
    public DetectiveVisionItem(Settings settings) {
        super(settings);
    }
    private static boolean isDetectiveVisionLenses(ItemStack stack) {
        return stack.getItem() == ModItems.DETECTIVE_VISION_LENSES;
    }
    public static boolean useDetectiveVisionLenses(LivingEntity entity) {
        Optional<TrinketComponent> trinketComponent = TrinketsApi.getTrinketComponent(entity);
        if (trinketComponent.isPresent()) {
            List<Pair<SlotReference, ItemStack>> equipped = ((TrinketComponent) trinketComponent.get())
                    .getEquipped(DetectiveVisionItem::isDetectiveVisionLenses);

            for (Pair<SlotReference, ItemStack> slot : equipped) {
                ItemStack stack = (ItemStack) slot.getRight();
                Item item = stack.getItem();
                if (item == ModItems.DETECTIVE_VISION_LENSES && KeyInputHandler.DVtoggle) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Press the Detective Vision Key to").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("see all living entities within a").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("30 block radius.").formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" ").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("Vision will impede after 10 seconds").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("due to overheating.").formatted(Formatting.GRAY));
    }
}
