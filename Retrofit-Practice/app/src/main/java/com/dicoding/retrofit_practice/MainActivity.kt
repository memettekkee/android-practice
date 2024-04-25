package com.dicoding.retrofit_practice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.retrofit_practice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val baseUrl = "https://jsonplaceholder.typicode.com/"

    var postsList = ArrayList<Response>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showPosts()
    }

    fun showPosts(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI : Api = retrofit.create(Api::class.java)

        val call : Call<List<Response>> = retrofitAPI.getAllPosts()

        call.enqueue(object : Callback<List<Response>>{
            override fun onResponse(
                call: Call<List<Response>>,
                response: retrofit2.Response<List<Response>>
            ) {
                if(!response.isSuccessful){
                    binding.User.text = "error"
                    binding.Id.text = "error"
                    binding.Title.text = "error"
                    binding.Body.text = "error"
                }

                postsList = response.body() as ArrayList<Response>

                binding.User.text = postsList[0].userId.toString()
                binding.Id.text = postsList[0].id.toString()
                binding.Title.text = postsList[0].title
                binding.Body.text = postsList[0].body
            }
            override fun onFailure(call: Call<List<Response>>, t: Throwable) {
                Toast.makeText(applicationContext,t.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        })
    }
}