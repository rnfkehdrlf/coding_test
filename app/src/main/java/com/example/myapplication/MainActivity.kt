package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var result = "hello world"
        val tvResult: TextView = findViewById(R.id.tv_result)
        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val input3: EditText = findViewById(R.id.input3)
        val btnResult: Button = findViewById(R.id.btn_result)
        btnResult.setOnClickListener {
            val a  = input1.text.toString()
            val b = input2.text.toString()
            val c = input3.text.toString()
            result = quiz008(a,b)
            tvResult.text = result
        }
    }

    fun quiz008(input1: String, input2: String): String{

        val n = input1.toInt()
//        val m = input2.toInt()
        var list = ArrayList<Int>()
        var count = 0

        var st = StringTokenizer(input2)
        for (token in st) {
            list.add(token.toString().toInt())
        }

        list.sort()
        for (k in list) {
            var i = 0
            var j = list.size -1
            while (i < j) {
                if (list[i] + list[j] > k) {
                    j--
                } else if (list[i] + list[j] < k) {
                    i++
                } else {
                    if (list[i] != k && list[j] != k) {
                        count++
                    }
                    break
                }
            }
        }

        return count.toString()
    }
}