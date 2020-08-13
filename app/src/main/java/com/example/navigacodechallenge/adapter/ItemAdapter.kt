package com.example.navigacodechallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigacodechallenge.R
import com.example.navigacodechallenge.model.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(var itemList: List<Item>, val picasso: Picasso) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.titleTextView.text = item.title
        holder.bodyTextView.text = item.body
        if(item.image != null) {
            picasso.load(item.image.url).into(holder.imageView)
            holder.imageView.visibility = View.VISIBLE
        } else {
            holder.imageView.visibility = View.GONE
        }
        if (item.media) {
            holder.mediaIcon.visibility = View.VISIBLE
        } else {
            holder.mediaIcon.visibility = View.GONE
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.item_title

        val bodyTextView: TextView = itemView.item_body

        val imageView: ImageView = itemView.item_image

        val mediaIcon: ImageView = itemView.item_media
    }

}