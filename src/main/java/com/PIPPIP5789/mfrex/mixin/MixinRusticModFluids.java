package com.PIPPIP5789.mfrex.mixin;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rustic.common.blocks.fluids.BlockFluidRustic;
import rustic.common.blocks.fluids.FluidDrinkable;
import rustic.common.blocks.fluids.ModFluids;
import rustic.common.potions.PotionsRustic;

import java.util.List;

import static rustic.common.blocks.fluids.ModFluids.*;

/*
 * I don't usually make notes, but I wanted to make a note that I did not
 * make like 95% of this code; it's all Rustic's code. Sadly, given my limited
 * knowledge of Mixins, I haven't figured out a way to insert code into the
 * middle of a method... thereby meaning the only way to change the middle of
 * said method is through copy/pasting the entire method, and calling it instead
 * of the original one. It's not a fantastic solution, but it's the only thing
 * that I could get to work. ALl of that to say, all credit goes to the Rustic
 * dev(s) and the incredible work done to make the mod.
 */
@Mixin(ModFluids.class)
public class MixinRusticModFluids {

    @Shadow
    private static List<Fluid> FLUIDS;

    @Inject(method = "init", at = @At("HEAD"), remap = false, cancellable = true)
    private static void init(CallbackInfo ci) {
        OLIVE_OIL = new FluidDrinkable("oliveoil", new ResourceLocation("rustic:blocks/fluids/olive_oil_still"),
                new ResourceLocation("rustic:blocks/fluids/olive_oil_flow")) {
            @Override
            public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
                player.getFoodStats().addStats(1, 0.4F);
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 600, 1));
            }
        }.setDensity(920).setViscosity(2000);
        registerRustic(OLIVE_OIL);

        IRONBERRY_JUICE = new FluidDrinkable("ironberryjuice",
                new ResourceLocation("rustic:blocks/fluids/ironberry_juice_still"),
                new ResourceLocation("rustic:blocks/fluids/ironberry_juice_flow")) {
            @Override
            public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
                player.getFoodStats().addStats(1, 0.8F);
                int duration = 30 * 20;
                PotionEffect effect = player.getActivePotionEffect(PotionsRustic.IRON_SKIN_POTION);
                if (effect == null) {
                    player.addPotionEffect(new PotionEffect(PotionsRustic.IRON_SKIN_POTION, duration, 0, false, true));
                } else {
                    player.addPotionEffect(new PotionEffect(PotionsRustic.IRON_SKIN_POTION, effect.getDuration() + duration, 0, false, true));
                }
            }
        }.setDensity(1100).setViscosity(1100);
        registerRustic(IRONBERRY_JUICE);

        WILDBERRY_JUICE = new FluidDrinkable("wildberryjuice",
                new ResourceLocation("rustic:blocks/fluids/wildberry_juice_still"),
                new ResourceLocation("rustic:blocks/fluids/wildberry_juice_flow")) {
            @Override
            public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
                player.getFoodStats().addStats(1, 1F);
                if (player.getRNG().nextFloat() < 0.2F) {
                    player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 75));
                }
                if (player.getRNG().nextFloat() < 0.1F) {
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, 200));
                }
            }
        }.setDensity(1070).setViscosity(1100);
        registerRustic(WILDBERRY_JUICE);

        GRAPE_JUICE = new FluidDrinkable("grapejuice", new ResourceLocation("rustic:blocks/fluids/grape_juice_still"),
                new ResourceLocation("rustic:blocks/fluids/grape_juice_flow")) {
            @Override
            public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
                player.getFoodStats().addStats(1, 0.9F);
            }
        }.setDensity(1070).setViscosity(1100);
        registerRustic(GRAPE_JUICE);

        APPLE_JUICE = new FluidDrinkable("applejuice", new ResourceLocation("rustic:blocks/fluids/apple_juice_still"),
                new ResourceLocation("rustic:blocks/fluids/apple_juice_flow")) {
            @Override
            public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
                player.getFoodStats().addStats(1, 1.2F);
            }
        }.setDensity(1050).setViscosity(1100);
        registerRustic(APPLE_JUICE);

        HONEY = new FluidDrinkable("honey", new ResourceLocation("rustic:blocks/fluids/honey_still"),
                new ResourceLocation("rustic:blocks/fluids/honey_flow")) {
            @Override
            public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
                player.getFoodStats().addStats(3, 0.4F);
                if (player.getRNG().nextFloat() < 0.6F) {
                    player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 75));
                }
            }
        }.setDensity(1433).setViscosity(5500);
        registerRustic(HONEY);

        BLOCK_OLIVE_OIL = new BlockFluidRustic("olive_oil", OLIVE_OIL, Material.WATER);
        BLOCK_OLIVE_OIL.setQuantaPerBlock(4);

        BLOCK_IRONBERRY_JUICE = new BlockFluidRustic("ironberry_juice", IRONBERRY_JUICE, Material.WATER);
        BLOCK_IRONBERRY_JUICE.setQuantaPerBlock(6);

        BLOCK_WILDBERRY_JUICE = new BlockFluidRustic("wildberry_juice", WILDBERRY_JUICE, Material.WATER);
        BLOCK_WILDBERRY_JUICE.setQuantaPerBlock(6);

        BLOCK_GRAPE_JUICE = new BlockFluidRustic("grape_juice", GRAPE_JUICE, Material.WATER);
        BLOCK_GRAPE_JUICE.setQuantaPerBlock(6);

        BLOCK_APPLE_JUICE = new BlockFluidRustic("apple_juice", APPLE_JUICE, Material.WATER);
        BLOCK_APPLE_JUICE.setQuantaPerBlock(6);

        BLOCK_HONEY = new BlockFluidRustic("honey", HONEY, Material.WATER) {
            public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
                entity.motionX *= 0.5F;
                entity.motionY *= 0.5F;
                entity.motionZ *= 0.5F;
            }
        };
        BLOCK_HONEY.setQuantaPerBlock(2);

        ci.cancel();
    }

    @Inject(method = "initModels*", at = @At("HEAD"), remap = false, cancellable = true)
    private static void initModels(CallbackInfo ci) {
        BLOCK_OLIVE_OIL.initModel();
        BLOCK_IRONBERRY_JUICE.initModel();
        BLOCK_WILDBERRY_JUICE.initModel();
        BLOCK_GRAPE_JUICE.initModel();
        BLOCK_APPLE_JUICE.initModel();
        BLOCK_HONEY.initModel();
        ci.cancel();
    }

    @Unique
    private static void registerRustic(Fluid fluid) {
        if (!FluidRegistry.registerFluid(fluid)) {
            fluid = FluidRegistry.getFluid(fluid.getName());
        }
        FluidRegistry.addBucketForFluid(fluid);
        FLUIDS.add(fluid);
    }
/*
    @Inject(method = "register*", at = @At("HEAD"), remap = false, cancellable = true)
    private static void register(Fluid fluid, boolean addBucket, CallbackInfo ci) {
        ci.cancel();
    }
*/
}
