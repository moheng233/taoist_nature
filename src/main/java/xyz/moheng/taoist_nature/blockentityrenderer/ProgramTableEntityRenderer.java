package xyz.moheng.taoist_nature.blockentityrenderer;

import xyz.moheng.taoist_nature.blockentity.ProgramTableEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

public class ProgramTableEntityRenderer extends BlockEntityRenderer<ProgramTableEntity> {

    public ProgramTableEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(ProgramTableEntity blockEntity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);
        // Rotate the item
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((blockEntity.getWorld().getTime() + tickDelta) * 4));
        MinecraftClient.getInstance().getItemRenderer().renderItem(blockEntity.rendererItem, ModelTransformation.Mode.GROUND,
                light, overlay, matrices, vertexConsumers);

        matrices.pop();
    }
    
}