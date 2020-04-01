package xyz.moheng.taoist_nature.gui;

import spinnery.common.BaseContainerScreen;
import spinnery.widget.WAbstractWidget;
import spinnery.widget.WInterface;
import spinnery.widget.WPanel;
import spinnery.widget.WSlot;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;

public class PortrayTableScreen extends BaseContainerScreen<PortrayTable> {
    public PortrayTableScreen(PortrayTable container) {
        super(container.name, container, container.player);

        WInterface mainInterface = getInterface();

        WPanel mainPanel = mainInterface.createChild(WPanel.class, Position.of(0, 0, 0), Size.of(9 * 18 + 8, 5 * 18 + 108)).setParent(mainInterface);

        mainPanel.setLabel(container.name);
        mainPanel.setOnAlign(WAbstractWidget::center);
        mainPanel.center();
        mainInterface.add(mainPanel);

        WSlot.addPlayerInventory(Position.of(mainPanel, ((mainPanel.getWidth()) / 2) - (int) (18 * 4.5f), 5 * 18 + 24, 1), Size.of(18, 18), mainInterface);
        // WSlot.addArray(Position.of(mainPanel, 21, 37, 1), Size.of(18, 18), mainInterface, 0, 
        //     container.BACKPACK_INVENTORY, 2, 1);

        mainInterface.createChild(WSlot.class,Position.of(mainPanel, 21, 18*2+9, 1),Size.of(18, 18))
            .setInventoryNumber(container.BACKPACK_INVENTORY)
            .setSlotNumber(0);

        mainInterface.createChild(WSlot.class,Position.of(mainPanel, 40, 18*2+9, 1),Size.of(18, 18))
            .setInventoryNumber(container.BACKPACK_INVENTORY)
            .setSlotNumber(1);

        mainInterface.createChild(WSlot.class,Position.of(mainPanel, 129, 18*2+9, 1), Size.of(18,18))
            .setInventoryNumber(container.BACKPACK_INVENTORY)
            .setSlotNumber(2)
            .setLocked(true);
    
        
    }


}