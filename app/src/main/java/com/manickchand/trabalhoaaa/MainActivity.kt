package com.manickchand.trabalhoaaa

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {

    private val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
    private val MESSAGE_SHOW = "MESSAGE_SHOW"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isToShowMessage()

        supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, HomeFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }


    private fun isToShowMessage(){
        val sharedPrefs = getSharedPreferences( SHARED_PREFS_NAME, Context.MODE_PRIVATE )

        val needsShowMessage = sharedPrefs.getBoolean(MESSAGE_SHOW, false)

        if (!needsShowMessage){

            Toast.makeText(this, "Bem-vindo ao FutebolQuiz!", Toast.LENGTH_LONG).show()

            sharedPrefs?.edit()?.apply {
                putBoolean(MESSAGE_SHOW, true)
                commit()
            }
        }

    }
}