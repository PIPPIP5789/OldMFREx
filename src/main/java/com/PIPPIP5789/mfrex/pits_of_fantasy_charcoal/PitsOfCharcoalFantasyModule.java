package com.PIPPIP5789.mfrex.pits_of_fantasy_charcoal;

import com.PIPPIP5789.mfrex.pits_of_fantasy_charcoal.init.PitsOfCharcoalFantasyBlockInit;
import com.PIPPIP5789.mfrex.pits_of_fantasy_charcoal.init.PitsOfCharcoalFantasyItemInit;
import com.PIPPIP5789.mfrex.pits_of_fantasy_charcoal.init.PitsOfCharcoalFantasyRecipeInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PitsOfCharcoalFantasyModule {

    public static void preInit(FMLPreInitializationEvent event) {
        PitsOfCharcoalFantasyItemInit.initItems();
        PitsOfCharcoalFantasyBlockInit.initBlocks();
    }

    public static void init(FMLInitializationEvent event) {
        try {
            PitsOfCharcoalFantasyItemInit.initOreDict();
        }
        catch(ClassNotFoundException e) {
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        PitsOfCharcoalFantasyRecipeInit.removeOldRecipes();
    }


}
