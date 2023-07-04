package home.codelab.myroutine.domain.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

val fullFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
val diffFormat = SimpleDateFormat("yyyy лет MM месяцев dd дней HH:mm:ss")
fun String.toDateTime(): Date {
    var date: Date = try {
        fullFormat.parse(this)
    } catch (error: ParseException) {
        Date()
    }
    return date
}