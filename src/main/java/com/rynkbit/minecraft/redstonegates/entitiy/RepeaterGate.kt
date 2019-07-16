package com.rynkbit.minecraft.redstonegates.entitiy

import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.Repeater
import org.bukkit.material.Diode

class RepeaterGate(
        val repeater: Block
){
    private fun getBlockFace(): BlockFace {
        return (repeater.state.data as Diode).facing
    }

    private fun getRightFace(): BlockFace {
        when (val blockFace = getBlockFace()) {
            BlockFace.NORTH -> {
                return  BlockFace.EAST
            }
            BlockFace.EAST -> {
                return BlockFace.SOUTH
            }
            BlockFace.SOUTH -> {
                return BlockFace.WEST
            }
            BlockFace.WEST -> {
                return BlockFace.NORTH
            }
            else -> {
                println("WARNING: No function for statement for face: $blockFace")
            }
        }
        return BlockFace.NORTH
    }

    fun getRightBlock(): Block {
        return repeater.getRelative(getRightFace())
    }

    private fun getLeftFace(): BlockFace {
        when (val blockFace = getBlockFace()) {
            BlockFace.NORTH -> {
                return  BlockFace.WEST
            }
            BlockFace.EAST -> {
                return BlockFace.NORTH
            }
            BlockFace.SOUTH -> {
                return BlockFace.EAST
            }
            BlockFace.WEST -> {
                return BlockFace.SOUTH
            }
            else -> {
                println("WARNING: No function for statement for face: $blockFace")
            }
        }
        return BlockFace.SOUTH
    }

    fun getLeftBlock(): Block {
        return repeater.getRelative(getLeftFace())
    }

    fun isLeftBlockPowered(): Boolean {
        return getLeftBlock().isBlockPowered || getLeftBlock().isBlockIndirectlyPowered
    }

    fun isRightBlockPowered(): Boolean {
        return getRightBlock().isBlockPowered || getRightBlock().isBlockIndirectlyPowered
    }
}