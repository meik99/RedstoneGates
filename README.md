# Repeater Gate

Turns standard repeaters into logic gates.

# Usage
After putting a repeater down, you can crouch and right click to change the delay as usual.

If you do not crouch and right click, an inventory will open, which is used to determine the gate the repeater will be simulating.

If the repeater is a gate, the left and right side of it are inputs. The output side is the same as a standard repeater.

For now, only redstone wires will be recognized as valid inputs. Recognizing redstone torches is planned for the future.

## Gates

By putting redstone into specific slots of the inventory of the repeater, the gate that should be simulated is selected. 
The following table contains all possible gates with the related redstone positions. Slots were redstone must be placed
are marked with an X, slots that are not marked with an X must remain empty.


| Gate  | Slot 1 | Slot 2 | Slot 3 | Slot 4 | Slot 5 | Slot 6 | Slot 7 | Slot 8 | Slot 9 |
|-------|--------|--------|--------|--------|--------|--------|--------|--------|--------|
| AND   | X      |        |        |        |        |        |        |        |        |
| OR    |        | X      |        |        |        |        |        |        |        |
| XOR   | X      | X      |        |        |        |        |        |        |        |
| NAND  |        |        | X      |        |        |        |        |        |        |
| NOR   | X      |        | X      |        |        |        |        |        |        |
| NOT*  |        | X      | X      |        |        |        |        |        |        |
| NOP** |        |        |        |        |        |        |        |        |        |

* The NOT-operation does only use the left input. The right side does not need to be connected to any redstone wire.

** The NOP-operation lets the repeater work as a normal repeater. No gate will be simulated.

The repeater has nine inventory slots, because the API only allows the creation of inventories, that have a multiple of
nine as slot size.
