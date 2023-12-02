package net.jonathan.jonathansbatsuits.entity.client.projectiles;

import net.jonathan.jonathansbatsuits.entity.client.EntityRegister;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class SmokePelletEntity extends ThrownItemEntity {
    public SmokePelletEntity(EntityType<? extends SmokePelletEntity> entityType, World world) {
        super((EntityType<? extends SmokePelletEntity>)entityType, world);
    }
    public SmokePelletEntity(World world, LivingEntity owner) {
        super((EntityType<? extends SmokePelletEntity>)EntityRegister.SMOKE_PELLET_ENTITY, owner, world);
    }

    @Override
    protected Item getDefaultItem() {return ModItems.SMOKE_PELLET;}

    @Override
    public void tick() {
        super.tick();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
            this.getEntityWorld().playSound(null, blockPos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            if (!this.getEntityWorld().isClient()) {
                ServerWorld serverWorld = (ServerWorld)this.getEntityWorld();
                this.giveBlindness(serverWorld);
                for (int i = 0; i < 20; i++) {
                    serverWorld.spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(),
                            25, 1.0, 1.0, 1.0, 0.05);
                }
            }
        }
    }
    public void giveBlindness(ServerWorld serverWorld) {
        float q = 6.0F;
        int k = MathHelper.floor(this.getX() - (double) q - 1.0D);
        int l = MathHelper.floor(this.getX() + (double) q + 1.0D);
        int t = MathHelper.floor(this.getY() - (double) q - 1.0D);
        int u = MathHelper.floor(this.getY() + (double) q + 1.0D);
        int v = MathHelper.floor(this.getZ() - (double) q - 1.0D);
        int w = MathHelper.floor(this.getZ() + (double) q + 1.0D);
        List<Entity> list = serverWorld.getOtherEntities(this.getOwner(),
                new Box((double) k, (double) t, (double) v, (double) l, (double) u, (double) w));
        Vec3d vec3d = new Vec3d(this.getX(), this.getY(), this.getZ());
        for (Entity value : list) {
            Entity entity = (Entity) value;
            double y = (double) (MathHelper.sqrt((float) entity.squaredDistanceTo(vec3d)) / q);
            if (y <= 1.0D) {
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 240));
                }
            }
        }
    }
}
