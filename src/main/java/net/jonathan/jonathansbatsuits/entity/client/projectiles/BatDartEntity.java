package net.jonathan.jonathansbatsuits.entity.client.projectiles;

import net.jonathan.jonathansbatsuits.entity.client.EntityRegister;
import net.jonathan.jonathansbatsuits.entity.damage.ModDamageTypes;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BatDartEntity extends ThrownItemEntity {
    public BatDartEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super((EntityType<? extends BatDartEntity>)entityType, world);
    }
    /**
    Save for future development
    public BatDartEntity(World world, LivingEntity livingEntity) {
        super((EntityType<? extends BatDartEntity>)EntityRegister.BAT_DART_ENTITY, livingEntity, world);
    }

    @Override
    public void tick() {
        super.tick();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            if (hitResult instanceof EntityHitResult entityHitResult) {
                Entity entity = entityHitResult.getEntity();
                float f = 4.0F;
                if (entity instanceof LivingEntity livingEntity) {
                    f += EnchantmentHelper.getAttackDamage(asItemStack(), livingEntity.getGroup());
                }

                Entity entity2 = this.getOwner();
                SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
                if (entity.damage(entity.getDamageSources().create(ModDamageTypes.BATARANG, entity2), f)) {
                    if (entity.getType() == EntityType.ENDERMAN) {
                        return;
                    }

                    if (entity instanceof LivingEntity) {
                        LivingEntity livingEntity2 = (LivingEntity) entity;
                        if (entity2 instanceof LivingEntity) {
                            EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                            EnchantmentHelper.onTargetDamaged((LivingEntity) entity2, livingEntity2);
                        }
                    }
                }
            }
        }
    }
     */
    @Override
    protected Item getDefaultItem() {
        return ModItems.BAT_DART;
    }
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.BAT_DART);
    }
}
