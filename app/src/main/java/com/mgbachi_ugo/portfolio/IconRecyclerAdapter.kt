package com.mgbachi_ugo.portfolio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.icon.view.*

class IconRecyclerAdapter(private val context: Context, private val icons: List<Icons>, private val itemClick: (Icons) -> Unit): RecyclerView.Adapter<IconRecyclerAdapter.Holder>(){

    inner class Holder(itemView: View, val itemClick: (Icons) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val iconImage: ImageView = itemView.findViewById(R.id.iconview)

        fun bindProduct(icon: Icons, context: Context){
            val resourceId = context.resources.getIdentifier(icon.iconImage, "drawable", context.packageName)
            iconImage.setImageResource(resourceId)
            itemView.setOnClickListener { itemClick(icon) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val  view = LayoutInflater.from(context).inflate(R.layout.icon, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
      return icons.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    holder.bindProduct(icons[position], context)
    }

}