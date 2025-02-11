package com.PIPPIP5789.mfrex.mixin;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rustic.common.Config;
import rustic.common.blocks.*;
import rustic.common.blocks.crops.*;
import rustic.common.blocks.slab.BlockDoubleSlabBase;
import rustic.common.blocks.slab.BlockSlabBase;
import rustic.common.blocks.slab.ItemBlockSlabBase;
import rustic.common.items.ModItems;
import rustic.common.tileentity.*;
import rustic.core.Rustic;

import static rustic.common.blocks.ModBlocks.*;

@Mixin(BlockBase.class)
public class MixinRusticBaseBlock {

    @Inject(method = "register*", at = @At("HEAD"), remap = false, cancellable = true)
    public void register(Item item, CallbackInfo ci) {
        if ("rustic:brewing_barrel".equals(item.getRegistryName().toString()) ||
            "rustic:clay_wall".equals(item.getRegistryName().toString()) ||
            "rustic:clay_wall_cross".equals(item.getRegistryName().toString()) ||
            "rustic:clay_wall_diag".equals(item.getRegistryName().toString())) {
            ci.cancel();
        }
    }

}