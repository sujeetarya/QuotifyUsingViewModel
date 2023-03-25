package com.example.quotifyusingviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, MainVMFactory(applicationContext)).get(MainViewModel::class.java)

        val tvQuote = findViewById<TextView>(R.id.tvQuote)
        val tvAuthor = findViewById<TextView>(R.id.tvAuthor)

        val tvPrevious = findViewById<TextView>(R.id.tvPrevious)
        val tvNext = findViewById<TextView>(R.id.tvNext)

        tvQuote.text = mainViewModel.getQuote().text
        tvAuthor.text = mainViewModel.getQuote().author

        tvPrevious.setOnClickListener {
            val previousQuote = mainViewModel.previousQuote()

            tvQuote.text = previousQuote.text
            tvAuthor.text = previousQuote.author
        }

        tvNext.setOnClickListener {
            val nextQuote = mainViewModel.nextQuote()

            tvQuote.text = nextQuote.text
            tvAuthor.text = nextQuote.author
        }

    }
}