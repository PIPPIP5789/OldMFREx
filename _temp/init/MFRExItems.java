package _temp.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class MFRExItems {

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> registry) {
        registry.getRegistry().register(new ItemBlock(MFRExBlocks.masonryBench).setRegistryName(MFRExBlocks.masonryBench.getRegistryName()));
    }

}
