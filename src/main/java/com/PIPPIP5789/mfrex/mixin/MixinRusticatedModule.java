//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.PIPPIP5789.mfrex.mixin;

import net.minecraft.block.Block;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;
import nihiltres.rusticatedfruit.common.block.BlockFluidRusticated;
import nihiltres.rusticatedfruit.common.module.AbstractModule;
import nihiltres.rusticatedfruit.common.module.RusticatedModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RusticatedModule.class)
public abstract class MixinRusticatedModule extends AbstractModule {

    public MixinRusticatedModule(String nameIn) {
        super(nameIn);
    }

    @Inject(method = "makeFluidBlock*", at = @At("HEAD"), remap = false, cancellable = true)
    private static void makeFluidBlock(Fluid fluid, int quantaPerBlock, CallbackInfoReturnable<Block> cir) {
        if(fluid == null) {
            cir.setReturnValue(null);
            cir.cancel();
        }
    }

    @Inject(method = "makeBooze", at = @At("HEAD"), remap = false, cancellable = true)
    private static void makeBooze(String name, Potion goodPotion, Potion badPotion, CallbackInfoReturnable<Fluid> cir) {
        cir.setReturnValue(null);
        cir.cancel();
    }

    @Inject(method = "addBrewingBarrelRecipe", at = @At("HEAD"), remap = false, cancellable = true)
    private static void addBrewingBarrelRecipe(Fluid output, Fluid input, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
        cir.cancel();
    }

}
