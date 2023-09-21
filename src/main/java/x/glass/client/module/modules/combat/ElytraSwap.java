package x.glass.client.module.modules.combat;

import net.minecraft.inventory.container.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import x.glass.client.module.Module;
import x.glass.client.module.ModuleCategory;
import x.glass.client.utils.FindUtil;

import static x.glass.client.Glass.mc;

public class ElytraSwap extends Module {
    public ElytraSwap() {
        super("ElytraSwap", ModuleCategory.Misc);
    }

    @Override
    public void onEnable() {
        int elytra = FindUtil.findItemInInventory(Items.ELYTRA);
        if (elytra != -1) {
            if (elytra == 6) {
                mc.playerController.windowClick(0, 6, 0, ClickType.PICKUP, mc.player);
                mc.playerController.windowClick(0, chestplate(), 0, ClickType.PICKUP, mc.player);
                mc.playerController.windowClick(0, 6, 0, ClickType.PICKUP, mc.player);
            } else if (chestplate() == 6) {
                mc.playerController.windowClick(0, elytra, 0, ClickType.PICKUP, mc.player);
                mc.playerController.windowClick(0, 6, 0, ClickType.PICKUP, mc.player);
                mc.playerController.windowClick(0, elytra, 0, ClickType.PICKUP, mc.player);
            }
        }
    }

    int chestplate() {
        for (int index = 0; index < mc.player.container.inventorySlots.size(); index++) {
            Item item = mc.player.container.getSlot(index).getStack().getItem();
            if (item == Items.NETHERITE_CHESTPLATE || item == Items.DIAMOND_CHESTPLATE || item == Items.GOLDEN_CHESTPLATE || item == Items.IRON_CHESTPLATE || item == Items.CHAINMAIL_CHESTPLATE || item == Items.LEATHER_CHESTPLATE) {
                return index;
            }
        }
        return 0;
    }
}
