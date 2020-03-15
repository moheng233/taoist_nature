package net.fabricmc.legal_logic.blockentity;

import net.fabricmc.legal_logic.BlockEntityReagistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import spinnery.common.BaseInventory;

public class ProgramTableEntity extends BlockEntity implements Inventory {

    public Inventory DiagramInventory;

    public ProgramTableEntity() {
        super(BlockEntityReagistry.PROGRAMTABLEENTITY);
        DiagramInventory = new BaseInventory(1);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getInvSize() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public boolean isInvEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ItemStack getInvStack(int slot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack takeInvStack(int slot, int amount) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack removeInvStack(int slot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInvStack(int slot, ItemStack stack) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canPlayerUseInv(PlayerEntity player) {
        // TODO Auto-generated method stub
        return false;
    }
    
}