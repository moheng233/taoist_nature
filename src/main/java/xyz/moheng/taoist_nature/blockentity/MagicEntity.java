package xyz.moheng.taoist_nature.blockentity;

import xyz.moheng.taoist_nature.BlockEntityReagistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class MagicEntity extends BlockEntity implements Tickable {


    public MagicEntity() {
        super(BlockEntityReagistry.MEGICENTITY);
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub

    }
    
}