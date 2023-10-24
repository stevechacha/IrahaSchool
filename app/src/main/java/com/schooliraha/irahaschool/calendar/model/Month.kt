package com.schooliraha.irahaschool.calendar.model

import com.schooliraha.irahaschool.calendar.model.Week
import java.time.YearMonth

data class Month(
    val yearMonth: YearMonth,
    val weeks: List<Week>
)
