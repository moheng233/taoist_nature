package net.fabricmc.legal_logic.LuaEngine;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class Engine {
    public Globals globals;

    public Engine (){
        
    }

    public void InitLua() {
        // 初始化lua脚本环境
        globals = JsePlatform.standardGlobals();

        globals.get("print").call(LuaValue.valueOf("Lua 环境加载成功"));
    }
}