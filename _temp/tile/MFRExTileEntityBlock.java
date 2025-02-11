package _temp.tile;

import minefantasy.mfr.block.BasicBlockMF;
import minefantasy.mfr.tile.TileEntityBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class MFRExTileEntityBlock<TE extends TileEntityBase> extends BasicBlockMF {

    public MFRExTileEntityBlock(String name, Material material) {
        super(name, material);
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TE) world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);

}