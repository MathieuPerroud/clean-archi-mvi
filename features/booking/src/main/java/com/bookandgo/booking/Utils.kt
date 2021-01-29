package com.bookandgo.booking

import com.bookandgo.domain.slot.Slot
import java.text.SimpleDateFormat
import java.util.*

fun checkIfBetween(
     start:Slot,
    end: Slot,
    currentHour: Int,
    currentMin: Int
) : Boolean {
    return checkIfBetween(start.hours,start.minutes,end.hours,end.minutes,currentHour,currentMin)
}

fun checkIfBetween(
    startHours: Int,
    startMin: Int,
    endHours: Int,
    endMin: Int,
    currentHour: Int,
    currentMin: Int
): Boolean {
    val string1 = if (startMin == 0) {
        "${startHours}:00"
    } else {
        "${startHours}:${startMin}"
    }
    val time1: Date = SimpleDateFormat("HH:mm").parse(string1)
    val calendar1 = Calendar.getInstance()
    calendar1.time = time1
    calendar1.add(Calendar.DATE, 1)


    val string2 = if (endMin == 0) {
        "${endHours}:00"
    } else {
        "${endHours}:${endMin}"
    }
    val time2: Date = SimpleDateFormat("HH:mm").parse(string2)
    val calendar2 = Calendar.getInstance()
    calendar2.time = time2
    calendar2.add(Calendar.DATE, 1)

    val someRandomTime = if (currentMin == 0) {
        "${currentHour}:00"
    } else {
        "${currentHour}:${currentMin}"
    }
    val d: Date = SimpleDateFormat("HH:mm").parse(someRandomTime)
    val calendar3 = Calendar.getInstance()
    calendar3.time = d
    calendar3.add(Calendar.DATE, 1)

    val x = calendar3.time
    if ((x.after(calendar1.time) && x.before(calendar2.time)) ||
        (currentMin == startMin && currentHour == startHours) ||
        (currentMin == endMin && currentHour == endHours)
    ) {
        //checkes whether the current time is between 14:49:00 and 20:11:13.
        return true
    }
    return false
}

fun getCurrentHour(): Int =
    Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

fun getCurrentMinute(): Int =
    Calendar.getInstance().get(Calendar.MINUTE)