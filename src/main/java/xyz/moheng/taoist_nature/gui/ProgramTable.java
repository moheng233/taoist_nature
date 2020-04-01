package xyz.moheng.taoist_nature.gui;

import xyz.moheng.taoist_nature.blockentity.ProgramTableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.OceanMonumentGenerator.Base;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.common.BaseInventory;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;
import spinnery.widget.WTextField;

public class ProgramTable extends BaseContainer {

    public static final int BACKPACK_INVENTORY = 3;

    public Text name;
    public PlayerEntity player;
    public BlockPos pos;
    public ProgramTableEntity entity;
    public CompoundTag tag;
    public BaseInventory DiagramInventory;

    public ProgramTable(int synchronizationID, PlayerInventory linkedPlayerInventory,BlockPos pos) {
        super(synchronizationID, linkedPlayerInventory);

        this.player = linkedPlayerInventory.player;
        this.name = new TranslatableText("block.taoist_nature.program_table");

        WInterface mainInterface = getInterface();

        if (!player.world.isClient) {
            this.pos = pos;
            entity = (ProgramTableEntity) player.world.getBlockEntity(this.pos);
            DiagramInventory = (BaseInventory) entity.DiagramInventory;
            
        }

        getInventories().put(BACKPACK_INVENTORY, DiagramInventory);



    }

    
}