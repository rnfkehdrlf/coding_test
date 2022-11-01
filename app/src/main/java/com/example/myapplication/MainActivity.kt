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
            result = quiz007(a,b,c)
            tvResult.text = result
        }
    }

    fun quiz007(input1: String, input2: String, input3:String): String{

        val m = input2.toInt()
        val n = input1.toInt()
        var list = ArrayList<Int>()
        var count = 0

        var st = StringTokenizer(input3)
        for (token in st) {
            list.add(token.toString().toInt())
        }

        list.sort()
        var i = 0
        var j = list.size -1
        while (i < j) {
            if (list[i] + list[j] > m) {
                j--
            } else if (list[i] + list[j] < m) {
                i++
            } else {
                count++
                i++
                j--
            }
        }
        return count.toString()
    }
}