package com.PIPPIP5789.mfrex.animaniafantasy;

import com.PIPPIP5789.mfrex.animaniafantasy.init.AnimaniaFantasyItemInit;
import com.PIPPIP5789.mfrex.animaniafantasy.init.AnimaniaFantasyRecipeInit;
import com.animania.Animania;
import com.animania.addons.farm.common.handler.FarmAddonBlockHandler;
import com.animania.addons.farm.common.handler.FarmAddonItemHandler;
import com.animania.common.handler.BlockHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class AnimaniaFantasyModule {

    public static void preInit(FMLPreInitializationEvent event) {
    }

    public static void init(FMLInitializationEvent event) {
    }

    public static void postInit(FMLPostInitializationEvent event) {
        AnimaniaFantasyItemInit.initOreDictBase();
        AnimaniaFantasyItemInit.initOreDictFarm();
        AnimaniaFantasyItemInit.initOreDictCatsDogs();
        AnimaniaFantasyItemInit.initOreDictExtra();

        AnimaniaFantasyRecipeInit.removeOldRecipesBase();
        AnimaniaFantasyRecipeInit.removeOldRecipesFarm();
        AnimaniaFantasyRecipeInit.removeOldRecipesCatsDogs();
        AnimaniaFantasyRecipeInit.removeOldRecipesExtra();

        AnimaniaFantasyRecipeInit.addNewRecipesBase();
    }

}
