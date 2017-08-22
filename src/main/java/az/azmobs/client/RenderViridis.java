package az.azmobs.client;

import az.azmobs.AzMobs;
import az.azmobs.entity.EntityViridis;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderViridis extends RenderSpider {

    private final ResourceLocation texture = new ResourceLocation(AzMobs.MODID, "textures/entity/viridis.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderViridis(RenderManager man) {
        super(man);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(EntitySpider entitySpider){
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityViridis> {
        @Override
        public Render<? super EntityViridis> createRenderFor(RenderManager man){
            return new RenderViridis(man);
        }
    }
}
