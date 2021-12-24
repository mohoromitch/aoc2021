import java.io.File
import java.lang.IndexOutOfBoundsException

fun getFile() = File("src/main/resources/input_1.txt")

fun main() {
    part1()
    part2()
}

private fun part1() {
    var previous: Int? = null
    var current: Int? = null
    var increasedCount = 0

    getFile().forEachLine {
        if (current == null) {
            println("Skipping first round")
            current = it.toInt()
            previous = it.toInt()
        } else {
            print("p:$previous - c:$current ")
            current = it.toInt()
            if (current!! > previous!!) {
                print("Increasing++")
                increasedCount++
            }
            println()
            previous = current
        }
    }

    println("Total increasing count: $increasedCount")
}

fun part2() {
    var increasedCount = 0
    val depths: MutableList<Int> = ArrayList()
    getFile().forEachLine { depths.add(it.toInt()) }

    try {
        for (i in 0 until depths.size) {
            if (getWindowForIndex(i, depths) < getWindowForIndex(i+1, depths)) increasedCount++
        }
    } catch (e: IndexOutOfBoundsException) {
        println("Reached end, continuing.")
    }

    println("Windowed increasedCount: $increasedCount")

}

fun getWindowForIndex(i: Int, depths: List<Int>): Int = depths[i] + depths[i+1] + depths[i+2]



