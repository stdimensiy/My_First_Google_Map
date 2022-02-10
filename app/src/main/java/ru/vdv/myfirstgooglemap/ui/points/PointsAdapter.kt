package ru.vdv.myfirstgooglemap.ui.points

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.myfirstgooglemap.domain.Point

class PointsAdapter : RecyclerView.Adapter<PointViewHolder>() {
    var items: List<Point> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        return PointViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        val item = items[position]
        holder.namePoint.text = item.title
        holder.descriptionPoint.text = item.description
        holder.header.text = item.dateTime.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}