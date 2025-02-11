package _temp.tile;

import minefantasy.mfr.container.ContainerBase;
import minefantasy.mfr.tile.TileEntityBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityMasonryBench extends TileEntityBase {

    //protected FluidTank steamTank;

    private ItemStackHandler inventory = new ItemStackHandler(1);

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("inventory", inventory.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        super.readFromNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }

    @Override
    protected ItemStackHandler createInventory() {
        return null;
    }

    @Override
    public ItemStackHandler getInventory() {
        return null;
    }

    @Override
    public ContainerBase createContainer(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    protected int getGuiId() {
        return 0;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return false;
    }

    /*@Override
    public void update() {
        if(steamTank.getFluidAmount() > 0) {
            System.out.println("Test");
        }
    }*/

}
