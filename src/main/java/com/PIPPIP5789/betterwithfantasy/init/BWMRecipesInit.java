package com.PIPPIP5789.betterwithfantasy.init;

import betterwithmods.common.BWMItems;
import betterwithmods.common.BWMRecipes;
import betterwithmods.common.BWRegistry;
import betterwithmods.module.gameplay.CauldronRecipes;
import betterwithmods.util.StackIngredient;
import com.PIPPIP5789.betterwithfantasy.BetterWithFantasy;
import com.google.common.collect.Lists;
import minefantasy.mfr.init.MineFantasyItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = BetterWithFantasy.MODID)
public class BWMRecipesInit {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_CHUNK_COOKED), Ingredient.fromItem(Items.BOWL)), new ItemStack(MineFantasyItems.STEW));
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(new OreIngredient("meatFish"), Ingredient.fromItem(MineFantasyItems.JUG_MILK), Ingredient.fromStacks(StackIngredient.fromStacks(new ItemStack(Items.BOWL, 2)).getMatchingStacks()[0])), new ItemStack(BWMItems.CHOWDER));
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(Ingredient.fromItem(Items.WHEAT), Ingredient.fromItem(MineFantasyItems.JUG_MILK), Ingredient.fromItem(Items.WHEAT_SEEDS), Ingredient.fromItem(Items.BOWL)), new ItemStack(MineFantasyItems.OATS));
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.COCA_POWDER), Ingredient.fromItem(MineFantasyItems.JUG_MILK), Ingredient.fromItem(MineFantasyItems.SUGAR_POT), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), new ItemStack(MineFantasyItems.CHOCOLATE));
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(StackIngredient.fromStacks(new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM), 3)), Ingredient.fromItem(MineFantasyItems.JUG_MILK), Ingredient.fromItem(Items.BOWL)), new ItemStack(Items.MUSHROOM_STEW));
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(StackIngredient.fromItem(MineFantasyItems.GENERIC_MEAT_COOKED), Ingredient.fromItem(MineFantasyItems.FLOUR), new OreIngredient("cookedCarrot"), new OreIngredient("cookedPotato"), StackIngredient.fromStacks(new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM), 3)), StackIngredient.fromStacks(new ItemStack(Items.BOWL, 5))), new ItemStack(BWMItems.HEARTY_STEW, 5));

        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(Items.COAL), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.COAL_DUST, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.KAOLINITE), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.KAOLINITE_DUST, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.FLUX), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.FLUX_POT, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_UNCOOKED), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.GENERIC_MEAT_MINCE_UNCOOKED, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_STRIP_UNCOOKED), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.GENERIC_MEAT_MINCE_UNCOOKED, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_CHUNK_UNCOOKED), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.GENERIC_MEAT_MINCE_UNCOOKED, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_COOKED), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.GENERIC_MEAT_MINCE_COOKED, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_STRIP_COOKED), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.GENERIC_MEAT_MINCE_COOKED, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_CHUNK_COOKED), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.GENERIC_MEAT_MINCE_COOKED, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(Items.WHEAT), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.FLOUR, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(Items.BREAD), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.BREADCRUMBS, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromItem(Items.REEDS), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.SUGAR_POT, 1)));
        BWRegistry.MILLSTONE.addMillRecipe(Lists.newArrayList(Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 3)), Ingredient.fromItem(MineFantasyItems.CLAY_POT)), Lists.newArrayList(new ItemStack(MineFantasyItems.COCA_POWDER, 1)));
    }

    /*

    mods.betterwithmods.Cauldron.addUnstoked([<ore:meatFish>, <minefantasyreforged:jug_milk>, <minecraft:bowl> * 2],[<betterwithmods:chowder> * 2]);
    mods.betterwithmods.Cauldron.addUnstoked([<minecraft:wheat>, <minefantasyreforged:jug_milk>, <minecraft:wheat_seeds>, <minecraft:bowl>],[<minefantasyreforged:oats>]);
    mods.betterwithmods.Cauldron.addUnstoked([<minefantasyreforged:coca_powder>, <minefantasyreforged:jug_milk>, <minefantasyreforged:sugar_pot>, <minefantasyreforged:clay_pot>],[<minefantasyreforged:chocolate>]);
    mods.betterwithmods.Cauldron.addUnstoked([<minecraft:brown_mushroom> * 3, <minefantasyreforged:jug_milk>, <minecraft:bowl>],[<minecraft:mushroom_stew>]);
    mods.betterwithmods.Cauldron.addUnstoked([<minefantasyreforged:generic_meat_chunk_cooked>, <minecraft:bowl>],[<minefantasyreforged:stew>]);
    mods.betterwithmods.Cauldron.addUnstoked([<minefantasyreforged:generic_meat_cooked>, <minefantasyreforged:flour>, <ore:cookedCarrot>, <ore:cookedPotato>, <minecraft:brown_mushroom> * 3, <minecraft:bowl> * 5],[<betterwithmods:hearty_stew> * 5]);

    mods.betterwithmods.Mill.addRecipe([<minecraft:coal>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:coal_dust>]);
    mods.betterwithmods.Mill.addRecipe([<minefantasyreforged:kaolinite>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:kaolinite_dust>]);
    mods.betterwithmods.Mill.addRecipe([<minefantasyreforged:flux>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:flux_pot>]);
    mods.betterwithmods.Mill.addRecipe([<minefantasyreforged:generic_meat_chunk_uncooked>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:generic_meat_mince_uncooked>]);
    mods.betterwithmods.Mill.addRecipe([<minefantasyreforged:generic_meat_chunk_cooked>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:generic_meat_mince_cooked>]);
    mods.betterwithmods.Mill.addRecipe([<minecraft:wheat>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:flour>]);
    mods.betterwithmods.Mill.addRecipe([<minecraft:bread>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:breadcrumbs>]);
    mods.betterwithmods.Mill.addRecipe([<minecraft:reeds>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:sugar_pot>]);
    mods.betterwithmods.Mill.addRecipe([<minecraft:dye:3>,<minefantasyreforged:clay_pot>],[<minefantasyreforged:coca_powder>]);

    */

}
