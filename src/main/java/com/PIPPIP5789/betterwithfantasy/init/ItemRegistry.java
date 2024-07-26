package com.PIPPIP5789.betterwithfantasy.init;

import com.PIPPIP5789.betterwithfantasy.BetterWithFantasy;
import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.item.ItemFoodMFR;
import minefantasy.mfr.item.ItemMultiFood;
import minefantasy.mfr.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(BetterWithFantasy.MODID)
@Mod.EventBusSubscriber(modid = BetterWithFantasy.MODID)
public class ItemRegistry {

    public static Item veggieSandwitch = Utils.nullValue();
    public static Item salad = Utils.nullValue();
    public static Item appleJam = Utils.nullValue();
    public static Item berryJam = Utils.nullValue();
    public static Item grapeJam = Utils.nullValue();
    public static Item appleJamRoll = Utils.nullValue();
    public static Item berryJamRoll = Utils.nullValue();
    public static Item grapeJamRoll = Utils.nullValue();
    //public static Item driedBerries = Utils.nullValue();
    public static Item carrotSlices = Utils.nullValue();
    public static Item potatoSlices = Utils.nullValue();
    public static Item pottage = Utils.nullValue();

    public static void initMFRItems() {
        appleJam = new ItemFoodMFR("jam_apple", 4, 2, false).setReturnItem(MineFantasyItems.CLAY_POT).setMaxStackSize(8);
        berryJam = new ItemFoodMFR("jam_berry", 2, 1, false).setReturnItem(MineFantasyItems.CLAY_POT).setMaxStackSize(8);;

        appleJamRoll = new ItemFoodMFR("jam_apple_roll", 6, 2, false).setFoodStats(2, 0.5F, 0.4F, 0.6F).setMaxStackSize(4);
        berryJamRoll = new ItemFoodMFR("jam_berry_roll", 4, 2, false).setFoodStats(2, 0.5F, 0.2F, 0.3F).setMaxStackSize(4);;

        //driedBerries = new ItemFoodMFR("berries_dried", 1, 1, false).setFoodStats(1, 0.1F, 0.1F, 0.1F);

        carrotSlices = new ItemFoodMFR("slices_carrot", 2, 2, false);
        potatoSlices = new ItemFoodMFR("slices_potato", 1, 1, false);

        pottage = new ItemFoodMFR("pottage",10, 12, false, 0).setFoodStats(2, 0.0F, 2.0F, 1.5F).setReturnItem(Items.BOWL).setMaxStackSize(1);

    }

    public static void initRusticItems() {
        grapeJam = new ItemFoodMFR("jam_grape", 3, 2, false).setReturnItem(MineFantasyItems.CLAY_POT).setMaxStackSize(8);;
        grapeJamRoll = new ItemFoodMFR("jam_grape_roll", 5, 2, false).setFoodStats(2, 0.5F, 0.3F, 0.4F).setMaxStackSize(4);;

        veggieSandwitch = new ItemMultiFood("sandwitch_veggie", 2, 5, 5, false, 1).setFoodStats(1, 0.1F, 1.0F, 0.3F).setMaxStackSize(1);
        salad = new ItemFoodMFR("salad", 6, 4, false).setFoodStats(1, 0.1F, 0.2F, 0.0F).setReturnItem(Items.BOWL).setMaxStackSize(1);
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event) {
        System.out.println("FantasyFoods registering items");

        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(appleJam);
        registry.register(berryJam);
        registry.register(appleJamRoll);
        registry.register(berryJamRoll);

        //registry.register(driedBerries);

        registry.register(carrotSlices);
        registry.register(potatoSlices);

        registry.register(pottage);
    }
}
