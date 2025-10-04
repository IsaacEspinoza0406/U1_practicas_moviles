fun main (){
    sayayin()
    //uber()
}
fun uber(){
    do {
        var ready = false

        println("¿Cuál es tu distancia?")
        var distance = readLine()!!.toDouble()

        println ("¿Estás disponible?")
        var avaliable = readLine()!!.toBoolean()

        if (distance <=0.5 && avaliable) {
            println("Listo para iniciar el recorrido")
            ready = true
        }
        else if (distance <=0.5 && !avaliable) {
            println("El conductor está cercano, pero no está disponible.")
        }
        else if (distance >=0.5 && avaliable) {
            println("Conductor disponible pero muy lejos, aplicarán tarifas más altas.")
        }
        else if (distance >=0.5 && !avaliable) {
            println("No hay conductores disponibles.")
        }
    }while (!ready)

}
fun sayayin(){
    println("Ingrese su numero.")
    var n = readLine()!!.toInt()

    if (n<=0){
        println("Ingrese un numero positivo.")
        var n = readLine()!!.toInt()
    }

    for (i in 2..n step 2) {
        println("Número par: $i")
    }
}