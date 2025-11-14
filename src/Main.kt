//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

        println("Suma de for.")
        println("Ingrese tu numero.")
        var number = readLine()!!.toInt()

        var additionFor = 0
        var subtractionWhile = 1

        for (i in 1..number) {
            additionFor += i
        }

        println("La suma de numero es %d".format( additionFor))

        println("Suma con while.")

        var n = 1

        while (n <= number) {
            subtractionWhile *= n
            n++
        }

        println("La suma de numero. es %d".format( subtractionWhile))
    }
