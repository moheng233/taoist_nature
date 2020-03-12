package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.legal_logic.gui.*;
import net.minecraft.util.Identifier;
import spinnery.common.BaseContainer;

public class ContainerRegistry implements ModInitializer {

    public static final Identifier FLOURMACHINE = new Identifier("legal_logic","flour_machine");

    @Override
    public void onInitialize() {
        ContainerProviderRegistry.INSTANCE.registerFactory(FLOURMACHINE, 
            (syncId, id, player, buf) -> new FlourMachine(syncId, player.inventory));

        ScreenProviderRegistry.INSTANCE.registerFactory(FLOURMACHINE,
            FlourMachineScreen::new);
    }
    
}