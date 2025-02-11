package com.PIPPIP5789.mfrex.rusticfantasy;

import com.PIPPIP5789.mfrex.rusticfantasy.init.RusticFantasyItemInit;
import com.PIPPIP5789.mfrex.rusticfantasy.init.RusticFantasyRecipeInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class RusticFantasyModule {

    public static void preInit(FMLPreInitializationEvent event) {
        RusticFantasyItemInit.initItems();
    }

    public static void init(FMLInitializationEvent event) {
        try {
            RusticFantasyItemInit.initOreDict();
        }
        catch(ClassNotFoundException e) {
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        RusticFantasyRecipeInit.removeOldRecipes();
    }


}
