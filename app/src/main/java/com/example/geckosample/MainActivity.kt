package com.example.geckosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.mozilla.geckoview.GeckoRuntime

class MainActivity : AppCompatActivity() {

    lateinit var geckoRuntime: GeckoRuntime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!::geckoRuntime.isInitialized) {
            geckoRuntime = GeckoRuntime.create(this)
        }

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            FirstFragment.run(supportFragmentManager)
        }
    }

}

fun MainActivity.getGeckoRuntime(): GeckoRuntime {
    return geckoRuntime
}