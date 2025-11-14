package org.example.Electronics

import Electronics.models.Electrodomestics
import Electronics.models.Television
import Electronics.models.WashingMachine

fun main(){
    var list = mutableListOf<Electrodomestics>()

    list.add(Electrodomestics(200, 20, 'a', "azul"))
    list.add(WashingMachine(40, 300, 40, 'b', "rojo"))
    list.add(Television(500, 30, 'c', "negro", 50, true))
    list.add(WashingMachine(25, 200))
    list.add(Television(250, 20))
    list.add(Electrodomestics(150, 10, 'z', "verde"))
    list.add(WashingMachine())
    list.add(Electrodomestics())
    list.add(Television())
    list.add(Television(600, 50, 'd', "gris", 60, false))

    var totalElectro = 0
    var totalWashing = 0
    var totalTelevision = 0

    for (e in list){
        var price = e.finalPrice()
        totalElectro += price

        if(e is WashingMachine ){
            totalWashing += price
        }else if(e is Television ){
            totalTelevision += price
        }
    }

    println("Precio total Electrodomésticos: " + totalElectro)
    println("Precio total Lavadoras: " + totalWashing)
    println("Precio total Televisiones: " + totalTelevision)


}