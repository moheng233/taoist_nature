package net.fabricmc.legal_logic.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import spinnery.common.BaseContainer;
import spinnery.common.BaseInventory;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;

public class FlourMachine extends BaseContainer {

    public static final int BACKPACK_INVENTORY = 1;
    public Text name;
    public PlayerEntity player;

    public FlourMachine(int synchronizationID, PlayerInventory linkedPlayerInventory) {
        super(synchronizationID, linkedPlayerInventory);
        this.name = "磨粉机";
        this.player = linkedPlayerInventory.player;

        WInterface mainInterface = getInterface();
        BaseInventory backpackInventory = new BaseInventory(27);

        getInventories().put(BACKPACK_INVENTORY, backpackInventory);

        mainInterface.createChild(WSlot.class);
        WSlot.addHeadlessArray(mainInterface, 0, BACKPACK_INVENTORY, 9, 3);
        WSlot.addHeadlessPlayerInventory(mainInterface);


    }
    
}