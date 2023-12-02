package net.jonathan.jonathansbatsuits.mixin;

import net.jonathan.jonathansbatsuits.entity.client.EntityRegister;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatarangEntity;
import net.jonathan.jonathansbatsuits.entity.damage.ModDamageSource;
import net.jonathan.jonathansbatsuits.entity.damage.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class ModDeathMessage {
    /**
    @Inject(at = @At("RETURN"), method = "onDeath")
    protected void deathMessage(DamageSource damageSource, CallbackInfo ci) {
        LivingEntity entity = LivingEntity.class.cast(this);
        BatarangEntity batarangEntity = new BatarangEntity(EntityRegister.BATARANG_ENTITY, entity.getEntityWorld());
        if (entity instanceof PlayerEntity playerEntity) {
            if (Objects.equals(damageSource, ModDamageSource.batarang(batarangEntity, null))) {
                playerEntity.sendMessage(Text.literal(playerEntity.getDisplayName() + " was pummelled with a batarang."));
            }
            if (Objects.equals(damageSource, ModDamageSource.hellbat())) {
                playerEntity.sendMessage(Text.literal(playerEntity.getDisplayName() + " wore the Hellbat for too long."));
            }
        }
    }
    */
}
