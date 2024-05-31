package net.jonathan.jonathansbatsuits.entity.client.projectiles;

import net.jonathan.jonathansbatsuits.entity.client.EntityRegister;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ExplosiveBatarangEntity extends PersistentProjectileEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public ExplosiveBatarangEntity(EntityType<? extends ExplosiveBatarangEntity> entityType, World world) {
        super(entityType, world);
    }

    public ExplosiveBatarangEntity(World world, LivingEntity livingEntity) {
        super((EntityType<? extends ExplosiveBatarangEntity>)EntityRegister.EXPLOSIVE_BATARANG_ENTITY, livingEntity, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2, World.ExplosionSourceType.NONE);
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2, World.ExplosionSourceType.NONE);
        this.discard();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.EXPLOSIVE_BATARANG);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 20, state -> {
            state.getController().setAnimation(RawAnimation.begin().then("spinning", Animation.LoopType.LOOP));
            if (!this.inGround) {
                return PlayState.CONTINUE;
            } else {
                return PlayState.STOP;
            }
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
