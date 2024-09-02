package com.PIPPIP5789.mfrex.init;

import com.google.common.collect.Lists;
import minefantasy.mfr.api.MineFantasyReforgedAPI;
import minefantasy.mfr.config.ConfigCrafting;
import minefantasy.mfr.init.MineFantasyBlocks;
import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.recipe.DummyRecipe;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class RecipeInit {

    public static void removeOldRecipes() {
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Blocks.BREWING_STAND))) {
            mfrRemoveRecipes(Blocks.BREWING_STAND);
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Blocks.CAULDRON))) {
            mfrRemoveRecipes(Blocks.CAULDRON);
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Blocks.IRON_BARS))) {
            mfrRemoveRecipes(Blocks.IRON_BARS);
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Blocks.IRON_DOOR))) {
            mfrRemoveRecipes(Blocks.IRON_DOOR);
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Blocks.IRON_TRAPDOOR))) {
            mfrRemoveRecipes(Blocks.IRON_TRAPDOOR);
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Items.MINECART))) {
            mfrRemoveRecipes(Items.MINECART);
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Blocks.RAIL))) {
            manualRemover(Item.getItemFromBlock(Blocks.RAIL));
        }
        if(ConfigCrafting.isAnvilItemCraftable(new ItemStack(Items.SHIELD))) {
            mfrRemoveRecipes(Items.SHIELD);
        }

        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.ACTIVATOR_RAIL))) {
            mfrRemoveRecipes(Blocks.ACTIVATOR_RAIL);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.ARMOR_STAND))) {
            mfrRemoveRecipes(Items.ARMOR_STAND);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.BANNER))) {
            mfrRemoveRecipes(Items.BANNER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.BED))) {
            mfrRemoveRecipes(Items.BED);

        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.BOAT))) {
            mfrRemoveRecipes(Items.BOAT);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.BIRCH_BOAT))) {
            mfrRemoveRecipes(Items.BIRCH_BOAT);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.SPRUCE_BOAT))) {
            mfrRemoveRecipes(Items.SPRUCE_BOAT);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.ACACIA_BOAT))) {
            mfrRemoveRecipes(Items.ACACIA_BOAT);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.DARK_OAK_BOAT))) {
            mfrRemoveRecipes(Items.DARK_OAK_BOAT);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.JUNGLE_BOAT))) {
            mfrRemoveRecipes(Items.JUNGLE_BOAT);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.BOOK))) {
            mfrRemoveRecipes(Items.BOOK);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.BOOKSHELF))) {
            mfrRemoveRecipes(Blocks.BOOKSHELF);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.BOWL))) {
            mfrRemoveRecipes(Items.BOWL);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.CARPET))) {
            manualRemover(Item.getItemFromBlock(Blocks.CARPET));
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.CHEST))) {
            mfrRemoveRecipes(Blocks.CHEST);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.CLOCK))) {
            mfrRemoveRecipes(Items.CLOCK);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.COMPASS))) {
            mfrRemoveRecipes(Items.COMPASS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DETECTOR_RAIL))) {
            mfrRemoveRecipes(Blocks.DETECTOR_RAIL);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DISPENSER))) {
            mfrRemoveRecipes(Blocks.DISPENSER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.OAK_DOOR))) {
            mfrRemoveRecipes(Blocks.OAK_DOOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.SPRUCE_DOOR))) {
            mfrRemoveRecipes(Blocks.SPRUCE_DOOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.BIRCH_DOOR))) {
            mfrRemoveRecipes(Blocks.BIRCH_DOOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.ACACIA_DOOR))) {
            mfrRemoveRecipes(Blocks.ACACIA_DOOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DARK_OAK_DOOR))) {
            mfrRemoveRecipes(Blocks.DARK_OAK_DOOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.JUNGLE_DOOR))) {
            mfrRemoveRecipes(Blocks.JUNGLE_DOOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DROPPER))) {
            mfrRemoveRecipes(Blocks.DROPPER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.ENCHANTING_TABLE))) {
            mfrRemoveRecipes(Blocks.ENCHANTING_TABLE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.OAK_FENCE))) {
            mfrRemoveRecipes(Blocks.OAK_FENCE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.SPRUCE_FENCE))) {
            mfrRemoveRecipes(Blocks.SPRUCE_FENCE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.BIRCH_FENCE))) {
            mfrRemoveRecipes(Blocks.BIRCH_FENCE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.JUNGLE_FENCE))) {
            mfrRemoveRecipes(Blocks.JUNGLE_FENCE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.ACACIA_FENCE))) {
            mfrRemoveRecipes(Blocks.ACACIA_FENCE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DARK_OAK_FENCE))) {
            mfrRemoveRecipes(Blocks.DARK_OAK_FENCE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.OAK_FENCE_GATE))) {
            mfrRemoveRecipes(Blocks.OAK_FENCE_GATE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.BIRCH_FENCE_GATE))) {
            mfrRemoveRecipes(Blocks.BIRCH_FENCE_GATE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.SPRUCE_FENCE_GATE))) {
            mfrRemoveRecipes(Blocks.SPRUCE_FENCE_GATE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DARK_OAK_FENCE_GATE))) {
            mfrRemoveRecipes(Blocks.DARK_OAK_FENCE_GATE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.JUNGLE_FENCE_GATE))) {
            mfrRemoveRecipes(Blocks.JUNGLE_FENCE_GATE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.ACACIA_FENCE_GATE))) {
            mfrRemoveRecipes(Blocks.ACACIA_FENCE_GATE);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.FISHING_ROD))) {
            mfrRemoveRecipes(Items.FISHING_ROD);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.HOPPER))) {
            mfrRemoveRecipes(Blocks.HOPPER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.ITEM_FRAME))) {
            mfrRemoveRecipes(Items.ITEM_FRAME);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.JUKEBOX))) {
            mfrRemoveRecipes(Blocks.JUKEBOX);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.LADDER))) {
            mfrRemoveRecipes(Blocks.LADDER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.NOTEBLOCK))) {
            mfrRemoveRecipes(Blocks.NOTEBLOCK);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.OBSERVER))) {
            mfrRemoveRecipes(Blocks.OBSERVER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.PAINTING))) {
            mfrRemoveRecipes(Items.PAINTING);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.PAPER))) {
            mfrRemoveRecipes(Items.PAPER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.PISTON))) {
            mfrRemoveRecipes(Blocks.PISTON);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.GOLDEN_RAIL))) {
            mfrRemoveRecipes(Blocks.GOLDEN_RAIL);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.REDSTONE_LAMP))) {
            mfrRemoveRecipes(Blocks.REDSTONE_LAMP);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.REPEATER))) {
            mfrRemoveRecipes(Items.REPEATER);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.COMPARATOR))) {
            mfrRemoveRecipes(Items.COMPARATOR);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Items.SIGN))) {
            mfrRemoveRecipes(Items.SIGN);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.OAK_STAIRS))) {
            mfrRemoveRecipes(Blocks.OAK_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.SPRUCE_STAIRS))) {
            mfrRemoveRecipes(Blocks.SPRUCE_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.BIRCH_STAIRS))) {
            mfrRemoveRecipes(Blocks.BIRCH_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.ACACIA_STAIRS))) {
            mfrRemoveRecipes(Blocks.ACACIA_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.DARK_OAK_STAIRS))) {
            mfrRemoveRecipes(Blocks.DARK_OAK_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.JUNGLE_STAIRS))) {
            mfrRemoveRecipes(Blocks.JUNGLE_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(MineFantasyBlocks.YEW_STAIRS))) {
            mfrRemoveRecipes(MineFantasyBlocks.YEW_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(MineFantasyBlocks.IRONBARK_STAIRS))) {
            mfrRemoveRecipes(MineFantasyBlocks.IRONBARK_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(MineFantasyBlocks.EBONY_STAIRS))) {
            mfrRemoveRecipes(MineFantasyBlocks.EBONY_STAIRS);
        }
        if(ConfigCrafting.isCarpenterItemCraftable(new ItemStack(Blocks.TRAPDOOR))) {
            mfrRemoveRecipes(Blocks.TRAPDOOR);
        }

        if(ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(Items.BEETROOT_SOUP))) {
            mfrRemoveRecipes(Items.BEETROOT_SOUP);
        }
        if(ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(Items.MUSHROOM_STEW))) {
            mfrRemoveRecipes(Items.MUSHROOM_STEW);
        }
        if(ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(Items.RABBIT_STEW))) {
            mfrRemoveRecipes(Items.RABBIT_STEW);
        }
    }

    //To be used on stubborn recipes that don't get removed by just calling .remove
    private static void manualRemover(Item item) {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;
        ArrayList<IRecipe> recipe = Lists.newArrayList(recipeRegistry.getValues());
        for (IRecipe r : recipe) {
            ItemStack output = r.getRecipeOutput();
            if (output.getItem() == item) {
                recipeRegistry.remove(r.getRegistryName());
            }
        }
    }

    private static void mfrRemoveRecipes(final Block output) {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;

        recipeRegistry.remove(output.getRegistryName());
    }

    //Here if I decide to use it later
    private static void mfrRemoveRecipes(final Item output) {
        mfrRemoveRecipes(recipe -> {
            final ItemStack recipeOutput = recipe.getRecipeOutput();
            return !recipeOutput.isEmpty() && recipeOutput.getItem() == output;
        });
    }

    private static int mfrRemoveRecipes(final Predicate<IRecipe> predicate) {
        final IForgeRegistry<IRecipe> registry = ForgeRegistries.RECIPES;
        final List<IRecipe> toRemove = new ArrayList<>();

        for (final IRecipe recipe : registry) {
            if (predicate.test(recipe)) {
                toRemove.add(recipe);
            }
        }

        toRemove.forEach(recipe -> {
            final ResourceLocation registryName = Objects.requireNonNull(recipe.getRegistryName());
            final IRecipe replacement = new DummyRecipe().setRegistryName(registryName);
            registry.register(replacement);
        });

        return 0;
    }
}
