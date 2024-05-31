package net.jonathan.jonathansbatsuits.entity.client.entity_renderers;

import net.jonathan.jonathansbatsuits.entity.client.entity_models.GrappleHookModel;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.GrappleHookEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GrappleHookRenderer extends GeoEntityRenderer<GrappleHookEntity> {
    public GrappleHookRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GrappleHookModel());
    }

    @Override
    public void preRender(MatrixStack poseStack, GrappleHookEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer,
                          boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getYaw()));
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(entity.getPitch()));
    }

    @Override
    public void render(GrappleHookEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        this.animatable = entity;

        defaultRender(poseStack, entity, bufferSource, null, null, entityYaw, partialTick, packedLight);

        PlayerEntity shooter = (PlayerEntity)entity.getOwner();
        Arm mainArm = MinecraftClient.getInstance().options.getMainArm().getValue();
        Hand activeHand = shooter.getActiveHand();


        poseStack.push();
        boolean rightHandIsActive = (mainArm == Arm.RIGHT && activeHand == Hand.MAIN_HAND) || (mainArm == Arm.LEFT && activeHand == Hand.OFF_HAND);
        double bodyYawToRads = Math.toRadians(shooter.bodyYaw);
        double radius = rightHandIsActive ? -0.4D : 0.4D;
        double startX = shooter.getX() + radius * Math.cos(bodyYawToRads);
        double startY = shooter.getY() + (shooter.getHeight() / 3D);
        double startZ = shooter.getZ() + radius * Math.sin(bodyYawToRads);
        float distanceX = (float) (startX - entity.getX());
        float distanceY = (float) (startY - entity.getY());
        float distanceZ = (float) (startZ - entity.getZ());
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderLayer.getLineStrip());
        MatrixStack.Entry entry = poseStack.peek();

        for (int z = 0; z <= 16; ++z) {
            renderRope(distanceX, distanceY, distanceZ, vertexConsumer, entry, percentage(z, 16), percentage(z + 1, 16));
        }

        poseStack.pop();
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    private static float percentage(int value, int max) {
        return (float)value / (float)max;
    }

    public void renderRope(float x, float y, float z, VertexConsumer buffer, MatrixStack.Entry matrices, float segmentStart, float segmentEnd) {
        float f = x * segmentStart;
        float g = y * (segmentStart * segmentStart + segmentStart) * 0.5f + 0.25f;
        float h = z * segmentStart;
        float i = x * segmentEnd - f;
        float j = y * (segmentEnd * segmentEnd + segmentEnd) * 0.5f + 0.25f - g;
        float k = z * segmentEnd - h;
        float l = MathHelper.sqrt(i * i + j * j + k * k);
        buffer.vertex(matrices.getPositionMatrix(), f, g, h).color(0, 0, 0, 255).normal(matrices.getNormalMatrix(), i /= l, j /= l, k /= l)
                .next();
    }
}
