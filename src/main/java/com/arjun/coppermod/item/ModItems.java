package com.arjun.coppermod.item;

import com.arjun.coppermod.CopperModMAIN;
import com.arjun.coppermod.block.ModBlocks;
import com.arjun.coppermod.block.ModFluids;
import com.arjun.coppermod.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item>  COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().group(CopperModMAIN.COPPER_TAB)));
    public static final RegistryObject<Item>  COPPERED_APPLE =
            Registration.ITEMS.register("coppered_apple",
                    CopperedApple::new);
            public static void register() { }

    /* TOOLS */

    public static RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel",
                    () -> new ShovelItem(CopperItemTier.COPPER,2.5f,0f,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.SHOVEL, 3)
                            .group(CopperModMAIN.COPPER_TAB)
                    ));
    public static RegistryObject<Item> COPPER_SWORD =
            Registration.ITEMS.register("copper_sword",
                    () -> new SwordItem(CopperItemTier.COPPER,7,1.6f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(CopperModMAIN.COPPER_TAB)
                    ));
    public static RegistryObject<Item> COPPER_PICKAXE =
            Registration.ITEMS.register("copper_pickaxe",
                    () -> new PickaxeItem(CopperItemTier.COPPER,5,0,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 3)
                                    .group(CopperModMAIN.COPPER_TAB)
                    ));
    public static RegistryObject<Item> COPPER_HOE =
            Registration.ITEMS.register("copper_hoe",
                    () -> new HoeItem(CopperItemTier.COPPER,0,0,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 3)
                                    .group(CopperModMAIN.COPPER_TAB)
                    ));
    public static RegistryObject<Item> COPPER_AXE =
            Registration.ITEMS.register("copper_axe",
                    () -> new PickaxeItem(CopperItemTier.COPPER,9,-3.5f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 3)
                                    .group(CopperModMAIN.COPPER_TAB)
                    ));


    public static final RegistryObject<Item> COPPER_HELMET =
            Registration.ITEMS.register("copper_helmet",
                () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                        new Item.Properties().group(CopperModMAIN.COPPER_TAB)));

    public static final RegistryObject<Item> COPPER_CHESTPLATE =
            Registration.ITEMS.register("copper_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                            new Item.Properties().group(CopperModMAIN.COPPER_TAB)));

    public static final RegistryObject<Item> COPPER_LEGGINGS =
            Registration.ITEMS.register("copper_leggings",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                            new Item.Properties().group(CopperModMAIN.COPPER_TAB)));

    public static final RegistryObject<Item> COPPER_BOOTS =
            Registration.ITEMS.register("copper_boots",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET,
                            new Item.Properties().group(CopperModMAIN.COPPER_TAB)));



    public enum ModArmorMaterial implements IArmorMaterial{
        COPPER(50, new int[] {2, 7, 5, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())), CopperModMAIN.MOD_ID+ ":copper", 0, 0.25f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackRes;

        ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackRes) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackRes = knockbackRes;
        }


        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        public float getKnockbackResistance(){
            return knockbackRes;
        }
    }

    public enum CopperItemTier implements IItemTier{
        COPPER(2, 250, 3.2f, 0f, 20,
                Ingredient.fromStacks(
                        new ItemStack(ModItems.COPPER_INGOT.get())
                    )
                );

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantibility;

        public final Ingredient repairMaterial;

        CopperItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantibility, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantibility = enchantibility;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantibility;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }
    public static final RegistryObject<Item> ZUCCHINI_SEED =
            Registration.ITEMS.register("zucchini_seed",
                    () -> new BlockItem(ModBlocks.ZUCCHINI_CROP.get(), new Item.Properties()
                            .group(CopperModMAIN.COPPER_TAB))
            );

    public static final RegistryObject<Item> OIL_BUCKET =
            Registration.ITEMS.register("oil_bucket",
                    () -> new BucketItem(ModFluids.OIL_FLUID::get,
                            new Item.Properties().group(CopperModMAIN.COPPER_TAB).maxStackSize(1)));
}
