package net.fabricmc.legal_logic.blockentity;

import net.fabricmc.legal_logic.BlockEntityReagistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class PortrayTableEntity extends BlockEntity{

    public CompoundTag Inventory = null;
    public double Schedule = 0f;

    public PortrayTableEntity() {
        super(BlockEntityReagistry.PORTRAYTABLEENTITY);
        System.out.println("233");
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        this.Inventory = (CompoundTag) tag.get("Inventory");
        this.Schedule = tag.getDouble("Schedule");
    }

    public CompoundTag getInventory(CompoundTag tag){
        return Inventory;

    }

    public void setInventory(CompoundTag tag){
        this.Inventory = tag;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.put("Inventory", Inventory);
        tag.putDouble("Schedule",Schedule);
        return tag;
    }
}