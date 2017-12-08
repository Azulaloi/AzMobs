package az.menagerie.client;

import az.menagerie.Menagerie;
import az.menagerie.entity.EntityFrog;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderFrog extends RenderLiving<EntityFrog> {

    private final ResourceLocation texture = new ResourceLocation(Menagerie.MODID, "textures/entity/frog.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderFrog(RenderManager man) {
        super(man, new ModelFrog(), 0.25F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityFrog entity) {
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityFrog> {
        @Override
        public Render<? super EntityFrog> createRenderFor(RenderManager man){
            return new RenderFrog(man);
        }
    }
}

