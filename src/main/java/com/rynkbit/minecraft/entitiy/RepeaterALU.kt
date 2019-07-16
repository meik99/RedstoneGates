package com.rynkbit.minecraft.entitiy

import com.rynkbit.minecraft.reflection.RepeaterReflection
import org.bukkit.inventory.ItemStack

class RepeaterALU(val content: Array<ItemStack>, val repeaterGate: RepeaterGate) {


    fun execute() {
        val decoder = RepeaterDecoder(content)
        val op = decoder.decode()

        when(op){
            ALUOp.AND -> {
                if (repeaterGate.isLeftBlockPowered() && repeaterGate.isRightBlockPowered()) {
                    RepeaterReflection().setPowered(repeaterGate.repeater, true)
                } else {
                    RepeaterReflection().setPowered(repeaterGate.repeater, false)
                }
            }
            ALUOp.OR -> {
                if (repeaterGate.isLeftBlockPowered() || repeaterGate.isRightBlockPowered()) {
                    RepeaterReflection().setPowered(repeaterGate.repeater, true)
                } else {
                    RepeaterReflection().setPowered(repeaterGate.repeater, false)
                }
            }
            ALUOp.XOR -> {
                if (repeaterGate.isLeftBlockPowered() xor repeaterGate.isRightBlockPowered()) {
                    RepeaterReflection().setPowered(repeaterGate.repeater, true)
                } else {
                    RepeaterReflection().setPowered(repeaterGate.repeater, false)
                }
            }
            ALUOp.NAND -> {
                if (!(repeaterGate.isLeftBlockPowered() && repeaterGate.isRightBlockPowered())) {
                    RepeaterReflection().setPowered(repeaterGate.repeater, true)
                } else {
                    RepeaterReflection().setPowered(repeaterGate.repeater, false)
                }
            }
            ALUOp.NOR -> {
                if (!(repeaterGate.isLeftBlockPowered() || repeaterGate.isRightBlockPowered())) {
                    RepeaterReflection().setPowered(repeaterGate.repeater, true)
                } else {
                    RepeaterReflection().setPowered(repeaterGate.repeater, false)
                }
            }
            ALUOp.NOT -> {
                if(repeaterGate.isLeftBlockPowered()){
                    RepeaterReflection().setPowered(repeaterGate.repeater, false)
                } else {
                    RepeaterReflection().setPowered(repeaterGate.repeater, true)
                }
            }
        }
    }

}