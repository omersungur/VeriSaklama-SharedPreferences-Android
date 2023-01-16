package com.omersungur.verisaklama_sharedpreferences_android

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    lateinit var textView : TextView
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.omersungur.verisaklama_sharedpreferences_android",
            MODE_PRIVATE)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)

        var storedAge = sharedPreferences.getInt("storedAge",0)
        if(storedAge == 0)
            textView.text = "Your Age: "
        else {
            textView.text = "Your Age: " + storedAge
        }

    }
    fun save (view : View) {

        val age = editText.text.toString()

        if(age.isEmpty()) // is empty ile editText içi boş mu kontrol ediyoruz. Boş ise return ile bu metoddan çıkıyoruz.
            return

        //if(!editText.text.toString().matches("".toRegex()))

        if(age.startsWith(" "))
            return

        if(age.contains(" "))
            return

        textView.text = "Your Age: " + age.toString()

        val userAge : Int = Integer.parseInt(editText.text.toString())

        sharedPreferences.edit().putInt("storedAge",userAge).apply()
    }

    fun delete (view: View) {

        var storedData = sharedPreferences.getInt("storedAge",0)

        //sharedPreferences.edit().clear().apply(); her şeyi siler.
        if(storedData != 0)
        sharedPreferences.edit().remove("storedAge").apply()
        textView.text = "Your Age: "
    }
}

