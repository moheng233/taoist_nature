package xyz.moheng.taoist_nature.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryListener;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import spinnery.common.BaseContainer;
import spinnery.common.BaseInventory;
import spinnery.util.InventoryUtilities;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;

public class QiankunDag extends BaseContainer {

    public static final int BACKPACK_INVENTORY = 1;
    public Text name;
    public PlayerEntity player;

    public ItemStack backpackStack;

    public QiankunDag(int synchronizationID, PlayerInventory linkedPlayerInventory) {
        super(synchronizationID, linkedPlayerInventory);
        this.name = new TranslatableText("item.taoist_nature.qiankun_dag");
        this.player = linkedPlayerInventory.player;
        
        if (!this.player.world.isClient) {
            backpackStack = player.getStackInHand(player.getActiveHand());
        }

        // 初始化Interface
        WInterface mainInterface = getInterface();
        BaseInventory backpackInventory = new BaseInventory(27);
        if (!this.player.world.isClient) {
            if (backpackStack.hasTag()) {
                CompoundTag tag = (CompoundTag) backpackStack.getTag().get("backpack");
                InventoryUtilities.read(backpackInventory, tag);
            }
            backpackInventory.addListener(new InventoryListener() {
                @Override
                public void onInvChange(Inventory inventory) {
                    CompoundTag tag = InventoryUtilities.write(getInventory(BACKPACK_INVENTORY), new CompoundTag());
                    if (tag != backpackStack.getTag().get("backpack")){
                        CompoundTag tag2 = new CompoundTag();
                        tag2.put("backpack", tag);
                        backpackStack.setTag(tag2);

                        System.out.println("Tag Change");
                    }
                    
                }
            });
        }


        getInventories().put(BACKPACK_INVENTORY, backpackInventory);

        mainInterface.createChild(WSlot.class);
        WSlot.addHeadlessArray(mainInterface, 0, BACKPACK_INVENTORY, 9, 3);
        WSlot.addHeadlessPlayerInventory(mainInterface);
        
        
    }

    @Override
    public void close(PlayerEntity player) {
        if(!player.world.isClient){
            CompoundTag tag = new CompoundTag();
            tag.put("backpack", InventoryUtilities.write(getInventory(BACKPACK_INVENTORY), new CompoundTag()));
            
            backpackStack.setTag(tag);

            super.close(player);
        }
        
    }
    
}