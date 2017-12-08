package az.menagerie.client;

import az.menagerie.Menagerie;
import az.menagerie.entity.EntityGelum;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGelum extends RenderLiving<EntityGelum> {

    private static final ResourceLocation texture = new ResourceLocation(Menagerie.MODID, "textures/entity/gelum.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderGelum(RenderManager man) {
        super(man, new ModelOcelot(), 0.4F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGelum entity) {
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityGelum> {
        @Override
        public Render<? super EntityGelum> createRenderFor(RenderManager man) {
            return new RenderGelum(man);
        }
    }
}
