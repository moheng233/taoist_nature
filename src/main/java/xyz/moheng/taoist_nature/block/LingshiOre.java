package xyz.moheng.taoist_nature.block;

import java.util.ArrayList;
import java.util.List;

import xyz.moheng.taoist_nature.ItemReagistry;
import xyz.moheng.taoist_nature.util.SRandom;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class LingshiOre extends OreBlock {

    public LingshiOre(Settings settings) {
        super(settings);
    }

    @Override
    public List<ItemStack> getDroppedStacks(net.minecraft.block.BlockState state, net.minecraft.loot.context.LootContext.Builder builder) {
        List<ItemStack> Dropped = new ArrayList<ItemStack>();
        // Dropped.add(
        // new ItemStack(LegalLogicMod.LINGSHIMINEITEM,1)
        // );

        Dropped.add(new ItemStack(ItemReagistry.LINGSHIPOWDER, SRandom.GetRInt(0, 6))
        );
        
        CompoundTag tag = new CompoundTag();
        tag.putInt("quality",SRandom.GetRInt(0, 5));
        tag.putInt("Damage", SRandom.GetRInt(0, 20));
        ItemStack LINGSHI = new ItemStack(ItemReagistry.LINGSHI);
        LINGSHI.setTag(tag);

        Dropped.add(LINGSHI);

        return Dropped;
    }

    @Override
    public float getHardness(BlockState state, BlockView world, BlockPos pos) {
        return 1.5f;
    }
}