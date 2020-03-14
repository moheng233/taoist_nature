package net.fabricmc.legal_logic.block;

import net.fabricmc.legal_logic.blockentity.ProgramTableEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ProgramTable extends Table implements BlockEntityProvider {

    public ProgramTable(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new ProgramTableEntity();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ctx) {
        double var1 = 1f / 16f;
        return VoxelShapes.union(
                VoxelShapes.cuboid(0f, var1 * 11, 0f, 1f, 1f, 1f),
                VoxelShapes.cuboid(0f, 0f, 0f, var1 * 2, var1 * 11, var1 * 2),
                VoxelShapes.cuboid(var1 * 14, 0f, 0f, 1f, var1 * 11, var1 * 2),
                VoxelShapes.cuboid(0f, 0f, var1 * 14, var1 * 2, var1 * 11, 1f),
                VoxelShapes.cuboid(var1 * 14, 0f, var1 * 14, 1f, var1 * 11, 1f));

    }
    
}