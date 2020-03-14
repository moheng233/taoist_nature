package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.legal_logic.item.*;

public class ItemReagistry implements ModInitializer {

    // 实例化item类
    public static final LingshiPowder LINGSHIPOWDER = new LingshiPowder(
            new Settings().group(LegalLogicMod.LOGICGROUP));
    public static final Lingshi LINGSHI = new Lingshi(new Settings().group(LegalLogicMod.LOGICGROUP));
    public static final QuankunDag QIANKUNDAG = new QuankunDag(new Settings().group(LegalLogicMod.LOGICGROUP));
    public static final MatrixMethodDiagram MATRIXMETHODDIAGRAM = new MatrixMethodDiagram(new Settings().group(LegalLogicMod.LOGICGROUP));

    public static final BlockItem LINGSHIMINEITEM = new BlockItem(BlockReagistry.LINGSHIMINE,
        new Item.Settings().group(LegalLogicMod.LOGICGROUP));
    public static final BlockItem PORTRAYTABLEITEM = new BlockItem(BlockReagistry.PORTRAYTABLE,
        new Item.Settings().group(LegalLogicMod.LOGICGROUP)
    );
    public static final BlockItem PROGRAMTABLEITEM = new BlockItem(BlockReagistry.PROGRAMTABLE,
        new Item.Settings().group(LegalLogicMod.LOGICGROUP)
    );
    public static final BlockItem MAGICITEM = new BlockItem(BlockReagistry.MAGIC,
        new Item.Settings().group(LegalLogicMod.MAGICGROUP)
    );

    public static final String MODID = LegalLogicMod.MODID;//在""中填写Modid
    
    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        System.out.println("逻辑法则初始化开始");

        // Item声明
        Registry.register(Registry.ITEM, new Identifier(MODID, "lingshi_mine"),LINGSHIMINEITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lingshi_powder"), LINGSHIPOWDER);
        Registry.register(Registry.ITEM, new Identifier(MODID, "portray_table"), PORTRAYTABLEITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "program_table"), PROGRAMTABLEITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lingshi"), LINGSHI);
        Registry.register(Registry.ITEM, new Identifier(MODID, "qiankun_dag"),QIANKUNDAG);
        Registry.register(Registry.ITEM, new Identifier(MODID, "magic"), MAGICITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "matrixmethod_diagran"), MATRIXMETHODDIAGRAM);
        
        System.out.println("逻辑法则物品初始化结束");
	}

}
