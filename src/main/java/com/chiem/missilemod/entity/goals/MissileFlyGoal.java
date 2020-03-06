package com.chiem.missilemod.entity.goals;

import com.chiem.missilemod.entity.MissileEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class MissileFlyGoal extends Goal {

    private final MissileEntity parentEntity;

    public MissileFlyGoal(MissileEntity missileEntity) {
        this.parentEntity = missileEntity;
        this.setMutexFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean shouldExecute() {
        return parentEntity.isLaunched();
    }

    @Override
    public boolean shouldContinueExecuting() {
        return true;
    }

    @Override
    public void startExecuting() {

    }

    @Override
    public void tick() {
        if (parentEntity.isLaunched() && !this.parentEntity.isExploded()) {

            this.parentEntity.getMoveHelper().setMoveTo(
                    this.parentEntity.getFlightPath().get(this.parentEntity.getCurrentFlightPoint()).getX(),
                    this.parentEntity.getFlightPath().get(this.parentEntity.getCurrentFlightPoint()).getY(),
                    this.parentEntity.getFlightPath().get(this.parentEntity.getCurrentFlightPoint()).getZ(),
                    this.parentEntity.getSpeed()
            );

            int deltaX = (int) this.parentEntity.getFlightPath().get(this.parentEntity.getCurrentFlightPoint()).getX() - (int) Math.floor(this.parentEntity.getPosX());
            int deltaY = (int) this.parentEntity.getFlightPath().get(this.parentEntity.getCurrentFlightPoint()).getY() - (int) Math.floor(this.parentEntity.getPosY());
            int deltaZ = (int) this.parentEntity.getFlightPath().get(this.parentEntity.getCurrentFlightPoint()).getZ() - (int) Math.floor(this.parentEntity.getPosZ());

            if (inRange(1, deltaY) && inRange(1, deltaX) && inRange(1, deltaZ)) {
                if (this.parentEntity.isLastFlightPoint()) {
                    this.parentEntity.explode();
                } else {
                    this.parentEntity.incrementFlightPath();
                    this.parentEntity.recalculateLook();

                    this.parentEntity.rotationYaw = (float) (Math.atan2(this.parentEntity.getDirection().getZ(), this.parentEntity.getDirection().getX()) * 180 / Math.PI);
                    this.parentEntity.rotationPitch = (float) (Math.atan2(Math.sqrt(this.parentEntity.getDirection().getZ() * this.parentEntity.getDirection().getZ() +
                                    this.parentEntity.getDirection().getX() * this.parentEntity.getDirection().getX()),
                            this.parentEntity.getDirection().getY()) * 180 / Math.PI);
                }
            }
        }
    }

    private boolean inRange(int range, int value)
    {
        return value <= range && value >= -range;
    }
}
