package net.fabricmc.legal_logic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class LegalLogicModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.print("客户端初始化开始");

        BlockRenderLayerMap.INSTANCE.putBlock(BlockReagistry.MAGIC,RenderLayer.getTranslucent());
    }
    
}