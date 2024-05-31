package net.jonathan.jonathansbatsuits.entity.client;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.block.ModBlocks;
import net.jonathan.jonathansbatsuits.entity.client.block_entity.ResonanceEngineBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityRegister<T extends BlockEntity> {

    public static final BlockEntityType<ResonanceEngineBlockEntity> RESONANCE_ENGINE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(JonathansBatsuits.MOD_ID, "resonance_engine"), FabricBlockEntityTypeBuilder
                    .<ResonanceEngineBlockEntity>create(ResonanceEngineBlockEntity::new, ModBlocks.RESONANCE_ENGINE).build());


}
