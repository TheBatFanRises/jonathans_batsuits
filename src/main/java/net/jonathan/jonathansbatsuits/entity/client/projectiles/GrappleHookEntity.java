package net.jonathan.jonathansbatsuits.entity.client.projectiles;

import net.jonathan.jonathansbatsuits.entity.client.EntityRegister;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.jonathan.jonathansbatsuits.item.custom.GrappleGunItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GrappleHookEntity extends PersistentProjectileEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GrappleHookEntity(EntityType<? extends GrappleHookEntity> entityType, World world) {
        super(entityType, world);
    }

    public GrappleHookEntity(World world, LivingEntity livingEntity) {
        super((EntityType<? extends GrappleHookEntity>)EntityRegister.GRAPPLE_HOOK_ENTITY, livingEntity, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity shooter = this.getOwner();
        Entity hookedEntity = entityHitResult.getEntity();
        assert shooter != null;
        Vec3d distance = shooter.getPos().subtract(hookedEntity.getPos());
        Vec3d motion = distance.normalize();
        if (Math.abs(distance.y) < 0.1D) {
            motion = new Vec3d(motion.x, 0, motion.z);
        }
        if (new Vec3d(distance.x, 0, distance.z).length() < new Vec3d(hookedEntity.getWidth() / 2, 0, hookedEntity.getWidth() / 2).length() / 1.4) {
            motion = new Vec3d(0, motion.y, 0);
        }

        hookedEntity.setVelocity(motion);
        this.kill();
    }

    @Override
    public void tick() {
        Entity shooter = this.getOwner();
        if (shooter == null || this.isInLava() || this.getY() >= shooter.getY() + 60) {
            this.kill();
        }
        if (this.isSubmergedInWater()) {
            this.setVelocity(this.getVelocity().x * 2, this.getVelocity().y * 2, this.getVelocity().z * 2);
        }
        assert shooter != null;
        Vec3d distance = shooter.getPos().subtract(this.getPos());
        Vec3d motion = distance.normalize();
        if (this.inGround) {
            if (Math.abs(distance.y) < 0.1D) {
                motion = new Vec3d(motion.x, 0, motion.z);
            }
            if (new Vec3d(distance.x, 0, distance.z).length() < new Vec3d(this.getWidth() / 2, 0, this.getWidth() / 2).length() / 1.4) {
                motion = new Vec3d(0, motion.y, 0);
            }

            shooter.setVelocity(-1 * motion.x, -1 * motion.y, -1 * motion.z);

            if (distance.length() <= 1 || distance.length() >= 60) {
                this.kill();
            }
        }

        LivingEntity livingShooter = (LivingEntity)shooter;
        ItemStack mainHand = livingShooter.getMainHandStack();
        ItemStack offHand = livingShooter.getOffHandStack();

        if (mainHand.getItem() != ModItems.GRAPPLE_GUN && offHand.getItem() != ModItems.GRAPPLE_GUN) {
            this.discard();
        }
        super.tick();
    }

    public void use() {
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

    public void remove(RemovalReason reason) {
        super.remove(reason);
        this.setPlayerGrapple(null);
    }

    @Override
    public void onRemoved() {
        this.setPlayerGrapple(null);
    }

    @Override
    public void setOwner(@Nullable Entity entity) {
        super.setOwner(entity);
        this.setPlayerGrapple(this);
    }

    private void setPlayerGrapple(@Nullable GrappleHookEntity hookEntity) {
        PlayerEntity playerEntity = (PlayerEntity)this.getOwner();
        if (playerEntity != null) {
            GrappleGunItem.hookEntity = hookEntity;
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 20, state -> {
            state.getController().setAnimation(RawAnimation.begin().thenLoop("spinning"));
            if (!this.inGround) {
                return PlayState.CONTINUE;
            } else {
                return PlayState.STOP;
            }
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
