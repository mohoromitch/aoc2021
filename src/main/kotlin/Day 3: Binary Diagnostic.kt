import java.io.File
import kotlin.collections.Map.Entry

private fun getFile() = File("src/main/resources/input_3.txt")

fun main() {
    part1()
}

private fun part1() {
    // Indices correspond to digit position, each position has a Map to accumulate the counts of digits.
    val counts = emptyList<MutableMap<Char, Int>>().toMutableList()

    getFile().forEachLine {
        accumulateCountsFor(it, counts)
    }

    println(counts)

    val gammaSB = StringBuilder()
    val epsilonSB = StringBuilder()

    counts.forEach {
        gammaSB.append(calculateGamma(it).key)
        epsilonSB.append(calculateEpsilon(it).key)
    }

    val gamma = gammaSB.toString().toInt(2)
    val epsilon = epsilonSB.toString().toInt(2)

    val powerConsumption = gamma*epsilon
    println("power consumption: $powerConsumption")

}

private fun accumulateCountsFor(it: String, counts: MutableList<MutableMap<Char, Int>>) {
    for (i in it.indices) {
        val digitMap = try {
            counts[i]
        } catch (e: Exception) {
            counts.add(i, defaultMap())
            counts[i]
        }
        val currentValue = digitMap.getOrDefault(it[i], 0)
        val newValue = currentValue + 1
        digitMap[it[i]] = newValue
    }
    println(counts)
}

private fun defaultMap(): MutableMap<Char, Int> {
    return mapOf('0' to 0, '1' to 0).toMutableMap()
}

private fun calculateGamma(digitMap: MutableMap<Char, Int>): Entry<Char, Int> {
    return digitMap.maxByOrNull { it.value }!!
}

private fun calculateEpsilon(digitMap: MutableMap<Char, Int>): Entry<Char, Int> {
    return digitMap.minByOrNull { it.value }!!
}

