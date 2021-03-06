package xyz.moheng.taoist_nature.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class LingshiPowder extends Item
{

    public LingshiPowder(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.taoist_nature.lingshi_powder.tooltip-1"));
        tooltip.add(new TranslatableText("item.taoist_nature.lingshi_powder.tooltip-2"));
    }
    
}