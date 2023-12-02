package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.jonathan.jonathansbatsuits.item.custom.DetectiveVisionItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(MinecraftClient.class)
public abstract class DetectiveVisionAbility {
    @Shadow @Nullable public ClientPlayerEntity player;
    @Shadow @Nullable public ClientWorld world;

    @Unique
    private static boolean isDetectiveVisionLenses(ItemStack stack) {
        return stack.getItem() == ModItems.DETECTIVE_VISION_LENSES;
    }

    @Inject(at = @At("HEAD"), method = "hasOutline", cancellable = true)
    protected void detectEntities(Entity entity, CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = this.player;

        float q = 30.0F;
        assert player != null;
        int k = MathHelper.floor(player.getX() - (double) q - 1.0D);
        int l = MathHelper.floor(player.getX() + (double) q + 1.0D);
        int t = MathHelper.floor(player.getY() - (double) q - 1.0D);
        int u = MathHelper.floor(player.getY() + (double) q + 1.0D);
        int v = MathHelper.floor(player.getZ() - (double) q - 1.0D);
        int w = MathHelper.floor(player.getZ() + (double) q + 1.0D);

        List<Entity> list = (player.getEntityWorld()).getOtherEntities(player,
                new Box((double) k, (double) t, (double) v, (double) l, (double) u, (double) w));
        Vec3d vec3d = new Vec3d(player.getX(), player.getY(), player.getZ());
        for (int x = 0; x < list.size(); ++x) {
            entity = (Entity) list.get(x);
            double y = (double) (MathHelper.sqrt((float) entity.squaredDistanceTo(vec3d)) / q);

            if (y <= 1.0D && DetectiveVisionItem.useDetectiveVisionLenses(player) && KeyInputHandler.dvTick <= 100) {
                cir.setReturnValue(true);
            }
        }
    }
}
