package com.example.listazakupow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addProduct = findViewById<LinearLayout>(R.id.add)
        var productList = findViewById<LinearLayout>(R.id.list)

        addProduct.visibility = View.GONE
        productList.visibility = View.GONE
    }
}