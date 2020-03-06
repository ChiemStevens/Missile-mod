package com.chiem.missilemod.client;

import com.chiem.missilemod.MissileMod;
import com.chiem.missilemod.client.render.entity.MissileRenderer;
import com.chiem.missilemod.client.render.entity.model.MissileModel;
import com.chiem.missilemod.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MissileMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber {

    private static final Logger LOGGER = LogManager.getLogger(MissileMod.MODID + " Client Mod Event Subscriber");

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {

        // Register Entity Renderers
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MISSILE.get(), m -> new MissileRenderer<>(m, new MissileModel<>(), 0.5F));
        LOGGER.debug("Registered Entity Renderers");

    }

}