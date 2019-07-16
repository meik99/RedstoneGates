package com.rynkbit.minecraft.entitiy

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

enum class ALUOp(val content: Array<ItemStack?>){
    AND(arrayOf(ItemStack(Material.REDSTONE), null, null, null, null, null, null, null, null)),
    OR(arrayOf(null, ItemStack(Material.REDSTONE), null, null, null, null, null, null, null)),
    XOR(arrayOf(ItemStack(Material.REDSTONE), ItemStack(Material.REDSTONE), null, null, null, null, null, null, null)),
    NAND(arrayOf(null, null, ItemStack(Material.REDSTONE), null, null, null, null, null, null)),
    NOR(arrayOf(ItemStack(Material.REDSTONE), null, ItemStack(Material.REDSTONE), null, null, null, null, null, null)),
    NOT(arrayOf(null, ItemStack(Material.REDSTONE), ItemStack(Material.REDSTONE), null, null, null, null, null, null)),
    NOP(arrayOf())
}