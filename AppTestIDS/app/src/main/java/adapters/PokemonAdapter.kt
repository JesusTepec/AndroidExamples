package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apptest.databinding.PokemonItemBinding
import model.Pokemon
import java.util.*


class PokemonAdapter(private val mContext: Context, mList: ArrayList<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.MovieViewHolder>() {

    private var pokemonList: ArrayList<Pokemon>
    private var binding: PokemonItemBinding? = null

    init {
        this.pokemonList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(mContext)
        binding = PokemonItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemBinding.txtName.text = pokemonList[position].name
        Glide.with(mContext).load(pokemonList[position].url)
            .into(holder.itemBinding.imgPokemon)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updateList(updatedList: ArrayList<Pokemon>) {
        pokemonList = updatedList
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(
        val itemBinding: PokemonItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root)

}