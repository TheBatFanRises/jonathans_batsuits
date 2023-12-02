package net.jonathan.jonathansbatsuits.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.data.server.recipe.ComplexRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class ModRecipeProviders extends FabricRecipeProvider {
    public ModRecipeProviders(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ComplexRecipeJsonBuilder.create(ModRecipeSeriealizer.LACED_BATARANG).offerTo(exporter, getRecipeName(ModItems.LACED_BATARANG));
    }
}
