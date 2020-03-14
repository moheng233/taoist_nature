package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.fabricmc.legal_logic.block.*;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockReagistry implements ModInitializer {


    public static final LingshiOre LINGSHIMINE = new LingshiOre(
        FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).breakByHand(false).build());
        
    public static final PortrayTable PORTRAYTABLE = new PortrayTable(
        FabricBlockSettings.of(Material.METAL).build());

    public static final ProgramTable PROGRAMTABLE = new ProgramTable(
        FabricBlockSettings.of(Material.METAL).build()
    );
    public static final Magic MAGIC = new Magic(
        FabricBlockSettings.of(Material.METAL).build()
    );
    

        public static final String MODID = LegalLogicMod.MODID;//在""中填写Modid
    @Override
	public void onInitialize() {
        System.out.println("逻辑法则方块初始化开始");

        // Block声明
        Registry.register(Registry.BLOCK, new Identifier(MODID, "magic"), MAGIC);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "lingshi_mine"), LINGSHIMINE);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "portray_table"), PORTRAYTABLE);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "program_table"), PROGRAMTABLE);
    
        System.out.println("逻辑法则方块初始化结束");
    }
}