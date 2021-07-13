package com.example.marvelappapresentation.view.activitys.charactersFeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelappapresentation.R
import com.example.marvelappapresentation.data.characterModel.Result
import com.example.marvelappapresentation.databinding.ActivityHomeBinding
import com.example.marvelappapresentation.view.adapters.characterAdapter.CharacterAdapter
import com.example.marvelappapresentation.viewModel.CharacterViewModel

class HomeActivity : AppCompatActivity() {

    private val results = mutableListOf<Result>()
    private lateinit var binding: ActivityHomeBinding
    val characterViewModel by lazy { ViewModelProvider(this).get(CharacterViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val heroesAdapter = CharacterAdapter(this, results)
        binding.recyclerHome.adapter = heroesAdapter
        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerHome.layoutManager = layoutManager

        characterViewModel.listMutableCharacter.observe(this, Observer {
            it?.let { itchar ->
                results.addAll(itchar)
            }
            heroesAdapter.notifyDataSetChanged()
        })

        characterViewModel.loading.observe(this, Observer {
            if(it){
                binding.progressBar.visibility = VISIBLE
            } else{
                binding.progressBar.visibility = GONE
            }
        })

        characterViewModel.errorMessage.observe(this, Observer {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

    }
}