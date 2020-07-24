package converter

@Suppress("unused")
enum class UnitType(
    val names: List<String>,
    val toMain: (Double) -> Double, val fromMain: (Double) -> Double, val type: Quantities
) {

    NULL(listOf("???", "???", "???"), fun(_) = 0.0, fun(_) = 0.0, Quantities.NULL),

    GRAM(listOf("g", "gram", "grams"),
        fun(x) = x, fun(x) = x, Quantities.WEIGHT
    ),
    KILOGRAM(listOf("kg", "kilogram", "kilograms"),
        fun(x) = x * 1000.0, fun(x) = x / 1000.0, Quantities.WEIGHT
    ),
    MILLIGRAM(listOf("mg", "milligram", "milligrams"),
        fun(x) = x * 0.001, fun(x) = x / 0.001, Quantities.WEIGHT
    ),
    POUND(listOf("lb", "pound", "pounds"),
        fun(x) = x * 453.592, fun(x) = x / 453.592, Quantities.WEIGHT
    ),
    OUNCES(listOf("oz", "ounce", "ounces"),
        fun(x) = x * 28.3495, fun(x) = x / 28.3495, Quantities.WEIGHT
    ),

    METER(listOf("m", "meter", "meters"),
        fun(x) = x, fun(x) = x, Quantities.DISTANCE
    ),
    KILOMETER(listOf("km", "kilometer", "kilometers"),
        fun(x) = x * 1000.0, fun(x) = x / 1000.0, Quantities.DISTANCE
    ),
    CENTIMETER(listOf("cm", "centimeter", "centimeters"),
        fun(x) = x * 0.01, fun(x) = x / 0.01, Quantities.DISTANCE
    ),
    MILLIMETER(listOf("mm", "millimeter", "millimeters"),
        fun(x) = x * 0.001, fun(x) = x / 0.001, Quantities.DISTANCE
    ),
    MILE(listOf("mi", "mile", "miles"),
        fun(x) = x * 1609.35, fun(x) = x / 1609.35, Quantities.DISTANCE
    ),
    YARD(listOf("yd", "yard", "yards"),
        fun(x) = x * 0.9144, fun(x) = x / 0.9144, Quantities.DISTANCE
    ),
    FOOT(listOf("ft", "foot", "feet"),
        fun(x) = x * 0.3048, fun(x) = x / 0.3048, Quantities.DISTANCE
    ),
    INCH(listOf("in", "inch", "inches"),
        fun(x) = x * 0.0254, fun(x) = x / 0.0254, Quantities.DISTANCE
    ),

    KELVIN(listOf("k", "kelvin", "kelvins"),
        fun(x) = x, fun(x) = x, Quantities.TEMPERATURE
    ),
    CELSIUS(listOf("c", "degree celsius", "degrees celsius", "celsius", "dc"),
        fun(x) = x + 273.15, fun(x) = x - 273.15, Quantities.TEMPERATURE
    ),
    FAHRENHEIT(listOf("f", "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df"),
        fun(x) = (x + 459.67) * (5.0 / 9.0), fun(x) = ((x * (9.0 / 5.0)) - 459.67),
        Quantities.TEMPERATURE
    );

    companion object {
        fun getUnit(inputUnitStr: String): UnitType {
            var inputUnit = NULL
            for (type in values()) {
                if (type.names.contains(inputUnitStr)) inputUnit = type
            }
            return inputUnit
        }
    }
}