package com.rynkbit.minecraft

import com.rynkbit.minecraft.listener.CurrentChangeListener
import com.rynkbit.minecraft.listener.RepeaterListener
import com.rynkbit.minecraft.store.InventoryContentStore
import com.rynkbit.minecraft.store.RepeaterInventoryStore
import com.rynkbit.minecraft.store.RepeaterStore
import org.bukkit.plugin.java.JavaPlugin

class RedstoneGatesPlugin : JavaPlugin() {
    private val repeaterInventoryStore = RepeaterInventoryStore()
    private val inventoryContentStore = InventoryContentStore()
    private val repeaterStore = RepeaterStore()

    override fun onEnable() {
        server.pluginManager.registerEvents(
                RepeaterListener(
                        repeaterStore,
                        repeaterInventoryStore,
                        inventoryContentStore), this)
        server.pluginManager.registerEvents(
                CurrentChangeListener(
                        repeaterStore,
                        repeaterInventoryStore,
                        inventoryContentStore
                ), this)
    }

    override fun onDisable() {

    }
}