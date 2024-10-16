package com.example.bmiviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {

    private val _height = MutableLiveData("")
    private val _weight = MutableLiveData("")
    private val _bmi = MutableLiveData("")

    val height: LiveData<String> = _height
    val weight: LiveData<String> = _weight
    val bmi: LiveData<String> = _bmi

    fun updateHeight(newHeight: String) {
        _height.value = newHeight
        calculateBMI()
    }

    fun updateWeight(newWeight: String) {
        _weight.value = newWeight
        calculateBMI()
    }

    private fun calculateBMI() {
        val h = _height.value?.toFloatOrNull()
        val w = _weight.value?.toFloatOrNull()

        if (h != null && w != null && h > 0) {
            val bmiValue = w / (h * h)
            _bmi.value = String.format("%.2f", bmiValue)
        } else {
            _bmi.value = ""
        }
    }
}
