package com.chiem.missilemod.client.render.entity.model;

import com.chiem.missilemod.entity.MissileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MissileModel <T extends MissileEntity> extends EntityModel<T> {
    private ModelRenderer topWingPlate4;
    private ModelRenderer bone8;
    private ModelRenderer topWingPlate3;
    private ModelRenderer bone7;
    private ModelRenderer topWingPlate2;
    private ModelRenderer bone6;
    private ModelRenderer topWingPlate1;
    private ModelRenderer bone5;
    private ModelRenderer warHead;
    private ModelRenderer topWing4;
    private ModelRenderer topWing3;
    private ModelRenderer topWing2;
    private ModelRenderer topWing1;
    private ModelRenderer wingplate3;
    private ModelRenderer bone;
    private ModelRenderer wing1;
    private ModelRenderer enginge;
    private ModelRenderer wing2;
    private ModelRenderer wingplate1;
    private ModelRenderer bone3;
    private ModelRenderer wingplate2;
    private ModelRenderer bone2;
    private ModelRenderer wing3;
    private ModelRenderer wing4;
    private ModelRenderer wingplate4;
    private ModelRenderer bone4;
    private ModelRenderer shaft;

    private ModelRenderer everything;

    private float yaw;
    private float pitch;

    public MissileModel() {
        textureWidth = 128;
        textureHeight = 128;

        yaw = 0;
        pitch = 0;
        everything = new ModelRenderer(this);

        topWingPlate4 = new ModelRenderer(this);
        topWingPlate4.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWingPlate4, 0.0F, -0.7854F, 0.0F);
        everything.addChild(topWingPlate4);

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(-5.0F, -43.0F, -4.0F);
        setRotationAngle(bone8, 0.0F, 0.0F, 0.5236F);
        topWingPlate4.addChild(bone8);
        bone8.setTextureOffset( 0,  68);
        bone8.addBox(-2.0F, -6.0F, 3.0F, 3, 7, 2, 0.0F, false);

        topWingPlate3 = new ModelRenderer(this);
        topWingPlate3.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWingPlate3, 0.0F, 0.7854F, 0.0F);
        everything.addChild(topWingPlate3);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, -43.0F, 5.0F);
        setRotationAngle(bone7, 0.5236F, 0.0F, 0.0F);
        topWingPlate3.addChild(bone7);
        bone7.setTextureOffset( 34,  65);
        bone7.addBox(-1.0F, -6.0F, -1.0F, 2, 7, 3, 0.0F, false);

        topWingPlate2 = new ModelRenderer(this);
        topWingPlate2.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWingPlate2, 0.0F, 0.7854F, 0.0F);
        everything.addChild(topWingPlate2);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, -43.0F, 4.0F);
        setRotationAngle(bone6, 0.0F, 0.0F, 0.5236F);
        topWingPlate2.addChild(bone6);
        bone6.setTextureOffset( 10,  68);
        bone6.addBox(-6.0F, -3.0F, -5.0F, 3, 7, 2, 0.0F, false);

        topWingPlate1 = new ModelRenderer(this);
        topWingPlate1.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWingPlate1, 0.0F, -0.7854F, 0.0F);
        everything.addChild(topWingPlate1);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, -43.0F, -5.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        topWingPlate1.addChild(bone5);
        bone5.setTextureOffset( 66,  10);
        bone5.addBox(-1.0F, -6.0F, -2.0F, 2, 7, 3, 0.0F, false);

        warHead = new ModelRenderer(this);
        warHead.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(warHead, 0.0F, -0.7854F, 0.0F);
        warHead.setTextureOffset( 24,  28);
        warHead.addBox(-5.0F, -53.0F, -5.0F, 10, 5, 10, 0.0F, false);
        warHead.setTextureOffset( 42,  0);
        warHead.addBox(-4.0F, -55.0F, -4.0F, 8, 2, 8, 0.0F, false);
        warHead.setTextureOffset( 24,  43);
        warHead.addBox(-3.0F, -57.0F, -3.0F, 6, 2, 6, 0.0F, false);
        warHead.setTextureOffset( 18,  28);
        warHead.addBox(-2.0F, -59.0F, -2.0F, 4, 2, 4, 0.0F, false);
        everything.addChild(warHead);

        topWing4 = new ModelRenderer(this);
        topWing4.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWing4, 0.0F, 0.7854F, 0.0F);
        topWing4.setTextureOffset( 44,  62);
        topWing4.addBox(4.0F, -43.0F, -1.0F, 3, 9, 2, 0.0F, false);
        everything.addChild(topWing4);

        topWing3 = new ModelRenderer(this);
        topWing3.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWing3, 0.0F, -0.7854F, 0.0F);
        topWing3.setTextureOffset( 64,  20);
        topWing3.addBox(4.0F, -43.0F, -1.0F, 3, 9, 2, 0.0F, false);
        everything.addChild(topWing3);

        topWing2 = new ModelRenderer(this);
        topWing2.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWing2, 0.0F, -0.7854F, 0.0F);
        topWing2.setTextureOffset( 64,  31);
        topWing2.addBox(-7.0F, -43.0F, -1.0F, 3, 9, 2, 0.0F, false);
        everything.addChild(topWing2);

        topWing1 = new ModelRenderer(this);
        topWing1.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(topWing1, 0.0F, 0.7854F, 0.0F);
        topWing1.setTextureOffset( 24,  65);
        topWing1.addBox(-7.0F, -43.0F, -1.0F, 3, 9, 2, 0.0F, false);
        everything.addChild(topWing1);

        wingplate3 = new ModelRenderer(this);
        wingplate3.setRotationPoint(6.0F, 14.0F, -6.0F);
        setRotationAngle(wingplate3, 0.0F, 0.7854F, 0.0F);
        everything.addChild(wingplate3);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone, 0.0F, 0.0F, -0.6109F);
        wingplate3.addChild(bone);
        bone.setTextureOffset( 34,  51);
        bone.addBox(-2.0F, -11.0F, -1.0F, 3, 12, 2, 0.0F, false);

        wing1 = new ModelRenderer(this);
        wing1.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(wing1, 0.0F, 0.7854F, 0.0F);
        wing1.setTextureOffset( 58,  43);
        wing1.addBox(7.0F, -10.0F, -1.0F, 3, 10, 2, 0.0F, false);
        everything.addChild(wing1);

        enginge = new ModelRenderer(this);
        enginge.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(enginge, 0.0F, -0.7854F, 0.0F);
        enginge.setTextureOffset( 0,  0);
        enginge.addBox(-7.0F, -14.0F, -7.0F, 14, 14, 14, 0.0F, false);
        everything.addChild(enginge);

        wing2 = new ModelRenderer(this);
        wing2.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(wing2, 0.0F, -0.7854F, 0.0F);
        wing2.setTextureOffset( 58,  58);
        wing2.addBox(7.0F, -10.0F, -1.0F, 3, 10, 2, 0.0F, false);
        everything.addChild(wing2);

        wingplate1 = new ModelRenderer(this);
        wingplate1.setRotationPoint(6.0F, 14.0F, 6.0F);
        setRotationAngle(wingplate1, 0.0F, -0.7854F, 0.0F);
        everything.addChild(wingplate1);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone3, 0.0F, 0.0F, -0.6109F);
        wingplate1.addChild(bone3);
        bone3.setTextureOffset( 24,  51);
        bone3.addBox(-2.0F, -11.0F, -1.0F, 3, 12, 2, 0.0F, false);

        wingplate2 = new ModelRenderer(this);
        wingplate2.setRotationPoint(-6.0F, 14.0F, -6.0F);
        setRotationAngle(wingplate2, 0.0F, -0.7854F, 0.0F);
        everything.addChild(wingplate2);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone2, 0.0F, 0.0F, 0.6109F);
        wingplate2.addChild(bone2);
        bone2.setTextureOffset( 48,  48);
        bone2.addBox(-1.0F, -11.0F, -1.0F, 3, 12, 2, 0.0F, false);

        wing3 = new ModelRenderer(this);
        wing3.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(wing3, 0.0F, -0.7854F, 0.0F);
        wing3.setTextureOffset( 56,  10);
        wing3.addBox(-10.0F, -10.0F, -1.0F, 3, 10, 2, 0.0F, false);
        everything.addChild(wing3);

        wing4 = new ModelRenderer(this);
        wing4.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(wing4, 0.0F, 0.7854F, 0.0F);
        wing4.setTextureOffset( 54,  26);
        wing4.addBox(-10.0F, -10.0F, -1.0F, 3, 10, 2, 0.0F, false);
        everything.addChild(wing4);

        wingplate4 = new ModelRenderer(this);
        wingplate4.setRotationPoint(-6.0F, 14.0F, 6.0F);
        setRotationAngle(wingplate4, 0.0F, 0.7854F, 0.0F);
        everything.addChild(wingplate4);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, -12.0F);
        setRotationAngle(bone4, 0.0F, 0.0F, 0.6109F);
        wingplate4.addChild(bone4);
        bone4.setTextureOffset( 0,  0);
        bone4.addBox(-1.0F, -11.0F, 11.0F, 3, 12, 2, 0.0F, false);

        shaft = new ModelRenderer(this);
        shaft.setRotationPoint(0.0F, 24.0F, 0.0F);
        shaft.setTextureOffset( 0,  28);
        shaft.addBox(-3.0F, -48.0F, -3.0F, 6, 34, 6, 0.0F, false);
        everything.addChild(shaft);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        matrixStackIn.push();
        matrixStackIn.rotate(new Vector3f(0F, 1F, 0F).rotationDegrees(yaw));
        matrixStackIn.rotate(new Vector3f(0F, 0F, 1F).rotationDegrees(pitch));
        everything.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        matrixStackIn.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        yaw = entityIn.rotationYaw;
        pitch = entityIn.rotationPitch;
    }
}
