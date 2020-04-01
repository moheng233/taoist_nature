package xyz.moheng.taoist_nature.block;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import xyz.moheng.taoist_nature.ContainerRegistry;
import xyz.moheng.taoist_nature.blockentity.PortrayTableEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PortrayTable extends Table implements BlockEntityProvider {

    public PortrayTable(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new PortrayTableEntity();
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ContainerProviderRegistry.INSTANCE.openContainer(ContainerRegistry.PORTRAYTABLE, player, (buffer) -> {
                buffer.writeBlockPos(pos);
            });
        }
        return ActionResult.SUCCESS;
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