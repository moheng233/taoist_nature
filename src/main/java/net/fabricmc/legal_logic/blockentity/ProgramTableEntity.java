package net.fabricmc.legal_logic.blockentity;

import net.fabricmc.legal_logic.BlockEntityReagistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import spinnery.common.BaseInventory;

public class ProgramTableEntity extends BlockEntity {

    public Inventory DiagramInventory;

    public ProgramTableEntity() {
        super(BlockEntityReagistry.PROGRAMTABLEENTITY);
        DiagramInventory = new BaseInventory(1);
    }
    
}