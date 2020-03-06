package com.chiem.missilemod.entity.helpers;

public class MissilePoint {

    private double x;
    private double y;
    private double z;

    public MissilePoint(double x, double y, double z)
    {
        this.x = x;
        this.z = z;
        this.y = y;
    }

    public static MissilePoint normalize(MissilePoint a, double distance)
    {
        MissilePoint normalized = new MissilePoint(0, 0, 0);
        normalized.setX(a.getX() / distance);
        normalized.setY(a.getY() / distance);
        normalized.setZ(a.getZ() / distance);
        return normalized;
    }

    public static double calculateFlatDistance(MissilePoint start, MissilePoint end)
    {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2) + Math.pow(end.getZ() - start.getZ(), 2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
