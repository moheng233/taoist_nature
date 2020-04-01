package xyz.moheng.taoist_nature;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import xyz.moheng.taoist_nature.blockentity.ProgramTableEntity;

public class LegalLogicModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.print("客户端初始化开始");

        BlockRenderLayerMap.INSTANCE.putBlock(BlockReagistry.MAGIC,RenderLayer.getTranslucent());

        ClientSidePacketRegistry.INSTANCE.register(LegalLogicMod.RENDERER_PICKET_ID, 
            (packetContext,attachedData) -> {
                BlockPos pos = attachedData.readBlockPos();
                ItemStack stack = attachedData.readItemStack();
                packetContext.getTaskQueue().execute(() -> {
                    ProgramTableEntity entity = (ProgramTableEntity) packetContext.getPlayer().world.getBlockEntity(pos);
                    entity.rendererItem = stack;
                });
            }
        );
    }
    
}