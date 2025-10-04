package Electronics.models

open class Electrodomestics(
    protected var price: Int = BASE_PRICE,
    protected var weight: Int = BASE_WEIGHT,
    protected var energyConsumption: Char = ENERGY_CONSUMPTION,
    protected var color: String = COLOR,
){
    companion object{
        const val BASE_PRICE: Int = 100
        const val COLOR: String = "blanco"
        const val ENERGY_CONSUMPTION: Char = 'f'
        const val BASE_WEIGHT: Int = 5
    }

    constructor(price: Int, weight: Int): this(price,weight,ENERGY_CONSUMPTION,COLOR )
    constructor(): this(
        price = BASE_PRICE,
        weight = BASE_WEIGHT
    )
    init {
        energyConsumption = checkEnergyConsumption(energyConsumption)
        color = checkColor(color)
    }


    private fun checkEnergyConsumption(letter: Char): Char {
        val letters = arrayListOf<Char>('a','b','c','d','e','f')
        val lowerLetter = letter.lowercaseChar()
        if (letters.contains(lowerLetter)){
            return letter
        }
        return ENERGY_CONSUMPTION
    }

    private fun checkColor(color: String): String {
        val colors = arrayListOf<String>("blanco","negro","rojo","azul","gris")
        val lowerColor = color.lowercase()
        if (colors.contains(lowerColor)){
            return lowerColor
        }
        return COLOR
    }

    open fun finalPrice(): Int{
        var c: Int = 0
        val map = buildMap {
            put('a',100);
            put('b',80);
            put('c',60);
            put('d',50);
            put('e',30);
            put('f',10);
        }
        c += map.getOrDefault(energyConsumption,10)
        c += when (weight) {
            in 0..19 -> 10
            in 20..49 -> 50
            in 50..79 -> 80
            else -> 100
        }

        return BASE_PRICE + c
    }

}