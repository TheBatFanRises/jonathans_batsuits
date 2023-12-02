package net.jonathan.jonathansbatsuits.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ADAM_WEST("adam_west", 15, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.LIGHT_GRAY_WOOL, Items.BLUE_WOOL);
    }),
    MICHAEL_KEATON("michael_keaton", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.BLACK_WOOL);
    }),
    CHRISTIAN_BALE("christian_bale", 33, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            2.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.GRAY_WOOL);
    }),
    BEN_AFFLECK("ben_affleck", 33, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            2.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.GRAY_WOOL);
    }),
    ROBERT_PATTINSON("robert_pattinson", 37, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            3.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.BLACK_WOOL);
    }),
    JONATHANS_BATSUIT("jonathans_batsuit", 25, new int[]{2, 6, 7, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.GRAY_WOOL, Items.BLUE_WOOL);
    }),
    ARCTIC_SUIT("arctic_suit", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.WHITE_WOOL);
    }),
    THERMAL_SUIT("thermal_suit", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.RED_WOOL);
    }),
    BATTLE_ARMOR_V1("battle_armor_v1", 37, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            3.0F, 2.0F, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    SCUBA_SUIT("scuba_suit", 15, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    STEALTH_SUIT("stealth_suit", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.BLACK_WOOL);
    }),
    TAS("tas", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.BLACK_WOOL);
    }),
    TNBA("tnba", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.BLACK_WOOL);
    }),
    BATMAN_BEYOND("batman_beyond", 33, new int[]{3, 6, 10, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.REDSTONE_BLOCK);
    }),
    ARKHAM_ASYLUM("arkham_asylum", 15, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.BLACK_WOOL, Items.GRAY_WOOL);
    }),
    HELLBAT("hellbat", 74, new int[]{4, 7, 9, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            10.0F, 2.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    BAT_GLIDER("bat_glider", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.BLUE_WOOL);
    });

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.getEquipmentSlot().getEntitySlotId()];
    }


    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}