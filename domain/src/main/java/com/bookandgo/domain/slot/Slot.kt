package com.bookandgo.domain.slot

open class Slot(open val hours: Int, open val minutes: Int){
    override fun toString()=
        if (minutes == 0) {
            "${hours}:00"
        } else {
            "${hours}:${minutes}"
        }

}