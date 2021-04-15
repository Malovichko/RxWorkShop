package com.example.rxworkshop.characterScreen.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rxworkshop.R

class CharacterActivity:AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var birthYearTextView: TextView
    private lateinit var genderTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView(){
        nameTextView = findViewById(R.id.text_view_name_value)
        birthYearTextView = findViewById(R.id.text_view_birth_year)
        genderTextView = findViewById(R.id.text_view_gender)
    }

}