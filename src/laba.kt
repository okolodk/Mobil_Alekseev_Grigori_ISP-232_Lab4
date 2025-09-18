fun main() {
    //Задание 1
//    showGameLogo()
//    showGameLogo()

    //Задание 2
//    showEnemy("Гоблин", 22)
//    showEnemy("Орк", 45)

    //Задание 3
//    spawnEnemy("гоблин")
//    spawnEnemy("Вождь гоблинов", 200,true)

}
//Задание 1
fun showGameLogo() {
    println("=== EPIC QUEST ===")
}
//Задание 2
fun showEnemy(name: String, level: Int) {
    println("Враг: ${name} (Уровень: ${level})")
}
//Задание 3
fun spawnEnemy(name: String, health: Int = 100, isBoss:
Boolean = false) {
    println("Враг: $name (Здоровье: $health HP) ${if (isBoss)  "БОСС!" else ""}")
}