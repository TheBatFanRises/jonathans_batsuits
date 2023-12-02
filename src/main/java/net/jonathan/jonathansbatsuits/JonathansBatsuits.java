package net.jonathan.jonathansbatsuits;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.jonathan.jonathansbatsuits.effect.ModEffects;
import net.jonathan.jonathansbatsuits.entity.client.EntityRegister;
import net.jonathan.jonathansbatsuits.event.ScubaSuitEvent;
import net.jonathan.jonathansbatsuits.integration.trinkets.ElytraTrinketHandler;
import net.jonathan.jonathansbatsuits.item.ModItemGroup;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.jonathan.jonathansbatsuits.networking.ModPackets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class JonathansBatsuits implements ModInitializer {
	public static final String MOD_ID = "jonathansbatsuits";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();

		ModItemGroup.registerItemGroups();

		EntityRegister.registerModEntities();

		GeckoLib.initialize();

		ModPackets.registerC2SPackets();

		ElytraTrinketHandler.register();

		ModEffects.registerEffects();

		ServerTickEvents.START_SERVER_TICK.register(new ScubaSuitEvent());
	}
}