package az.menagerie.client;

import az.menagerie.Menagerie;
import az.menagerie.entity.EntityDuck;
import az.menagerie.entity.EntityGilded;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving<EntityDuck> {

    private static final ResourceLocation texture = new ResourceLocation(Menagerie.MODID, "textures/entity/duck.png");

    public static final RenderFactory RENDER_FACTORY = new RenderFactory();

    public RenderDuck(RenderManager man) {
        super(man, new ModelChicken(), 0.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDuck entity) {
        return texture;
    }

    public static class RenderFactory implements IRenderFactory<EntityDuck> {
        @Override
        public Render<? super EntityDuck> createRenderFor(RenderManager man) {
            return new RenderDuck(man);
        }
    }

    protected float handleRotationFloat(EntityDuck livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
