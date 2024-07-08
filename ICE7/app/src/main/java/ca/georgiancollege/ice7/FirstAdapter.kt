package ca.georgiancollege.ice7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.ice7.databinding.TextRowItemBinding

class FirstAdapter(private val dataSet: Array<TVShow>) :
    RecyclerView.Adapter<FirstAdapter.ViewHolder>()
{

    class ViewHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder
    {
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
    {
        viewHolder.binding.title.text = dataSet[position].title
        viewHolder.binding.genre.text = dataSet[position].genre
    }

    override fun getItemCount() = dataSet.size
}
