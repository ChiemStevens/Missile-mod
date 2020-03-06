package com.chiem.missilemod;

import com.chiem.missilemod.init.ModBlocks;
import com.chiem.missilemod.init.ModEntityTypes;
import com.chiem.missilemod.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MissileMod.MODID)
public final class MissileMod {

    public static final String MODID = "missilemod";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public MissileMod() {
        LOGGER.debug("Hello from Explosion Mod!");

        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register Deferred Registers (Does not need to be before Configs)
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        // Register Configs (Does not need to be after Deferred Registers)
        //modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
        //modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
    }
}
