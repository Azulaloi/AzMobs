package az.menagerie.render.tile;

import az.menagerie.Menagerie;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileGildedSkullRenderer extends TileEntitySkullRenderer {

    private static final ResourceLocation SKELETON_TEXTURES = new ResourceLocation(Menagerie.MODID, "textures/entity/gilded.png");
    private final ModelSkeletonHead skeletonHead = new ModelSkeletonHead(0, 0, 64, 32);

    public TileGildedSkullRenderer() {
        super();
    }

    @Override
    public void render(TileEntitySkull te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

        //Checks if it is a TE before trying to get TE properties,
        //prevents null pointers when rendered as an item
        renderSkull((float) x, (float) y, (float) z,
                    te == null ? EnumFacing.NORTH : EnumFacing.getFront(te.getBlockMetadata() & 7),
                    te == null ? 0 : te.getSkullRotation() * 360 / 16.0F, 3, null, destroyStage, partialTicks);
    }

    @Override
    public void setRendererDispatcher(@Nonnull TileEntityRendererDispatcher rendererDispatcherIn) {
        rendererDispatcher = rendererDispatcherIn;
        //That was weird. Has something to do with forge instancing?
    }

    @Override
    public void renderSkull(float x, float y, float z, @Nonnull EnumFacing facing, float rotationIn, int skullType, @Nullable GameProfile profile, int destroyStage, float animateTicks) {

        ModelBase modelbase = this.skeletonHead;

        if (destroyStage >= 0) {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 2.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        } else {
            this.bindTexture(SKELETON_TEXTURES);
        }

        GlStateManager.pushMatrix();
        GlStateManager.disableCull();

        if (facing == EnumFacing.UP) {
            GlStateManager.translate(x + 0.5F, y, z + 0.5F);
        } else {
            switch (facing) {
                case NORTH:
                    GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.74F);
                    break;
                case SOUTH:
                    GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.26F);
                    rotationIn = 180.0F;
                    break;
                case WEST:
                    GlStateManager.translate(x + 0.74F, y + 0.25F, z + 0.5F);
                    rotationIn = 270.0F;
                    break;
                case EAST:
                default:
                    GlStateManager.translate(x + 0.26F, y + 0.25F, z + 0.5F);
                    rotationIn = 90.0F;
            }
        }

        float f = 0.0625F;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        GlStateManager.enableAlpha();

        modelbase.render((Entity)null, animateTicks, 0.0F, 0.0F, rotationIn, 0.0F, 0.0625F);
        GlStateManager.popMatrix();

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}
