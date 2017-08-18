package az.azmobs.client;

import az.azmobs.AzMobs;
import az.azmobs.entity.EntityFireBat;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

/**
 * Created by Azulaloi on 8/18/2017
 */
public class RenderFireBat extends RenderLiving<EntityFireBat> {

    private final ResourceLocation texture = new ResourceLocation(AzMobs.MODID, "textures/entity/firebat.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderFireBat(RenderManager man) {
        super(man, new ModelBat(), 0.25F);
    }

    protected void preRenderCallback(EntityFireBat entity, float partialTickTime){
        GlStateManager.scale(0.35F, 0.35F, 0.35F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityFireBat entity){
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityFireBat> {
        @Override
        public Render<? super EntityFireBat> createRenderFor(RenderManager man){
            return new RenderFireBat(man);
        }
    }
}
