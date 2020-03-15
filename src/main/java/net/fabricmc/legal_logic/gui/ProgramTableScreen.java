package net.fabricmc.legal_logic.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import spinnery.common.BaseContainerScreen;
import spinnery.widget.WAbstractWidget;
import spinnery.widget.WInterface;
import spinnery.widget.WPanel;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;

public class ProgramTableScreen extends BaseContainerScreen<ProgramTable> {

    public ProgramTableScreen(ProgramTable container) {
        super(container.name, container, container.player);

        Window window = MinecraftClient.getInstance().getWindow();

        WInterface mainInterface = getInterface();
        WPanel mainPanel = mainInterface.createChild(WPanel.class, Position.of(0,0,0),Size.of(18*12+8, 8 * 18 + 8)).setParent(mainInterface);

        mainPanel.setLabel(container.name);
        mainPanel.setOnAlign(WAbstractWidget::center);
        mainPanel.center();
        mainInterface.add(mainPanel);

    }
    
}