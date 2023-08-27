package ui

import adapters.PokemonAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptest.R
import com.example.apptest.databinding.ActivityMainBinding
import model.Pokemon
import viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PokemonAdapter

    private var pokemonList = ArrayList<Pokemon>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel(this)
        initRecyclerView()
        initData()
    }
    
    private fun initData() {
        viewModel.getPokemons().observe(this, {
            pokemonList.addAll(it)
            adapter.updateList(pokemonList)
        })
    }

    private fun initRecyclerView() {
        binding.pokemonList.layoutManager = LinearLayoutManager(this)
        adapter = PokemonAdapter(this, pokemonList)
        binding.pokemonList.adapter = adapter
    }

}