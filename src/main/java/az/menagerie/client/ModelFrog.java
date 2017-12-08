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
    public ModelRenderer field_178704_h;
    public ModelRenderer field_178698_a;
    public ModelRenderer field_178697_c;
    public ModelRenderer field_178695_e;
    public ModelRenderer field_178693_g;
    public ModelRenderer field_178696_b;
    public ModelRenderer field_178694_d;
    public ModelRenderer field_178692_f;

    public ModelFrog() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.field_178704_h = new ModelRenderer(this, 26, 3);
        this.field_178704_h.setRotationPoint(0.0F, 18.0F, -1.0F);
        this.field_178704_h.addBox(-2.0F, 0.0F, -1.5F, 4, 3, 4);
        this.field_178698_a = new ModelRenderer(this, 14, 18);
        this.field_178698_a.setRotationPoint(3.0F, 17.5F, 3.7F);
        this.field_178698_a.addBox(-1.0F, 5.5F, -0.7F, 2, 1, 5);
        this.field_178697_c = new ModelRenderer(this, 26, 10);
        this.field_178697_c.setRotationPoint(3.0F, 19.3F, 3.7F);
        this.field_178697_c.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 5);
        this.setRotationAngles(this.field_178697_c, -0.15707963267948966F, 0.0F, 0.0F);
        this.field_178695_e = new ModelRenderer(this, 0, 0);
        this.field_178695_e.setRotationPoint(0.0F, 19.0F, 8.0F);
        this.field_178695_e.addBox(-3.0F, 0.0F, -8.0F, 6, 3, 7);
        this.setRotationAngles(this.field_178695_e, -0.10471975511965977F, 0.0F, 0.0F);
        this.field_178693_g = new ModelRenderer(this, 0, 10);
        this.field_178693_g.setRotationPoint(-2.5F, 19.0F, 0.0F);
        this.field_178693_g.addBox(-1.0F, 0.0F, -1.0F, 1, 5, 2);
        this.setRotationAngles(this.field_178693_g, -0.19198621771937624F, 0.0F, 0.0F);
        this.field_178696_b = new ModelRenderer(this, 0, 18);
        this.field_178696_b.setRotationPoint(-3.0F, 17.5F, 3.7F);
        this.field_178696_b.addBox(-1.0F, 5.5F, -0.7F, 2, 1, 5);
        this.field_178694_d = new ModelRenderer(this, 12, 10);
        this.field_178694_d.setRotationPoint(-3.0F, 19.3F, 3.7F);
        this.field_178694_d.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 5);
        this.setRotationAngles(this.field_178694_d, -0.15707963267948966F, 0.0F, 0.0F);
        this.field_178692_f = new ModelRenderer(this, 6, 10);
        this.field_178692_f.setRotationPoint(3.5F, 19.0F, 0.0F);
        this.field_178692_f.addBox(-1.0F, 0.0F, -1.0F, 1, 5, 2);
        this.setRotationAngles(this.field_178692_f, -0.19198621771937624F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
//        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale, entityIn);
        float red = 1.0F;
        float green = 1.0F;
        float blue = 1.0F;
        float alpha = 1.0F;

        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178704_h.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178698_a.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.field_178697_c.offsetX, this.field_178697_c.offsetY, this.field_178697_c.offsetZ);
        GlStateManager.translate(this.field_178697_c.rotationPointX * scale, this.field_178697_c.rotationPointY * scale, this.field_178697_c.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.field_178697_c.offsetX, -this.field_178697_c.offsetY, -this.field_178697_c.offsetZ);
        GlStateManager.translate(-this.field_178697_c.rotationPointX * scale, -this.field_178697_c.rotationPointY * scale, -this.field_178697_c.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178697_c.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.field_178695_e.offsetX, this.field_178695_e.offsetY, this.field_178695_e.offsetZ);
        GlStateManager.translate(this.field_178695_e.rotationPointX * scale, this.field_178695_e.rotationPointY * scale, this.field_178695_e.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.field_178695_e.offsetX, -this.field_178695_e.offsetY, -this.field_178695_e.offsetZ);
        GlStateManager.translate(-this.field_178695_e.rotationPointX * scale, -this.field_178695_e.rotationPointY * scale, -this.field_178695_e.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178695_e.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.field_178693_g.offsetX, this.field_178693_g.offsetY, this.field_178693_g.offsetZ);
        GlStateManager.translate(this.field_178693_g.rotationPointX * scale, this.field_178693_g.rotationPointY * scale, this.field_178693_g.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.field_178693_g.offsetX, -this.field_178693_g.offsetY, -this.field_178693_g.offsetZ);
        GlStateManager.translate(-this.field_178693_g.rotationPointX * scale, -this.field_178693_g.rotationPointY * scale, -this.field_178693_g.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178693_g.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178696_b.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.field_178694_d.offsetX, this.field_178694_d.offsetY, this.field_178694_d.offsetZ);
        GlStateManager.translate(this.field_178694_d.rotationPointX * scale, this.field_178694_d.rotationPointY * scale, this.field_178694_d.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.field_178694_d.offsetX, -this.field_178694_d.offsetY, -this.field_178694_d.offsetZ);
        GlStateManager.translate(-this.field_178694_d.rotationPointX * scale, -this.field_178694_d.rotationPointY * scale, -this.field_178694_d.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178694_d.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.field_178692_f.offsetX, this.field_178692_f.offsetY, this.field_178692_f.offsetZ);
        GlStateManager.translate(this.field_178692_f.rotationPointX * scale, this.field_178692_f.rotationPointY * scale, this.field_178692_f.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.field_178692_f.offsetX, -this.field_178692_f.offsetY, -this.field_178692_f.offsetZ);
        GlStateManager.translate(-this.field_178692_f.rotationPointX * scale, -this.field_178692_f.rotationPointY * scale, -this.field_178692_f.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(red, green, blue, alpha);
        this.field_178692_f.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
