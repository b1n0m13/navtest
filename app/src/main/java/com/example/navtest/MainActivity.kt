package com.example.navtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        push_button.setOnClickListener {
            val fragment = MyFragment.newInstance(counter++)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        pop_button.setOnClickListener {
            supportFragmentManager.popBackStack()
        }

        replace_button.setOnClickListener {
            val fragment = MyFragment.newInstance(counter++)

            supportFragmentManager.popBackStack()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }
    }
}