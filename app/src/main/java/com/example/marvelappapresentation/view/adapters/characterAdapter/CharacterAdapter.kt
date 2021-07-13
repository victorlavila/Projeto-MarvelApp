package com.example.marvelappapresentation.view.adapters.characterAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelappapresentation.R
import com.example.marvelappapresentation.data.characterModel.Result
import com.example.marvelappapresentation.domain.utils.BASE_URL
import com.example.marvelappapresentation.view.activitys.charactersFeature.HeroDetailActivity
import com.squareup.picasso.Picasso

class CharacterAdapter(private val context: Context,
                       private val characterList: List<Result>,
                       ): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_item_home,
            parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList.elementAt(position)
        Picasso.get().load(character.thumbnail.path + ".jpg").into(holder.imageHeroes)
        holder.heroesName.text = character.name
    }

    override fun getItemCount() = characterList.size

    inner class CharacterViewHolder(itemView:View):
        RecyclerView.ViewHolder(itemView){
        val imageHeroes: ImageView = itemView.findViewById(R.id.imageCharacter)
        val heroesName: TextView = itemView.findViewById(R.id.characterName)
    }
}