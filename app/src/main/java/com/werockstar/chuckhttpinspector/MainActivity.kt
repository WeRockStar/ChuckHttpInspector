package com.werockstar.chuckhttpinspector

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.readystatesoftware.chuck.ChuckInterceptor
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = Request.Builder()
                .url("https://api.github.com/users/werockstar")
                .build()

        btnDoHttp.setOnClickListener {
            okHttpClient().newCall(request)
                    .enqueue(object : Callback {
                        override fun onResponse(call: Call?, response: Response?) {

                        }

                        override fun onFailure(call: Call?, e: IOException?) {

                        }
                    })
        }
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(this))
                .build()
    }
}

