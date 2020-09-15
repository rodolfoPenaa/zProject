package com.example.z4project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.z4project.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity(){

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {

        }
     }
}