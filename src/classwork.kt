import kotlin.random.Random

fun main() {
    // === Шаг 1: Функция без параметров ===
    greetPlayer()
    greetPlayer()

    // === Шаг 2: Функция с одним параметром ===
    showChatMessage("Привет всем!")
    showChatMessage("GG")

    // === Шаг 3: Функция с несколькими параметрами ===
    showPlayerInfo("Герой", 100)
    showPlayerInfo("Воин", 85)

    // === Шаг 4: Необязательные параметры ===
    createCharacter("Артур")
    createCharacter("Огр", 3)
    createCharacter("Легион", 10, true)

    // === Шаг 5: Именованные аргументы ===
    createItem("Меч силы", value = 100, rarity = "Эпический")

    // === Шаг 6: Возвращение результата ===
    val totalDamage = calculateDamage(20, 1.5)
    println("Нанесено урона: $totalDamage")

    // === Шаг 7: Функция с Unit ===
    logEvent("Игрок вошёл в игру")

    // === Шаг 8: Сокращённая функция ===
    println(multiply(4, 5))

    // === Шаг 9: Перегрузка функций ===
    println(sum(1, 2))           // Int + Int
    println(sum(1, 2, 3))        // Int + Int + Int
    println(sum(5, 3.14))        // Int + Double
    println(sum(2.5, 10))        // Double + Int
    println(sum("Яблоко", 3))    // String + Int
    println(sum(5, "Банан"))     // Int + String

    // === Шаг 10: Анонимные функции ===
    val anonymousGreeting = fun() { println("Привет от анонимной функции!") }
    anonymousGreeting()

    val square = fun(x: Int): Int { return x * x }
    println(square(5))

    val checkAccess = fun(age: Int): Boolean {
        if (age >= 18) return true else return false
    }
    println(checkAccess(20))

    // === Шаг 11: Лямбда-выражения ===
    val hello = { println("hello") }
    hello()
    hello()

    val greet = { name: String -> println("Привет, $name!") }
    greet("Alice")

    val add = { a: Int, b: Int -> a + b }
    val result = add(3, 7)
    println(result)

    // === Шаг 12: Функции высшего порядка ===
    applyEffect { println("Здоровье восстановлено!") }

    onEnemyDefeated { exp -> println("Получено опыта: $exp") }

    // === Шаг 13: Замыкания (Closures) ===
    val killCounter = createCounter()
    println(killCounter()) // 1
    println(killCounter()) // 2
    println(killCounter()) // 3

    // === Шаг 14: Крестики-нолики ===
    ticTacToeGame()

    // === Шаг 15: Камень-Ножницы-Бумага ===
    rockPaperScissorsGame()
}

// --- Основные функции из лабораторной ---

fun greetPlayer() {
    println("Добро пожаловать в игру!")
}

fun showChatMessage(text: String) {
    println("[Чат] $text")
}

fun showPlayerInfo(name: String, health: Int) {
    println("$name | Здоровье: $health HP")
}

fun createCharacter(
    name: String,
    level: Int = 1,
    isHero: Boolean = false
) {
    val type = if (isHero) "Герой" else "Монстр"
    println("$name (Ур. $level) — $type")
}

fun createItem(
    name: String,
    rarity: String = "Обычный",
    value: Int = 10
) {
    println("Предмет: $name ($rarity), Стоимость: $value золота")
}

fun calculateDamage(baseDamage: Int, multiplier: Double): Int {
    return (baseDamage * multiplier).toInt()
}

fun logEvent(event: String) {
    println("[LOG] $event")
}

fun multiply(a: Int, b: Int) = a * b

// Перегрузка sum

fun sum(a: Int, b: Int): Int = a + b
fun sum(a: Int, b: Int, c: Int): Int = a + b + c
fun sum(a: Int, b: Double): Double = a + b
fun sum(a: Double, b: Int): Double = a + b
fun sum(name: String, count: Int): String = "$name x$count"
fun sum(count: Int, name: String): String = "Кол-во: $count, Название: $name"

// Анонимные и лямбды — уже в main

fun applyEffect(effect: () -> Unit) {
    println("Применяем эффект...")
    effect()
}

fun onEnemyDefeated(callback: (Int) -> Unit) {
    val exp = 50
    callback(exp)
}

fun createCounter(): () -> Int {
    var count = 0
    return { ++count }
}

// === Крестики-нолики ===

fun ticTacToeGame() {
    val board = Array(3) { Array(3) { ' ' } }
    var currentPlayer = 'X'
    var moves = 0

    println("\n=== Крестики-нолики: Ты(X) против Компьютера(O) ===")
    printBoard(board)

    while (true) {
        if (currentPlayer == 'X') {
            println("Твой ход! Введите строку и столбец (0, 1 или 2):")
            val row = readlnOrNull()?.toIntOrNull()
            val col = readlnOrNull()?.toIntOrNull()

            if (row == null || col == null) {
                println("Введите числовые значения.")
                continue
            }

            if (row !in 0..2 || col !in 0..2) {
                println("Неверные координаты. Повторите попытку.")
                continue
            }
            if (board[row][col] != ' ') {
                println("Ячейка уже занята. Попробуй снова.")
                continue
            }
            board[row][col] = currentPlayer
        } else {
            println("Ход компьютера:")
            val (row, col) = getComputerMove(board)
            println("Компьютер выбрал: $row $col")
            board[row][col] = currentPlayer
        }

        moves++
        printBoard(board)

        if (checkWin(board, currentPlayer)) {
            println(if (currentPlayer == 'X') "Ты победил!" else "Компьютер победил!")
            break
        } else if (moves == 9) {
            println("Ничья!")
            break
        }
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
    println("Игра окончена.\n")
}

fun printBoard(board: Array<Array<Char>>) {
    print("  ")
    for (i in board.indices) {
        print("$i ")
    }
    println()
    for (i in board.indices) {
        print("$i")
        println(board[i].joinToString(" ") { if (it == ' ') "_" else it.toString() })
    }
    println()
}

fun checkWin(board: Array<Array<Char>>, player: Char): Boolean {
    for (i in 0..2) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true
        if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true
    }
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true
    return false
}

fun getComputerMove(board: Array<Array<Char>>): Pair<Int, Int> {
    val emptyCells = mutableListOf<Pair<Int, Int>>()
    for (i in 0..2) {
        for (j in 0..2) {
            if (board[i][j] == ' ') {
                emptyCells.add(Pair(i, j))
            }
        }
    }
    return emptyCells[Random.nextInt(emptyCells.size)]
}

// === Камень-Ножницы-Бумага ===

fun rockPaperScissorsGame() {
    val options = arrayOf("Камень", "Ножницы", "Бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>): String {
    val randomIndex = (Random.nextDouble() * optionsParam.size).toInt()
    return optionsParam[randomIndex]
}

fun getUserChoice(optionsParam: Array<String>): String {
    while (true) {
        println("Выберите: ${optionsParam.contentToString()}")
        val userInput = readLine()
        if (userInput != null && userInput in optionsParam) {
            return userInput
        }
        println("Неверный ввод! Попробуйте снова.")
    }
}

fun printResult(userChoice: String, gameChoice: String) {
    println("Вы выбрали: $userChoice")
    println("Компьютер выбрал: $gameChoice")
    when {
        userChoice == gameChoice -> println("Ничья!")
        (userChoice == "Камень" && gameChoice == "Ножницы") ||
                (userChoice == "Ножницы" && gameChoice == "Бумага") ||
                (userChoice == "Бумага" && gameChoice == "Камень") -> println("Вы победили!")
        else -> println("Вы проиграли!")
    }
}