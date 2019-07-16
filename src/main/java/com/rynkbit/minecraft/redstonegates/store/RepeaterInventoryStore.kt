package com.rynkbit.minecraft.redstonegates.store

import com.rynkbit.minecraft.redstonegates.RepeaterInventoryHolder
import org.bukkit.block.Block

class RepeaterInventoryStore {
    private val store = mutableMapOf<Block, RepeaterInventoryHolder>()

    fun putIfNotContains(block: Block, inventoryHolder: RepeaterInventoryHolder){
        if(!store.containsKey(block)){
            store[block] = inventoryHolder
        }
    }

    operator fun get(block: Block): RepeaterInventoryHolder {
        return store[block] ?: RepeaterInventoryHolder()
    }

    fun containsKey(key: Block): Boolean {
        return store.containsKey(key)
    }
}