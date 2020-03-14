package net.fabricmc.legal_logic;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;
import net.fabricmc.legal_logic.LuaEngine.Engine;
import net.minecraft.server.MinecraftServer;

public class LegalLogicModServer implements DedicatedServerModInitializer {
    
    @Override
    public void onInitializeServer() {
        System.out.println("服务端初始化开始");

        // 对于Lua环境的初始化
        ServerStartCallback.EVENT.register((MinecraftServer server) -> {
            LegalLogicMod.ENGINE.InitLua();
        });

        LegalLogicMod.ENGINE = new Engine();

    }
    
}