package com.PIPPIP5789.mfrex.betterwithfantasy;

import com.PIPPIP5789.mfrex.betterwithfantasy.init.BetterWithFantasyItemInit;
import com.PIPPIP5789.mfrex.betterwithfantasy.init.BetterWithFantasyRecipeInit;
import com.PIPPIP5789.mfrex.fantasy_corn.init.FantasyCornRecipeInit;
import com.PIPPIP5789.mfrex.rusticfantasy.init.RusticFantasyItemInit;
import com.PIPPIP5789.mfrex.rusticfantasy.init.RusticFantasyRecipeInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BetterWithFantasyModule {

    public static void preInit(FMLPreInitializationEvent event) {
        BetterWithFantasyItemInit.initItems();
    }

    public static void init(FMLInitializationEvent event) {
        try {
            BetterWithFantasyItemInit.initOreDict();
        }
        catch(ClassNotFoundException e) {
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        BetterWithFantasyRecipeInit.removeOldRecipes();
    }

}
