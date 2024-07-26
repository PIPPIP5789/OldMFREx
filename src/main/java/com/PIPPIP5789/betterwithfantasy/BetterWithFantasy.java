package com.PIPPIP5789.betterwithfantasy;

import betterwithmods.common.BWMBlocks;
import betterwithmods.common.blocks.BlockUnfiredPottery;
import betterwithmods.common.registry.BellowsManager;
import betterwithmods.common.registry.block.recipe.BlockIngredient;
import betterwithmods.common.registry.heat.BWMHeatRegistry;
import betterwithmods.util.InvUtils;
import com.PIPPIP5789.betterwithfantasy.init.BlockRegistry;
import com.PIPPIP5789.betterwithfantasy.init.ItemRegistry;
import com.PIPPIP5789.betterwithfantasy.proxy.CommonProxy;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.api.refine.IBellowsUseable;
import minefantasy.mfr.block.BlockBellows;
import minefantasy.mfr.init.MineFantasyBlocks;
import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.tile.TileEntityBellows;
import minefantasy.mfr.tile.TileEntityForge;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import betterwithmods.BWMod;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = BetterWithFantasy.MODID, name = BetterWithFantasy.NAME, version = BetterWithFantasy.VERSION, dependencies = "after:" + MineFantasyReforged.MOD_ID + ";after:" + BWMod.MODID)
public class BetterWithFantasy {
    public static final String MODID = "betterwithfantasy";
    public static final String NAME = "BetterWithFantasy";
    public static final String VERSION = "0.1";

    @SidedProxy(clientSide = "com.PIPPIP5789.betterwithfantasy.proxy.ClientProxy", serverSide = "com.PIPPIP5789.betterwithfantasy.proxy.ServerProxy")
    public static CommonProxy PROXY;
    public ItemRegistry itemRegistry;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Initializing Compatabilities");

        System.out.println("Initializing Items");
        ItemRegistry.initMFRItems();
        BlockRegistry.initBlocks();
        PROXY.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        //BWMBlocks blcoks;
        //BlockUnfiredPottery block;

        //IBellowsUseable
        //BlockBellows

        //BWMHeatRegistry.addHeatSource(new BlockIngredient(InvUtils.asNonnullList(new ItemStack(Item.getItemFromBlock(MineFantasyBlocks.FIREPIT), 1))), BWMHeatRegistry.UNSTOKED_HEAT);

        PROXY.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        /*CarpenterRecipeLoader.INSTANCE.loadRegistry("carpenter", "assets/fantasyfoods/carpenter_recipes", "config/MineFantasyReforged/custom/recipes/carpenter_recipes/");
        if(LoadedAddons.rustic) {
            CarpenterRecipeLoader.INSTANCE.loadRegistry("carpenter", "assets/fantasyfoods/compat/rustic/carpenter_recipes", "config/MineFantasyReforged/custom/recipes/carpenter_recipes/");
        }*/
        PROXY.postInit();
    }
}