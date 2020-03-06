package com.chiem.missilemod.entity.helpers;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.controller.LookController;

public class MissileLookController extends LookController {

    public MissileLookController(MobEntity mob) {
        super(mob);
        this.isLooking = true;
    }

    @Override
    public void tick() {
        if (this.func_220680_b()) {
            this.mob.rotationPitch = 0.0F;
        }
    }

    @Override
    protected boolean func_220680_b() {
        return false;
    }
}
