package net.fabricmc.legal_logic.item;

import java.util.List;

import net.fabricmc.legal_logic.ItemReagistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class Lingshi extends Item {

    public Lingshi(Settings settings) {
        super(settings.maxCount(1).maxDamage(100));
        // TODO Auto-generated constructor stub
    }

    @Override
    public void appendStacks(net.minecraft.item.ItemGroup group,
            net.minecraft.util.DefaultedList<net.minecraft.item.ItemStack> stacks) {
        if (this.isIn(group)) {
            CompoundTag tag = new CompoundTag();
            tag.putInt("quality", 0);
            tag.putInt("Damage", 0);

            ItemStack itemStack = new ItemStack(ItemReagistry.LINGSHI);
            itemStack.setTag(tag);
            stacks.add(itemStack);

            CompoundTag tag1 = new CompoundTag();
            tag1.putInt("quality", 1);
            tag1.putInt("Damage", 0);
            ItemStack itemStack1 = new ItemStack(ItemReagistry.LINGSHI);
            itemStack1.setTag(tag1);
            stacks.add(itemStack1);

            CompoundTag tag2 = new CompoundTag();
            tag2.putInt("quality", 2);
            tag2.putInt("Damage", 0);
            ItemStack itemStack2 = new ItemStack(ItemReagistry.LINGSHI);
            itemStack2.setTag(tag2);
            stacks.add(itemStack2);

            CompoundTag tag3 = new CompoundTag();
            tag3.putInt("quality", 3);
            tag3.putInt("Damage", 0);
            ItemStack itemStack3 = new ItemStack(ItemReagistry.LINGSHI);
            itemStack3.setTag(tag3);
            stacks.add(itemStack3);

            CompoundTag tag4 = new CompoundTag();
            tag4.putInt("quality", 4);
            tag4.putInt("Damage", 0);
            ItemStack itemStack4 = new ItemStack(ItemReagistry.LINGSHI);
            itemStack4.setTag(tag4);
            stacks.add(itemStack4);
        }

    }

    @Override
    public Text getName(ItemStack itemStack) {
        CompoundTag tag = itemStack.getTag();
        int quality = 0;
        if (tag != null) {
            quality = tag.getInt("quality");
        }

        return new TranslatableText("item.legal_logic.lingshi",
                new TranslatableText("item.legal_logic.lingshi.quality-" + quality));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        CompoundTag tag = itemStack.getTag();
        int quality = 0;
        if (tag != null) {
            quality = tag.getInt("quality");
        }

        tooltip.add(new TranslatableText("item.legal_logic.lingshi.tooltip-1",
                new TranslatableText("item.legal_logic.lingshi.quality-" + quality)));

    }
}