package az.menagerie.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelMoobloom extends ModelBase {
    public ModelRenderer torso;
    public ModelRenderer udders;
    public ModelRenderer leg_br;
    public ModelRenderer leg_fr;
    public ModelRenderer leg_bl;
    public ModelRenderer leg_fl;
    public ModelRenderer head;
    public ModelRenderer horn_left;
    public ModelRenderer horn_right;
    public ModelRenderer bloom_head;
    public ModelRenderer bloom_head2;

    public ModelMoobloom(int height, float scale) {
        this.textureWidth = 96;
        this.textureHeight = 48;

        this.torso = new ModelRenderer(this, 18, 4);
        this.torso.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.torso.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10);
        this.setAngles(this.torso, 1.5707963267948966F, 0.0F, 0.0F);
        this.udders = new ModelRenderer(this, 52, 0);
        this.udders.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.udders.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1);
        this.setAngles(this.udders, 1.5707963267948966F, 0.0F, 0.0F);
        this.leg_br = new ModelRenderer(this, 0, 16);
        this.leg_br.setRotationPoint(4.0F, 12.0F, 7.0F);
        this.leg_br.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leg_fr = new ModelRenderer(this, 0, 16);
        this.leg_fr.setRotationPoint(4.0F, 12.0F, -6.0F);
        this.leg_fr.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leg_bl = new ModelRenderer(this, 0, 16);
        this.leg_bl.setRotationPoint(-4.0F, 12.0F, 7.0F);
        this.leg_bl.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leg_fl = new ModelRenderer(this, 0, 16);
        this.leg_fl.setRotationPoint(-4.0F, 12.0F, -6.0F);
        this.leg_fl.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6);
        this.horn_left = new ModelRenderer(this, 22, 0);
        this.horn_left.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.horn_left.addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1);
        this.horn_right = new ModelRenderer(this, 22, 0);
        this.horn_right.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.horn_right.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1);
        this.bloom_head = new ModelRenderer(this, 78, 18);
        this.bloom_head.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.bloom_head.addBox(-4.0F, -12.0F, 0.0F, 8, 13, 1);
        this.setAngles(this.bloom_head, 0.0F, -0.7853981633974483F, 0.0F);
        this.bloom_head2 = new ModelRenderer(this, 78, 18);
        this.bloom_head2.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.bloom_head2.addBox(-4.0F, -12.0F, 0.0F, 8, 13, 1);
        this.setAngles(this.bloom_head2, 0.0F, 0.7853981633974483F, 0.0F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.torso.offsetX, this.torso.offsetY, this.torso.offsetZ);
        GlStateManager.translate(this.torso.rotationPointX * scale, this.torso.rotationPointY * scale, this.torso.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.torso.offsetX, -this.torso.offsetY, -this.torso.offsetZ);
        GlStateManager.translate(-this.torso.rotationPointX * scale, -this.torso.rotationPointY * scale, -this.torso.rotationPointZ * scale);
        this.torso.render(scale);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.udders.offsetX, this.udders.offsetY, this.udders.offsetZ);
        GlStateManager.translate(this.udders.rotationPointX * scale, this.udders.rotationPointY * scale, this.udders.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.udders.offsetX, -this.udders.offsetY, -this.udders.offsetZ);
        GlStateManager.translate(-this.udders.rotationPointX * scale, -this.udders.rotationPointY * scale, -this.udders.rotationPointZ * scale);
        this.udders.render(scale);
        GlStateManager.popMatrix();
        this.leg_br.render(scale);
        this.leg_fr.render(scale);
        this.leg_bl.render(scale);
        this.leg_fl.render(scale);
        this.head.render(scale);
        this.horn_left.render(scale);
        this.horn_right.render(scale);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.bloom_head.offsetX, this.bloom_head.offsetY, this.bloom_head.offsetZ);
        GlStateManager.translate(this.bloom_head.rotationPointX * scale, this.bloom_head.rotationPointY * scale, this.bloom_head.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.bloom_head.offsetX, -this.bloom_head.offsetY, -this.bloom_head.offsetZ);
        GlStateManager.translate(-this.bloom_head.rotationPointX * scale, -this.bloom_head.rotationPointY * scale, -this.bloom_head.rotationPointZ * scale);
        this.bloom_head.render(scale);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.bloom_head2.offsetX, this.bloom_head2.offsetY, this.bloom_head2.offsetZ);
        GlStateManager.translate(this.bloom_head2.rotationPointX * scale, this.bloom_head2.rotationPointY * scale, this.bloom_head2.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.bloom_head2.offsetX, -this.bloom_head2.offsetY, -this.bloom_head2.offsetZ);
        GlStateManager.translate(-this.bloom_head2.rotationPointX * scale, -this.bloom_head2.rotationPointY * scale, -this.bloom_head2.rotationPointZ * scale);
        this.bloom_head2.render(scale);
        GlStateManager.popMatrix();
    }

    public void setAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.torso.rotateAngleX = ((float)Math.PI / 2F);
        this.leg_br.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg_bl.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_fr.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_fl.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
