package com.PIPPIP5789.betterwithfantasy.init;

import betterwithmods.common.BWMRecipes;
import betterwithmods.common.BWRegistry;
import betterwithmods.module.gameplay.CauldronRecipes;
import com.PIPPIP5789.betterwithfantasy.BetterWithFantasy;
import com.google.common.collect.Lists;
import minefantasy.mfr.init.MineFantasyItems;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_CHUNK_COOKED), Ingredient.fromItem(Items.BOWL)), new ItemStack(MineFantasyItems.STEW));
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(Ingredient.fromItem(MineFantasyItems.GENERIC_MEAT_CHUNK_COOKED), Ingredient.fromItem(Items.BOWL)), new ItemStack(MineFantasyItems.STEW));

    }

}
