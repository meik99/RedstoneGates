package com.rynkbit.minecraft.redstonegates.entitiy

import org.bukkit.inventory.ItemStack

class RepeaterDecoder(private val content: Array<ItemStack>){
    fun decode(): ALUOp {
        var aluop: ALUOp = ALUOp.NOP

        for (op in ALUOp.values()){
            if(op != ALUOp.NOP) {
                var opMatched = true

                for ((index, itemStack) in op.content.withIndex()) {
                    if(!checkEquals(content[index], itemStack)){
                        opMatched = false
                    }
                }

                if (opMatched){
                    aluop = op
                    break
                }
            }
        }

        return aluop
    }

    private fun checkEquals(itemStack: ItemStack?, itemStack1: ItemStack?): Boolean {
        return (itemStack == null && itemStack1 == null) ||
                (itemStack != null && itemStack1 != null && itemStack.type == itemStack1.type)
    }
}