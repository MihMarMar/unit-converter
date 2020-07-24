package converter

import converter.UnitType.Companion.getUnit
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Enter what you want to convert (or exit):")
        val firstInput = scanner.next().toLowerCase()
        if (firstInput == "exit") break
        val inputAmount = firstInput.toDouble()

        var inputUnitStr = scanner.next().toLowerCase()
        if (inputUnitStr.contains("degree")) { // edge case where unit is in 2 words
            inputUnitStr += " " + scanner.next().toLowerCase()
        }
        val inputUnit = getUnit(inputUnitStr)

        scanner.next() // skip "to"

        var outputUnitStr = scanner.next().toLowerCase()
        if (outputUnitStr.contains("degree")) { // edge case where unit is in 2 words
            outputUnitStr += " " + scanner.next().toLowerCase()
        }
        val outputUnit = getUnit(outputUnitStr)

        if ((inputUnit.type == Quantities.WEIGHT || inputUnit.type == Quantities.DISTANCE) && inputAmount < 0) {
            println("${inputUnit.type.str} shouldn't be negative")
            continue
        }

        if ((inputUnit == UnitType.NULL || outputUnit == UnitType.NULL) || inputUnit.type != outputUnit.type) {
            println("Conversion from ${inputUnit.names[2]} to ${outputUnit.names[2]} is impossible.")
            continue
        }

        val outputAmount = outputUnit.fromMain(inputUnit.toMain(inputAmount))

        val inputName = if (inputAmount == 1.0) inputUnit.names[1] else inputUnit.names[2]
        val outputName = if (outputAmount == 1.0) outputUnit.names[1] else outputUnit.names[2]
        println("$inputAmount $inputName is $outputAmount $outputName".format())


    }


}

