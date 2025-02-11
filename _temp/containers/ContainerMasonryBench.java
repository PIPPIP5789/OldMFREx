package _temp.containers;

import _temp.tile.TileEntityMasonryBench;
import minefantasy.mfr.container.ContainerBase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMasonryBench extends ContainerBase {

    public ContainerMasonryBench(InventoryPlayer playerInventory, TileEntityMasonryBench tile) {
        super(playerInventory, tile);

        IItemHandler inventory = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35) {
            @Override
            public void onSlotChanged() {
                tile.markDirty();
            }
        });
        addPlayerSlots(playerInventory, 8, 142);
    }

}
