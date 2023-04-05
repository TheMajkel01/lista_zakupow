package com.example.listazakupow

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import com.google.android.material.chip.ChipGroup
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun createCheckboxChip(text: String, chipGroup: ChipGroup) {
            val chip = Chip(chipGroup.context)
            chip.text = text
            chip.isCheckable = true
            chip.isChecked = false
            chip.setTextAppearanceResource(R.style.ChipTextAppearance)
            chipGroup.addView(chip)
        }


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

        var chipGroup1 = findViewById<ChipGroup>(R.id.chipGroup1)
        var chipGroup2 = findViewById<ChipGroup>(R.id.chipGroup2)
        var chipGroup3= findViewById<ChipGroup>(R.id.chipGroup3)

        chipGroup1.setBackgroundColor(ContextCompat.getColor(this, R.color.type1))
        chipGroup2.setBackgroundColor(ContextCompat.getColor(this, R.color.type2))
        chipGroup3.setBackgroundColor(ContextCompat.getColor(this, R.color.type3))

        findViewById<Button>(R.id.reset).setOnClickListener {
            chipGroup1.removeAllViews()
            chipGroup2.removeAllViews()
            chipGroup3.removeAllViews()
        }

        var button1 = findViewById<Button>(R.id.addButton1)
        var button2 = findViewById<Button>(R.id.addButton2)
        var button3 = findViewById<Button>(R.id.addButton3)

        var input1 = findViewById<TextView>(R.id.input1)
        var input2 = findViewById<TextView>(R.id.input2)
        var input3 = findViewById<TextView>(R.id.input3)

        button1.setOnClickListener {
            if(!input1.text.toString().isNullOrEmpty()) {
                createCheckboxChip(input1.text.toString(), chipGroup1)
            }
        }

        button2.setOnClickListener {
            if(!input2.text.toString().isNullOrEmpty()) {
                createCheckboxChip(input2.text.toString(), chipGroup2)
            }
        }

        button3.setOnClickListener {
            if(!input3.text.toString().isNullOrEmpty()) {
                createCheckboxChip(input3.text.toString(), chipGroup3)
            }
        }
    }
}