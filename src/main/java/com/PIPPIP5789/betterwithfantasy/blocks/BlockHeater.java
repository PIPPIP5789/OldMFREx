package com.PIPPIP5789.betterwithfantasy.blocks;

import com.PIPPIP5789.betterwithfantasy.tile.TileHeater;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.block.BlockTileEntity;
import minefantasy.mfr.init.MineFantasyTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHeater extends BlockTileEntity implements minefantasy.mfr.api.crafting.IHeatSource, betterwithmods.api.tile.IHeatSource {

    public BlockHeater() {
        super(Material.FIRE);

        setRegistryName("heater");
        //setTranslationKey("heater");
        this.setHardness(1F);
        this.setResistance(0.5F);
        this.setCreativeTab(MineFantasyTabs.tabUtil);
        MineFantasyReforged.PROXY.addClientRegister(this);
    }

    @Override
    public boolean matches(World world, BlockPos blockPos) {
        return false;
    }

    @Override
    public boolean canPlaceAbove() {
        return false;
    }

    @Override
    public int getHeat() {
        return 100;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState iBlockState) {
        return new TileHeater();
    }

}
