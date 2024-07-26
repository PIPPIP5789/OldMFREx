package com.PIPPIP5789.betterwithfantasy.blocks;

/*
    Disclaimer: This code is the property of those who own the BetterWithMods mod.
    All credit goes to the author and maintainer of that mod. I simply had to pull
    it to here for this to work in some form or fashion, but all credit and
    everything goes to them.
 */

import betterwithmods.api.block.IMultiVariants;
import betterwithmods.common.BWMBlocks;
import betterwithmods.common.blocks.BWMBlock;
import com.google.common.collect.Lists;
import java.util.List;

import minefantasy.mfr.init.MineFantasyItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUnfiredPottery extends BWMBlock implements IMultiVariants {

    public static final PropertyEnum<BlockUnfiredPottery.EnumType> TYPE = PropertyEnum.create("potterytype", BlockUnfiredPottery.EnumType.class);
    private static final AxisAlignedBB BRICK_AABB = new AxisAlignedBB(0.25, 0.0, 0.0625, 0.75, 0.375, 0.9375);

    public BlockUnfiredPottery() {
        super(Material.CLAY);
        this.setSoundType(SoundType.GROUND);
        this.setHardness(0.5F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.FIRECLAY_BRICK));
    }

    public static ItemStack getStack(BlockUnfiredPottery.EnumType type) {
        return new ItemStack(BWMBlocks.UNFIRED_POTTERY, 1, type.getMeta());
    }

    public String[] getVariants() {
        return new String[] {"potterytype=fireclay_brick"};
    }

    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing side, float flX, float flY, float flZ, int meta, EntityLivingBase entity, EnumHand hand) {
        IBlockState state = super.getStateForPlacement(world, pos, side, flX, flY, flZ, meta, entity, hand);
        return state.withProperty(TYPE, EnumType.byMeta(meta));
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        EnumType[] var3 = BlockUnfiredPottery.EnumType.VALUES;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            BlockUnfiredPottery.EnumType type = var3[var5];
            items.add(getStack(type));
        }

    }

    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return Lists.newArrayList(new ItemStack(MineFantasyItems.FIRECLAY));
    }

    public int damageDropped(IBlockState state) {
        return ((BlockUnfiredPottery.EnumType) state.getValue(TYPE)).getMeta();
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return BRICK_AABB;
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return face != EnumFacing.DOWN ? BlockFaceShape.UNDEFINED : BlockFaceShape.CENTER;
    }

    public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.isSideSolid(pos.down(), EnumFacing.UP);
    }

    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos other) {
        if (!world.isSideSolid(pos.down(), EnumFacing.UP)) {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
        }

    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, BlockUnfiredPottery.EnumType.byMeta(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return ((BlockUnfiredPottery.EnumType)state.getValue(TYPE)).getMeta();
    }

    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{TYPE});
    }

    public enum EnumType implements IStringSerializable {
        FIRECLAY_BRICK(0, "fireclay_brick");

        private static final BlockUnfiredPottery.EnumType[] VALUES = values();
        private String name;
        private int meta;

        private EnumType(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

        public static BlockUnfiredPottery.EnumType byMeta(int meta) {
            return VALUES[meta];
        }

        public int getMeta() {
            return this.meta;
        }

        public String getName() {
            return this.name;
        }
    }

}
