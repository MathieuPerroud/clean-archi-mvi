package com.bookandgo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bookandgo.booking.list.BookingListFragment

class CustomFragmentFactory: FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {

            BookingListFragment::class.java.name -> {
                val fragment = BookingListFragment(/*
                    com.bookandgo.booking.BR.viewmodel*/)
                fragment
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}