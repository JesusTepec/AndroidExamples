package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptest.R
import com.example.apptest.databinding.ItemMovementsBinding
import com.example.apptest.model.Movement


class MovementsAdapter(private val movementsList: ArrayList<Movement>) :
    RecyclerView.Adapter<MovementsAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovementsBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemBinding.movement = movementsList[position]
    }

    override fun getItemCount(): Int {
        return movementsList.size
    }

    inner class CustomViewHolder(
        val itemBinding: ItemMovementsBinding
    ) : RecyclerView.ViewHolder(itemBinding.root)
}