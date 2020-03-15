package net.fabricmc.legal_logic.gui;

import net.fabricmc.legal_logic.blockentity.ProgramTableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.OceanMonumentGenerator.Base;
import net.minecraft.text.Text;
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

    public ProgramTable(int synchronizationID, PlayerInventory linkedPlayerInventory,PacketByteBuf buf) {
        super(synchronizationID, linkedPlayerInventory);

        this.player = linkedPlayerInventory.player;

        if (player.world.isClient) {
            pos = buf.readBlockPos();
            entity = (ProgramTableEntity) player.world.getBlockEntity(pos);
        }

        WInterface mainInterface = getInterface();
        BaseInventory DiagramInventory = (BaseInventory) entity.DiagramInventory;

        if (!player.world.isClient){

        }

        mainInterface.createChild(WTextField.class);

        getInventories().put(BACKPACK_INVENTORY, DiagramInventory);


    }

    
}