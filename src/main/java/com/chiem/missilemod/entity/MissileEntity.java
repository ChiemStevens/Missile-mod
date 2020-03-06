package com.chiem.missilemod.entity;

import com.chiem.missilemod.entity.goals.MissileFlyGoal;
import com.chiem.missilemod.entity.helpers.MissileBodyController;
import com.chiem.missilemod.entity.helpers.MissileLookController;
import com.chiem.missilemod.entity.helpers.MissileMovementController;
import com.chiem.missilemod.entity.helpers.MissilePoint;
import com.chiem.missilemod.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.ArrayList;

public class MissileEntity extends FlyingEntity {

    public static final float LENGTH = 3.5F;
    public static final float WIDTH = 0.6F;

    private final int MAX_HEIGHT = 300;

    private boolean launched;
    private int ticks;
    private ArrayList<MissilePoint> flightPath;
    private MissilePoint start;
    private MissilePoint end;
    private MissilePoint direction;
    private boolean lastFlightPoint;
    private int currentFlightPoint;
    private int speed;
    private boolean exploded;
    private int protectionTime;
    private int lockHeight;


    public MissileEntity(final EntityType<? extends MissileEntity> entityType, final World world) {
        super(entityType, world);
        this.moveController = new MissileMovementController(this);
        this.lookController = new MissileLookController(this);
        this.createBodyController();
        hasNoGravity();
        initMissileValues();


        this.rotationYaw = 0;
        this.rotationPitch = 0;
        this.setRotationYawHead(0);
    }

    public MissileEntity(final World world) {
        super(ModEntityTypes.MISSILE.get(), world);
    }

    private void initMissileValues() {
        launched = false;
        lastFlightPoint = false;
        ticks = 0;
        currentFlightPoint = 0;
        speed = 1;
        exploded = false;
        protectionTime = 20;
        lockHeight = 100;
    }

    @Override
    protected BodyController createBodyController() {
        return new MissileBodyController(this);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new MissileFlyGoal(this));
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }

    @Override
    public boolean canBeHitWithPotion() {
        return false;
    }

    @Override
    public boolean canRenderOnFire() {
        return false;
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    @Override
    public void onCollideWithPlayer(PlayerEntity entityIn) {
    }

    @Override
    protected void setOnFireFromLava() {
    }

    @Override
    public void setFire(int seconds) {
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
    }

    @Override
    protected void damageEntity(DamageSource damageSrc, float damageAmount) {
    }

    @Override
    protected void dealFireDamage(int amount) {
    }

    @Override
    protected void onInsideBlock(BlockState p_191955_1_) {

        if(this.launched) {
            if(protectionTime <= 0)
                this.explode();
        }
    }

    @Override
    protected void doBlockCollisions() {

        if(!this.world.isRemote) {
            for(int y = (int)this.getPosY() - 1; y <= (((int)this.getPosY() + (int)LENGTH) + 1); y++) {
                for(int x = (int)this.getPosX() -1; x <= ((int)this.getPosX() + 1); x++) {
                    for(int z = (int)this.getPosZ() -1; z <= ((int)this.getPosZ() + 1); z++) {
                        BlockState blockToCheck = world.getBlockState(new BlockPos(x, y, z));

                        if(blockToCheck.getBlock() == Blocks.AIR || blockToCheck.getBlock() == Blocks.VOID_AIR) {
                            continue;
                        }

                        onInsideBlock(blockToCheck);
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(!this.world.isRemote) {
            if(ticks >= 1000) {
                if(!launched) {
                    //TODO: Remove later
                    launch(new MissilePoint(0,0,0));
                }
                else {
                    if(protectionTime > 0)
                        protectionTime--;
                }
            }
        }

        ticks++;
    }

    public void launch(MissilePoint end) {
        start = new MissilePoint(this.getPosX(), this.getPosY(), this.getPosZ());
        this.end = end;
        flightPath = calculateFlightPath(start, end);
        recalculateLook();
        launched = true;
    }

    public void explode() {
        this.exploded = true;
        this.remove();
        doExplosion();
    }

    protected void doExplosion() {
        this.world.createExplosion(this, DamageSource.DRAGON_BREATH, this.getPosX(), this.getPosY(), this.getPosZ(), 4.0F, false, Explosion.Mode.DESTROY);
    }

    public void recalculateLook()
    {
        double distance = MissilePoint.calculateFlatDistance(new MissilePoint(this.getPosX(), this.getPosY(), this.getPosZ()), flightPath.get(currentFlightPoint));
        MissilePoint subtract = new MissilePoint((flightPath.get(currentFlightPoint).getX() - this.getPosX()),
                (flightPath.get(currentFlightPoint).getY() - this.getPosY()),
                (flightPath.get(currentFlightPoint).getZ() - this.getPosZ()));
        direction = MissilePoint.normalize(subtract, distance);
    }

    private ArrayList<MissilePoint> calculateFlightPath(MissilePoint point1, MissilePoint point2) {
        ArrayList<MissilePoint> flightPath = new ArrayList<>();

        if(lockHeight > 0) {
            point1.setY(lockHeight);
        }

        double bezierX, bezierY, bezierZ;

        bezierY = Math.max(MAX_HEIGHT, MissilePoint.calculateFlatDistance(point1, point2) * 2);
        bezierX = (point2.getX() + point1.getX()) / 2;
        bezierZ = (point2.getZ() + point1.getZ()) / 2;

        for (double t = 0.0; t <= 1.001; t += 0.1) {

            int x = (int) ((1 - t) * (1 - t) * point1.getX() + 2 * (1 - t) * t * bezierX + t * t * point2.getX());
            int y = (int) ((1 - t) * (1 - t) * point1.getY() + 2 * (1 - t) * t * bezierY + t * t * point2.getY());
            int z = (int) ((1 - t) * (1 - t) * point1.getZ() + 2 * (1 - t) * t * bezierZ + t * t * point2.getZ());

            if (y > MAX_HEIGHT) {
                y = MAX_HEIGHT;
            }

            flightPath.add(new MissilePoint(x, y, z));
        }

        flightPath.set(flightPath.size() - 1, point2);

        return flightPath;
    }

    public void incrementFlightPath() {
        currentFlightPoint++;
        if (currentFlightPoint >= flightPath.size() - 1) {
            lastFlightPoint = true;
        }
    }



    public boolean isLaunched() {
        return this.launched;
    }

    public ArrayList<MissilePoint> getFlightPath() {
        return flightPath;
    }

    public MissilePoint getDirection() {
        return direction;
    }

    public boolean isLastFlightPoint() {
        return lastFlightPoint;
    }

    public int getCurrentFlightPoint() {
        return currentFlightPoint;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isExploded() {
        return exploded;
    }

    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

}
