package com.chiem.missilemod.entity.helpers;

import com.chiem.missilemod.entity.MissileEntity;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.Vec3d;

public class MissileMovementController extends MovementController {

    private final MissileEntity parentEntity;

    public MissileMovementController(MissileEntity missileEntity) {
        super(missileEntity);
        this.parentEntity = missileEntity;
    }

    public void tick() {
        if (this.action == MovementController.Action.MOVE_TO) {
            Vec3d vec3d = new Vec3d(this.posX - this.parentEntity.getPosX(), this.posY - this.parentEntity.getPosY(), this.posZ - this.parentEntity.getPosZ());
            vec3d = vec3d.normalize();
            this.parentEntity.setMotion(this.parentEntity.getMotion().add(vec3d.scale(0.1D)));
        }
    }
}

