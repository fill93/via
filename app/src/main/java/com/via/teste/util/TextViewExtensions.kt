package com.via.teste.util

import android.graphics.Paint
import android.widget.TextView

fun TextView.extAddStrike() {
    paintFlags = paintFlags.or( Paint.STRIKE_THRU_TEXT_FLAG )
}

fun TextView.extRemoveStrike() {
    paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}
