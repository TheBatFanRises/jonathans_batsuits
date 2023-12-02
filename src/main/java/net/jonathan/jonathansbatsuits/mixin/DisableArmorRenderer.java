package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.item.custom.BatmanBeyondItem;
import net.jonathan.jonathansbatsuits.item.custom.StealthSuitItem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//There are a couple of unconventional details that are needed in order for this mixin to work. They are highlighted in the comments.

@Mixin(ArmorFeatureRenderer.class)
public class DisableArmorRenderer<T extends LivingEntity, A extends BipedEntityModel<T>> {

    //The "render" method needs to be called. This method specifically calls other methods to render each armor piece on the entity model.
    @Inject(at = @At("HEAD"), method = "render*", cancellable = true)
    private void disableModel(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j,
                              float k, float l, CallbackInfo ci) {

        //These may look like simple if statements, but there's way more to them than meets the eye.
        //It doesn't matter what class it's in, the isWearingAll() method needs to return each individual ItemStack object, not just a true/false Boolean
        //value. Also, the second conditional needs to return an entity data tracker flag. Therefore, the called method is the isSneaking() method as appose
        //to the isInSneakingPose() method. For this to work whenever the entity has the Invisibility status effect, the isInvisible() method needs to be
        //called. If both conditionals are true, the method is cancelled, disabling the armor render.

        if (StealthSuitItem.isWearingAll(livingEntity) && livingEntity.isSneaking()) {
                ci.cancel();
        }
        if (BatmanBeyondItem.isWearingAll(livingEntity) && livingEntity.isInvisible()) {
                ci.cancel();
        }
    }
}
