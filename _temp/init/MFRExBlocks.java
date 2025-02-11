package _temp.init;

import _temp.blocks.BlockMasonryBench;
import minefantasy.mfr.block.BasicBlockMF;
import minefantasy.mfr.util.Utils;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class MFRExBlocks {

    public static BasicBlockMF masonryBench = Utils.nullValue();

    public static void preInitBlocks() {
        masonryBench = new BlockMasonryBench();
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> registry) {
        registry.getRegistry().register(masonryBench);
    }

}
