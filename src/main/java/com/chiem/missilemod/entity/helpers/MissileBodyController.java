package com.chiem.missilemod.entity.helpers;

import com.chiem.missilemod.entity.MissileEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.controller.BodyController;

public class MissileBodyController extends BodyController {

    private MissileEntity parentEntity;

    public MissileBodyController(MobEntity mob) {
        super(mob);
        this.parentEntity = (MissileEntity)mob;
    }

    @Override
    public void updateRenderAngles() {
        this.parentEntity.renderYawOffset = 0;
        this.parentEntity.prevRotationYawHead = this.parentEntity.rotationYawHead;
    }
}

