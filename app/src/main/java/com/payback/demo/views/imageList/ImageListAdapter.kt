package com.payback.demo.views.imageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.payback.demo.R
import com.payback.demo.databinding.FragmentImageDetailsBinding
import com.payback.demo.databinding.ItemImagesListBinding
import com.payback.demo.domain.ImageListItem
import com.payback.demo.views.imageDetails.ImageDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class ImagesListAdapter @Inject constructor(val clickListener: ClickListener) :
    ListAdapter<ImageListItem, ImagesListAdapter.ViewHolder>(ImagesListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemImagesListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageListItem, clickListener: ClickListener) {
            binding.data = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemImagesListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class ImagesListDiffCallback : DiffUtil.ItemCallback<ImageListItem>() {

    override fun areItemsTheSame(oldItem: ImageListItem, newItem: ImageListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageListItem, newItem: ImageListItem): Boolean {
        return oldItem == newItem
    }

}

class ClickListener @Inject constructor() {

    var onItemClick: ((ImageListItem) -> Unit)? = null

    fun onClick(data: ImageListItem) {
        onItemClick?.invoke(data)
    }
}