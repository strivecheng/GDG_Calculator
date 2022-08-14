package com.example.gdg_calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author strivexing
 * @date 2022/8/8 22:50
 * @description
 */
class MainViewModel : ViewModel() {
    val showText: MutableStateFlow<String> = MutableStateFlow("")
    val showThemeDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val number1: MutableStateFlow<Int> = MutableStateFlow(0)
    private val number2: MutableStateFlow<Int> = MutableStateFlow(0)
    private val opt: MutableStateFlow<String> = MutableStateFlow("")
    private val isCalculate: MutableStateFlow<Boolean> = MutableStateFlow(false)

    fun update(s: String) {
        when (s) {
            "AC" -> {
                showText.value = ""
                number1.value = 0
                number2.value = 0
                opt.value = ""
                isCalculate.value = false
            }
            in arrayOf("+", "—", "x", "÷") -> {
                showText.value = showText.value + s
                opt.value = s
                isCalculate.value = true
            }
            in "1".."9" -> {
                if (isCalculate.value) {
                    number2.value = s.toInt()
                    showText.value = number1.value.toString() + opt.value + number2.value
                } else {
                    number1.value = (number1.value.toString() + s).toInt()
                    showText.value = number1.value.toString()
                }

            }
            "=" -> {
                when (opt.value) {
                    "+" -> {
                        showText.value = (number1.value + number2.value).toString()
                    }
                    "—" -> {
                        showText.value = (number1.value - number2.value).toString()
                    }
                    "x" -> {
                        showText.value = (number1.value * number2.value).toString()
                    }
                    "÷" -> {
                        showText.value = (number1.value / number2.value).toString()
                    }
                }
                number1.value = 0
                number2.value = 0
                opt.value = ""
                isCalculate.value = false
            }
        }
    }
}