package net.fabricmc.legal_logic.gui;

import net.fabricmc.legal_logic.blockentity.PortrayTableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryListener;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.common.BaseInventory;
import spinnery.util.InventoryUtilities;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;

public class PortrayTable extends BaseContainer {

    public static final int BACKPACK_INVENTORY = 2;
    public Text name;
    public PlayerEntity player;
    public BlockPos pos;
    public CompoundTag tag;

    public PortrayTableEntity blockentity;

    public PortrayTable(int synchronizationID, PlayerInventory linkedPlayerInventory,PacketByteBuf buf) {
        super(synchronizationID, linkedPlayerInventory);
        this.name = new TranslatableText("block.legal_logic.portray_table");
        this.player = linkedPlayerInventory.player;
        
        WInterface mainInterface = getInterface();
        BaseInventory tableinventory = new BaseInventory(3);

        if (!this.player.world.isClient) {
            this.pos = buf.readBlockPos();
            blockentity = (PortrayTableEntity) player.world.getBlockEntity(pos);
        }

        if(!this.player.world.isClient){
            tag = blockentity.Inventory;
        }

        if(!this.player.world.isClient){
            if (tag != null) {
                InventoryUtilities.read(tableinventory, tag);
            }
        }

        getInventories().put(BACKPACK_INVENTORY,tableinventory);

        mainInterface.createChild(WSlot.class)
            .setSlotNumber(0)
            .setInventoryNumber(BACKPACK_INVENTORY);
        
        mainInterface.createChild(WSlot.class)
            .setSlotNumber(1)
            .setInventoryNumber(BACKPACK_INVENTORY);

        mainInterface.createChild(WSlot.class)
            .setSlotNumber(2)
            .setInventoryNumber(BACKPACK_INVENTORY);

        // WSlot.addHeadlessArray(mainInterface, 0, BACKPACK_INVENTORY, 3, 1);
        WSlot.addHeadlessPlayerInventory(mainInterface);

        if(!this.player.world.isClient){

            // for (WAbstractWidget o:mainInterface.getAllWidgets()) {
            //     WSlot wslot = (WSlot) o;
            //     if(wslot.getSlotNumber() == 1){
            //         wslot.accept(ItemReagistry.LINGSHI);
            //     }
            //     if(wslot.getSlotNumber() == 2){
            //         wslot.setLocked(true);
            //     }   
            // }

            tableinventory.addListener(new InventoryListener(){
                @Override
                public void onInvChange(Inventory inventory) {
                    CompoundTag tag = InventoryUtilities.write(getInventory(BACKPACK_INVENTORY), new CompoundTag());

                    blockentity.Inventory = tag;
                }
            });
        }
    }

    @Override
    public void close(PlayerEntity player){
        if (!this.player.world.isClient) {
            blockentity.Inventory = InventoryUtilities.write(getInventory(BACKPACK_INVENTORY), new CompoundTag());
        }
    }
    
}