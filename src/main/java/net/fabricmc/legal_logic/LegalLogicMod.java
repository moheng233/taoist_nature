package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;
import net.fabricmc.legal_logic.LuaEngine.Engine;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;


public class LegalLogicMod implements ModInitializer {

    // 声明ItemGroup
    public static final ItemGroup LOGICGROUP = FabricItemGroupBuilder
            .create(new Identifier("legal_logic", "base_group")).icon(() -> new ItemStack(ItemReagistry.LINGSHIPOWDER))
            .build();


    Engine ENGINE;

    public static final String MODID = "legal_logic";//在""中填写Modid
    
    @Override
	public void onInitialize() {

        ServerStartCallback.EVENT.register((MinecraftServer server) -> {
            ENGINE.InitLua();
        });

        ENGINE = new Engine();
	}

}
