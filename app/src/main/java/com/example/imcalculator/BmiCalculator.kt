package com.example.imcalculator

object BmiCalculator {
    enum class Category {
        UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESITY_I, OBESITY_II, OBESITY_III
    }

    fun calculate(weightKg: Double, heightMeters: Double): Double {
        require(weightKg.isFinite() && weightKg > 0) { "Weight must be finite and positive" }
        require(heightMeters.isFinite() && heightMeters > 0) { "Height must be finite and positive" }
        val bmi = weightKg / (heightMeters * heightMeters)
        require(bmi.isFinite() && bmi > 0) { "Measurements produce an invalid BMI" }
        return bmi
    }

    fun classify(bmi: Double): Category {
        require(bmi.isFinite() && bmi > 0) { "BMI must be finite and positive" }
        return when {
            bmi < 18.5 -> Category.UNDERWEIGHT
            bmi < 25.0 -> Category.NORMAL
            bmi < 30.0 -> Category.OVERWEIGHT
            bmi < 35.0 -> Category.OBESITY_I
            bmi < 40.0 -> Category.OBESITY_II
            else -> Category.OBESITY_III
        }
    }
}
