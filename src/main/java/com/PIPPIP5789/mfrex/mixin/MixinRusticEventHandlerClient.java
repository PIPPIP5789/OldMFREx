package com.PIPPIP5789.mfrex.mixin;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rustic.client.EventHandlerClient;
import rustic.client.models.BookBakedModel;
import rustic.client.models.LiquidBarrelItemModel;
import rustic.client.models.TEISRModel;
import rustic.common.blocks.ModBlocks;
import rustic.common.blocks.fluids.ModFluids;

import java.util.List;

@Mixin(EventHandlerClient.class)
public class MixinRusticEventHandlerClient {

    @Inject(method = "onModelBakeEvent", at = @At("HEAD"), remap = false, cancellable = true)
    public void onModelBakeEvent(ModelBakeEvent event, CallbackInfo ci) {
        /*Object object = event.getModelRegistry().getObject(LiquidBarrelItemModel.modelResourceLocation);
        IBakedModel existingModel;
        if (object instanceof IBakedModel) {
            existingModel = (IBakedModel)object;
            LiquidBarrelItemModel customModel = new LiquidBarrelItemModel(existingModel);
            event.getModelRegistry().putObject(LiquidBarrelItemModel.modelResourceLocation, customModel);
        }

        ModelResourceLocation mrl = new ModelResourceLocation(ModBlocks.CABINET.getRegistryName(), "inventory");
        object = event.getModelRegistry().getObject(mrl);
        if (object instanceof IBakedModel) {
            existingModel = (IBakedModel)object;
            event.getModelRegistry().putObject(mrl, new TEISRModel(existingModel));
        }*/

        ci.cancel();
    }

}
