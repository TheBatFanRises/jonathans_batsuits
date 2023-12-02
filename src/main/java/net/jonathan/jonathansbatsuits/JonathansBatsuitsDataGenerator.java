package net.jonathan.jonathansbatsuits;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jonathan.jonathansbatsuits.recipes.ModRecipeProviders;
import net.minecraft.data.DataProvider;

public class JonathansBatsuitsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModRecipeProviders::new);
	}
}
