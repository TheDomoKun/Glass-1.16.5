package x.glass.client.module.utils;

import net.minecraft.item.Item;

import static x.glass.client.Glass.mc;

public class FindUtil {
    public static int findItemInInventory(Item item) {
        for (int index = 0; index < mc.player.container.inventorySlots.size(); index++) {
            if (mc.player.container.getSlot(index).getStack().getItem() == item) {
                return index;
            }
        }
        return -1;
    }

    public static int findItemInHotBar(Item item) {
        for (int index = 0; index < 9; index++) {
            if (mc.player.inventory.getStackInSlot(index).getItem() == item) {
                return index;
            }
        }
        return -1;
    }
}
