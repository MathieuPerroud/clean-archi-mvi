package com.bookandgo.domain.space

import com.bookandgo.domain.booking.Booking

open class Space(open val name:String, open val bookings:List<Booking>)