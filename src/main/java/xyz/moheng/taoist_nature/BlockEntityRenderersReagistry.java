package xyz.moheng.taoist_nature;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import xyz.moheng.taoist_nature.blockentityrenderer.*;

public class BlockEntityRenderersReagistry implements ClientModInitializer {

    
    public static final String MODID = LegalLogicMod.MODID;//在""中填写Modid
    @Override
	public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(
            BlockEntityReagistry.PROGRAMTABLEENTITY, ProgramTableEntityRenderer::new);
    }
}