package net.jonathan.jonathansbatsuits.recipes;

import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;

public interface ModRecipeSeriealizer<T extends CraftingRecipe> extends RecipeSerializer<T> {
    public static final RecipeSerializer<LacedBatarangRecipe> LACED_BATARANG = RecipeSerializer.register("crafting_special_lacedbatarang",
            new SpecialRecipeSerializer(LacedBatarangRecipe::new));
}
