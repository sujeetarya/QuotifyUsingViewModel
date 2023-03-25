package com.example.quotifyusingviewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.io.InputStream

class MainViewModel(val context: Context) : ViewModel() {
    var quoteList: Array<Quote> = emptyArray()
    var index = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {
        val inputStream: InputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer: ByteArray = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json: String = String(buffer, Charsets.UTF_8)
        return Gson().fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote(): Quote {
        return quoteList[index]
    }

    fun nextQuote(): Quote {
        return quoteList[++index]
    }

    fun previousQuote(): Quote {
        return quoteList[--index]
    }
}