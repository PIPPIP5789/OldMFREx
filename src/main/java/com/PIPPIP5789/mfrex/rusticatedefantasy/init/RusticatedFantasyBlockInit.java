package com.PIPPIP5789.mfrex.rusticatedefantasy.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.blocks.crops.BlockHerbBase;

public class RusticatedFantasyBlockInit {

    public static BlockHerbBase garlic_crop;

    public static void initOreDict() throws ClassNotFoundException {
    }

    public static void initBlocks() {
    }

    public static void register(RegistryEvent.Register<Block> event) {
        System.out.println("RusticFantasy registering items");

        IForgeRegistry<Block> registry = event.getRegistry();

        //registry.register(garlic_crop);
    }

}
