package net.jonathan.jonathansbatsuits.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.item.custom.BatmanBeyondItem;
import net.jonathan.jonathansbatsuits.item.custom.ChristianBaleItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Identifier;

public class AbilityCooldownOverlay implements HudRenderCallback {
    public static final Identifier FILLED_BAR = new Identifier(JonathansBatsuits.MOD_ID, "textures/cooldowns/filled_ability.png");
    public static final Identifier EMPTY_BAR = new Identifier(JonathansBatsuits.MOD_ID, "textures/cooldowns/empty_ability.png");
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();

        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        assert client != null;
        ClientPlayerEntity player = client.player;
        assert player != null;
        if (ChristianBaleItem.isWearingAll(player) || BatmanBeyondItem.isWearingAll(player)) {
            for (int i = 0; i < 10; i++) {
                drawContext.drawTexture(EMPTY_BAR, x - 94 + (i * 9), y - 60, 0, 0, 12, 12, 12, 12);
            }
            for (int i = 0; i < 10; i++) {
                if (KeyInputHandler.abilityTick / 40 >= i) {
                    drawContext.drawTexture(FILLED_BAR, x - 94 + (i * 9), y - 60, 0, 0, 12, 12, 12, 12);
                } else {
                    break;
                }
            }
        }
    }
}
