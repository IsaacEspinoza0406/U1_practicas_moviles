package org.example.Activities

import kotlin.math.pow
import kotlin.math.sqrt

class Raices(
    var a: Double = 0.0,
    var b: Double = 0.0,
    var c: Double = 0.0,
) {
//    (-b+-sqrt(b^2)-(4*a*c)))/(2*a)

    fun obtenerRaices(a: Double, b: Double, c: Double) {
        var preSqrt = (b.pow(2) - (4.0 * a * c))

        var result = sqrt(preSqrt)

        var finalResultPositive = (-b + (result)) / (2 * a)

        var finalResultNegative = (-b - (result)) / (2 * a)
        if (finalResultPositive.isNaN()) {
            return println("El resultado en no valido")
        } else if (finalResultNegative.isNaN()) {
            return println("El resultado no valido")
        }
        println(finalResultPositive)
        println(finalResultNegative)

    }

    fun obtenerRaiz(a: Double, b: Double, c: Double) {
        var preSqrt = (b.pow(2) - (4.0 * a * c))
        if (preSqrt == 0.0) {
            println("Tiene una nunica solucion")
            var result = sqrt(preSqrt)

            var finalResultPositive = (-b + (result)) / (2 * a)

            var finalResultNegative = (-b - (result)) / (2 * a)
            if (!finalResultPositive.isNaN()) {
                println(finalResultPositive)

            } else if (!finalResultNegative.isNaN()) {
                println(finalResultNegative)

            }


        }

    }

    fun getDiscriminante(a: Double, b: Double, c: Double): Double {
        var discrimate = (b.pow(2) - (4.0 * a * c))
        return discrimate
    }

    fun tieneRaices(a: Double, b: Double, c: Double): Boolean {
        var preSqrt = (b.pow(2) - (4.0 * a * c))
        if (preSqrt >= 0.0) {
            return true
        }
        return false
    }

    fun tieneRaiz(a: Double, b: Double, c: Double): Boolean {
        var preSqrt = (b.pow(2) - (4.0 * a * c))
        if (preSqrt == 0.0) {
            return true
        }
        return false
    }

    fun calcular(a: Double, b: Double, c: Double) {
        var preSqrt = (b.pow(2) - (4.0 * a * c))

        var result = sqrt(preSqrt)

        var finalResultPositive = (-b + (result)) / (2 * a)

        var finalResultNegative = (-b - (result)) / (2 * a)
        if (finalResultPositive.isNaN()) {
            return println("El resultado en no valido")
        } else if (finalResultNegative.isNaN()) {
            return println("El resultado no valido")
        }
        println(finalResultPositive)
        println(finalResultNegative)
    }

}