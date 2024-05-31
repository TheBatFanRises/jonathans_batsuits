package net.jonathan.jonathansbatsuits.block.custom;

import net.jonathan.jonathansbatsuits.entity.client.BlockEntityRegister;
import net.jonathan.jonathansbatsuits.entity.client.block_entity.ResonanceEngineBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ResonanceEngineBlock extends BlockWithEntity implements BlockEntityProvider {

    public static boolean wasUsed;

    public ResonanceEngineBlock() {
        super(Settings.create().nonOpaque());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            wasUsed = !wasUsed;
        }
        return ActionResult.SUCCESS;
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
