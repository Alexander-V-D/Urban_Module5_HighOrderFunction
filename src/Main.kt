fun main() {

    //Задача 1
    print("Пример выполнения решения из задачи 1: ")
    println(action("Желтый", "Коричневый", mix = ::mixColors))

    //Задача 2
    println("Пример выполнения решения из задачи 2: " +
            changeArray(arrayOf(1, 2, 3, 4, 5), change = ::increaseBy1).contentToString())
}

fun action(firstColor: String, secondColor: String, mix: (String, String) -> String): String {
    return mix(firstColor, secondColor)
}

fun mixColors(firstColor: String, secondColor: String): String {
    when {
        firstColor.lowercase() == "красный" ||
                secondColor.lowercase() == "красный"
                && firstColor.lowercase() == "желтый"
                || secondColor.lowercase() == "желтый" -> return "Оранжевый"
        firstColor.lowercase() == "синий" ||
                secondColor.lowercase() == "синий"
                && firstColor.lowercase() == "желтый"
                || secondColor.lowercase() == "желтый" -> return "Зеленый"
        firstColor.lowercase() == "красный" ||
                secondColor.lowercase() == "красный"
                && firstColor.lowercase() == "синий"
                || secondColor.lowercase() == "синий" -> return "Фиолетовый"
        firstColor.lowercase() == "черный" -> return "Темно-$secondColor"
        secondColor.lowercase() == "черный" -> return "Темно-$firstColor"
        firstColor.lowercase() == "белый" -> return "Светло-$secondColor"
        secondColor.lowercase() == "белый" -> return "Светло-$firstColor"
        else -> return firstColor.dropLast(2) + "о-" + secondColor.lowercase()
    }
}

fun increaseBy1(number: Int) = number + 1
fun multiplyBy2(number: Int) = number * 2

fun changeArray(array: Array<Int>, change: (Int) -> Int): Array<Int> {
    var newArray = arrayOf<Int>()
    array.map { change(it) }.forEach { newArray += it }
    return newArray
}