package com.rynkbit.minecraft.redstonegates

import com.rynkbit.minecraft.redstonegates.store.InventoryContentStore
import com.rynkbit.minecraft.redstonegates.store.RepeaterInventoryStore
import org.bukkit.block.Block
import org.bukkit.entity.Player

class InventoryHandler(
        val repeaterInventoryStore: RepeaterInventoryStore,
        val inventoryContentStore: InventoryContentStore){

    fun openAndRestoreInventory(block: Block, player: Player){
        val inventoryHolder = restoreInventory(block)
        inventoryHolder.openInventory(player)
    }

    private fun restoreInventory(block: Block): RepeaterInventoryHolder {
        repeaterInventoryStore.putIfNotContains(block, RepeaterInventoryHolder())

        val inventoryHolder = repeaterInventoryStore[block]

        if(inventoryContentStore.containsKey(inventoryHolder)){
            inventoryHolder.inventory.contents = inventoryContentStore[inventoryHolder]
        }

        return inventoryHolder
    }
}