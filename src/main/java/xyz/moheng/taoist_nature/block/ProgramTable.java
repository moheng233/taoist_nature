package xyz.moheng.taoist_nature.block;

import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import xyz.moheng.taoist_nature.ContainerRegistry;
import xyz.moheng.taoist_nature.ItemReagistry;
import xyz.moheng.taoist_nature.blockentity.PortrayTableEntity;
import xyz.moheng.taoist_nature.blockentity.ProgramTableEntity;
import net.java.games.input.Component.Identifier.Key;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.Keyboard;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ProgramTable extends Table implements BlockEntityProvider {

    public ProgramTable(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new ProgramTableEntity();
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ProgramTableEntity entity = (ProgramTableEntity) world.getBlockEntity(pos);
            if(entity.getInvStack(0).getItem() == Items.AIR){
                ItemStack pStack = player.getItemsHand().iterator().next();
                if (pStack.getItem() == ItemReagistry.MATRIXMETHODDIAGRAM){
                    ItemStack stack = pStack.copy();
                    pStack.setCount(pStack.getCount()-1);
                    stack.setCount(1);
                    entity.setInvStack(0, stack);
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.FAIL;
                }
            } else {
                if(player.isDescending()){
                    ItemScatterer.spawn(world, pos, entity.DiagramInventory);
                    entity.rendereItem(new ItemStack(Items.AIR));
                } else {
                    ContainerProviderRegistry.INSTANCE.openContainer(ContainerRegistry.PROGRAMTABLE, player, (buffer) -> {
                        buffer.writeBlockPos(pos);
                    });
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ProgramTableEntity entity = (ProgramTableEntity) world.getBlockEntity(pos);
        ItemScatterer.spawn(world, pos, entity.DiagramInventory);
        super.onBlockRemoved(state, world, pos, newState, moved);
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