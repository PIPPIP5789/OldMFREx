package com.PIPPIP5789.mfrex;

import com.PIPPIP5789.mfrex.init.RecipeInit;
import com.google.common.collect.Lists;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MineFantasyBlocks;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MFREx.MODID, name = MFREx.NAME, version = MFREx.VERSION, dependencies = "after:" + MineFantasyReforged.MOD_ID)
public class MFREx {
    public static final String MODID = "mfrex";
    public static final String NAME = "MFREx";
    public static final String VERSION = "0.1";

    //@SidedProxy(clientSide = "com.PIPPIP5789.betterwithfantasy.proxy.ClientProxy", serverSide = "com.PIPPIP5789.betterwithfantasy.proxy.ServerProxy")
    //public static CommonProxy PROXY;
    //public ItemRegistry itemRegistry;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws NoSuchFieldException, IllegalAccessException {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RecipeInit.removeOldRecipes();
    }
}