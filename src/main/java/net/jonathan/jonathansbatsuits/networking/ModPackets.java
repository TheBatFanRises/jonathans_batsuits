package net.jonathan.jonathansbatsuits.networking;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.jonathan.jonathansbatsuits.item.custom.BatmanBeyondItem;
import net.jonathan.jonathansbatsuits.item.custom.ChristianBaleItem;
import net.jonathan.jonathansbatsuits.item.custom.NightVisionGogglesItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.Optional;

public class ModPackets {
    public static final Identifier SUIT_ABILITY_ID = new Identifier(JonathansBatsuits.MOD_ID, "suit_ability");
    public static final Identifier BATMAN_BEYOND_JETS = new Identifier(JonathansBatsuits.MOD_ID, "batman_beyond_jets");
    public static final Identifier NIGHT_VISION_ID = new Identifier(JonathansBatsuits.MOD_ID, "night_vision_packet");

    public static void registerC2SPackets() {

        JonathansBatsuits.LOGGER.info("Thank you Adam. (Registering " + JonathansBatsuits.MOD_ID + " packets)");

        ServerPlayNetworking.registerGlobalReceiver(SUIT_ABILITY_ID, (server, player, handler, buf, responseSender) -> {

            server.execute(() -> {

                ServerWorld serverWorld = (ServerWorld) player.getEntityWorld();

                if (!serverWorld.isClient) {

                    //Because C2ME doesn't like the EntityType.spawn method, the ServerWorld.spawnEntity method needs to be called for sake of compatibility.
                    if (ChristianBaleItem.isWearingAll(player)) {
                        for (int i = 0; i <= 10; i++) {
                            /**
                            BatEntity batEntity = new BatEntity(EntityType.BAT, serverWorld);
                            serverWorld.spawnEntity(batEntity);
                            batEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, -1));
                            batEntity.teleport(player.getX(), player.getY(), player.getZ());
                             */

                            EntityType.BAT.spawn(serverWorld, player.getBlockPos(), SpawnReason.TRIGGERED).addStatusEffect(
                                    new StatusEffectInstance(new StatusEffectInstance(StatusEffects.WITHER, -1)));
                        }
                    }

                    if (BatmanBeyondItem.isWearingAll(player)) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 0, false, false,
                                false));
                    }
                }
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(BATMAN_BEYOND_JETS, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {

                ItemStack stack = player.getEquippedStack(EquipmentSlot.CHEST);
                ServerWorld serverWorld = (ServerWorld)player.getEntityWorld();

                if (!serverWorld.isClient) {

                    if (player.isFallFlying() && BatmanBeyondItem.isWearingAll(player)) {
                        FireworkRocketEntity rocket = new FireworkRocketEntity(serverWorld, stack, player);
                        serverWorld.spawnEntity(rocket);
                        stack.damage(5, player, playerEntity -> playerEntity.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                        KeyInputHandler.bbTick = 0;
                    }
                }
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(NIGHT_VISION_ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {

                Optional<TrinketComponent> trinketComponent = TrinketsApi.getTrinketComponent(player);
                if (trinketComponent.isPresent()) {
                    List<Pair<SlotReference, ItemStack>> equipped = ((TrinketComponent) trinketComponent.get())
                            .getEquipped(NightVisionGogglesItem::isNightVisionGoggles);

                    for (Pair<SlotReference, ItemStack> slot : equipped) {
                        ItemStack stack = (ItemStack) slot.getRight();
                        Item item = stack.getItem();
                        if (item == ModItems.NIGHT_VISION_GOGGLES) {
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0, false, false,
                                    false));
                        }
                    }
                }
            });
        });
    }
    public static void registerS2CPackets() {

    }
}
