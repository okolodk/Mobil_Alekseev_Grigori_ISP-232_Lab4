fun main() {
    //Задание 1
//    showGameLogo()
//    showGameLogo()

    //Задание 2
//    showEnemy("Гоблин", 22)
//    showEnemy("Орк", 45)

    //Задание 3
//    spawnEnemy("гоблин")
//    spawnEnemy("Вождь гоблинов", isBoss = true)

    //Задание 4
//    spawnEnemy("Гоблин", 300)
//    spawnEnemy("Король Тьмы", 500, true)

    //Задание 5
//    createQuest("Найти кота")
//    createQuest("Спасти принцессу",100, true)

//Задание 6
//    print(calculateXP(5))

//Задание 7
//    println(checkInventory("Меч"))
//    println(checkInventory("Зелье"))
}
//Задание 1
fun showGameLogo() {
    println("=== EPIC QUEST ===")
}
//Задание 2
fun showEnemy(name: String, level: Int) {
    println("Враг: ${name} (Уровень: ${level})")
}
//Задание 3, 4
fun spawnEnemy(name: String, health: Int = 100, isBoss: Boolean = false) {
    println("Враг: $name (Здоровье: $health HP) ${if (isBoss)  "БОСС!" else ""}")
}
//Задание 5
fun createQuest(title: String, reward: Int = 50, isMain: Boolean = false) {
    println("Квест: ${title} (Награда: ${reward} золота)${if (isMain) " | ОСНОВНОЙ" else ""}")
}
//Задание 6
fun  calculateXP(level: Int): Int {
    return 1000 * level
}
//Задание 7
fun checkInventory(item: String): Boolean {
    val items = arrayOf("Меч", "Посох", "Лук")
    if (item in items) {return true}
    else {return  false}
}
//Задание 8
fun castSpell() { println("Каст случайного заклинания!")}
fun castSpell(spell: String) { println("Каст заклинания $spell!") }
fun castSpell(spell: String, power: Int) {println( "Каст $spell с силой $power!")}

