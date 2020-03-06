package com.chiem.missilemod.client.render.entity;

import com.chiem.missilemod.MissileMod;
import com.chiem.missilemod.client.render.entity.model.MissileModel;
import com.chiem.missilemod.entity.MissileEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;

public class MissileRenderer <T extends MissileEntity, M extends MissileModel<T>> extends LivingRenderer<T, M> {

    private static final ResourceLocation MISSILE_TEXTURE = new ResourceLocation(MissileMod.MODID, "textures/entity/missile/missile.png");

    public MissileRenderer(final EntityRendererManager manager, M model, float shadowSize) {
        super(manager, model, shadowSize);
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return MISSILE_TEXTURE;
    }

}

