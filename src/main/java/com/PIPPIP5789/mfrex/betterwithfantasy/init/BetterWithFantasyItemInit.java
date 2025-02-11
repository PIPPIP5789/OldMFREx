package com.PIPPIP5789.mfrex.betterwithfantasy.init;

import minefantasy.mfr.init.MineFantasyItems;
import minefantasy.mfr.item.ItemFoodMFR;
import minefantasy.mfr.item.ItemMultiFood;
import minefantasy.mfr.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.items.ModItems;

public class BetterWithFantasyItemInit {

    public static Item fishDinner = Utils.nullValue();

    public static void initOreDict() throws ClassNotFoundException {
        }

    public static void initItems() {
        fishDinner = new ItemFoodMFR("fish_dinner", 5, 4,false);
    }

    public static void register(RegistryEvent.Register<Item> event) {
        System.out.println("BetterWithFantasy registering items");

        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(fishDinner);
    }

}
