package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URl="https://rickandmortyapi.com/api/"
class MainActivity : AppCompatActivity() {
    lateinit var image:ImageView
    lateinit var name:TextView
    lateinit var gender:TextView
    lateinit var status:TextView
    lateinit var location:TextView
    lateinit var species:TextView

    val viewmodel:SharedViewModel by lazy {
        ViewModelProvider(this)[SharedViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image=findViewById(R.id.charater_img)
        name=findViewById(R.id.character_name)
        gender=findViewById(R.id.character_gender)
        status=findViewById(R.id.character_alive)
        location=findViewById(R.id.character_location)
        species=findViewById(R.id.character_species)
        getPosts()
    }

    private fun getPosts() {
        viewmodel.refresh(1)

        viewmodel.characterliveData.observe(this){response->
            if (response == null){
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_SHORT).show()
                return@observe
            }
            Picasso.get().load(response.image).into(image)
            name.text=response.name
            gender.text=response.gender
            status.text=response.status
            location.text=response.location.name
            species.text=response.species
        }
    }
}