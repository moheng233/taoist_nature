package xyz.moheng.taoist_nature;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LegalLogicMod implements ModInitializer {

        public static final String MODID = "taoist_nature";// 在""中填写Modid

        public static final Identifier RENDERER_PICKET_ID = new Identifier(MODID, "renderer_picketid");

        // 声明ItemGroup
        public static final ItemGroup LOGICGROUP = FabricItemGroupBuilder
                        .create(new Identifier(MODID, "base_group"))
                        .icon(() -> new ItemStack(ItemReagistry.LINGSHIPOWDER)).build();

        public static final ItemGroup MAGICGROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "magic_group"))
                        .icon(() -> new ItemStack(ItemReagistry.MATRIXMETHODDIAGRAM)).build();

        @Override
        public void onInitialize() {
        }

}
