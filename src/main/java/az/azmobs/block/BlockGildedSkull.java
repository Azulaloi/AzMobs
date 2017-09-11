package az.azmobs.block;

import az.azmobs.AzMobs;
import az.azmobs.block.tile.TileGildedSkull;
import az.azmobs.item.ModItems;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockGildedSkull extends BlockSkull {
    public BlockGildedSkull() {
        setRegistryName(AzMobs.MODID, "gilded_skull");
        setUnlocalizedName("gilded_skull");
        setHardness(1.0F);
    }

    @Nonnull
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileGildedSkull();
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
        if(!state.getValue(NODROP)) {
            ItemStack itemStack = new ItemStack(ModItems.gildedSkull, 1);
            TileEntitySkull te = (TileEntitySkull) worldIn.getTileEntity(pos);

            if(te != null){
                drops.add(itemStack);
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.gildedSkull;
    }

    @Nonnull
    @Override
    public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult result, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
        return new ItemStack(ModItems.gildedSkull);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    public void regSpecialModelMapper() {
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(FACING, NODROP).build());
    }
}
