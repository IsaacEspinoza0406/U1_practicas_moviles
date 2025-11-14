import kotlin.math.sqrt
class Raices(val a: Double, val b: Double, val c: Double) {
    fun getDiscriminante(): Double {
        return (b * b) - (4 * a * c)
    }

    fun tieneRaices(): Boolean {
        return getDiscriminante() > 0
    }

    fun tieneRaiz(): Boolean {
        return getDiscriminante() == 0.0
    }

    fun obtenerRaices() {
        val discriminante = getDiscriminante()
        val solucion1 = (-b + sqrt(discriminante)) / (2 * a)
        val solucion2 = (-b - sqrt(discriminante)) / (2 * a)
        println("Las dos soluciones posibles son:")
        println("Solución 1: $solucion1")
        println("Solución 2: $solucion2")
    }

    fun obtenerRaiz() {
        val solucion = -b / (2 * a)
        println("La única solución posible es:")
        println("Solución: $solucion")
    }

    fun calcular() {
        if (tieneRaices()) {
            obtenerRaices()
        } else if (tieneRaiz()) {
            obtenerRaiz()
        } else {
            println("La ecuación no tiene soluciones reales.")
        }
    }
}

fun main() {
    println("--- Caso 1: Ecuación con dos soluciones (x^2 - 5x + 6 = 0) ---")
    val ecuacion1 = Raices(1.0, -5.0, 6.0) // Soluciones: x=3, x=2
    ecuacion1.calcular()

    println("\n--- Caso 2: Ecuación con una solución (x^2 + 4x + 4 = 0) ---")
    val ecuacion2 = Raices(1.0, 4.0, 4.0)  // Solución: x=-2
    ecuacion2.calcular()

    println("\n--- Caso 3: Ecuación sin soluciones reales (5x^2 + 2x + 1 = 0) ---")
    val ecuacion3 = Raices(5.0, 2.0, 1.0)  // Sin soluciones reales
    ecuacion3.calcular()
}