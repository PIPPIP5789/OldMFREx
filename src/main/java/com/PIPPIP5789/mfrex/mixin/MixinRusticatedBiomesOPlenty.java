package com.PIPPIP5789.mfrex.mixin;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.enums.BOPTrees;
import biomesoplenty.api.enums.BOPWoods;
import biomesoplenty.api.item.BOPItems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import biomesoplenty.common.block.BlockBOPLeaves;
import biomesoplenty.common.block.BlockBOPLog;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import nihiltres.rusticatedfruit.common.FruitTree;
import nihiltres.rusticatedfruit.common.block.BlockLeavesFruit;
import nihiltres.rusticatedfruit.common.block.properties.IBlockSetup;
import nihiltres.rusticatedfruit.common.module.RusticatedModule;
import nihiltres.rusticatedfruit.common.potion.PotionFragrant;
import nihiltres.rusticatedfruit.common.potion.PotionParry;
import nihiltres.rusticatedfruit.common.potion.PotionSnap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rustic.common.blocks.BlockBase;
import rustic.common.blocks.fluids.FluidBooze;
import rustic.common.blocks.fluids.ModFluids;
import rustic.common.items.ItemFluidBottle;

import static nihiltres.rusticatedfruit.common.module.BiomesOPlenty.*;

@Mixin(nihiltres.rusticatedfruit.common.module.BiomesOPlenty.class)
public class MixinRusticatedBiomesOPlenty extends RusticatedModule {

    @Shadow
    private static FruitTree TREE_PEACH;
    @Shadow
    private static FruitTree TREE_PEAR;
    @Shadow
    private static FruitTree TREE_PERSIMMON;
    @Shadow
    private static Block BLOCK_LEAVES_PEACH;
    @Shadow
    private static Block BLOCK_LEAVES_PEAR;
    @Shadow
    private static Block BLOCK_LEAVES_PERSIMMON;
    @Shadow
    private static Block BLOCK_SAPLING_PEACH;
    @Shadow
    private static Block BLOCK_SAPLING_PEAR;
    @Shadow
    private static Block BLOCK_SAPLING_PERSIMMON;
    @Shadow
    private static Block BLOCK_SEED_PEACH;
    @Shadow
    private static Block BLOCK_SEED_PEAR;
    @Shadow
    private static Block BLOCK_SEED_PERSIMMON;
    @Shadow
    private static Item ITEMBLOCK_LEAVES_PEACH;
    @Shadow
    private static Item ITEMBLOCK_LEAVES_PEAR;
    @Shadow
    private static Item ITEMBLOCK_LEAVES_PERSIMMON;
    @Shadow
    private static Item ITEMBLOCK_SAPLING_PEACH;
    @Shadow
    private static Item ITEMBLOCK_SAPLING_PEAR;
    @Shadow
    private static Item ITEMBLOCK_SAPLING_PERSIMMON;
    @Shadow
    private static Item ITEMBLOCK_SEED_PEACH;
    @Shadow
    private static Item ITEMBLOCK_SEED_PEAR;
    @Shadow
    private static Item ITEMBLOCK_SEED_PERSIMMON;
    @Shadow
    private static Item ITEMBLOCK_FLUID_PEACH_JUICE;
    @Shadow
    private static Item ITEMBLOCK_FLUID_PEAR_JUICE;
    @Shadow
    private static Item ITEMBLOCK_FLUID_PERSIMMON_JUICE;

    public MixinRusticatedBiomesOPlenty(String nameIn) {
        super(nameIn);
    }

    @Inject(method = "preInit", at = @At("HEAD"), remap = false, cancellable = true)
    private void preInit(CallbackInfo ci) {
        TREE_PEACH = new FruitTree("peach", getState(BOPBlocks.log_3, BOPWoods.MAHOGANY), getState(BOPBlocks.leaves_3, BOPTrees.FLOWERING), new ItemStack(BOPItems.peach), 7, 3);
        TREE_PEAR = new FruitTree("pear", getState(BOPBlocks.log_1, BOPWoods.MANGROVE), getState(BOPBlocks.leaves_4, BOPTrees.WILLOW), new ItemStack(BOPItems.pear), 6, 2);
        TREE_PERSIMMON = new FruitTree("persimmon", getState(BOPBlocks.log_3, BOPWoods.EBONY), getState(BOPBlocks.leaves_2, BOPTrees.MAPLE), new ItemStack(BOPItems.persimmon), 5, 2);
        ((BlockLeavesFruit)TREE_PERSIMMON.BLOCK_LEAF).setNoTinting();
        BLOCK_LEAVES_PEACH = TREE_PEACH.BLOCK_LEAF;
        BLOCK_LEAVES_PEAR = TREE_PEAR.BLOCK_LEAF;
        BLOCK_LEAVES_PERSIMMON = TREE_PERSIMMON.BLOCK_LEAF;
        BLOCK_SAPLING_PEACH = TREE_PEACH.BLOCK_SAPLING;
        BLOCK_SAPLING_PEAR = TREE_PEAR.BLOCK_SAPLING;
        BLOCK_SAPLING_PERSIMMON = TREE_PERSIMMON.BLOCK_SAPLING;
        BLOCK_SEED_PEACH = TREE_PEACH.BLOCK_SEED;
        BLOCK_SEED_PEAR = TREE_PEAR.BLOCK_SEED;
        BLOCK_SEED_PERSIMMON = TREE_PERSIMMON.BLOCK_SEED;
        ITEMBLOCK_LEAVES_PEACH = TREE_PEACH.ITEM_LEAF;
        ITEMBLOCK_LEAVES_PEAR = TREE_PEAR.ITEM_LEAF;
        ITEMBLOCK_LEAVES_PERSIMMON = TREE_PERSIMMON.ITEM_LEAF;
        ITEMBLOCK_SAPLING_PEACH = TREE_PEACH.ITEM_SAPLING;
        ITEMBLOCK_SAPLING_PEAR = TREE_PEAR.ITEM_SAPLING;
        ITEMBLOCK_SAPLING_PERSIMMON = TREE_PERSIMMON.ITEM_SAPLING;
        ITEMBLOCK_SEED_PEACH = TREE_PEACH.ITEM_SEED;
        ITEMBLOCK_SEED_PEAR = TREE_PEAR.ITEM_SEED;
        ITEMBLOCK_SEED_PERSIMMON = TREE_PERSIMMON.ITEM_SEED;
        ITEMBLOCK_FLUID_PEACH_JUICE = IBlockSetup.getItemBlock(BLOCK_FLUID_PEACH_JUICE);
        ITEMBLOCK_FLUID_PEAR_JUICE = IBlockSetup.getItemBlock(BLOCK_FLUID_PEAR_JUICE);
        ITEMBLOCK_FLUID_PERSIMMON_JUICE = IBlockSetup.getItemBlock(BLOCK_FLUID_PERSIMMON_JUICE);
        this.addBlocks(new Block[]{BLOCK_LEAVES_PEACH, BLOCK_LEAVES_PEAR, BLOCK_LEAVES_PERSIMMON, BLOCK_SAPLING_PEACH, BLOCK_SAPLING_PEAR, BLOCK_SAPLING_PERSIMMON, BLOCK_SEED_PEACH, BLOCK_SEED_PEAR, BLOCK_SEED_PERSIMMON, BLOCK_FLUID_PEACH_JUICE, BLOCK_FLUID_PEAR_JUICE, BLOCK_FLUID_PERSIMMON_JUICE});
        this.addItems(new Item[]{ITEMBLOCK_LEAVES_PEACH, ITEMBLOCK_LEAVES_PEAR, ITEMBLOCK_LEAVES_PERSIMMON, ITEMBLOCK_SAPLING_PEACH, ITEMBLOCK_SAPLING_PEAR, ITEMBLOCK_SAPLING_PERSIMMON, ITEMBLOCK_SEED_PEACH, ITEMBLOCK_SEED_PEAR, ITEMBLOCK_SEED_PERSIMMON, ITEMBLOCK_FLUID_PEACH_JUICE, ITEMBLOCK_FLUID_PEAR_JUICE, ITEMBLOCK_FLUID_PERSIMMON_JUICE});
        ci.cancel();
    }

    @Inject(method = "init", at = @At("HEAD"), remap = false, cancellable = true)
    private void init(CallbackInfo ci) {
        //List<Fluid> rusticFluids = (List)ReflectionHelper.getPrivateValue(ModFluids.class, (Object)null, "FLUIDS", "X");

        FLUIDS.stream().forEach((fluid) -> {
            if (!(fluid instanceof FluidBooze)) {
                FluidRegistry.addBucketForFluid(fluid);
                //rusticFluids.add(fluid);
                ItemFluidBottle.addFluid(fluid);
            }
            else {
                FLUIDS.remove(fluid);
            }
        });
        addCrushingTubRecipe(FLUID_PEACH_JUICE, BOPItems.peach, ITEMBLOCK_SEED_PEACH);
        addCrushingTubRecipe(FLUID_PEAR_JUICE, BOPItems.pear, ITEMBLOCK_SEED_PEAR);
        addCrushingTubRecipe(FLUID_PERSIMMON_JUICE, BOPItems.persimmon, ITEMBLOCK_SEED_PERSIMMON);
        ci.cancel();
    }

}
