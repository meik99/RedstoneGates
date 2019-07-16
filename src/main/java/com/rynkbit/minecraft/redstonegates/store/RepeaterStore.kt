package com.rynkbit.minecraft.redstonegates.store

import org.bukkit.block.Block


class RepeaterStore{
    private val store = mutableListOf<Block>()

    fun addIfNotContains(block: Block) {
        if(!store.contains(block)){
            store.add(block)
        }
    }

    fun removeIfContains(block: Block) {
        if(store.contains(block)){
            store.remove(block)
        }
    }

    fun contains(block: Block): Boolean {
        return store.contains(block)
    }

    fun forEach(function: (repeater: Block) -> Unit) {
        store.forEach(function)
    }
}