package net.jonathan.jonathansbatsuits.block;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.block.custom.ResonanceEngineBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //VisionSteps Blocks
    public static final ResonanceEngineBlock RESONANCE_ENGINE = registerBlock("resonance_engine", new ResonanceEngineBlock(
            AbstractBlock.Settings.create().hardness(2).nonOpaque()));

    public static <B extends Block> B registerBlock(String name, B block) {
        return Registry.register(Registries.BLOCK, new Identifier(JonathansBatsuits.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        JonathansBatsuits.LOGGER.info("Registering " + JonathansBatsuits.MOD_ID + " blocks");
    }
}
