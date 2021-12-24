import java.io.File

private fun getFile() = File("src/main/resources/input_2.txt")

fun main() {
    part1()
    part2()
}

private fun part1() {
    var x = 0
    var y = 0

    getFile().forEachLine {
        val tokens = it.trim().split(" ")
        val action = tokens[0]
        val value = tokens[1].toInt()
        println("action: $action, value: $value")
        when (action) {
            "up" -> y -= value
            "down" -> y += value
            "forward" -> x += value
            "back" -> x -= value
        }
    }
    println("ending coords: $x, $y")
    println("ending product: ${x * y}")
}

private fun part2() {
    var x = 0
    var y = 0
    var aim = 0


    getFile().forEachLine {
        val tokens = it.trim().split(" ")
        val action = tokens[0]
        val value = tokens[1].toInt()
        println("action: $action, value: $value")
        when (action) {
            "up" -> {
                aim -= value
            }
            "down" -> {
                aim += value
            }
            "forward" -> {
                x += value
                y += value*aim
            }
            "back" -> {
                x -= value
                y -= value*aim
            }
        }
    }
    println("ending coords: $x, $y")
    println("ending product: ${x * y}")
}