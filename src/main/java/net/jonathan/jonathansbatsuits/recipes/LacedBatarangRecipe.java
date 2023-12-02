package net.jonathan.jonathansbatsuits.recipes;

import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class LacedBatarangRecipe extends SpecialCraftingRecipe {
    public LacedBatarangRecipe(Identifier identifier, CraftingRecipeCategory craftingRecipeCategory) {
        super(identifier, craftingRecipeCategory);
    }

    @Override
    public boolean matches(RecipeInputInventory recipeInputInventory, World world) {
        if (recipeInputInventory.getWidth() != 3 || recipeInputInventory.getHeight() != 3) {
            return false;
        }
        for (int i = 0; i < recipeInputInventory.getWidth(); ++i) {
            for (int j = 0; j < recipeInputInventory.getHeight(); ++j) {
                ItemStack itemStack = recipeInputInventory.getStack(i + j * recipeInputInventory.getWidth());
                if (itemStack.isEmpty()) {
                    return false;
                }
                if (!(i == 1 && j == 1 ? !itemStack.isOf(Items.LINGERING_POTION) : !itemStack.isOf(ModItems.BATARANG))) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack craft(RecipeInputInventory recipeInputInventory, DynamicRegistryManager dynamicRegistryManager) {
        ItemStack itemStack = recipeInputInventory.getStack(1 + recipeInputInventory.getWidth());
        if (!itemStack.isOf(Items.LINGERING_POTION)) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStack2 = new ItemStack(ModItems.LACED_BATARANG, 8);
        PotionUtil.setPotion(itemStack2, PotionUtil.getPotion(itemStack));
        PotionUtil.setCustomPotionEffects(itemStack2, PotionUtil.getCustomPotionEffects(itemStack));
        return itemStack2;
    }

    @Override
    public boolean fits(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSeriealizer.LACED_BATARANG;
    }
}
