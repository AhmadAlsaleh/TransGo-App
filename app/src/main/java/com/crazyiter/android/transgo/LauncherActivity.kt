package com.crazyiter.android.transgo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LauncherActivity : AppCompatActivity() {

    private val IS_FIRST = "isFirst"
    private val TIPS = "tips"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        Handler().postDelayed({
            setupApp()
        }, 2000)

    }

    private fun setupApp() {
        val sharedPreferences = getSharedPreferences(TIPS, Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean(IS_FIRST, true)) {
            goToTips()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }

    private fun goToTips() {
        val sharedPreferencesEditor = getSharedPreferences(TIPS, Context.MODE_PRIVATE).edit()
        sharedPreferencesEditor.putBoolean(IS_FIRST, false)
        sharedPreferencesEditor.apply()
        startActivity(Intent(this, TipsActivity::class.java))
    }

}
