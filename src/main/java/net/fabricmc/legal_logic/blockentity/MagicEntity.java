package net.fabricmc.legal_logic.blockentity;

import net.fabricmc.legal_logic.BlockEntityReagistry;
import net.fabricmc.legal_logic.Magic.Magic;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class MagicEntity extends BlockEntity implements Tickable {

    public Magic magic;

    public MagicEntity() {
        super(BlockEntityReagistry.MEGICENTITY);
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub

    }
    
}