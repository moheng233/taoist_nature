package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.legal_logic.LuaEngine.Engine;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class LegalLogicMod implements ModInitializer {

    public static final String MODID = "legal_logic";//在""中填写Modid

    // 声明ItemGroup
    public static final ItemGroup LOGICGROUP = FabricItemGroupBuilder
            .create(new Identifier("legal_logic", "base_group"))
            .icon(() -> new ItemStack(ItemReagistry.LINGSHIPOWDER))
            .build();

    public static final ItemGroup MAGICGROUP = FabricItemGroupBuilder
        .create(new Identifier(MODID,"magic_group"))
        .icon(() -> new ItemStack(ItemReagistry.MATRIXMETHODDIAGRAM))
        .build();


    public static Engine ENGINE;
    
    @Override
	public void onInitialize() {

	}

}
