package com.example.appmovie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appmovie.databinding.MovieItemBinding
import model.Movie
import java.util.*


class MovieAdapter(private val mContext: Context, mList: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList: ArrayList<Movie>
    private var binding: MovieItemBinding? = null

    init {
        this.movieList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(mContext)
        binding = MovieItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemBinding.movie = movieList[position]
        val url = "http://image.tmdb.org/t/p/w500${movieList[position].posterPath}"
        Glide.with(mContext).load(url)
            .into(holder.itemBinding.posterImage)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateList(updatedList: ArrayList<Movie>) {
        movieList = updatedList
        notifyDataSetChanged()
    }

    fun getMovieAt(position: Int): Movie {
        return movieList[position]
    }

    inner class MovieViewHolder(
        val itemBinding: MovieItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root)

}