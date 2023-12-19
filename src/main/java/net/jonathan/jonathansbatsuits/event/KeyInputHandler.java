package net.jonathan.jonathansbatsuits.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.jonathan.jonathansbatsuits.networking.ModPackets;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static KeyBinding abilityKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.jonathansbatsuits.batsuit_ability",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_I,
            "key.category.jonathansbatsuits.batsuits"));
    public static KeyBinding dvKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.jonathansbatsuits.detective_vision",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_P,
            "key.category.jonathansbatsuits.batsuits"));
    public static KeyBinding bbKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.jonathansbatsuits.batman_beyond_jets",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            "key.category.jonathansbatsuits.batsuits"));
    public static boolean DVtoggle;
    public static float abilityTick = 0;
    public static float bbTick = 0;
    public static float dvTick = 0;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            abilityTick++;
            bbTick++;
            dvTick++;
            if (abilityKey.wasPressed() && abilityTick >= 400) {
                ClientPlayNetworking.send(ModPackets.SUIT_ABILITY_ID, PacketByteBufs.create());
                abilityTick = 0;
            }
            if (dvKey.wasPressed() && dvTick >= 400) {
                DVtoggle = true;
                dvTick = 0;
            }
            if (bbKey.wasPressed() && bbTick >= 200) {
                ClientPlayNetworking.send(ModPackets.BATMAN_BEYOND_JETS, PacketByteBufs.create());
            }
        });
    }
}
