package com.PIPPIP5789.mfrex.rusticfantasy.init;

import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.item.ItemFoodMFR;
import minefantasy.mfr.item.ItemMultiFood;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.blocks.crops.BlockHerbBase;
import rustic.common.blocks.crops.Herbs;
import rustic.common.items.ModItems;

import static rustic.common.blocks.crops.Herbs.CLOUDSBLUFF_CROP;

public class RusticFantasyBlockInit {

    public static BlockHerbBase garlic_crop;

    public static void initOreDict() throws ClassNotFoundException {
    }

    public static void initBlocks() {
        initHerbs();
    }

    public static void initHerbs() {
        /*garlic_crop = new BlockHerbBase("garlic_crop", true) {
            public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
                return EnumPlantType.Plains;
            }

            /public Item getHerb() {
                //return RusticFantasyItemInit.garlic;
            }
        };*/
        //Blocks.FIRE.setFireInfo(garlic_crop, 60, 100);
    }

    public static void register(RegistryEvent.Register<Block> event) {
        System.out.println("RusticFantasy registering items");

        IForgeRegistry<Block> registry = event.getRegistry();

        registry.register(garlic_crop);
    }

}
