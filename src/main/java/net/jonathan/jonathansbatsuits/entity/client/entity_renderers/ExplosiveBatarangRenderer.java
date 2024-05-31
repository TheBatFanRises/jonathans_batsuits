package net.jonathan.jonathansbatsuits.entity.client.entity_renderers;

import net.jonathan.jonathansbatsuits.entity.client.entity_models.ExplosiveBatarangModel;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.ExplosiveBatarangEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ExplosiveBatarangRenderer extends GeoEntityRenderer<ExplosiveBatarangEntity> {
    public ExplosiveBatarangRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ExplosiveBatarangModel());
    }
    @Override
    public void preRender(MatrixStack poseStack, ExplosiveBatarangEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer,
                          boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getYaw() - 90));
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(entity.getPitch()));
    }
}
