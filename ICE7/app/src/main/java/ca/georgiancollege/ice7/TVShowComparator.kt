package ca.georgiancollege.ice7

import androidx.recyclerview.widget.DiffUtil

class TVShowComparator: DiffUtil.ItemCallback<TVShow>()
{
    override fun areItemsTheSame(oldItem: TVShow, newItem: TVShow): Boolean
    {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TVShow, newItem: TVShow): Boolean
    {
        return oldItem == newItem
    }
}