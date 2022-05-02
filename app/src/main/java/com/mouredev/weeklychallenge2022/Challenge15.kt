package com.mouredev.weeklychallenge2022

import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue

/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
class DaysError: Exception()

fun main() {
    daysBetween("02/05/2022", "03/09/1975"); // 17042
    daysBetween("", "03/09/1975") // Error en el parseo
    daysBetween("02/05/2022", "3/9/1975") // Error en el formato fecha
}

fun daysBetween (dateOne: String, dateTwo: String) {

    try {
        println ("El numero de dias entre las dos fechas es de: ${countDays(dateOne, dateTwo)}");
    } catch (e:Exception){
        println ("Error en el parseo")
    } catch (e: DaysError) {
        println("Error en el formato de alguna fecha")
    }
}

private fun countDays(dateOne: String, dateTwo: String): Int{

    val pattern = SimpleDateFormat("dd/MM/yyyy");
    val regex = "^([0-9]){2}[/]([0-9]){2}[/]([0-9]){4}$".toRegex()

    if(pattern.parse(dateOne) != null &&
        pattern.parse(dateOne) != null &&
        dateOne.contains(regex) &&
        dateTwo.contains(regex)){
            return TimeUnit.DAYS.convert(pattern.parse(dateOne).time - pattern.parse(dateTwo).time, TimeUnit.MILLISECONDS).toInt().absoluteValue;
    }
    throw DaysError()
}