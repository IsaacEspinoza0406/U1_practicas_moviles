package Electronics.models

class Television(
    price: Int,
    weight: Int,
    energyConsumption: Char,
    color: String,
    var resolution: Int = RESOLUTION,
    var sintonizatorTDT: Boolean = SINTONIZATOR,
):Electrodomestics(price, weight, energyConsumption, color){
    companion object{
        const val RESOLUTION: Int = 20
        const val SINTONIZATOR: Boolean = false
    }

    constructor(price: Int, weight: Int): this(
        price = price,
        weight = weight,
        energyConsumption = ENERGY_CONSUMPTION,
        color = COLOR,
        resolution = RESOLUTION
    )

    constructor(): this(
        price = BASE_PRICE,
        weight = BASE_WEIGHT,
        energyConsumption = ENERGY_CONSUMPTION,
        color = COLOR,
    )

    override fun finalPrice(): Int {
        var finalPrice = super.finalPrice()
        if (resolution > 40){
            finalPrice += (finalPrice * 0.3).toInt()
        }
        return finalPrice
    }

}