package com.PIPPIP5789.betterwithfantasy.init;

import betterwithmods.common.BWMBlocks;
import com.PIPPIP5789.betterwithfantasy.BetterWithFantasy;
import com.PIPPIP5789.betterwithfantasy.blocks.BlockHeater;
import com.PIPPIP5789.betterwithfantasy.blocks.BlockUnfiredPottery;
import minefantasy.mfr.util.Utils;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(BetterWithFantasy.MODID)
@Mod.EventBusSubscriber(modid = BetterWithFantasy.MODID)
public class BlockRegistry {

    public static Block heater = Utils.nullValue();
    public static Block fireclay_brick = new BlockUnfiredPottery();

    public static void initBlocks() {
        //heater = new BlockHeater();
        //System.out.println("WAKA TEST");
        //fireclay_brick = new BlockUnfiredPottery();
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Block> event) {
        //event.getRegistry().register(heater);
        //System.out.println("WAKA -> " + fireclay_brick);
        //event.getRegistry().register(fireclay_brick);
        //fireclay_brick = new BlockUnfiredPottery();
        //BWMBlocks.registerBlock(fireclay_brick);
    }

}