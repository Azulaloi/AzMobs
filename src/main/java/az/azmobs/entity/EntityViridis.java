package az.azmobs.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityViridis extends EntitySpider {
    public EntityViridis(World worldIn) {
        super(worldIn);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity){
        boolean sb = super.attackEntityAsMob(entity);
        if (sb && entity instanceof EntityLivingBase){
            float diff = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            float amp = diff > 2.0F ? 1 : 0;
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 140 * (int)diff, (int)amp));
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 140 * (int)diff, (int)amp));
        }
        return sb;
    }
}
