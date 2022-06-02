package com.red.sampleapp.feature.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.red.sampleapp.feature.popular.databinding.ItemPopularBinding
import com.red.sampleapp.feature.popular.models.MovieUI

class MovieListAdapter : PagingDataAdapter<MovieUI, MovieViewHolder>(MovieDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemPopularBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position)?.name)
    }
}

class MovieDiffCallBack : DiffUtil.ItemCallback<MovieUI>() {
    override fun areItemsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean {
        return oldItem == newItem
    }
}

class MovieViewHolder(
    private val binding: ItemPopularBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String?) {
        name?.let {
            binding.tvText.text = name
        }?:run {
            binding.tvText.text = binding.tvText.context.getString(R.string.empty)
        }
    }
}
