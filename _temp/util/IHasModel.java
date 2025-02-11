package _temp.util;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IHasModel {

    @SideOnly(Side.CLIENT)
    public default void registerModel() {
        //SteamAgeRevolution.PROXY.registerItemRenderer((Item) this, 0, "inventory");
    }

}
