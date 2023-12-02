package net.jonathan.jonathansbatsuits.entity.damage;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.registry.ModRegistryKeys;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public interface ModDamageTypes {
    public static final RegistryKey<DamageType> BATARANG = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "damage_type/batarang"));
    public static final RegistryKey<DamageType> HELLBAT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "damage_type/hellbat"));

    public static final RegistryKey<DamageType> BAT_DART = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "damage_type/bat_dart"));

    public static void registerModDamageTypes(Registerable<DamageType> damageTypeRegisterable) {
        damageTypeRegisterable.register(BATARANG, new DamageType("batarang", 0.1f));
        damageTypeRegisterable.register(HELLBAT, new DamageType("hellbat", 0.0f));
        damageTypeRegisterable.register(BAT_DART, new DamageType("bat_dart", 0.1f));
    }
}
