package com.PIPPIP5789.mfrex.animaniafantasy.init;

import com.PIPPIP5789.mfrex.core.MFREx;
import com.PIPPIP5789.mfrex.core.util.RecipeIniter;
import com.animania.Animania;
import com.animania.addons.extra.common.handler.ExtraAddonItemHandler;
import com.animania.addons.farm.common.handler.FarmAddonBlockHandler;
import com.animania.addons.farm.common.handler.FarmAddonItemHandler;
import com.animania.common.handler.BlockHandler;
import com.animania.common.handler.ItemHandler;
import com.animania.common.items.AnimaniaItem;
import minefantasy.mfr.api.MineFantasyReforgedAPI;
import minefantasy.mfr.config.ConfigCrafting;
import minefantasy.mfr.config.ConfigHardcore;
import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.recipe.CarpenterRecipeBase;
import minefantasy.mfr.recipe.CraftingManagerCarpenter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.Collection;

public class AnimaniaFantasyRecipeInit extends RecipeIniter {

    public static void removeOldRecipesBase() {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;

        mfrRemoveRecipes(FarmAddonItemHandler.carvingKnife);
        mfrRemoveRecipes(FarmAddonItemHandler.cheeseWedgeFriesian);
        mfrRemoveRecipes(FarmAddonItemHandler.cheeseWedgeHolstein);
        mfrRemoveRecipes(FarmAddonItemHandler.cheeseWedgeJersey);
        mfrRemoveRecipes(FarmAddonItemHandler.cheeseWedgeGoat);
        mfrRemoveRecipes(FarmAddonItemHandler.cheeseWedgeSheep);

        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(FarmAddonItemHandler.ridingCrop))) {
            mfrRemoveRecipes(FarmAddonItemHandler.ridingCrop);
        }
        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(BlockHandler.itemBlockTrough))) {
            mfrRemoveRecipes(BlockHandler.itemBlockTrough);
        }
        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(BlockHandler.itemBlockStraw))) {
            recipeRegistry.remove(new ResourceLocation(Animania.MODID, "straw"));
            recipeRegistry.remove(new ResourceLocation(Animania.MODID, "straw_cutting"));
            //recipeRegistry.remove(Item.getByNameOrId("animania:block_straw").getRegistryName());
        }
        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(BlockHandler.blockSaltLick))) {
            recipeRegistry.remove(new ResourceLocation(Animania.MODID, "salt_lick_0"));
            //recipeRegistry.remove(BlockHandler.blockSaltLick.getRegistryName());
        }
    }

    public static void removeOldRecipesFarm() {
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;

        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(FarmAddonItemHandler.cart))) {
            mfrRemoveRecipes(FarmAddonItemHandler.cart);
        }
        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(FarmAddonItemHandler.tiller))) {
            mfrRemoveRecipes(FarmAddonItemHandler.tiller);
        }
        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(FarmAddonItemHandler.wagon))) {
            mfrRemoveRecipes(FarmAddonItemHandler.wagon);
        }
        if (ConfigCrafting.isCarpenterItemCraftable(new ItemStack(FarmAddonItemHandler.wheel))) {
            mfrRemoveRecipes(FarmAddonItemHandler.wheel);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.rawPrimeSteak))) {
            mfrRemoveRecipes(FarmAddonItemHandler.rawPrimeSteak);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.rawPrimeBacon))) {
            mfrRemoveRecipes(FarmAddonItemHandler.rawPrimeBacon);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.rawPrimeBeef))) {
            mfrRemoveRecipes(FarmAddonItemHandler.rawPrimeBeef);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.baconOmelette))) {
            mfrRemoveRecipes(FarmAddonItemHandler.baconOmelette);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.cheeseOmelette))) {
            mfrRemoveRecipes(FarmAddonItemHandler.cheeseOmelette);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.truffleOmelette))) {
            mfrRemoveRecipes(FarmAddonItemHandler.truffleOmelette);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.ultimateOmelette))) {
            mfrRemoveRecipes(FarmAddonItemHandler.ultimateOmelette);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.truffleSoup))) {
            mfrRemoveRecipes(FarmAddonItemHandler.truffleSoup);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonItemHandler.chocolateTruffle))) {
            mfrRemoveRecipes(FarmAddonItemHandler.chocolateTruffle);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonBlockHandler.blockCheeseMold))) {
            mfrRemoveRecipes(FarmAddonBlockHandler.blockCheeseMold);
        }
        if (ConfigCrafting.isKitchenBenchItemCraftable(new ItemStack(FarmAddonBlockHandler.blockHive))) {
            recipeRegistry.remove(new ResourceLocation(Animania.MODID, "bee_hive"));
        }

        if (ConfigHardcore.preventCook) {
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimeBeef);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimeSteak);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimePork);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimeBacon);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimeChicken);
            MineFantasyReforgedAPI.removeSmelting(Items.EGG);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.brownEgg);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimeMutton);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawChevon);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawPrimeChevon);
            MineFantasyReforgedAPI.removeSmelting(FarmAddonItemHandler.rawHorse);
        }
    }

    public static void removeOldRecipesCatsDogs() {

    }

    public static void removeOldRecipesExtra() {
        if (ConfigHardcore.preventCook) {
            MineFantasyReforgedAPI.removeSmelting(ExtraAddonItemHandler.peacockEggBlue);
            MineFantasyReforgedAPI.removeSmelting(ExtraAddonItemHandler.peacockEggWhite);
            MineFantasyReforgedAPI.removeSmelting(ExtraAddonItemHandler.rawFrogLegs);
            MineFantasyReforgedAPI.removeSmelting(ExtraAddonItemHandler.rawPeacock);
            MineFantasyReforgedAPI.removeSmelting(ExtraAddonItemHandler.rawPrimePeacock);
            MineFantasyReforgedAPI.removeSmelting(ExtraAddonItemHandler.rawPrimeRabbit);
        }
    }

    /*
    event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_block"), new ItemStack(block), true, new Object[]{
                    "XXX",
                    "XXX",
                    "XXX",
                    'X', ingotKey}).setRegistryName(getRL(ingotKey + "_block")));
     */

    public static void addNewRecipesBase() {
        GameRegistry.addShapedRecipe(new ResourceLocation(MFREx.MODID, "salt_pot"), null, new ItemStack(MineFantasyItems.SALT), new Object[] {
                " S ",
                " S ",
                " P ",
                'S', new ItemStack(Item.getByNameOrId("animania:salt")),
                'P', MineFantasyItems.CLAY_POT
        });
        GameRegistry.addShapedRecipe(new ResourceLocation(MFREx.MODID, "salt_lick"), null, new ItemStack(Item.getByNameOrId("animania:salt_lick")), new Object[] {
                "W",
                "S",
                'S', MineFantasyItems.SALT,
                'W', MineFantasyItems.JUG_WATER
        });
        //recipeRegistry.register(new ShapedOreRecipe(null, new ItemStack(MineFantasyItems.SALT).getItem(), new Object[] {0, 0}));
    }

}
