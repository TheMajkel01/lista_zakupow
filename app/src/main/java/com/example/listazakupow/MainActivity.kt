package com.example.listazakupow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addProduct = findViewById<LinearLayout>(R.id.add)
        var productList = findViewById<LinearLayout>(R.id.list)
        
        var radioGroup = findViewById<RadioGroup>(R.id.choiceGroup)

        addProduct.visibility = View.GONE
        productList.visibility = View.GONE

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton -> {
                    productList.visibility = View.GONE
                    addProduct.visibility = View.VISIBLE
                }
                R.id.radioButton2 -> {
                    addProduct.visibility = View.GONE
                    productList.visibility = View.VISIBLE
                }
            }
        }
    }
}