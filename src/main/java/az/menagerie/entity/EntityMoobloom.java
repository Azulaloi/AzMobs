package az.menagerie.entity;

import az.menagerie.Menagerie;
import az.menagerie.item.ModItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public class EntityMoobloom extends EntityCow implements net.minecraftforge.common.IShearable {

    public EntityMoobloom(World world) {
        super(world);
        this.setSize(0.9F, 1.4F);
        this.spawnableBlock = Blocks.GRASS;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BOWL && this.getGrowingAge() >= 0 && !player.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);

            if (itemstack.isEmpty())
            {
                player.setHeldItem(hand, new ItemStack(ModItems.bloomMilk));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.bloomMilk)))
            {
                player.dropItem(new ItemStack(ModItems.bloomMilk), false);
            }

            return true;
        }
        else if (false && itemstack.getItem() == Items.SHEARS && this.getGrowingAge() >= 0) //Forge Disable, Moved to onSheared
        {
            this.setDead();
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);

            if (!this.world.isRemote)
            {
                EntityCow entitycow = new EntityCow(this.world);
                entitycow.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
                entitycow.setHealth(this.getHealth());
                entitycow.renderYawOffset = this.renderYawOffset;

                if (this.hasCustomName())
                {
                    entitycow.setCustomNameTag(this.getCustomNameTag());
                }

                this.world.spawnEntity(entitycow);

                for (int i = 0; i < 5; ++i)
                {
                    this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double)this.height, this.posZ, new ItemStack(Blocks.RED_MUSHROOM)));
                }

                itemstack.damageItem(1, player);
                this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }
    }

    public EntityMoobloom createChild(EntityAgeable ageable)
    {
        return new EntityMoobloom(this.world);
    }


    @Override
    public boolean isShearable(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos) {
        return getGrowingAge() >= 0;
    }

    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        this.setDead();
        ((net.minecraft.world.WorldServer)this.world).spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, false, this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 1, 0.0D, 0.0D, 0.0D, 0.0D);

        EntityCow entitycow = new EntityCow(this.world);
        entitycow.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        entitycow.setHealth(this.getHealth());
        entitycow.renderYawOffset = this.renderYawOffset;

        if (this.hasCustomName())
        {
            entitycow.setCustomNameTag(this.getCustomNameTag());
        }

        this.world.spawnEntity(entitycow);

        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        for (int i = 0; i < 5; ++i)
        {
            ret.add(new ItemStack(Blocks.DOUBLE_PLANT));
        }

        this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
        return ret;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation (Menagerie.MODID + ":mobs/moobloom");
    }
}
