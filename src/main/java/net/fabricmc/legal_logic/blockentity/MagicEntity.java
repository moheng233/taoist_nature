package net.fabricmc.legal_logic.blockentity;

import net.fabricmc.legal_logic.BlockEntityReagistry;
import net.fabricmc.legal_logic.Magic.Magic;
import net.minecraft.block.entity.BlockEntity;

public class MagicEntity extends BlockEntity {

    public Magic magic;

    public MagicEntity() {
        super(BlockEntityReagistry.MEGICENTITY);
    }
    
}