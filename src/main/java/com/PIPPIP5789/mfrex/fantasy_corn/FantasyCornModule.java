package com.PIPPIP5789.mfrex.fantasy_corn;

import com.PIPPIP5789.mfrex.core.init.MFRExRecipeInit;
import com.PIPPIP5789.mfrex.fantasy_corn.init.FantasyCornRecipeInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class FantasyCornModule {

    public static void preInit(FMLPreInitializationEvent event) {
    }

    public static void init(FMLInitializationEvent event) {

    }

    public static void postInit(FMLPostInitializationEvent event) {
        FantasyCornRecipeInit.removeOldRecipes();
    }


}
