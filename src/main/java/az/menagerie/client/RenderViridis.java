package az.menagerie.client;

import az.menagerie.Menagerie;
import az.menagerie.client.layers.LayerViridisEyes;
import az.menagerie.entity.EntityViridis;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderViridis<T extends EntityViridis> extends RenderLiving<T> {

    private final ResourceLocation texture = new ResourceLocation(Menagerie.MODID, "textures/entity/viridis.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderViridis(RenderManager man) {
        super(man, new ModelSpider(), 1.0F);
        this.addLayer(new LayerViridisEyes(this));
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(T entity) {
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityViridis> {
        @Override
        public Render<? super EntityViridis> createRenderFor(RenderManager man) {
            return new RenderViridis(man);
        }
    }
}
