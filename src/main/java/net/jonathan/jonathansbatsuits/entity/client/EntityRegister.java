package net.jonathan.jonathansbatsuits.entity.client;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.entity.client.projectiles.*;
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

    public static final EntityType<BatDartEntity> BAT_DART_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "bat_dart"), FabricEntityTypeBuilder.<BatDartEntity>create(SpawnGroup.MISC, BatDartEntity::new).dimensions(EntityDimensions.fixed(
                0.5f, 0.5f).scaled(1)).trackRangeBlocks(30).trackedUpdateRate(20).build());

    public static final EntityType<SmokePelletEntity> SMOKE_PELLET_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(JonathansBatsuits.MOD_ID,
            "smoke_pellet"), FabricEntityTypeBuilder.<SmokePelletEntity>create(SpawnGroup.MISC, SmokePelletEntity::new).dimensions(EntityDimensions.fixed(
                0.5f, 0.5f)).trackRangeBlocks(30).trackedUpdateRate(20).build());

    public static final EntityType<ExplosiveBatarangEntity> EXPLOSIVE_BATARANG_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JonathansBatsuits.MOD_ID, "explosive_batarang"), FabricEntityTypeBuilder.<ExplosiveBatarangEntity>create(SpawnGroup.MISC,
                ExplosiveBatarangEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(30).trackedUpdateRate(20).build());

    public static final EntityType<GrappleHookEntity> GRAPPLE_HOOK_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(JonathansBatsuits.MOD_ID, "grapple_hook"), FabricEntityTypeBuilder.<GrappleHookEntity>create(SpawnGroup.MISC,
                    GrappleHookEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(60).trackedUpdateRate(20).build());

    public static void registerModEntities() {
        JonathansBatsuits.LOGGER.info("Roger, ready to move out! (Registering " + JonathansBatsuits.MOD_ID + "entities)");
    }

}