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
    public static final String KEY_CATEGORY_BATSUITS = "key.category.jonathansbatsuits.batsuits";
    public static final String KEY_BATSUIT_ABILITY = "key.jonathansbatsuits.batsuit_ability";
    public static final String KEY_DETECTIVE_VISION = "key.jonathansbatsuits.detective_vision";
    public static final String KEY_BATMAN_BEYOND_JETS = "key.jonathansbatsuits.batman_beyond_jets";
    public static KeyBinding abilityKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            KEY_BATSUIT_ABILITY,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_I,
            KEY_CATEGORY_BATSUITS
    ));
    public static KeyBinding dvKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            KEY_DETECTIVE_VISION,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_P,
            KEY_CATEGORY_BATSUITS
    ));
    public static KeyBinding bbKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            KEY_BATMAN_BEYOND_JETS,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            KEY_CATEGORY_BATSUITS
    ));
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
