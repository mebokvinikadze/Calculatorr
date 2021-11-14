package com.example.galgulatori

import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.text.trimmedLength
import org.w3c.dom.Text
import java.text.DecimalFormat
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    private var canAddOperation = false
    private var canAddDecimal = true

    private lateinit var resultTextView: TextView
    private lateinit var resultText: TextView

    private var operand: Double = 0.0
    private var operation: String = ""
    private var pasuxi:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      resultTextView = findViewById(R.id.input)

        resultText = findViewById(R.id.output)


    }


    fun clearClick(clickedView: View) {

        resultText.text = ""
        resultTextView.text = ""


    }



    fun numberClick(clickedView: View) {

        if (clickedView is AppCompatButton) {

            var number = clickedView.text.toString()
            val resultText = resultTextView.text.toString()

            if (number == "") {
                number = ""

            }






            resultTextView.text = resultText + number

        }






    }

    fun operationClick(clickedView: View) {

        if (clickedView is AppCompatButton) {

            this.operation = clickedView.text.toString()

            val operandText = resultTextView.text.toString()
            if (operandText.isNotEmpty()) {
                this.operand = operandText.toDouble()
            }

            resultTextView.text = ""

        }

    }

    fun equalsClick(clickedView: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toDouble()
        }


        var result = ""

        when (this.operation) {
            "+" -> result = (this.operand + secOperand).toString()
            "-" -> result = (this.operand - secOperand).toString()
            "*" -> result = (this.operand * secOperand).toString()
            "/" -> result = (this.operand / secOperand).toString()
            "x²" -> result = (this.operand * this.operand).toString()
            "√2" -> result = sqrt(this.operand).toString()

            }

        if (result.endsWith(".0")) {
            result = result.dropLast(2)
        }

        resultText.text = result

    }

    fun delClick(clickedView: View) {

        val length = resultTextView.text.trimmedLength()
        if (length > 0)
            resultTextView.text = resultTextView.text.subSequence(0, length - 1)




}


    }


