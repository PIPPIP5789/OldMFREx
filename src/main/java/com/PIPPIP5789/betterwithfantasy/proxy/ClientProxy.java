package com.PIPPIP5789.betterwithfantasy.proxy;

import com.PIPPIP5789.betterwithfantasy.init.ResearchInit;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
        //ResearchInit.initResearch();
    }
}
