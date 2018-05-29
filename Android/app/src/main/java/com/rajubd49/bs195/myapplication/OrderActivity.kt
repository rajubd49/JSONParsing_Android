package com.rajubd49.bs195.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.content.Intent



class OrderActivity : AppCompatActivity() {

    var quantity = 0;
    var pricePerQuantity = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
    }

    private fun displayQuantity (number: Int) {
        var quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.setText("" + number)
    }

    private fun displayPrice (number: Int) {
        var priceTextView = findViewById<TextView>(R.id.price_text_view)
        priceTextView.setText("Total $" + number)
    }

    fun minusButtonClicked(view: View) {
        if (quantity>0) {
            quantity = quantity - 1
            displayQuantity(quantity)
        }
    }

    fun plusButtonClicked(view: View) {
        quantity = quantity + 1
        displayQuantity(quantity)
    }

    fun orderButtonClicked(view: View) {
        displayPrice(quantity*pricePerQuantity)

//        val relativeLayoutActivity = Intent(this, RelativeLayoutActivity::class.java)
//        startActivity(relativeLayoutActivity)
    }

}