package com.bookandgo.common.components.bottomsheet

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.bookandgo.common.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheet @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr)  {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<BottomSheet>
    init {

        LayoutInflater.from(context)
            .inflate(R.layout.bottom_sheet, this, true)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BottomSheet,
            0, 0
        )
    }

    fun initBehavior() {
        bottomSheetBehavior = BottomSheetBehavior.from(this@BottomSheet)
        //bottomSheetBehavior.isDraggable = true
    }
    fun setPeekHeight(peekHeight: Int) {
        bottomSheetBehavior.peekHeight = peekHeight
    }
    fun expand() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }
    fun collapse() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
    fun toggleState() {
        bottomSheetBehavior.apply {
            state = if (state == BottomSheetBehavior.STATE_EXPANDED) {
                BottomSheetBehavior.STATE_COLLAPSED
            } else {
                BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

}