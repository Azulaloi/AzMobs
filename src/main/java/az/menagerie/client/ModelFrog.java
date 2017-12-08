package az.menagerie.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelFrog extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer hind_right_foot;
    public ModelRenderer hind_right_leg;
    public ModelRenderer body;
    public ModelRenderer front_left_leg;
    public ModelRenderer hind_left_foot;
    public ModelRenderer hind_left_leg;
    public ModelRenderer front_right_leg;

    public ModelFrog() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.head = new ModelRenderer(this, 26, 3);
        this.head.setRotationPoint(0.0F, 18.0F, -1.0F);
        this.head.addBox(-2.0F, 0.0F, -1.5F, 4, 3, 4);
        this.hind_right_foot = new ModelRenderer(this, 14, 18);
        this.hind_right_foot.setRotationPoint(2.7F, 23.0F, 7.6F);
        this.hind_right_foot.addBox(0.0F, 0.0F, -4.5F, 2, 1, 5);
        this.hind_right_leg = new ModelRenderer(this, 26, 10);
        this.hind_right_leg.setRotationPoint(3.0F, 19.3F, 3.7F);
        this.hind_right_leg.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 5);
        this.setAngles(this.hind_right_leg, -0.15707963267948966F, 0.1911135497644277F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 19.0F, 8.0F);
        this.body.addBox(-3.0F, 0.0F, -8.0F, 6, 3, 7);
        this.setAngles(this.body, -0.10471975511965977F, 0.0F, 0.0F);
        this.front_left_leg = new ModelRenderer(this, 0, 10);
        this.front_left_leg.setRotationPoint(-2.5F, 19.0F, 0.0F);
        this.front_left_leg.addBox(-1.0F, 0.0F, 0.0F, 1, 5, 2);
        this.setAngles(this.front_left_leg, -0.19198621771937624F, 0.0F, 0.0F);
        this.hind_left_foot = new ModelRenderer(this, 0, 18);
        this.hind_left_foot.setRotationPoint(-4.7F, 23.0F, 7.6F);
        this.hind_left_foot.addBox(0.0F, 0.0F, -4.5F, 2, 1, 5);
        this.hind_left_leg = new ModelRenderer(this, 12, 10);
        this.hind_left_leg.setRotationPoint(-3.0F, 19.3F, 3.7F);
        this.hind_left_leg.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 5);
        this.setAngles(this.hind_left_leg, -0.15707963267948966F, -0.1911135497644277F, 0.0F);
        this.front_right_leg = new ModelRenderer(this, 6, 10);
        this.front_right_leg.setRotationPoint(3.5F, 19.0F, 0.0F);
        this.front_right_leg.addBox(-1.0F, 0.0F, 0.0F, 1, 5, 2);
        this.setAngles(this.front_right_leg, -0.19198621771937624F, 0.0F, 0.0F);
    }


    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
        this.head.render(scale);
        this.hind_right_foot.render(scale);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.hind_right_leg.offsetX, this.hind_right_leg.offsetY, this.hind_right_leg.offsetZ);
        GlStateManager.translate(this.hind_right_leg.rotationPointX * scale, this.hind_right_leg.rotationPointY * scale, this.hind_right_leg.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.hind_right_leg.offsetX, -this.hind_right_leg.offsetY, -this.hind_right_leg.offsetZ);
        GlStateManager.translate(-this.hind_right_leg.rotationPointX * scale, -this.hind_right_leg.rotationPointY * scale, -this.hind_right_leg.rotationPointZ * scale);
        this.hind_right_leg.render(scale);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translate(this.body.rotationPointX * scale, this.body.rotationPointY * scale, this.body.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translate(-this.body.rotationPointX * scale, -this.body.rotationPointY * scale, -this.body.rotationPointZ * scale);
        this.body.render(scale);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.front_left_leg.offsetX, this.front_left_leg.offsetY, this.front_left_leg.offsetZ);
        GlStateManager.translate(this.front_left_leg.rotationPointX * scale, this.front_left_leg.rotationPointY * scale, this.front_left_leg.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.front_left_leg.offsetX, -this.front_left_leg.offsetY, -this.front_left_leg.offsetZ);
        GlStateManager.translate(-this.front_left_leg.rotationPointX * scale, -this.front_left_leg.rotationPointY * scale, -this.front_left_leg.rotationPointZ * scale);
        this.front_left_leg.render(scale);
        GlStateManager.popMatrix();
        this.hind_left_foot.render(scale);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.hind_left_leg.offsetX, this.hind_left_leg.offsetY, this.hind_left_leg.offsetZ);
        GlStateManager.translate(this.hind_left_leg.rotationPointX * scale, this.hind_left_leg.rotationPointY * scale, this.hind_left_leg.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.hind_left_leg.offsetX, -this.hind_left_leg.offsetY, -this.hind_left_leg.offsetZ);
        GlStateManager.translate(-this.hind_left_leg.rotationPointX * scale, -this.hind_left_leg.rotationPointY * scale, -this.hind_left_leg.rotationPointZ * scale);
        this.hind_left_leg.render(scale);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.front_right_leg.offsetX, this.front_right_leg.offsetY, this.front_right_leg.offsetZ);
        GlStateManager.translate(this.front_right_leg.rotationPointX * scale, this.front_right_leg.rotationPointY * scale, this.front_right_leg.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.front_right_leg.offsetX, -this.front_right_leg.offsetY, -this.front_right_leg.offsetZ);
        GlStateManager.translate(-this.front_right_leg.rotationPointX * scale, -this.front_right_leg.rotationPointY * scale, -this.front_right_leg.rotationPointZ * scale);
        this.front_right_leg.render(scale);
        GlStateManager.popMatrix();
    }

    public void setAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
