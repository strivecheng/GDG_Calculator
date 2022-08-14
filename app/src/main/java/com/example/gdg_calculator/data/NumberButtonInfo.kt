package com.example.gdg_calculator.data

/**
 * @author strivexing
 * @date 2022/8/7 22:42
 * @description
 */
data class NumberButtonInfo(
    val label: String,
    val type: KeyType
)

enum class KeyType {
    CLEAR,
    NUMBER,
    SYMBOL,
    EQUAL
}


fun getPortraitCalculatorTopData(): Array<NumberButtonInfo> = arrayOf(
    NumberButtonInfo("√", KeyType.SYMBOL),
    NumberButtonInfo("π", KeyType.SYMBOL),
    NumberButtonInfo("^", KeyType.NUMBER),
    NumberButtonInfo("!", KeyType.NUMBER),
)

fun getPortraitCalculatorData(): Array<Array<NumberButtonInfo>> = arrayOf(
    arrayOf(
        NumberButtonInfo("AC", KeyType.CLEAR),
        NumberButtonInfo("( )", KeyType.SYMBOL),
        NumberButtonInfo("%", KeyType.SYMBOL),
        NumberButtonInfo("÷", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("7", KeyType.NUMBER),
        NumberButtonInfo("8", KeyType.NUMBER),
        NumberButtonInfo("9", KeyType.NUMBER),
        NumberButtonInfo("x", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("4", KeyType.NUMBER),
        NumberButtonInfo("5", KeyType.NUMBER),
        NumberButtonInfo("6", KeyType.NUMBER),
        NumberButtonInfo("—", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("1", KeyType.NUMBER),
        NumberButtonInfo("2", KeyType.NUMBER),
        NumberButtonInfo("3", KeyType.NUMBER),
        NumberButtonInfo("+", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("0", KeyType.NUMBER),
        NumberButtonInfo(".", KeyType.NUMBER),
        NumberButtonInfo("<", KeyType.NUMBER),
        NumberButtonInfo("=", KeyType.EQUAL),
    )
)

fun getLandscapeCalculatorLeftData(): Array<Array<NumberButtonInfo>> = arrayOf(
    arrayOf(
        NumberButtonInfo("RAD", KeyType.CLEAR),
        NumberButtonInfo("√", KeyType.SYMBOL),
        NumberButtonInfo("π", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("INV", KeyType.NUMBER),
        NumberButtonInfo("^", KeyType.NUMBER),
        NumberButtonInfo("!", KeyType.NUMBER),
    ),
    arrayOf(
        NumberButtonInfo("sin", KeyType.NUMBER),
        NumberButtonInfo("cos", KeyType.NUMBER),
        NumberButtonInfo("tan", KeyType.NUMBER),
    ),
    arrayOf(
        NumberButtonInfo("e", KeyType.NUMBER),
        NumberButtonInfo("ln", KeyType.NUMBER),
        NumberButtonInfo("log", KeyType.NUMBER),
    ),
)

fun getLandscapeCalculatorRightData(): Array<Array<NumberButtonInfo>> = arrayOf(
    arrayOf(
        NumberButtonInfo("7", KeyType.NUMBER),
        NumberButtonInfo("8", KeyType.NUMBER),
        NumberButtonInfo("9", KeyType.NUMBER),
        NumberButtonInfo("÷", KeyType.SYMBOL),
        NumberButtonInfo("AC", KeyType.CLEAR),
    ),
    arrayOf(
        NumberButtonInfo("4", KeyType.NUMBER),
        NumberButtonInfo("5", KeyType.NUMBER),
        NumberButtonInfo("6", KeyType.NUMBER),
        NumberButtonInfo("x", KeyType.SYMBOL),
        NumberButtonInfo("( )", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("1", KeyType.NUMBER),
        NumberButtonInfo("2", KeyType.NUMBER),
        NumberButtonInfo("3", KeyType.NUMBER),
        NumberButtonInfo("—", KeyType.SYMBOL),
        NumberButtonInfo("%", KeyType.SYMBOL),
    ),
    arrayOf(
        NumberButtonInfo("0", KeyType.NUMBER),
        NumberButtonInfo(".", KeyType.NUMBER),
        NumberButtonInfo("<", KeyType.NUMBER),
        NumberButtonInfo("+", KeyType.SYMBOL),
        NumberButtonInfo("=", KeyType.EQUAL),
    ),
)