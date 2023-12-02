package net.jonathan.jonathansbatsuits.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.item.custom.BatmanBeyondItem;
import net.jonathan.jonathansbatsuits.item.custom.ChristianBaleItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ModPackets {
    public static final Identifier SUIT_ABILITY_ID = new Identifier(JonathansBatsuits.MOD_ID, "suit_ability");
    public static final Identifier BATMAN_BEYOND_JETS = new Identifier(JonathansBatsuits.MOD_ID, "batman_beyond_jets");
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(SUIT_ABILITY_ID, ((server, player, handler, buf, responseSender) -> {

            if (ChristianBaleItem.isWearingAll(player)) {
                for (int i = 0; i < 10; i++) {
                    Objects.requireNonNull(EntityType.BAT.spawn((ServerWorld)player.getEntityWorld(), player.getBlockPos(), SpawnReason.TRIGGERED))
                            .addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, -1));
                }
            }

            if (BatmanBeyondItem.isWearingAll(player)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200,0, false, false,
                        false));
            }
        }));

        ServerPlayNetworking.registerGlobalReceiver(BATMAN_BEYOND_JETS, (server, player, handler, buf, responseSender) -> {

            ItemStack stack = player.getEquippedStack(EquipmentSlot.CHEST);
            ServerWorld serverWorld = (ServerWorld)player.getEntityWorld();

            if (player.isFallFlying() && BatmanBeyondItem.isWearingAll(player)) {
                serverWorld.spawnEntity(new FireworkRocketEntity(serverWorld, stack, player));
                stack.damage(5, player, playerEntity -> playerEntity.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                KeyInputHandler.bbTick = 0;
            }
        });
    }
    public static void registerS2CPackets() {

    }
}
