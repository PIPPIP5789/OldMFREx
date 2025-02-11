package com.PIPPIP5789.mfrex.fantasy_corn.init;

import com.PIPPIP5789.mfrex.core.util.RecipeIniter;
import minefantasy.mfr.api.MineFantasyReforgedAPI;
import minefantasy.mfr.config.ConfigCrafting;
import minefantasy.mfr.config.ConfigHardcore;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import panda.corn.init.ModItems;

public class FantasyCornRecipeInit extends RecipeIniter {

    public static void removeOldRecipes() {
        if(ConfigCrafting.isRoastItemCraftable(new ItemStack(ModItems.CORNCHOWDER))) {
            mfrRemoveRecipes(ModItems.CORNCHOWDER);
        }
        if(ConfigCrafting.isRoastItemCraftable(new ItemStack(ModItems.CHICKENCORNCHOWDER))) {
            mfrRemoveRecipes(ModItems.CHICKENCORNCHOWDER);
        }
        if(ConfigHardcore.preventCook) {
            MineFantasyReforgedAPI.removeSmelting(new ItemStack(ModItems.CORNCOB));
            MineFantasyReforgedAPI.removeSmelting(new ItemStack(ModItems.KERNELS));
        }
    }

}
