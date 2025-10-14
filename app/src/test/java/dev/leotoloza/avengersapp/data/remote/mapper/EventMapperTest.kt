package dev.leotoloza.avengersapp.data.remote.mapper

import org.junit.Assert.assertEquals
import org.junit.Test

class EventMapperTest {
    @Test
    fun `formatMarvelDate should return a formatted date for a valid date string`() {
        val date = "2023-10-26 12:00:00"
        val expected = "26 de octubre 2023"
        assertEquals(expected, formatMarvelDate(date))
    }

    @Test
    fun `formatMarvelDate should return an empty string for a null input string`() {
        assertEquals("", formatMarvelDate(null))
    }

    @Test
    fun `formatMarvelDate should return an empty string for an empty input string`() {
        assertEquals("", formatMarvelDate(""))
    }

    @Test
    fun `formatMarvelDate should return an empty string for an incorrect date format`() {
        val date = "26-10-2023"
        assertEquals("", formatMarvelDate(date))
    }

    @Test
    fun `formatMarvelDate should return an empty string for a non-date string input`() {
        val notADate = "not-a-date"
        assertEquals("", formatMarvelDate(notADate))
    }

    @Test
    fun `formatMarvelDate should return a formatted date for a leap year date`() {
        val date = "2024-02-29 10:00:00"
        val expected = "29 de febrero 2024"
        assertEquals(expected, formatMarvelDate(date))
    }

    @Test
    fun `formatMarvelDate should return a formatted date for a date with a single digit day`() {
        val date = "2023-01-09 05:30:00"
        val expected = "9 de enero 2023"
        assertEquals(expected, formatMarvelDate(date))
    }

    @Test
    fun `formatMarvelDate should return a formatted date for a date with a single digit month`() {
        val date = "2023-08-15 12:00:00"
        val expected = "15 de agosto 2023"
        assertEquals(expected, formatMarvelDate(date))
    }

    @Test
    fun `formatMarvelDate should return an empty string for invalid date values`() {
        val date = "2023-13-40 99:99:99"
        assertEquals("", formatMarvelDate(date))
    }

    @Test
    fun `formatMarvelDate should return an empty string for a date string with extra whitespace`() {
        val date = " 2023-10-26 12:00:00 "
        assertEquals("", formatMarvelDate(date))
    }
}
