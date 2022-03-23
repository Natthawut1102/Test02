package com.example.test02

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import com.example.test02.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var x = ""
    var number1 = ""
    var number2 = true
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}1")
            else {
                displaylol.text = "1"
                number2 = true
            }
        }

        two.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}2")
            else {
                displaylol.text = "2"
                number2 = true
            }
        }

        three.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}3")
            else {
                displaylol.text = "3"
                number2 = true
            }
        }

        four.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}4")
            else {
                displaylol.text = "4"
                number2 = true
            }
        }

        five.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}5")
            else {
                displaylol.text = "5"
                number2 = true
            }
        }

        six.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}6")
            else {
                displaylol.text = "6"
                number2 = true
            }
        }

        seven.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}7")
            else {
                displaylol.text = "7"
                number2 = true
            }
        }

        eight.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}8")
            else {
                displaylol.text = "8"
                number2 = true
            }
        }

        nine.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}9")
            else {
                displaylol.text = "9"
                number2 = true
            }
        }

        zero.setOnClickListener {
            if (number2)
                displaylol.text = formatDecimal("${displaylol.text}0")
            else {
                displaylol.text = "0"
                number2 = true
            }
        }

        del.setOnClickListener {
            displaylol.text = displaylol.text.toString().dropLast(1).ifEmpty {"0"}
        }

        plus.setOnClickListener {
            x = "+"
            if (x != "" && number1 == "") {
                number1 = displaylol.text.toString()
            }
            if (check) {
                compute()
                number1 = displaylol.text.toString()
            }
            check = true
            number2 = false
        }

        minus.setOnClickListener {
            x = "-"
            if (x != "" && number1 == "") {
                number1 = displaylol.text.toString()
            }
            if (check) {
                compute()
                number1 = displaylol.text.toString()
            }
            check = true
            number2 = false
        }

        multiplier.setOnClickListener {
            x = "*"
            if (x != "" && number1 == "") {
                number1 = displaylol.text.toString()
            }
            if (check) {
                compute()
                number1 = displaylol.text.toString()
            }
            check = true
            number2 = false
        }

        divide.setOnClickListener {
            x = "/"
            if (x != "" && number1 == "") {
                number1 = displaylol.text.toString()
            }
            if (check) {
                compute()
                number1 = displaylol.text.toString()
            }
            check = true
            number2 = false
        }

        modulo.setOnClickListener {
            x = "%"
            if (x != "" && number1 == "") {
                number1 = displaylol.text.toString()
            }
            if (check) {
                compute()
                number1 = displaylol.text.toString()
            }
            check = true
            number2 = false
        }

        equal.setOnClickListener{
            compute ()
            x = ""
            number1 = ""
            check = false
        }

        clear.setOnClickListener {
            x = ""
            number1 = ""
            number2 = true
            displaylol.text = "0"
            check = false
        }

        dot.setOnClickListener {
            if (!displaylol.text.toString().contains(".")&& displaylol.text.toString().isNotEmpty()) {
                displaylol.text = "${displaylol.text}."
            }
        }
    }
    fun compute () {
        var number2 = displaylol.text.toString()
        if (x != "" && number2 != "") {
            if (x == "+") {
                println(number1 + number2)
                displaylol.text =
                    formatDecimal((number1.toDouble() + number2.toDouble()).toString())
            } else if (x == "-") {
                displaylol.text =
                    formatDecimal((number1.toDouble() - number2.toDouble()).toString())
            } else if (x == "*") {
                displaylol.text =
                    formatDecimal((number1.toDouble() * number2.toDouble()).toString())
            } else if (x == "/") {
                if (number2 == "0" || number2 == "") {
                    displaylol.text = "ERROR"
                    return@compute
                }
                displaylol.text =
                    formatDecimal((number1.toDouble() / number2.toDouble()).toString())
            } else if (x == "%") {
                if (number2 == "0" || number2 == "") {
                    displaylol.text = "ERROR"
                    return@compute
                }
                displaylol.text =
                    formatDecimal((number1.toDouble() % number2.toDouble()).toString())
            }
        }
    }

    private fun formatDecimal(num: String): String {
        val format = DecimalFormat("0.#######");
        return format.format(num.ifEmpty { "0" }.toDouble())
    }
}