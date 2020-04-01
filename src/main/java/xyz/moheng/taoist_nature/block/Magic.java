package xyz.moheng.taoist_nature.block;

import com.google.common.util.concurrent.Service.State;

import xyz.moheng.taoist_nature.blockentity.MagicEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Magic extends Block implements BlockEntityProvider {

    public static final DirectionProperty FACING;

    public Magic(Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new MagicEntity();
    }

    @Override
    public float getHardness(BlockState state, BlockView world, BlockPos pos) {
        return 0.5f;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ctx) {
        Direction direction = state.get(FACING);
        double unit = 1f/16f;
        if(direction == Direction.DOWN){
            return VoxelShapes.cuboid(0f, 1f, 0f, 1f, 1f-unit, 1f);
        } else if (direction == Direction.UP ){
            return VoxelShapes.cuboid(0f, 0f, 0f, 1f, unit, 1f);
        } else if (direction == Direction.NORTH) {
            return VoxelShapes.cuboid(0f, 0f, 1f-unit, 1f, 1f, 1f);
        } else if (direction == Direction.SOUTH) {
            return VoxelShapes.cuboid(0f, 0f, 0, 1f, 1f, unit);
        } else if (direction == Direction.EAST) {
            return VoxelShapes.cuboid(0f, 0f, 0f, unit, 1f, 1f);
        } else if (direction == Direction.WEST) {
            return VoxelShapes.cuboid(1f-unit, 0f, 0f, 1f, 1f, 1f);
        }
        return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 1/16f, 1f);
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    static {
        FACING = Properties.FACING;
    }

}