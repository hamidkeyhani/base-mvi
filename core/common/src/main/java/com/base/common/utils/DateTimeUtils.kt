package com.base.common.utils

import android.os.Build
import android.text.format.DateUtils
import androidx.annotation.RequiresApi
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toKotlinLocalDateTime
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.abs


object DateTimeUtils {

    fun createDateString(year: Int, month: Int, day: Int): String {
        return "${if (month + 1 < 10) "0${month + 1}" else (month + 1)}" +
                "${if (day < 10) "0$day" else day}" +
                year.toString()
    }

    fun timeStampToSimpleTimeFormat(longTimeStamp: Long): String {
        val seconds = abs(longTimeStamp / 1000)
        return String.format(
            "%02d:%02d",
            seconds % 3600 / 60,
            seconds % 60
        )
    }

    // input format is 02252023 monthDayYear
    fun isDateGreaterThanToday(date: String): Boolean {
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())

        val inputDate = convertPureDateToSlashDateFormat(date)
        val todayDate = sdf.format(Date())
        val firstDate: Date = sdf.parse(inputDate) as Date
        val secondDate: Date = sdf.parse(todayDate) as Date

        val cmp = firstDate.compareTo(secondDate)
        return when {
            cmp > 0 -> {
                true
            }

            cmp < 0 -> {
                false
            }

            else -> {
                false
            }
        }
    }

    //convert 02112023 to 02/11/2023
    private fun convertPureDateToSlashDateFormat(pureDate: String): String {
        return try {
            val month = pureDate.substring(0, 2)
            val day = pureDate.substring(2, 4)
            val year = pureDate.substring(4, 8)
            "$month/$day/$year"
        } catch (e: Exception) {
            return pureDate
        }
    }

    //convert 02112023 to 2023-02-20
    fun convertPureDateToDashDateFormat(pureDate: String): String {
        return try {
            val day = pureDate.substring(0, 2)
            val month = pureDate.substring(2, 4)
            val year = pureDate.substring(4, 8)
            "$year-$month-$day"
        } catch (e: Exception) {
            return pureDate
        }
    }

    //convert 2018-02-09T00:00:00Z to 09/02/2018
    fun isoToDmy(date: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            isoToDmyApi26(date)
        } else {
            isoToDmyBelow26(date)
        }
    }

    //convert 2018-02-09T00:00:00Z to 09/02/2018
    @RequiresApi(Build.VERSION_CODES.O)
    private fun isoToDmyApi26(isoDate: String): String {
        val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
        val outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        val utcDateTime = ZonedDateTime.parse(isoDate, inputFormatter.withZone(ZoneOffset.UTC))
        val localDateTime =
            utcDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime()

        return outputFormatter.format(localDateTime)
    }

    //convert 2018-02-09T00:00:00Z to 09/02/2018
    private fun isoToDmyBelow26(isoDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")

        val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)

        val date = inputFormat.parse(isoDate)

        return outputFormat.format(date)
    }


    // convert 2023-01-23T11:39:23 to 23/01/2023
    fun convertStandardDateToDashDateFormat(standardDate: String): String {
        return try {
            val x1 = standardDate.substringBefore("T")
            val x2 = x1.split("-")
            x2.let {
                "${it[2]}/${it[1]}/${it[0]}"
            }
        } catch (e: Exception) {
            return "Unknown date"
        }
    }

    // convert 1801 to 30:01
    fun convertMillisecondToMinSec(millisecond: Long): String {
        return DateUtils.formatElapsedTime(millisecond / 1000)
    }

    //convert 23/03/2023 to 2023-03-23T00:00:00.000Z (Both API +26 and -26)
    fun convertDateToIso8601(date: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            convertDateToIso8601Api26(date)
        } else {
            convertDateToIso8601Api21(date)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun convertDateToIso8601Api26(date: String): String {
        return try {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            val formattedDate = java.time.LocalDate.parse(date, formatter)
            formattedDate.atStartOfDay().toString() + ":00.000Z"
        } catch (e: Exception) {
            date
        }
    }

    private fun convertDateToIso8601Api21(date: String): String {
        return try {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val parsedDate = formatter.parse(date)
            val calendar = Calendar.getInstance()
            if (parsedDate != null) {
                calendar.time = parsedDate
            }
            val timeZone = TimeZone.getTimeZone("UTC")
            val isoFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            isoFormatter.timeZone = timeZone
            isoFormatter.format(calendar.time)
        } catch (e: Exception) {
            date
        }
    }


    fun toDayMonthYearFormat(localDate: LocalDate): String {
        val day = localDate.dayOfMonth
        val month = localDate.monthNumber
        val year = localDate.year
        return String.format("%02d", day) +
                "/" +
                String.format("%02d", month) +
                "/$year"
    }

    fun convertLocalDateToIsoString(localDate: LocalDate): String {
        val timeZone = TimeZone.getTimeZone("UTC")
        val isoFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        isoFormatter.timeZone = timeZone
       return isoFormatter.format(localDate)
    }

    //convert YYYY-MM-DDTHH:mm:ss.sssZ to LocalDate
    fun dayMonthYearToLocalDate(date: String): LocalDate {
        return LocalDate.parse(date)
    }

    // convert 2023-01-23T11:39:23 to LocalDate
    fun convertStandardDateToLocalDate(standardDate: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+00:00")
        val dateTime = LocalDateTime.parse(standardDate, formatter)
        return dateTime.toKotlinLocalDateTime().date
    }
}