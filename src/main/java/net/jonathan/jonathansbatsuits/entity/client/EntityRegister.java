package net.jonathan.jonathansbatsuits.entity.client;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatDartEntity;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatarangEntity;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.SmokePelletEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityRegister<T extends Entity> {

    //Gadgets
    public static final EntityType<BatarangEntity> BATARANG_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "batarang"), FabricEntityTypeBuilder.<BatarangEntity>create(SpawnGroup.MISC, BatarangEntity::new).dimensions(EntityDimensions.fixed(
                0.5f, 0.5f)).trackRangeBlocks(30).trackedUpdateRate(20).build());
    /**
    public static final EntityType<BatDartEntity> BAT_DART_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "bat_dart"), FabricEntityTypeBuilder.<BatDartEntity>create(SpawnGroup.MISC, BatDartEntity::new).dimensions(EntityDimensions.fixed(
                0.5f, 0.5f).scaled(1)).trackRangeBlocks(30).trackedUpdateRate(20).build());
     */

    public static final EntityType<SmokePelletEntity> SMOKE_PELLET_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "smoke_pellet"), FabricEntityTypeBuilder.<SmokePelletEntity>create(SpawnGroup.MISC, SmokePelletEntity::new).dimensions(EntityDimensions.fixed(
                0.5f, 0.5f)).trackRangeBlocks(30).trackedUpdateRate(20).build());

    public static void registerModEntities() {
        JonathansBatsuits.LOGGER.debug("Registering Mod Entities for " + JonathansBatsuits.MOD_ID);
    }

}