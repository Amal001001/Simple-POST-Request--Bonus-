package com.example.simplepostrequestbonus

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var et: EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et = findViewById(R.id.et)
        button = findViewById(R.id.button)
        button.setOnClickListener { addName() }

    }

        fun addName() {
            val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
            if (et.text != null) {
                val progressDialog = ProgressDialog(this@MainActivity)
                progressDialog.setMessage("Please wait")
                progressDialog.show()
                apiInterface?.addName(data(et.text.toString()))!!.enqueue(object : Callback<data> {
                  override fun onResponse(call: Call<data>, response: Response<data>) {
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity, "name added", Toast.LENGTH_SHORT).show()
                  }

                  override fun onFailure(call: Call<data>, t: Throwable) {
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity, "something went wrong!", Toast.LENGTH_SHORT).show()
                  }
                })
            }
        }

}