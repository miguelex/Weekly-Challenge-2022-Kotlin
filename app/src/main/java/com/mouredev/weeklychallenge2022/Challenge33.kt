package com.mouredev.weeklychallenge2022

/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(chineseSexagenarianCycle(1975))
    println(chineseSexagenarianCycle(1984))
    println(chineseSexagenarianCycle(1949))
}

private fun chineseSexagenarianCycle(year: Int): Pair<String, String> {

    val animals = listOf("Rat", "Ox", "Tigger", "Rabbit", "Dragon", "Snake", "Horse",
                         "Sheep","Monkey", "Rooster", "Dog", "Pig")
    val elements = listOf("Wood", "Fire", "Earth", "Metal", "Water")

    val cycle = (year % 60)

    var indexOfElements = ((cycle - 4) / 2) % 5
    var indexOfAnimals = (cycle - 4) % 12

    return Pair(elements[indexOfElements], animals[indexOfAnimals])
}