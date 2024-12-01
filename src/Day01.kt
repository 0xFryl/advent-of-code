import kotlin.math.abs

fun main() {
    // Part 1
    val input = readInput("Day01_source")
    val inputLeft: MutableList<Int> = mutableListOf()
    val inputRight: MutableList<Int> = mutableListOf()
    val splitRegex = "\\s+".toRegex()

    for (i in input) {
        val groups = i.split(splitRegex)
        inputLeft.add(groups[0].toInt())
        inputRight.add(groups[1].toInt())
    }

    inputLeft.sort()
    inputRight.sort()

    var count = 0
    for (i in 0..<inputLeft.size) {
        count += abs(inputLeft[i] - inputRight[i])
    }

    println("Part 1: $count")

    // Part 2
    count = 0
    val countItem = inputRight.groupingBy { it }.eachCount()

    for (i in 0..<inputLeft.size) {
        if (inputLeft[i] in countItem) {
            count += inputLeft[i] * countItem[inputLeft[i]]!!
        }
    }

    println("Part 2: $count")
}
