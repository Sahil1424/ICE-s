package ca.georgiancollege.ice6

/*
* ID-200530610
* Sahil Sahil
* ICE-6
* 16/06/2024
* */

import ca.georgiancollege.ice6.databinding.ActivityMainBinding
import java.text.DecimalFormat

class Calculator(dataBinding: ActivityMainBinding) {
    private var binding: ActivityMainBinding = dataBinding
    private var result: String
    private var currentOperand: String
    private var currentOperator: String
    private val decimalFormat = DecimalFormat("#.#####")

    init {
        result = ""
        currentOperand = ""
        currentOperator = ""
        createButtonReferences()
    }

    private fun createButtonReferences() {
        val operandButtons = arrayOf(
            binding.oneButton, binding.twoButton, binding.threeButton, binding.fourButton,
            binding.fiveButton, binding.sixButton, binding.sevenButton, binding.eightButton,
            binding.nineButton, binding.zeroButton, binding.plusMinusButton, binding.decimalButton,
            binding.deleteButton
        )

        val operatorButtons = arrayOf(
            binding.minusButton, binding.plusButton, binding.mulitplyButton, binding.divideButton,
            binding.percentButton, binding.clearButton, binding.equalsButton
        )

        operandButtons.forEach { it.setOnClickListener { operandHandler(it.tag as String) } }

        operatorButtons.forEach { it.setOnClickListener { operatorHandler(it.tag as String) } }

        binding.equalsButton.setOnClickListener { equalsHandler() }
    }

    private fun operandHandler(tag: String) {
        when (tag) {
            "." -> {
                if (!binding.resultTextView.text.contains(".")) {
                    result += if (result.isEmpty()) "0." else "."
                    binding.resultTextView.text = result
                }
            }
            "delete" -> {
                result = result.dropLast(1)
                binding.resultTextView.text = if (result.isEmpty() || result == "-") "0" else result
            }
            "plus_minus" -> {
                if (result.startsWith("-")) {
                    result = result.substring(1)
                } else {
                    if (result.isNotEmpty()) {
                        result = "-".plus(result)
                    }
                }
                binding.resultTextView.text = result
            }
            else -> {
                if (binding.resultTextView.text == "0") {
                    result = tag
                } else {
                    result += tag
                }
                binding.resultTextView.text = result
            }
        }
    }

    private fun operatorHandler(tag: String) {
        if (tag != "clear") {
            if (currentOperand.isNotEmpty()) {
                when (currentOperator) {
                    "plus" -> add()
                    "minus" -> subtract()
                    "multiply" -> multiply()
                    "divide" -> divide()
                }
            } else {
                currentOperand = binding.resultTextView.text.toString()
                result = ""
                binding.resultTextView.text = ""
            }
            currentOperator = tag
        } else {
            clear()
        }
    }

    private fun equalsHandler() {
        if (currentOperand.isNotEmpty() && result.isNotEmpty()) {
            when (currentOperator) {
                "plus" -> add()
                "minus" -> subtract()
                "multiply" -> multiply()
                "divide" -> divide()
            }
            currentOperator = ""
        }
    }

    private fun add() {
        if (currentOperand.contains(".") || result.contains(".")) {
            result = decimalFormat.format(currentOperand.toFloat() + result.toFloat())
        } else {
            result = (currentOperand.toInt() + result.toInt()).toString()
        }
        binding.resultTextView.text = result
        currentOperand = result
        result = ""
    }

    private fun subtract() {
        if (currentOperand.contains(".") || result.contains(".")) {
            result = decimalFormat.format(currentOperand.toFloat() - result.toFloat())
        } else {
            result = (currentOperand.toInt() - result.toInt()).toString()
        }
        binding.resultTextView.text = result
        currentOperand = result
        result = ""
    }

    private fun multiply() {
        if (currentOperand.contains(".") || result.contains(".")) {
            result = decimalFormat.format(currentOperand.toFloat() * result.toFloat())
        } else {
            result = (currentOperand.toInt() * result.toInt()).toString()
        }
        binding.resultTextView.text = result
        currentOperand = result
        result = ""
    }

    private fun divide() {
        if (result == "0") {
            binding.resultTextView.text = "Error"
            return
        }
        if (currentOperand.contains(".") || result.contains(".")) {
            result = decimalFormat.format(currentOperand.toFloat() / result.toFloat())
        } else {
            result = (currentOperand.toInt() / result.toInt()).toString()
        }
        binding.resultTextView.text = result
        currentOperand = result
        result = ""
    }

    private fun clear() {
        result = ""
        binding.resultTextView.text = "0"
        currentOperand = ""
        currentOperator = ""
    }
}
