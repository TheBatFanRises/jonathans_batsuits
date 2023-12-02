package net.jonathan.jonathansbatsuits.registry;

import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.damage.ModDamageTypes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModRegistryKeys {
    public static final RegistryKey<Registry<ModDamageTypes>> MOD_DAMAGE_TYPE = ModRegistryKeys.of("mod_damage_type");

    private static <T> RegistryKey<Registry<T>> of(String id) {
        return RegistryKey.ofRegistry(new Identifier(JonathansBatsuits.MOD_ID, id));
    }
}
