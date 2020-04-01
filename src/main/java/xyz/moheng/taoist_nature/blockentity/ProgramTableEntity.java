package xyz.moheng.taoist_nature.blockentity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import xyz.moheng.taoist_nature.BlockEntityReagistry;
import xyz.moheng.taoist_nature.LegalLogicMod;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.PacketByteBuf;
import spinnery.common.BaseInventory;
import spinnery.util.InventoryUtilities;

public class ProgramTableEntity extends BlockEntity implements Inventory {

    public BaseInventory DiagramInventory;
    public ItemStack rendererItem;

    public ProgramTableEntity() {
        super(BlockEntityReagistry.PROGRAMTABLEENTITY);
        DiagramInventory = new BaseInventory(1);
        rendererItem = new ItemStack(Items.AIR);
    }

    @Override
    public void clear() {
        DiagramInventory.clear();

    }

    @Override
    public int getInvSize() {
        return 1;
    }

    @Override
    public boolean isInvEmpty() {
        return DiagramInventory.isInvEmpty();
    }

    @Override
    public ItemStack getInvStack(int slot) {
        return DiagramInventory.getInvStack(slot);
    }

    @Override
    public ItemStack takeInvStack(int slot, int amount) {
        return DiagramInventory.takeInvStack(slot, amount);
    }

    @Override
    public ItemStack removeInvStack(int slot) {
        return DiagramInventory.removeInvStack(slot);
    }

    @Override
    public void setInvStack(int slot, ItemStack object) {
        DiagramInventory.setInvStack(slot, object);
        if (slot == 0) {
            this.rendereItem(object);
        }
    }

    public void rendereItem(ItemStack stack){
        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(this);

            PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());

            buf.writeBlockPos(this.getPos());
            buf.writeItemStack(stack);

            watchingPlayers.forEach( player -> {
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, LegalLogicMod.RENDERER_PICKET_ID, buf);
            });
    }

    @Override
    public boolean canPlayerUseInv(PlayerEntity player) {
        return DiagramInventory.canPlayerUseInv(player);
    }
    
    @Override
    public void fromTag(CompoundTag tag){
        super.fromTag(tag);
        this.rendereItem(getInvStack(0));
        InventoryUtilities.read(DiagramInventory, (CompoundTag) tag.get("Inventory"));
    }

    @Override
    public CompoundTag toTag(CompoundTag tag){
        super.toTag(tag);
        CompoundTag inventory = new CompoundTag();
        InventoryUtilities.write(DiagramInventory, inventory);
        tag.put("Inventory", inventory );
        return tag;
    }

}