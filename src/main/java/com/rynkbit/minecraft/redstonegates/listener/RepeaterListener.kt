package com.rynkbit.minecraft.redstonegates.listener

import com.rynkbit.minecraft.redstonegates.InventoryHandler
import com.rynkbit.minecraft.redstonegates.RepeaterInventoryHolder
import com.rynkbit.minecraft.redstonegates.store.InventoryContentStore
import com.rynkbit.minecraft.redstonegates.store.RepeaterInventoryStore
import com.rynkbit.minecraft.redstonegates.store.RepeaterStore
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.player.PlayerInteractEvent

class RepeaterListener(
        private val repeaterStore: RepeaterStore,
        private val repeaterInventoryStore: RepeaterInventoryStore,
        private val inventoryContentStore: InventoryContentStore)
    : Listener{

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_BLOCK && !event.player.isSneaking) {
            val block = event.clickedBlock

            if (block != null) {
                val type = block.type

                if (type.name == Material.REPEATER.name) {

                    InventoryHandler(
                            repeaterInventoryStore,
                            inventoryContentStore)
                            .openAndRestoreInventory(
                                    block,
                                    event.player
                            )

                    repeaterStore.addIfNotContains(block)

                    event.isCancelled = true
                }
            }
        }
    }


    @EventHandler
    fun onInventoryClose(event: InventoryCloseEvent) {
        val inventory = event.inventory.holder

        if (inventory is RepeaterInventoryHolder) {
            val content = inventory.inventory.contents

            inventoryContentStore[inventory] = content
        }
    }


    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        repeaterStore.removeIfContains(event.block)
    }
}