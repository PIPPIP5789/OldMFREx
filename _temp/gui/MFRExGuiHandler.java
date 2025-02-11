package _temp.gui;

import _temp.blocks.BlockMasonryBench;
import _temp.containers.ContainerMasonryBench;
import _temp.tile.TileEntityMasonryBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class MFRExGuiHandler implements IGuiHandler {

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case BlockMasonryBench.GUI_ID:
                return new ContainerMasonryBench(player.inventory, (TileEntityMasonryBench) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case BlockMasonryBench.GUI_ID:
                return new GuiMasonryBench(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }

}
