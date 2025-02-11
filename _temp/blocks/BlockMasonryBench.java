package _temp.blocks;

import _temp.tile.MFRExTileEntityBlock;
import _temp.tile.TileEntityMasonryBench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class BlockMasonryBench extends MFRExTileEntityBlock<TileEntityMasonryBench> {

    public static final int GUI_ID = 2;

    public BlockMasonryBench() {
        super("masonry_bench", Material.ROCK);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        /*if (!world.isRemote) {
            TileEntityMasonryBench tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            System.out.println("Test Waka");
            player.openGui(SteamAgeRevolution.Constants.INSTANCE, SteamAgeRevolution.Constants.GUI_STEAM_FURNACE, world, pos.getX(), pos.getY(), pos.getZ());
        }*/
        System.out.println("Waka");
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityMasonryBench tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

    public Class<TileEntityMasonryBench> getTileEntityClass() {
        return TileEntityMasonryBench.class;
    }

    @Nullable
    @Override
    public TileEntityMasonryBench createTileEntity(World world, IBlockState state) {
        return new TileEntityMasonryBench();
    }


}
