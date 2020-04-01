package xyz.moheng.taoist_nature.item;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import xyz.moheng.taoist_nature.ContainerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class QuankunDag extends Item {

    public QuankunDag(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ContainerProviderRegistry.INSTANCE.openContainer(ContainerRegistry.QIANKUNDAG, user, (buffer) -> {
                buffer.writeText(new TranslatableText(this.getTranslationKey()));
            });
        }
        return TypedActionResult.success(user.getMainHandStack());

    }
}