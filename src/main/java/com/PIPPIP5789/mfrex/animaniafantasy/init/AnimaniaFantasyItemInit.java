package com.PIPPIP5789.mfrex.animaniafantasy.init;

import betterwithmods.module.compat.jei.JEI;
import com.animania.addons.catsdogs.CatsDogsAddon;
import com.animania.addons.catsdogs.common.handler.CatsDogsAddonBlockHandler;
import com.animania.addons.catsdogs.common.handler.CatsDogsAddonItemHandler;
import com.animania.addons.extra.common.handler.ExtraAddonBlockHandler;
import com.animania.addons.extra.common.handler.ExtraAddonItemHandler;
import com.animania.addons.farm.common.handler.FarmAddonBlockHandler;
import com.animania.addons.farm.common.handler.FarmAddonItemHandler;
import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.integration.jei.JEICarpenterRecipe;
import minefantasy.mfr.integration.jei.JEIIntegration;
import minefantasy.mfr.item.ItemFoodMFR;
import minefantasy.mfr.util.Utils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class AnimaniaFantasyItemInit {

    public static void initOreDictBase() {
        //OreDictionary.registerOre();
    }

    public static void initOreDictFarm() {
        //OreDictionary.registerOre("wool", FarmAddonBlockHandler.blockAnimaniaWool);
        OreDictionary.registerOre("egg", FarmAddonItemHandler.brownEgg);
        OreDictionary.registerOre("raw_meat", FarmAddonItemHandler.rawPrimeBacon);
        OreDictionary.registerOre("cheese", FarmAddonItemHandler.cheeseWedgeFriesian);
        OreDictionary.registerOre("cheese", FarmAddonItemHandler.cheeseWedgeHolstein);
        OreDictionary.registerOre("cheese", FarmAddonItemHandler.cheeseWedgeJersey);
        OreDictionary.registerOre("cheese", FarmAddonBlockHandler.blockCheeseSheep);
        OreDictionary.registerOre("cheese", FarmAddonBlockHandler.blockCheeseGoat);
        OreDictionary.registerOre("cheese", MineFantasyItems.CHEESE_SLICE);

        // ADD A NAME CHANGE - WOOL IS PROCESSED WOOL, CHEESE IS GENERIC CHEESE
    }

    public static void initOreDictCatsDogs() {
        //OreDictionary.registerOre("berry", CatsDogsAddonItemHandler.);
    }

    public static void initOreDictExtra() {
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherBlue);
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherCharcoal);
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherOpal);
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherPeach);
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherPurple);
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherTaupe);
        OreDictionary.registerOre("feather", ExtraAddonItemHandler.peacockFeatherWhite);
        OreDictionary.registerOre("egg", ExtraAddonItemHandler.peacockEggBlue);
        OreDictionary.registerOre("egg", ExtraAddonItemHandler.peacockEggWhite);


    }

}
