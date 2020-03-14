package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.legal_logic.gui.*;
import net.minecraft.util.Identifier;

public class ContainerRegistry implements ModInitializer {

    public static final Identifier QIANKUNDAG = new Identifier("legal_logic","qiankun_dag");
    public static final Identifier PORTRAYTABLE = new Identifier("legal_logic","portray_table");

    @Override
    public void onInitialize() {

        System.out.println("逻辑法则UI初始化开始");


        ContainerProviderRegistry.INSTANCE.registerFactory(QIANKUNDAG, 
            (syncId, id, player, buf) -> new QiankunDag(syncId, player.inventory));

        ScreenProviderRegistry.INSTANCE.registerFactory(QIANKUNDAG,
            QiankunDagScreen::new);

        ContainerProviderRegistry.INSTANCE.registerFactory(PORTRAYTABLE, 
            (syncId,id,player,buf) -> new PortrayTable(syncId, player.inventory,buf));
        ScreenProviderRegistry.INSTANCE.registerFactory(PORTRAYTABLE,
            PortrayTableScreen::new);
        
        System.out.println("逻辑法则UI初始化结束");
    }
    
}