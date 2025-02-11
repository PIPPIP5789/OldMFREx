package com.PIPPIP5789.mfrex.mixin;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rustic.common.Config;
import rustic.common.blocks.BlockPlanksRustic;
import rustic.common.blocks.ModBlocks;
import rustic.common.blocks.fluids.ModFluids;
import rustic.common.crafting.*;
import rustic.common.items.ModItems;
import rustic.compat.dynamictrees.DynamicTreesCompat;
import rustic.core.Rustic;

import java.util.ArrayList;
import java.util.List;

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
@Mixin(Recipes.class)
public class MixinRusticRecipes {

    @Shadow public static List<IBrewingBarrelRecipe> brewingRecipes;

    @Inject(method = "addBrewingRecipes", at = @At("HEAD"), remap = false, cancellable = true)
    private static void addBrewingRecipes(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "addCraftingRecipes", at = @At("HEAD"), remap = false, cancellable = true)
    private static void addCraftingRecipes(CallbackInfo ci) {
        if (Config.ENABLE_PILLARS) {
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "pillar_stone"), null, new ItemStack(ModBlocks.STONE_PILLAR, 6), "SS ", "SS ", "SS ", 'S',
                    new ItemStack(Blocks.STONE, 1, 0));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "pillar_andesite"), null, new ItemStack(ModBlocks.ANDESITE_PILLAR, 6), "SS ", "SS ", "SS ", 'S',
                    new ItemStack(Blocks.STONE, 1, 5));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "pillar_diorite"), null, new ItemStack(ModBlocks.DIORITE_PILLAR, 6), "SS ", "SS ", "SS ", 'S',
                    new ItemStack(Blocks.STONE, 1, 3));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "pillar_granite"), null, new ItemStack(ModBlocks.GRANITE_PILLAR, 6), "SS ", "SS ", "SS ", 'S',
                    new ItemStack(Blocks.STONE, 1, 1));
            if (Config.ENABLE_SLATE) {
                GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "pillar_slate"), null, new ItemStack(ModBlocks.SLATE_PILLAR, 6), "SS", "SS", "SS", 'S',
                        new ItemStack(ModBlocks.SLATE));
            }
        }
        if (Config.ENABLE_SLATE) {
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_roof"), null, new ItemStack(ModBlocks.SLATE_ROOF, 4), "SS", "SS", 'S',
                    new ItemStack(ModBlocks.SLATE));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_roof_stairs"), null, new ItemStack(ModBlocks.SLATE_ROOF_STAIRS, 4), "S  ", "SS ", "SSS", 'S',
                    new ItemStack(ModBlocks.SLATE_ROOF));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_roof_slab"), null, new ItemStack(ModBlocks.SLATE_ROOF_SLAB_ITEM, 6), "SSS", 'S',
                    new ItemStack(ModBlocks.SLATE_ROOF));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_brick_stairs"), null, new ItemStack(ModBlocks.SLATE_BRICK_STAIRS, 4), "S  ", "SS ", "SSS", 'S',
                    new ItemStack(ModBlocks.SLATE_BRICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_brick_slab"), null, new ItemStack(ModBlocks.SLATE_BRICK_SLAB_ITEM, 6), "SSS", 'S',
                    new ItemStack(ModBlocks.SLATE_BRICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_tile"), null, new ItemStack(ModBlocks.SLATE_TILE), "S", 'S',
                    new ItemStack(ModBlocks.SLATE));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_tile_1"), null, new ItemStack(ModBlocks.SLATE_TILE), "S", 'S',
                    new ItemStack(ModBlocks.SLATE_BRICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_brick"), null, new ItemStack(ModBlocks.SLATE_BRICK, 4), "SS", "SS", 'S',
                    new ItemStack(ModBlocks.SLATE_TILE));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "slate_chiseled"), null, new ItemStack(ModBlocks.SLATE_CHISELED, 4), "SS", "SS", 'S',
                    new ItemStack(ModBlocks.SLATE_BRICK));
        }
        if (Config.ENABLE_CHAIRS) {
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "acacia_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_ACACIA, 4), "P  ", "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 4), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "big_oak_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_BIG_OAK, 4), "P  ", "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 5), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "birch_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_BIRCH, 4), "P  ", "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 2), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "jungle_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_JUNGLE, 4), "P  ", "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 3), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "oak_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_OAK, 4), "P  ", "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 0), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "spruce_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_SPRUCE, 4), "P  ", "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 1), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "olive_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_OLIVE, 4), "p  ", "ppp", "s s", 'p',
                    new ItemStack(ModBlocks.PLANKS, 1, BlockPlanksRustic.EnumType.OLIVE.getMetadata()), 's',
                    new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "ironwood_chair"), new ResourceLocation(Rustic.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_IRONWOOD, 4), "p  ", "ppp", "s s", 'p',
                    new ItemStack(ModBlocks.PLANKS, 1, BlockPlanksRustic.EnumType.IRONWOOD.getMetadata()), 's',
                    new ItemStack(Items.STICK));
        }
        if (Config.ENABLE_TABLES) {
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "acacia_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_ACACIA, 2), "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 4), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "big_oak_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_BIG_OAK, 2), "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 5), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "birch_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_BIRCH, 2), "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 2), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "jungle_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_JUNGLE, 2), "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 3), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "oak_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_OAK, 2), "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 0), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "spruce_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_SPRUCE, 2), "PPP", "S S", 'P',
                    new ItemStack(Blocks.PLANKS, 1, 1), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "olive_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_OLIVE, 2), "ppp", "s s", 'p',
                    new ItemStack(ModBlocks.PLANKS, 1, BlockPlanksRustic.EnumType.OLIVE.getMetadata()), 's',
                    new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "ironwood_table"), new ResourceLocation(Rustic.MODID, "table"), new ItemStack(ModBlocks.TABLE_IRONWOOD, 2), "ppp", "s s", 'p',
                    new ItemStack(ModBlocks.PLANKS, 1, BlockPlanksRustic.EnumType.IRONWOOD.getMetadata()), 's',
                    new ItemStack(Items.STICK));
        }
        if (Config.ENABLE_LATTICE) {
            GameRegistry.addShapedRecipe(new ResourceLocation(Rustic.MODID, "iron_lattice"), null, new ItemStack(ModBlocks.IRON_LATTICE, 16), " I ", "III", " I ", 'I',
                    new ItemStack(Items.IRON_INGOT));
        }
        if (Config.ENABLE_PAINTED_WOOD) {
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_WHITE, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeWhite").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_white")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_ORANGE, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeOrange").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_orange")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_MAGENTA, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeMagenta").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_magenta")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_LIGHT_BLUE, 8), "PPP",
                    "PDP", "PPP", 'P', "plankWood", 'D', "dyeLightBlue").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_light_blue")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_YELLOW, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeYellow").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_yellow")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_LIME, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeLime").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_lime")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_PINK, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyePink").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_pink")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_GRAY, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeGray").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_gray")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_SILVER, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeLightGray").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_silver")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_CYAN, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeCyan").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_cyan")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_PURPLE, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyePurple").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_purple")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_BLUE, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeBlue").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_blue")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_BROWN, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeBrown").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_brown")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_GREEN, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeGreen").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_green")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_RED, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeRed").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_red")));
            GameRegistry.findRegistry(IRecipe.class).register(new ShapedOreRecipe(null, new ItemStack(ModBlocks.PAINTED_WOOD_BLACK, 8), "PPP", "PDP",
                    "PPP", 'P', "plankWood", 'D', "dyeBlack").setRegistryName(new ResourceLocation(Rustic.MODID, "painted_wood_black")));
        }

        RecipeSorter.register("rustic:cabinet_recipe", RecipeCabinet.class,
                RecipeSorter.Category.SHAPED, "after:minecraft:shapeless");
        GameRegistry.findRegistry(IRecipe.class).register(new RecipeCabinet().setRegistryName(new ResourceLocation(Rustic.MODID, "cabinet")));

        if (Config.ENABLE_BOTTLE_EMPTYING) {
            GameRegistry.findRegistry(IRecipe.class).register(new RecipeNonIngredientReturn(null, new ItemStack(Items.GLASS_BOTTLE),
                    new ItemStack(ModItems.FLUID_BOTTLE)).setRegistryName(new ResourceLocation(Rustic.MODID, "bottle_emptying")));
        }
        GameRegistry.findRegistry(IRecipe.class).register(new RecipeNonIngredientReturn(null, new ItemStack(ModBlocks.LIQUID_BARREL),
                new ItemStack(ModBlocks.LIQUID_BARREL)).setRegistryName(new ResourceLocation(Rustic.MODID, "barrel_emptying")));

        if (Config.ENABLE_OLIVE_OILING) {
            RecipeSorter.register("rustic:olive_oil", RecipeOliveOil.class, RecipeSorter.Category.SHAPELESS,
                    "after:minecraft:shapeless");
            GameRegistry.findRegistry(IRecipe.class).register(new RecipeOliveOil().setRegistryName(new ResourceLocation(Rustic.MODID, "olive_oiling")));
        }

        if (Loader.isModLoaded("dynamictrees")) {
            GameRegistry.addShapelessRecipe(new ResourceLocation(Rustic.MODID, "oliveseed"), null, new ItemStack(DynamicTreesCompat.getOliveSeed()), Ingredient.fromItem(ModItems.OLIVES));
            GameRegistry.addShapelessRecipe(new ResourceLocation(Rustic.MODID, "ironwoodseed"), null, new ItemStack(DynamicTreesCompat.getIronwoodSeed()), Ingredient.fromItem(ModItems.IRONBERRIES));

            DynamicTreesCompat.addRecipes();
        }

        ci.cancel();
    }

}
