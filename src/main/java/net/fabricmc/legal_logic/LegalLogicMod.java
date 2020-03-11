package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.legal_logic.block.*;
import net.fabricmc.legal_logic.item.*;


public class LegalLogicMod implements ModInitializer {

    // 声明ItemGroup
    public static final ItemGroup LOGICGROUP = FabricItemGroupBuilder
            .create(new Identifier("legal_logic", "base_group")).icon(() -> new ItemStack(LegalLogicMod.LINGSHIPOWDER))
            .build();

    // 实例化item类
    public static final LingshiPowder LINGSHIPOWDER = new LingshiPowder(new Item.Settings().group(LOGICGROUP));

    public static final Lingshi LINGSHI = new Lingshi(new Item.Settings().group(LOGICGROUP));

    // 实例化Block类
    public static final LingshiOre LINGSHIMINE = new LingshiOre(
        FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).breakByHand(false).build());
    public static final BlockItem LINGSHIMINEITEM = new BlockItem(LINGSHIMINE,
        new Item.Settings().group(LOGICGROUP));


    public static final String MODID = "legal_logic";//在""中填写Modid
    
    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        System.out.println("逻辑法则初始化开始");

        // Item声明
        Registry.register(Registry.ITEM, new Identifier(MODID, "lingshi_powder"), LINGSHIPOWDER);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lingshi"), LINGSHI);

        
        // Block声明
        Registry.register(Registry.BLOCK, new Identifier(MODID, "lingshi_mine"), LINGSHIMINE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lingshi_mine"),LINGSHIMINEITEM);
        
	}

}
