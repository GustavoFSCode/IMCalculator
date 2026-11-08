package com.example.imcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class BmiCalculatorTest {
    @Test
    fun calculatesUsingKilogramsAndMeters() {
        assertEquals(22.857142857, BmiCalculator.calculate(70.0, 1.75), 0.000001)
    }

    @Test
    fun classifiesEveryBoundaryWithoutRounding() {
        val boundaries = listOf(
            18.5 to BmiCalculator.Category.NORMAL,
            25.0 to BmiCalculator.Category.OVERWEIGHT,
            30.0 to BmiCalculator.Category.OBESITY_I,
            35.0 to BmiCalculator.Category.OBESITY_II,
            40.0 to BmiCalculator.Category.OBESITY_III
        )
        val previous = listOf(
            BmiCalculator.Category.UNDERWEIGHT,
            BmiCalculator.Category.NORMAL,
            BmiCalculator.Category.OVERWEIGHT,
            BmiCalculator.Category.OBESITY_I,
            BmiCalculator.Category.OBESITY_II
        )
        boundaries.forEachIndexed { index, (boundary, category) ->
            assertEquals(previous[index], BmiCalculator.classify(boundary - 0.05))
            assertEquals(category, BmiCalculator.classify(boundary))
            assertEquals(category, BmiCalculator.classify(boundary + 0.05))
        }
    }

    @Test
    fun rejectsInvalidMeasurements() {
        listOf(0.0, -1.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY).forEach {
            assertThrows(IllegalArgumentException::class.java) { BmiCalculator.calculate(it, 1.75) }
            assertThrows(IllegalArgumentException::class.java) { BmiCalculator.calculate(70.0, it) }
            assertThrows(IllegalArgumentException::class.java) { BmiCalculator.classify(it) }
        }
        assertThrows(IllegalArgumentException::class.java) {
            BmiCalculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE)
        }
    }
}
