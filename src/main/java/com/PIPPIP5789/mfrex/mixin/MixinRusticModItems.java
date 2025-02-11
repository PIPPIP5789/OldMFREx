package com.PIPPIP5789.mfrex.mixin;

import minefantasy.mfr.init.MineFantasyItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rustic.common.Config;
import rustic.common.blocks.ModBlocks;
import rustic.common.entities.EntityTomato;
import rustic.common.items.*;
import rustic.common.potions.PotionsRustic;
import rustic.core.Rustic;

import java.util.Random;

import static rustic.common.items.ModItems.*;

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
@Mixin(ModItems.class)
public class MixinRusticModItems {

    @Inject(method = "init",  at = @At("HEAD"), remap = false, cancellable = true)
    private static void init(CallbackInfo ci) {
        BEE = new ItemBase("bee");
        BEE.setCreativeTab(Rustic.farmingTab);
        HONEYCOMB = new ItemBase("honeycomb");
        HONEYCOMB.setCreativeTab(Rustic.farmingTab);
        BEESWAX = new ItemBase("beeswax");
        TALLOW = new ItemBase("tallow");
        OLIVES = new ItemFoodBase("olives", 1, 0.4F, false) {
            public void initFood() {
                this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 1, false, false), 0.95F);
            }

            public int getMaxItemUseDuration(ItemStack stack) {
                return 24;
            }
        };
        IRONBERRIES = new ItemFoodBase("ironberries", 2, 0.4F, false) {
            public void initFood() {
                this.setAlwaysEdible();
            }

            public int getMaxItemUseDuration(ItemStack stack) {
                return 16;
            }

            protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
                if (!worldIn.isRemote) {
                    player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 15, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 200, 15, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 15, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 200, 15, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 200, 15, false, false));
                    player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 250, false, false));
                }

            }
        };
        FLUID_BOTTLE = new ItemFluidBottle();
        IRON_DUST_TINY = new ItemBase("dust_tiny_iron");
        IRON_DUST_TINY.setCreativeTab(Rustic.farmingTab);
        ELIXIR = new ItemElixir();
        TOMATO = new ItemFoodBase("tomato", 4, 0.4F, false) {
            public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
                ItemStack itemstack = playerIn.getHeldItem(handIn);
                if (playerIn.isSneaking()) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }

                    worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                    if (!worldIn.isRemote) {
                        EntityTomato entitytomato = new EntityTomato(worldIn, playerIn);
                        entitytomato.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
                        worldIn.spawnEntity(entitytomato);
                    }

                    playerIn.addStat(StatList.getObjectUseStats(this));
                    return new ActionResult(EnumActionResult.SUCCESS, itemstack);
                } else {
                    return super.onItemRightClick(worldIn, playerIn, handIn);
                }
            }
        };
        TOMATO_SEEDS = new ItemStakeCropSeed("tomato_seeds", ModBlocks.TOMATO_CROP);
        if (Config.ENABLE_SEED_DROPS) {
            MinecraftForge.addGrassSeed(new ItemStack(TOMATO_SEEDS), Config.SEED_DROP_RATE);
        }

        CHILI_PEPPER = new ItemFoodBase("chili_pepper", 3, 0.4F, false) {
            protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
                player.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 400));
            }
        };
        CHILI_PEPPER_SEEDS = new ItemStakeCropSeed("chili_pepper_seeds", ModBlocks.CHILI_CROP);
        if (Config.ENABLE_SEED_DROPS) {
            MinecraftForge.addGrassSeed(new ItemStack(CHILI_PEPPER_SEEDS), Config.SEED_DROP_RATE);
        }

        WILDBERRIES = new ItemFoodBase("wildberries", 2, 0.5F, false) {
            public int getMaxItemUseDuration(ItemStack stack) {
                return 16;
            }
        };
        GRAPES = new ItemFoodBase("grapes", 3, 0.3F, false) {
            public int getMaxItemUseDuration(ItemStack stack) {
                return 16;
            }
        };
        ci.cancel();
    }

    @Inject(method = "initModels",  at = @At("HEAD"), remap = false, cancellable = true)
    private static void initModels(CallbackInfo ci) {
        BEE.initModel();
        HONEYCOMB.initModel();
        BEESWAX.initModel();
        TALLOW.initModel();
        OLIVES.initModel();
        IRONBERRIES.initModel();
        FLUID_BOTTLE.initModel();
        IRON_DUST_TINY.initModel();
        ELIXIR.initModel();
        TOMATO.initModel();
        TOMATO_SEEDS.initModel();
        CHILI_PEPPER.initModel();
        CHILI_PEPPER_SEEDS.initModel();
        WILDBERRIES.initModel();
        GRAPES.initModel();

        ci.cancel();
    };

}