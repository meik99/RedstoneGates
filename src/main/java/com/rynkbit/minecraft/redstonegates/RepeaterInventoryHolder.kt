package com.rynkbit.minecraft.redstonegates

import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.meta.ItemMeta
import org.jetbrains.annotations.NotNull
import java.util.Arrays



class RepeaterInventoryHolder : InventoryHolder{
    // Create a new inventory, with "this" owner for comparison with other inventories, a size of nine, called example
    private var inv: Inventory = Bukkit.createInventory(this, 9, "Repeater Logic")

    @NotNull
    override fun getInventory(): Inventory {
        return inv
    }

    // You can open the inventory with this
    fun openInventory(p: Player) {
        p.openInventory(inv)
    }
}