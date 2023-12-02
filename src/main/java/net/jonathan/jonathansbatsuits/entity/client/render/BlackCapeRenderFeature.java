package net.jonathan.jonathansbatsuits.entity.client.render;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.integration.trinkets.ElytraTrinketHandler;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class BlackCapeRenderFeature<T extends LivingEntity, M extends EntityModel<T>> extends ElytraFeatureRenderer<T, M> {
    private static final Identifier BLACK_CAPE = new Identifier(JonathansBatsuits.MOD_ID, "textures/entity/black_cape_model.png");

    private final ElytraEntityModel<T> elytra;

    public BlackCapeRenderFeature(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context, loader);
        this.elytra = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
    }
    public static boolean shouldRender(ItemStack stack, LivingEntity entity) {
        return stack.getItem() == ModItems.BLACK_CAPE;
    }
    public static ItemStack tryFindElytra(LivingEntity entity) {
        ItemStack elytra = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (shouldRender(elytra, entity)) {
            return elytra;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k,
                       float l) {
        AbstractClientPlayerEntity abstractClientPlayerEntity;
        ItemStack stack;
        if (ElytraTrinketHandler.slotProvider == null) {
            stack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        } else {
            ElytraTrinketHandler.SlotProvider slotProvider = ElytraTrinketHandler.slotProvider;
            Objects.requireNonNull(livingEntity);
            stack = slotProvider.getElyra(livingEntity, livingEntity::getEquippedStack);
        }
        ItemStack itemStack = stack;
        if (itemStack != null && itemStack.getItem() == ModItems.BLACK_CAPE && itemStack.getItem() instanceof FabricElytraItem) {
            Identifier identifier = livingEntity instanceof AbstractClientPlayerEntity ? ((abstractClientPlayerEntity =
                    (AbstractClientPlayerEntity) livingEntity).canRenderElytraTexture() && abstractClientPlayerEntity.getElytraTexture() != null ?
                    abstractClientPlayerEntity.getElytraTexture() : BLACK_CAPE) : BLACK_CAPE;
            matrixStack.push();
            matrixStack.translate(0.0, 0.0, 0.125);
            ((EntityModel) this.getContextModel()).copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, RenderLayer.getArmorCutoutNoCull(identifier),
                    false, itemStack.hasGlint());
            this.elytra.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
            matrixStack.pop();
        }
    }
}