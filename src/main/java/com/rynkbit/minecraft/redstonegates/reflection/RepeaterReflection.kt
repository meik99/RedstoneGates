package com.rynkbit.minecraft.redstonegates.reflection

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockFace

class RepeaterReflection{
    fun setPowered(repeater: Block, powered: Boolean) {
        val blockData = Bukkit.createBlockData(Material.REPEATER)

            val setPowered = blockData::class.java.methods.find { it.name.contains("setPowered", false) }
            val setDelay = blockData::class.java.methods.find { it.name.contains("setDelay", false) }
            val setLocked = blockData::class.java.methods.find { it.name.contains("setLocked", false) }
            val setFacing = blockData::class.java.methods.find { it.name.contains("setFacing", false) }

            val getDelay = blockData::class.java.methods.find { it.name.contains("getDelay", false) }
            val getLocked = blockData::class.java.methods.find { it.name.contains("getLocked", false) }
            val getFacing = blockData::class.java.methods.find { it.name.contains("getFacing", false) }

            val locked = getLocked?.invoke(repeater.blockData) ?: false
            val facing = getFacing?.invoke(repeater.blockData) ?: BlockFace.NORTH
            val delay = getDelay?.invoke(repeater.blockData) as Int

            setDelay?.invoke(blockData, delay)
            setLocked?.invoke(blockData, locked)
            setFacing?.invoke(blockData, facing)
            setPowered?.invoke(blockData, powered)

            repeater.setBlockData(blockData, true)
    }

}