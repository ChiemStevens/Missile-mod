package com.chiem.missilemod.init;

import com.chiem.missilemod.MissileMod;
import com.chiem.missilemod.entity.MissileEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MissileMod.MODID);

    public static final String MISSILE_NAME = "missile";
    public static final RegistryObject<EntityType<MissileEntity>> MISSILE = ENTITY_TYPES.register(MISSILE_NAME, () ->
            EntityType.Builder.<MissileEntity>create(MissileEntity::new, EntityClassification.CREATURE)
                    .size(MissileEntity.WIDTH, MissileEntity.LENGTH)
                    .build(new ResourceLocation(MissileMod.MODID, MISSILE_NAME).toString())
    );

}