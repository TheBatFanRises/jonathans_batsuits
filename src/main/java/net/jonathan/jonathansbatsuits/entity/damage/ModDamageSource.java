package net.jonathan.jonathansbatsuits.entity.damage;

import net.jonathan.jonathansbatsuits.registry.ModRegistryKeys;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

public class ModDamageSource extends DamageSources {

    public DamageSource hellbat;

    public ModDamageSource(DynamicRegistryManager registryManager) {
        super(registryManager);
        this.hellbat = this.create(ModDamageTypes.HELLBAT);
    }

    public DamageSource batarang(PersistentProjectileEntity source, @Nullable Entity attacker) {
        return create(ModDamageTypes.BATARANG, source, attacker);
    }
    public DamageSource batDart(ThrownItemEntity source, @Nullable Entity attacker) {
        return create(ModDamageTypes.BAT_DART, source, attacker);
    }

    public DamageSource hellbat() {
        return hellbat;
    }
}
