package com.rajubd49.bs195.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true
    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        showFragmentOne()
        val changeFragmentButton = this.change_fragment_button
        changeFragmentButton.setOnClickListener() {
            if (isFragmentOneLoaded) {
                showFragmentTwo()
            } else {
                showFragmentOne()
            }
        }
    }

    private fun showFragmentOne () {
        val transaction = fragmentManager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    private fun showFragmentTwo () {
        val transaction = fragmentManager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }


}
