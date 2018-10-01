package com.mobile.app.aacexample.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.mobile.app.aacexample.R
import com.mobile.app.aacexample.util.consume
import com.mobile.app.aacexample.util.inTransaction
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var frag : MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            consume { replaceFragment(frag) }
        }
    }

    private fun <F> replaceFragment(fragment : F) where F : Fragment {
        supportFragmentManager.inTransaction {
            replace(contentFrame?.id?:return,fragment)
        }
    }
}
