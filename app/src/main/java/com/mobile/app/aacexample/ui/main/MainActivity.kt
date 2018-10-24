package com.mobile.app.aacexample.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.mobile.app.aacexample.R
import com.mobile.app.aacexample.data.local.AppDatabase
import com.mobile.app.aacexample.util.consume
import com.mobile.app.aacexample.util.inTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            AppDatabase.getInstance(this)
            consume { replaceFragment(MainFragment.newInstance()) }
        }
    }

    private fun <F> replaceFragment(fragment : F) where F : Fragment {
        supportFragmentManager.inTransaction {
            replace(contentFrame?.id?:return,fragment)
        }
    }

}
