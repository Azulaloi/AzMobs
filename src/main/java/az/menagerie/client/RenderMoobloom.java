package az.menagerie.client;

import az.menagerie.Menagerie;
import az.menagerie.client.layers.LayerMoobloomBloom;
import az.menagerie.entity.EntityMoobloom;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderMoobloom extends RenderLiving<EntityMoobloom> {

    private static final ResourceLocation texture = new ResourceLocation(Menagerie.MODID, "textures/entity/moobloom.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderMoobloom(RenderManager man) {
        super(man, new ModelCow(), 0.7F);
        this.addLayer(new LayerMoobloomBloom(this));
    }

    public ModelCow getMainModel()
    {
        return (ModelCow)super.getMainModel();
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(EntityMoobloom entityMoobloom) {
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityMoobloom> {
        @Override
        public Render<? super EntityMoobloom> createRenderFor(RenderManager man) {
            return new RenderMoobloom(man);
        }
    }
}
