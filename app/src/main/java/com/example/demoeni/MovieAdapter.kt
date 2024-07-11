package com.example.demoeni

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Movie(var id: Int = -1, var title: String = "") {
}

class MovieAdapter(context: Context, movies: List<Movie>) :
    ArrayAdapter<Movie>(context, 0, movies) {

    // Surcharger comment on affiche un element dans la liste
    // Param 1 -> position : quel est l'index du film dans liste de Film (dans la donnée, dans le List<Movie>)
    // on aura besoin de la position pour retrouver la film associer à la cellule/ligne
    // Param 2 -> convertView : Notre cellule designé (sauf qu'il faut le caster pour l'exploiter
    // Param 3 -> parent : La ListView (comme le ul en html)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 1 :: Retrouver notre cellule xml donc le list_item_movie.xml
        // itemView deviens notre cellule xml
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)
        }

        // 2 :: Retrouver l'instance Film associé à la cellule (get par l'index d'une List<Movie>)
        val movie = getItem(position);

        // 3 :: Alimenter la textview qui contient le titr du film par rapport à mon film
        // -- récupérer le TextView
        val titleTextView = itemView!!.findViewById<TextView>(R.id.tvMovieTitle)
        // -- changer le texte du TextView
        titleTextView.text = movie?.title

        return itemView
    }
}