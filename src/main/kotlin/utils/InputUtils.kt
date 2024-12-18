package utils

fun getTwoIntListsFromFile(filePath: String): Pair<List<Int>, List<Int>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val parts = line.trim().split("\\s+".toRegex())
            if (parts.size == 2) {
                val num1 = parts[0].toIntOrNull()
                val num2 = parts[1].toIntOrNull()
                if (num1 != null && num2 != null) {
                    list1.add(num1)
                    list2.add(num2)
                }
            }
        }
    }
    return Pair(list1, list2)
}

fun getListOfTripleIntPairs(filePath: String): List<Triple<Pair<Int,Int>, Pair<Int,Int>, Pair<Int,Int>>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list1 = mutableListOf<Pair<Int,Int>>()
    val list2 = mutableListOf<Pair<Int,Int>>()
    val list3 = mutableListOf<Pair<Int,Int>>()
    val resultList = mutableListOf<Triple<Pair<Int,Int>, Pair<Int,Int>, Pair<Int,Int>>>()

    val regex = "\\b\\d+\\b".toRegex()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val numbers = regex.findAll(line).map { it.value.toInt() }.toList()
            if (numbers.size == 2) {
                val pair = numbers[0] to numbers[1]
                if (line.startsWith("Button A")) {
                    list1.add(pair)
                } else if (line.startsWith("Button B")) {
                    list2.add(pair)
                } else if (line.startsWith("Prize")) {
                    list3.add(pair)
                }
            }
        }
    }

    for (i in list1.indices) {
        resultList.add(Triple(list1[i], list2[i], list3[i]))
    }
    return resultList
}

fun getListOfPairIntPairs(filePath: String): List<Pair<Pair<Int,Int>, Pair<Int,Int>>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val resultList = mutableListOf<Pair<Pair<Int,Int>, Pair<Int,Int>>>()

    val regex = "-?\\d+".toRegex()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val numbers = regex.findAll(line).map { it.value.toInt() }.toList()
            if (numbers.size == 4) {
                val pair1 = numbers[0] to numbers[1]
                val pair2 = numbers[2] to numbers[3]
                resultList.add(pair1 to pair2)
            }
        }
    }
    return resultList
}

fun getIntPairsAndIntListsFromFile(filePath: String): Pair<List<Pair<Int, Int>>, List<List<Int>>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val intsList = mutableListOf<List<Int>>()
    val intPairs = mutableListOf<Pair<Int, Int>>()

    var firstPart = true

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            if (line.trim().isEmpty()) {
                firstPart = false
            } else {
                if (firstPart) {
                    val split = line.split("|")
                    intPairs.add(split[0].toInt() to split[1].toInt())
                } else {
                    val split = line.split(",")
                    intsList.add(split.map { s -> s.toInt() })
                }
            }
        }
    }
    return intPairs to intsList
}

fun getStringListFromFile(filePath: String): List<String> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list = mutableListOf<String>()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            list.add(line)
        }
    }
    return list
}

fun getListOfCharListsFromFile(filePath: String): MutableList<MutableList<Char>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list = mutableListOf<MutableList<Char>>()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            list.add(line.trim().toMutableList())
        }
    }
    return list
}

fun getListOfIntListsFromFile(filePath: String): List<List<Int>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list = mutableListOf<List<Int>>()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val parts = line.trim().split("\\s+".toRegex())
            if (parts.isNotEmpty()) {
                val intList = parts.map { e -> e.toInt() }
                list.add(intList)
            }
        }
    }
    return list
}

fun getIntsPairsFromFile(filePath: String): List<Pair<Int,Int>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list = mutableListOf<Pair<Int,Int>>()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val split = line.split(",")
            list.add(split[0].toInt() to split[1].toInt())
        }
    }
    return list
}

fun getIntAndListOfIntsPairsFromFile(filePath: String): List<Pair<Long, List<Long>>> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    val list = mutableListOf<Pair<Long, List<Long>>>()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val split = line.split(": ")
            list.add(split[0].toLong() to (split[1].split(" ").toList().map { i -> i.toLong() }))
        }
    }
    return list
}

fun getStringFromFile(filePath: String): String {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    var result = ""

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            result += (line.trim())
        }
    }
    return result
}

fun getLongListFromFile(filePath: String): List<Long> {
    val inputStream = {}.javaClass.getResourceAsStream(filePath)
        ?: throw IllegalArgumentException("File not found in resources")

    var result: MutableList<Long> = mutableListOf()

    // Read and parse the file
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            if (line.trim().isNotEmpty()) {
                line.trim().split(" ").forEach { str -> result.add(str.toLong()) }
            }
        }
    }
    return result
}