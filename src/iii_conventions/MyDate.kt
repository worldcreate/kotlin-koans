package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int =
        when {
            this.year != other.year -> this.year - other.year
            this.month != other.month -> this.month - other.month
            else -> this.dayOfMonth - other.dayOfMonth
        }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate> {
    override fun contains(value: MyDate): Boolean =
        start <= value && value <= endInclusive
}
