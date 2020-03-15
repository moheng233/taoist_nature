package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.legal_logic.gui.*;
import net.minecraft.util.Identifier;

public class ContainerRegistry implements ModInitializer {

    public static final String MODID = LegalLogicMod.MODID;

    public static final Identifier QIANKUNDAG = new Identifier(MODID,"qiankun_dag");
    public static final Identifier PORTRAYTABLE = new Identifier(MODID,"portray_table");
    public static final Identifier PROGRAMTABLE = new Identifier(MODID, "program_table");

    @Override
    public void onInitialize() {

        System.out.println("逻辑法则UI初始化开始");


        ContainerProviderRegistry.INSTANCE.registerFactory(QIANKUNDAG, 
            (syncId, id, player, buf) -> new QiankunDag(syncId, player.inventory));
        ScreenProviderRegistry.INSTANCE.registerFactory(QIANKUNDAG,
            QiankunDagScreen::new);

        ContainerProviderRegistry.INSTANCE.registerFactory(PORTRAYTABLE, 
            (syncId,id,player,buf) -> new PortrayTable(syncId, player.inventory,buf.readBlockPos()));
        ScreenProviderRegistry.INSTANCE.registerFactory(PORTRAYTABLE,
            PortrayTableScreen::new);

        ContainerProviderRegistry.INSTANCE.registerFactory(PROGRAMTABLE, 
            (syncId,id,player,buf) -> new ProgramTable(syncId, player.inventory, buf.readBlockPos()));
        ScreenProviderRegistry.INSTANCE.registerFactory(PROGRAMTABLE, 
            ProgramTableScreen::new);
        
        System.out.println("逻辑法则UI初始化结束");
    }
    
}