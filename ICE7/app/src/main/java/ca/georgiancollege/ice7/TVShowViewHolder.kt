package ca.georgiancollege.ice7

import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.ice7.databinding.TextRowItemBinding

class TVShowViewHolder(private val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TVShow) {
        binding.genre.text = tvShow.genre
        binding.title.text = tvShow.title

        binding.rating.text = tvShow.rating.toString()
    }
}