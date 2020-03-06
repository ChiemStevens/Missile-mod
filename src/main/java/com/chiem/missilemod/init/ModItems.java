package com.chiem.missilemod.init;

import com.chiem.missilemod.MissileMod;
import com.chiem.missilemod.item.ModdedSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MissileMod.MODID);

    // This is a very simple Item. It has no special properties except for being on our creative tab.
    public static final RegistryObject<Item> MISSILE_ITEM = ITEMS.register("missile", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ModdedSpawnEggItem> MISSILE_SPAWN_EGG = ITEMS.register("missile_spawn_egg", () -> new ModdedSpawnEggItem(ModEntityTypes.MISSILE, 0xF0A5A2, 0xA9672B, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
}
