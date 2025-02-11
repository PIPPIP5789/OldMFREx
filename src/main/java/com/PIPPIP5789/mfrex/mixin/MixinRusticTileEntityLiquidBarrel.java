package com.PIPPIP5789.mfrex.mixin;

import minefantasy.mfr.api.heating.IQuenchBlock;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import rustic.common.tileentity.TileEntityLiquidBarrel;

@Mixin(TileEntityLiquidBarrel.class)
public abstract class MixinRusticTileEntityLiquidBarrel implements IQuenchBlock {

    @Shadow public abstract Fluid getFluid();

    @Shadow public abstract FluidTank getTank();

    @Override
    public float quench() {
        if (getFluid() == FluidRegistry.WATER) {
            getTank().drain(new FluidStack(FluidRegistry.WATER, 1000), true);
            return 0F;
        }
        return -1F;
    }

}
