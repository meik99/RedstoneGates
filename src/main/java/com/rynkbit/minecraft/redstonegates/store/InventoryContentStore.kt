package com.rynkbit.minecraft.redstonegates.store

import com.rynkbit.minecraft.redstonegates.RepeaterInventoryHolder
import org.bukkit.inventory.ItemStack

class InventoryContentStore{
    private val store = mutableMapOf<RepeaterInventoryHolder, Array<ItemStack>>()

    fun containsKey(key: RepeaterInventoryHolder): Boolean {
        return store.containsKey(key)
    }

    operator fun get(inventoryHolder: RepeaterInventoryHolder): Array<ItemStack> {
        return store[inventoryHolder] ?: arrayOf()
    }

    operator fun set(inventory: RepeaterInventoryHolder, value: Array<ItemStack>) {
        store[inventory] = value
    }
}