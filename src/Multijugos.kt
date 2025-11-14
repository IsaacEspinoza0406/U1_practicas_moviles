package Activities

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Ingresa la cantidad de miligramos para una pocion de multijugos")
    val cuantity: Int = readLine()!!.toInt()
    if (cuantity > 100){
        println("¡Felicidades, es una buena poción multijugos!")
    }else{
        println("La poción es mediocre, sangre sucia inmunda")
    }
}