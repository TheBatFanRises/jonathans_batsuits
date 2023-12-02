package net.jonathan.jonathansbatsuits.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup LIVE_ACTION_BATSUITS = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "live_action_batsuits"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.live_action_batsuits"))
                .icon(() -> new ItemStack(ModItems.ADAM_WEST_COWL)).entries((displayContext, entries) -> {
                    entries.add(ModItems.ADAM_WEST_COWL);
                    entries.add(ModItems.ADAM_WEST_CHESTPLATE);
                    entries.add(ModItems.ADAM_WEST_LEGGINGS);
                    entries.add(ModItems.ADAM_WEST_BOOTS);
                    entries.add(ModItems.MICHAEL_KEATON_COWL);
                    entries.add(ModItems.MICHAEL_KEATON_CHESTPLATE);
                    entries.add(ModItems.MICHAEL_KEATON_LEGGINGS);
                    entries.add(ModItems.MICHAEL_KEATON_BOOTS);
                    entries.add(ModItems.CHRISTIAN_BALE_COWL);
                    entries.add(ModItems.CHRISTIAN_BALE_CHESTPLATE);
                    entries.add(ModItems.CHRISTIAN_BALE_LEGGINGS);
                    entries.add(ModItems.CHRISTIAN_BALE_BOOTS);
                    entries.add(ModItems.BEN_AFFLECK_COWL);
                    entries.add(ModItems.BEN_AFFLECK_CHESTPLATE);
                    entries.add(ModItems.BEN_AFFLECK_LEGGINGS);
                    entries.add(ModItems.BEN_AFFLECK_BOOTS);
                    entries.add(ModItems.ROBERT_PATTINSON_COWL);
                    entries.add(ModItems.ROBERT_PATTINSON_CAPE);
                    entries.add(ModItems.ROBERT_PATTINSON_LEGGINGS);
                    entries.add(ModItems.ROBERT_PATTINSON_BOOTS);
                }).build());
    public static final ItemGroup MY_CUSTOM_BATSUITS = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "my_custom_batsuits"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.my_custom_batsuits"))
                .icon(() -> new ItemStack(ModItems.JONATHANS_BATSUIT_COWL)).entries((displayContext, entries) -> {
                    entries.add(ModItems.JONATHANS_BATSUIT_COWL);
                    entries.add(ModItems.JONATHANS_BATSUIT_CHESTPLATE);
                    entries.add(ModItems.JONATHANS_BATSUIT_LEGGINGS);
                    entries.add(ModItems.JONATHANS_BATSUIT_BOOTS);
                }).build());
    public static final ItemGroup SITUATIONAL_BATSUITS = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "situational_batsuits"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.situational_batsuits"))
            .icon(() -> new ItemStack(ModItems.ARCTIC_SUIT_COWL)).entries((displayContext, entries) -> {
                entries.add(ModItems.ARCTIC_SUIT_COWL);
                entries.add(ModItems.ARCTIC_SUIT_CHESTPLATE);
                entries.add(ModItems.ARCTIC_SUIT_LEGGINGS);
                entries.add(ModItems.ARCTIC_SUIT_BOOTS);
                entries.add(ModItems.THERMAL_SUIT_COWL);
                entries.add(ModItems.THERMAL_SUIT_CHESTPLATE);
                entries.add(ModItems.THERMAL_SUIT_LEGGINGS);
                entries.add(ModItems.THERMAL_SUIT_BOOTS);
                entries.add(ModItems.BATTLE_ARMOR_V1_HELMET);
                entries.add(ModItems.BATTLE_ARMOR_V1_CHESTPLATE);
                entries.add(ModItems.BATTLE_ARMOR_V1_LEGGINGS);
                entries.add(ModItems.BATTLE_ARMOR_V1_BOOTS);
                entries.add(ModItems.SCUBA_SUIT_BREATHING_APPARATUS);
                entries.add(ModItems.SCUBA_SUIT_WETSUIT);
                entries.add(ModItems.SCUBA_SUIT_LEGGINGS);
                entries.add(ModItems.SCUBA_SUIT_FLIPPERS);
                entries.add(ModItems.STEALTH_SUIT_COWL);
                entries.add(ModItems.STEALTH_SUIT_CHESTPLATE);
                entries.add(ModItems.STEALTH_SUIT_LEGGINGS);
                entries.add(ModItems.STEALTH_SUIT_BOOTS);
                entries.add(ModItems.HELLBAT_HELMET);
                entries.add(ModItems.HELLBAT_CHESTPLATE);
                entries.add(ModItems.HELLBAT_LEGGINGS);
                entries.add(ModItems.HELLBAT_BOOTS);
            }).build());
    public static final ItemGroup BASE_CAPES = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "base_capes"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.base_capes"))
            .icon(() -> new ItemStack(ModItems.BLUE_CAPE)).entries((displayContext, entries) -> {
                entries.add(ModItems.BLUE_CAPE);
                entries.add(ModItems.BLACK_CAPE);
            }).build());
    public static final ItemGroup THE_CONROY_LEGACY = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "the_conroy_legacy"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.the_conroy_legacy"))
            .icon(() -> new ItemStack(ModItems.TAS_COWL)).entries((displayContext, entries) -> {
                entries.add(ModItems.TAS_COWL);
                entries.add(ModItems.TAS_CHESTPLATE);
                entries.add(ModItems.TAS_LEGGINGS);
                entries.add(ModItems.TAS_BOOTS);
                entries.add(ModItems.TNBA_COWL);
                entries.add(ModItems.TNBA_CHESTPLATE);
                entries.add(ModItems.TNBA_LEGGINGS);
                entries.add(ModItems.TNBA_BOOTS);
                entries.add(ModItems.BATMAN_BEYOND_COWL);
                entries.add(ModItems.BATMAN_BEYOND_CHESTPLATE);
                entries.add(ModItems.BATMAN_BEYOND_LEGGINGS);
                entries.add(ModItems.BATMAN_BEYOND_BOOTS);
                entries.add(ModItems.ARKHAM_ASYLUM_COWL);
                entries.add(ModItems.ARKHAM_ASYLUM_CHESTPLATE);
                entries.add(ModItems.ARKHAM_ASYLUM_LEGGINGS);
                entries.add(ModItems.ARKHAM_ASYLUM_BOOTS);
            }).build());
    public static final ItemGroup GADGETS = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "gadgets"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gadgets"))
            .icon(() -> new ItemStack(ModItems.BATARANG)).entries((displayContext, entries) -> {
                entries.add(ModItems.BATARANG);
                displayContext.lookup().getOptionalWrapper(RegistryKeys.POTION).ifPresent(wrapper -> addPotions(entries, wrapper,
                        ModItems.LACED_BATARANG, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS));
                entries.add(ModItems.SMOKE_PELLET);
                entries.add(ModItems.BAT_GLIDER);
                entries.add(ModItems.DETECTIVE_VISION_LENSES);
            }).build());
    public static final ItemGroup VISIONSTEPS_ITEMS = Registry.register(Registries.ITEM_GROUP, new Identifier(JonathansBatsuits.MOD_ID,
            "visionsteps_items"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.visionsteps_items"))
            .icon(() -> new ItemStack(ModItems.PRIMORDIAL_ENERGY)).entries((displayContext, entries) -> {
                entries.add(ModItems.PRIMORDIAL_ENERGY);
            }).build());

    private static void addPotions(ItemGroup.Entries entries, RegistryWrapper<Potion> registryWrapper, Item item, ItemGroup.StackVisibility visibility) {
        registryWrapper.streamEntries().filter(entry -> !entry.matchesKey(Potions.EMPTY_KEY)).map(entry -> PotionUtil.setPotion(new ItemStack(item),
                (Potion)entry.value())).forEach(stack -> entries.add((ItemStack)stack, visibility));
    }

    public static void registerItemGroups() {
        JonathansBatsuits.LOGGER.info("Registering Item Groups For " + JonathansBatsuits.MOD_ID);
    }
}