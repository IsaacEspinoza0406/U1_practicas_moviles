package Electronics.models

class WashingMachine(
    var load: Int = DEFAULT_LOAD,
    price: Int,
    weight: Int,
    energyConsumption: Char,
    color: String,
):Electrodomestics(price, weight, energyConsumption, color){
    companion object {
        const val DEFAULT_LOAD: Int = 5
    }

    constructor(price: Int, weight: Int) :this(
        load = DEFAULT_LOAD,
        price = price,
        weight = weight,
        energyConsumption = ENERGY_CONSUMPTION,
        color = COLOR
    )
    constructor(): this(
        load = DEFAULT_LOAD,
        price = BASE_PRICE,
        weight = BASE_WEIGHT,
        energyConsumption = ENERGY_CONSUMPTION,
        color = COLOR
    )


    override fun finalPrice(): Int {
        var finalPrice = super.finalPrice()

        if (load > 30){
            finalPrice += 50
        }
        return finalPrice
    }


}