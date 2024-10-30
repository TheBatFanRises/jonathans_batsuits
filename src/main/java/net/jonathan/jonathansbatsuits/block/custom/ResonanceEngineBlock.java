package net.jonathan.jonathansbatsuits.block.custom;

import net.jonathan.jonathansbatsuits.entity.client.block_entity.ResonanceEngineBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class ResonanceEngineBlock extends BlockWithEntity implements BlockEntityProvider {

    public ResonanceEngineBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ResonanceEngineBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
