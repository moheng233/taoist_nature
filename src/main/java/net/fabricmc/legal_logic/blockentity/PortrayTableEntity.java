package net.fabricmc.legal_logic.blockentity;

import net.fabricmc.legal_logic.BlockEntityReagistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class PortrayTableEntity extends BlockEntity{

    public CompoundTag Inventory = null;
    public double Schedule = 0f;

    public PortrayTableEntity() {
        super(BlockEntityReagistry.PORTRAYTABLEENTITY);
        System.out.println("233");
    }

    @Override
    public void fromTag(CompoundTag tag) {
        this.pos = new BlockPos(tag.getInt("x"), tag.getInt("y"), tag.getInt("z"));
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
        Identifier identifier = BlockEntityType.getId(this.getType());
        if (identifier == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        } else {
            tag.putString("id", identifier.toString());
            tag.putInt("x", this.pos.getX());
            tag.putInt("y", this.pos.getY());
            tag.putInt("z", this.pos.getZ());
        }
        tag.put("Inventory", Inventory);
        tag.putDouble("Schedule",Schedule);
        return tag;
    }
}