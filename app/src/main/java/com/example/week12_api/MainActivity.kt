package com.example.week12_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week12_api.model.Hero
import com.example.week12_api.databinding.ActivityMainBinding
import com.example.week12_api.model.Users
import com.example.week12_api.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val itemlist = ArrayList<Hero>()

        response.enqueue(object : retrofit2.Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                for (i in response.body()!!.result!!){
                    itemlist.add(Hero(i?.image,i?.id,i?.title))
                }
                val adapter = UsersAdapter(itemlist)

                with(binding) {
                    lvNama.adapter = adapter
                    lvNama.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi Error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}