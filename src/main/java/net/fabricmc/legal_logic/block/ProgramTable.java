package net.fabricmc.legal_logic.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class ProgramTable extends Table implements BlockEntityProvider {

    protected ProgramTable(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return null;
    }
    
}