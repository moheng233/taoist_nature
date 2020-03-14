package net.fabricmc.legal_logic.block;

import net.fabricmc.legal_logic.blockentity.ProgramTableEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class ProgramTable extends Table implements BlockEntityProvider {

    public ProgramTable(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new ProgramTableEntity();
    }
    
}