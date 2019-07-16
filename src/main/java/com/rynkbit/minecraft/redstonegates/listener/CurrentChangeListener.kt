package com.rynkbit.minecraft.redstonegates.listener

import com.rynkbit.minecraft.redstonegates.entitiy.RepeaterALU
import com.rynkbit.minecraft.redstonegates.entitiy.RepeaterGate
import com.rynkbit.minecraft.redstonegates.store.InventoryContentStore
import com.rynkbit.minecraft.redstonegates.store.RepeaterInventoryStore
import com.rynkbit.minecraft.redstonegates.store.RepeaterStore
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockRedstoneEvent

class CurrentChangeListener(
        private val repeaterStore: RepeaterStore,
        private val repeaterInventoryStore: RepeaterInventoryStore,
        private val inventoryContentStore: InventoryContentStore
) : Listener {


    @EventHandler
    fun onRedstoneCurrentChange(event: BlockRedstoneEvent) {
        repeaterStore.forEach {
            val block = it
            val repeaterGate = RepeaterGate(block)


                if (repeaterStore.contains(block)) {
                    if (repeaterInventoryStore.containsKey(block)) {
                        val repeaterInventory = repeaterInventoryStore[block]

                        if (inventoryContentStore.containsKey(repeaterInventory)) {
                            val content = inventoryContentStore[repeaterInventory]
                            val repeaterALU = RepeaterALU(content, repeaterGate)

                            repeaterALU.execute()
                        }
                    }
                }

        }
    }

}