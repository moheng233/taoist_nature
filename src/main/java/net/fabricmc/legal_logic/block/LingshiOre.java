package net.fabricmc.legal_logic.block;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.legal_logic.LegalLogicMod;
import net.fabricmc.legal_logic.util.SRandom;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class LingshiOre extends OreBlock {

    public LingshiOre(Settings settings) {
        super(settings);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<ItemStack> getDroppedStacks(net.minecraft.block.BlockState state,
            net.minecraft.world.loot.context.LootContext.Builder builder) {
        List<ItemStack> Dropped = new ArrayList<ItemStack>();
        // Dropped.add(
        // new ItemStack(LegalLogicMod.LINGSHIMINEITEM,1)
        // );

        Dropped.add(new ItemStack(LegalLogicMod.LINGSHIPOWDER, new SRandom().GetRInt(0, 6))
        );
        
        CompoundTag tag = new CompoundTag();
        tag.putInt("quality", new SRandom().GetRInt(0, 5));
        tag.putInt("integrity", new SRandom().GetRInt(80, 100));
        ItemStack LINGSHI = new ItemStack(LegalLogicMod.LINGSHI);
        LINGSHI.setTag(tag);
        System.out.println(LINGSHI.getTag());

        Dropped.add(LINGSHI);

        return Dropped;
    }

    @Override
    public float getHardness(BlockState state, BlockView world, BlockPos pos) {
        return 1.5f;
    }
}