package com.dalae37.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.requestButton).setOnClickListener{RequestOn()}
    }

    private fun RequestOn(){
        var result : String = ""
        var json : JSONObject? = null
        val handler : Handler = Handler()
        Thread{
            val url = URL("http://dalae37.com:3737/key")
            println("$url")
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET
                inputStream.bufferedReader().use {
                    val response = StringBuffer()
                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    it.close()
                    result = response.toString()
                    json = JSONObject(result)
                    handler.post(Runnable {
                        findViewById<TextView>(R.id.requestText).text = json!!.getString("key")
                    })
                }
            }
        }.start()

    }
}