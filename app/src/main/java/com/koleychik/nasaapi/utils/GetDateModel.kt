package com.koleychik.nasaapi.utils

import com.koleychik.nasaapi.models.DateModel
import java.text.SimpleDateFormat
import java.util.*

class GetDateModel {

    companion object {
        fun get(time: Long? = null): DateModel {
            val formatter = SimpleDateFormat("dd-MM-yyyy")
            var date = Date()
            if (time != null) date = Date(time)
            val form = formatter.format(date)
            val arr = form.split("-")

            return DateModel(day = arr[0], month = arr[1], year = arr[2])
        }

        fun getMaxForSpinner(time: Long? = null): DateModel {
            val formatter = SimpleDateFormat("dd-MM-yyyy")
            var date = Date()
            if (time != null) date = Date(time)
            val form = formatter.format(date)
            val arr = form.split("-")

            return DateModel(day = "31", month = "12", year = arr[2])
        }

        fun get2015() = DateModel(
            "1",
            "1",
            "2015"
        )

        fun getDateModelFromString(string: String, divide: String = "-"): DateModel {
            val arr = string.split(divide)
            val year: String
            val day: String
            if (arr[0].length > 2) {
                year = arr[0]
                day = arr[2]
            } else {
                year = arr[2]
                day = arr[0]
            }
            return DateModel(day = day, month = arr[1], year = year)
        }

        private fun check31Date(month: Int, year: Int): String {
            val setMonthWith31Day = setOf(1, 3, 5, 7, 8, 10, 12)
            when {
                setMonthWith31Day.contains(month) -> "31"
                month == 2 -> {
                    return if ((year - 2016) % 4 == 0) "29"
                    else "28"
                }
                else -> return "30"
            }
            return "30"
        }

    }

}