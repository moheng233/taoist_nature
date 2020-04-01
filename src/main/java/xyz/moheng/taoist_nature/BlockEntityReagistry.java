package xyz.moheng.taoist_nature;

import net.fabricmc.api.ModInitializer;
import xyz.moheng.taoist_nature.blockentity.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityReagistry implements ModInitializer {

    public static BlockEntityType<PortrayTableEntity> PORTRAYTABLEENTITY;
    public static BlockEntityType<ProgramTableEntity> PROGRAMTABLEENTITY;
    public static BlockEntityType<MagicEntity> MEGICENTITY;
    
    public static final String MODID = LegalLogicMod.MODID;//在""中填写Modid
    @Override
	public void onInitialize() {
        PORTRAYTABLEENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID,"portray_table"), 
            BlockEntityType.Builder.create(PortrayTableEntity::new,BlockReagistry.PORTRAYTABLE).build(null)
        );

        PROGRAMTABLEENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID,"program_table"), 
            BlockEntityType.Builder.create(ProgramTableEntity::new, BlockReagistry.PROGRAMTABLE).build(null)
        );
        MEGICENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID,"megic"),
            BlockEntityType.Builder.create(MagicEntity::new, BlockReagistry.MAGIC).build(null)
        );
    }
}