package net.jonathan.jonathansbatsuits.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jonathan.jonathansbatsuits.JonathansBatsuits;
import net.jonathan.jonathansbatsuits.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Live Action Batsuits
    //Adam West
    public static final Item ADAM_WEST_COWL = registerItem("adam_west_cowl",
            new AdamWestItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ADAM_WEST_CHESTPLATE = registerItem("adam_west_chestplate",
            new AdamWestItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ADAM_WEST_LEGGINGS = registerItem("adam_west_leggings",
            new AdamWestItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ADAM_WEST_BOOTS = registerItem("adam_west_boots",
            new AdamWestItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Michael Keaton
    public static final Item MICHAEL_KEATON_COWL = registerItem("michael_keaton_cowl",
            new MichaelKeatonItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item MICHAEL_KEATON_CHESTPLATE = registerItem("michael_keaton_chestplate",
            new MichaelKeatonItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item MICHAEL_KEATON_LEGGINGS = registerItem("michael_keaton_leggings",
            new MichaelKeatonItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item MICHAEL_KEATON_BOOTS = registerItem("michael_keaton_boots",
            new MichaelKeatonItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Christian Bale
    public static final Item CHRISTIAN_BALE_COWL = registerItem("christian_bale_cowl",
            new ChristianBaleItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CHRISTIAN_BALE_CHESTPLATE = registerItem("christian_bale_chestplate",
            new ChristianBaleItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CHRISTIAN_BALE_LEGGINGS = registerItem("christian_bale_leggings",
            new ChristianBaleItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CHRISTIAN_BALE_BOOTS = registerItem("christian_bale_boots",
            new ChristianBaleItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Ben Affleck
    public static final Item BEN_AFFLECK_COWL = registerItem("ben_affleck_cowl",
            new BenAffleckItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BEN_AFFLECK_CHESTPLATE = registerItem("ben_affleck_chestplate",
            new BenAffleckItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BEN_AFFLECK_LEGGINGS = registerItem("ben_affleck_leggings",
            new BenAffleckItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BEN_AFFLECK_BOOTS = registerItem("ben_affleck_boots",
            new BenAffleckItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Robert Pattinson
    public static final Item ROBERT_PATTINSON_COWL = registerItem("robert_pattinson_cowl",
            new RobertPattinsonItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROBERT_PATTINSON_CAPE = registerItem("robert_pattinson_cape",
            new RobertPattinsonItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROBERT_PATTINSON_LEGGINGS = registerItem("robert_pattinson_leggings",
            new RobertPattinsonItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ROBERT_PATTINSON_BOOTS = registerItem("robert_pattinson_boots",
            new RobertPattinsonItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //My Custom Batsuit
    public static final Item JONATHANS_BATSUIT_COWL = registerItem("jonathans_batsuit_cowl",
            new JonathansBatsuitItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item JONATHANS_BATSUIT_CHESTPLATE = registerItem("jonathans_batsuit_chestplate",
            new JonathansBatsuitItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item JONATHANS_BATSUIT_LEGGINGS = registerItem("jonathans_batsuit_leggings",
            new JonathansBatsuitItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item JONATHANS_BATSUIT_BOOTS = registerItem("jonathans_batsuit_boots",
            new JonathansBatsuitItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Situational Batsuits
    //Arctic Suit
    public static final Item ARCTIC_SUIT_COWL = registerItem("arctic_suit_cowl",
            new ArcticSuitItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ARCTIC_SUIT_CHESTPLATE = registerItem("arctic_suit_chestplate",
            new ArcticSuitItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ARCTIC_SUIT_LEGGINGS = registerItem("arctic_suit_leggings",
            new ArcticSuitItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ARCTIC_SUIT_BOOTS = registerItem("arctic_suit_boots",
            new ArcticSuitItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Thermal Suit
    public static final Item THERMAL_SUIT_COWL = registerItem("thermal_suit_cowl",
            new ThermalSuitItem(ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item THERMAL_SUIT_CHESTPLATE = registerItem("thermal_suit_chestplate",
            new ThermalSuitItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item THERMAL_SUIT_LEGGINGS = registerItem("thermal_suit_leggings",
            new ThermalSuitItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item THERMAL_SUIT_BOOTS = registerItem("thermal_suit_boots",
            new ThermalSuitItem(ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    //Battle Armor V1
    public static final Item BATTLE_ARMOR_V1_HELMET = registerItem("battle_armor_v1_helmet",
            new BattleArmorV1Item(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BATTLE_ARMOR_V1_CHESTPLATE = registerItem("battle_armor_v1_chestplate",
            new BattleArmorV1Item(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BATTLE_ARMOR_V1_LEGGINGS = registerItem("battle_armor_v1_leggings",
            new BattleArmorV1Item(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BATTLE_ARMOR_V1_BOOTS = registerItem("battle_armor_v1_boots",
            new BattleArmorV1Item(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Scuba Suit
    public static final Item SCUBA_SUIT_BREATHING_APPARATUS = registerItem("scuba_suit_breathing_apparatus",
            new ScubaSuitItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SCUBA_SUIT_WETSUIT = registerItem("scuba_suit_wetsuit",
            new ScubaSuitItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SCUBA_SUIT_LEGGINGS = registerItem("scuba_suit_leggings",
            new ScubaSuitItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SCUBA_SUIT_FLIPPERS = registerItem("scuba_suit_flippers",
            new ScubaSuitItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Stealth Suit
    public static final Item STEALTH_SUIT_COWL = registerItem("stealth_suit_cowl",
            new StealthSuitItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item STEALTH_SUIT_CHESTPLATE = registerItem("stealth_suit_chestplate",
            new StealthSuitItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item STEALTH_SUIT_LEGGINGS = registerItem("stealth_suit_leggings",
            new StealthSuitItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item STEALTH_SUIT_BOOTS = registerItem("stealth_suit_boots",
            new StealthSuitItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Hellbat
    public static final Item HELLBAT_HELMET = registerItem("hellbat_helmet",
            new HellbatItem(ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item HELLBAT_CHESTPLATE = registerItem("hellbat_chestplate",
            new HellbatChestplate(ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item HELLBAT_LEGGINGS = registerItem("hellbat_leggings",
            new HellbatItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item HELLBAT_BOOTS = registerItem("hellbat_boots",
            new HellbatItem(ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    //Base Capes
    public static final Item BLUE_CAPE = registerItem("blue_cape",
            new BlueCapeItem(new FabricItemSettings().maxDamage(Items.ELYTRA.getMaxDamage()).equipmentSlot(stack -> EquipmentSlot.CHEST)));
    public static final Item BLACK_CAPE = registerItem("black_cape",
            new BlackCapeItem(new FabricItemSettings().maxDamage(Items.ELYTRA.getMaxDamage()).equipmentSlot(stack -> EquipmentSlot.CHEST)));

    //The Conroy Legacy
    //The Animated Series
    public static final Item TAS_COWL = registerItem("tas_cowl",
            new TasItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TAS_CHESTPLATE = registerItem("tas_chestplate",
            new TasItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TAS_LEGGINGS = registerItem("tas_leggings",
            new TasItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TAS_BOOTS = registerItem("tas_boots",
            new TasItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //The New Batman Adventures
    public static final Item TNBA_COWL = registerItem("tnba_cowl",
            new TnbaItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TNBA_CHESTPLATE = registerItem("tnba_chestplate",
            new TnbaItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TNBA_LEGGINGS = registerItem("tnba_leggings",
            new TnbaItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TNBA_BOOTS = registerItem("tnba_boots",
            new TnbaItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Batman Beyond
    public static final Item BATMAN_BEYOND_COWL = registerItem("batman_beyond_cowl",
            new BatmanBeyondItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BATMAN_BEYOND_CHESTPLATE = registerItem("batman_beyond_chestplate",
            new BatmanBeyondChestplate(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BATMAN_BEYOND_LEGGINGS = registerItem("batman_beyond_leggings",
            new BatmanBeyondItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BATMAN_BEYOND_BOOTS = registerItem("batman_beyond_boots",
            new BatmanBeyondItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Arkham Asylum
    public static final Item ARKHAM_ASYLUM_COWL = registerItem("arkham_asylum_cowl",
            new ArkhamAsylumItem(ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ARKHAM_ASYLUM_CHESTPLATE = registerItem("arkham_asylum_chestplate",
            new ArkhamAsylumItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ARKHAM_ASYLUM_LEGGINGS = registerItem("arkham_asylum_leggings",
            new ArkhamAsylumItem(ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ARKHAM_ASYLUM_BOOTS = registerItem("arkham_asylum_boots",
            new ArkhamAsylumItem(ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Injustice: Gods Among Us

    //Arkham City

    //Injustice 2

    //Arkham Knight

    //Suicide Squad: Kill The Justice League

    //Gadgets
    //Batarang
    public static final Item BATARANG = registerItem("batarang", new BatarangItem(new FabricItemSettings().maxCount(1)));
    public static final Item LACED_BATARANG = registerItem("laced_batarang", new LacedBatarangItem(new FabricItemSettings().maxCount(16)));

    //Bat-Dart
    public static final Item BAT_DART = registerItem("bat_dart", new BatDartItem(new FabricItemSettings().maxCount(16)));

    //Smoke Pellet
    public static final Item SMOKE_PELLET = registerItem("smoke_pellet", new SmokePelletItem(new FabricItemSettings().maxCount(16)));

    //Bat-Glider
    public static final Item BAT_GLIDER = registerItem("bat_glider",
            new BatGliderItem(ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    //Detective Vision Lenses
    public static final Item DETECTIVE_VISION_LENSES = registerItem("detective_vision_lenses", new DetectiveVisionItem(new FabricItemSettings()));

    //VisionSteps Primordial Energy
    public static final Item PRIMORDIAL_ENERGY = registerItem("primordial_energy", new Item(new FabricItemSettings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JonathansBatsuits.MOD_ID, name), item);
    }

    public static void registerModItems() {
        JonathansBatsuits.LOGGER.debug("Registering Mod Items for " + JonathansBatsuits.MOD_ID);
    }
}
