package net.fabricmc.legal_logic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.legal_logic.blockentity.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityReagistry implements ModInitializer {

    public static BlockEntityType<PortrayTableEntity> PORTRAYTABLEENTITY;
    
    public static final String MODID = LegalLogicMod.MODID;//在""中填写Modid
    @Override
	public void onInitialize() {
        PORTRAYTABLEENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID,"portray_table"), 
            BlockEntityType.Builder.create(PortrayTableEntity::new,BlockReagistry.PORTRAYTABLE).build(null)
        );
    }
}