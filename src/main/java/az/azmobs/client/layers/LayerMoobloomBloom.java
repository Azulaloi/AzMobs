package az.azmobs.client.layers;

import az.azmobs.client.RenderMoobloom;
import az.azmobs.entity.EntityMoobloom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraft.init.Blocks.DOUBLE_PLANT;

@SideOnly(Side.CLIENT)
public class LayerMoobloomBloom implements LayerRenderer<EntityMoobloom> {

    private final RenderMoobloom moobloomRenderer;

    public LayerMoobloomBloom(RenderMoobloom moobloomRendererIn) {
        this.moobloomRenderer = moobloomRendererIn;
    }

    public void doRenderLayer(EntityMoobloom entitylivingbaseIn, float limbSwing, float limSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!entitylivingbaseIn.isChild() && !entitylivingbaseIn.isInvisible())
        {
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            this.moobloomRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            GlStateManager.enableCull();
            GlStateManager.cullFace(GlStateManager.CullFace.FRONT);
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0F, -1.0F, 1.0F);
            GlStateManager.translate(0.2F, 0.35F, 0.5F);
            GlStateManager.rotate(42.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5F, -0.5F, 0.5F);
            blockrendererdispatcher.renderBlockBrightness(DOUBLE_PLANT.getStateFromMeta(5), 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.1F, 0.0F, -0.6F);
            GlStateManager.rotate(42.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(-0.5F, -0.5F, 0.5F);
            blockrendererdispatcher.renderBlockBrightness(DOUBLE_PLANT.getStateFromMeta(5), 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            this.moobloomRenderer.getMainModel().head.postRender(0.0625F);
            GlStateManager.scale(1.0F, -1.0F, 1.0F);
            GlStateManager.translate(0.0F, 0.7F, -0.2F);
            GlStateManager.rotate(12.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(-0.5F, -0.5F, 0.5F);
            blockrendererdispatcher.renderBlockBrightness(DOUBLE_PLANT.getStateFromMeta(5), 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.cullFace(GlStateManager.CullFace.BACK);
            GlStateManager.disableCull();
        }
    }

    public boolean shouldCombineTextures() {
        return true;
    }
}
