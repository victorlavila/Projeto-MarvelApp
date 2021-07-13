package com.example.marvelappapresentation.view.activitys.charactersFeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvelappapresentation.R
import com.example.marvelappapresentation.data.characterModel.Result
import com.example.marvelappapresentation.databinding.ActivityHeroDetailBinding
import com.example.marvelappapresentation.databinding.ActivityHomeBinding
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val detailsHeros = intent.extras

        if (detailsHeros != null){
            val hero =detailsHeros.getSerializable("HEROS") as Result
            Picasso.get().load(hero.thumbnail.path + ".jpg").into(binding.imageDetail)
            val herosName = detailsHeros.getSerializable("NAME") as Result
            binding.receiveNameDetail.text = herosName.name
            val info = detailsHeros.getSerializable("INFO") as Result
            binding.txtInformationDetail.text = info.description
        } else{
            Log.d("VICTOR", "Erro ao puxar os dados")
        }

    }
}