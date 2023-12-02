package net.jonathan.jonathansbatsuits.entity.client.entity_renderers;

import net.jonathan.jonathansbatsuits.entity.client.entity_models.BatarangModel;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatarangEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BatarangRenderer extends GeoEntityRenderer<BatarangEntity> {
    public BatarangRenderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new BatarangModel());
    }

    //Due to GeckoLib 4's system of universalizing most of the entity, model and renderer classes, the preRender() method needs to be overwritten and
    //the y and z rotation axis need to be set to the entity's yaw and pitch, respectively, in order for the entity to render properly as a projectile.

    @Override
    public void preRender(MatrixStack poseStack, BatarangEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer,
                          boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getYaw() - 90.0F));
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(entity.getPitch()));
    }
}