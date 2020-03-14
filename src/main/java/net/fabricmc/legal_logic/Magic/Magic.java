package net.fabricmc.legal_logic.Magic;

import java.util.HashMap;

import org.luaj.vm2.LuaValue;

import net.minecraft.nbt.CompoundTag;

// 法术类，包括了法阵和法术
public class Magic {

    // Magic 的类型
    public enum Type {
        Matrixmethod, // 法阵(从放置开始，就进入run状态，执行者是法阵的BlockEntity)
        Spell         // 法术(当玩家/实体使用(也可以是实时的)时，才进入run状态，执行者是player/任意实体)
    }

    // 用来储存Magic的各个函数
    public HashMap<String,LuaValue> Funmap;

    public Magic() {

    }

    public static Magic fromTag(CompoundTag Tag) {
        return new Magic();
    }

    public CompoundTag toTag(CompoundTag tag) {

        return tag;
    }
}