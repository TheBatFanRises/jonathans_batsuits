package net.jonathan.jonathansbatsuits.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.event.KeyInputHandler;
import net.jonathan.jonathansbatsuits.item.custom.DetectiveVisionItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Identifier;

public class DetectiveVisionOverlay implements HudRenderCallback {
    public static final Identifier VISION_OVERLAY = new Identifier(JonathansBatsuits.MOD_ID, "textures/overlays/detective_vision_overlay.png");
    public static final Identifier EMPTY_BAR = new Identifier(JonathansBatsuits.MOD_ID, "textures/cooldowns/empty_detective_vision.png");
    public static final Identifier FILLED_BAR = new Identifier(JonathansBatsuits.MOD_ID, "textures/cooldowns/filled_detective_vision.png");
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();

        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width;
            y = height;
        }
        assert client != null;
        ClientPlayerEntity player = client.player;
        assert player != null;

        if (DetectiveVisionItem.useDetectiveVisionLenses(player)) {
            if (KeyInputHandler.dvTick <= 100) {
                drawContext.drawTexture(VISION_OVERLAY, 0, 0, 0, 0, x, y, x, y);
            }
            if (KeyInputHandler.dvTick <= 400) {
                for (int i = 0; i < 10; i++) {
                    drawContext.drawTexture(EMPTY_BAR, (x / 2) - 94 + (i * 9), y - 74, 0, 0, 12, 12, 12, 12);
                }
                for (int i = 0; i < 10; i++) {
                    if (KeyInputHandler.dvTick / 40 >= i) {
                        drawContext.drawTexture(FILLED_BAR, (x / 2) - 94 + (i * 9), y - 74, 0, 0, 12, 12, 12, 12);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
