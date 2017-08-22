package az.azmobs.client;

import az.azmobs.AzMobs;
import az.azmobs.entity.EntityGilded;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGilded extends RenderSkeleton {

    private static final ResourceLocation texture = new ResourceLocation(AzMobs.MODID, "textures/entity/gilded.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderGilded(RenderManager man) {
        super(man);
    }

    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityGilded> {
        @Override
        public Render<? super EntityGilded> createRenderFor(RenderManager man) {
            return new RenderGilded(man);
        }
    }
}
