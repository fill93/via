package com.via.teste.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.extMoneyStr() : String {
    var df = DecimalFormat("¤ #,##0.00;-¤ #")
    //df.minimumFractionDigits = 2
    //df.maximumFractionDigits = 2
    df.decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.getDefault())
    return df.format(this) ?: df.format(0.00)
}