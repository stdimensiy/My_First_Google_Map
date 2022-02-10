package ru.vdv.myfirstgooglemap.ui.points

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myfirstgooglemap.databinding.ItemListPointsBinding

class PointViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemListPointsBinding = ItemListPointsBinding.inflate(
        li,
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {
    var itemFrame = binding.itemFrame
    var cardView = binding.cardView
    var imagePoint = binding.ivPoint
    var header = binding.tvItemHeader
    var namePoint = binding.tvPointName
    var descriptionPoint = binding.tvPointDescription
}