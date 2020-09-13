package com.example.z4project.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import com.example.z4project.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
        val gotoFavgment:Intent = Intent(MainActivity.this,FavoriteScrollingFragment.class)

        }
       }*/

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        val view:View? = super.onCreateView(parent, name, context, attrs)
        val favbtn:FloatingActionButton = view!!.findViewById(R.id.floatingActionButton)
        favbtn.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FavoriteScrollingFragment())
            .commitNow()
    }
}