package com.example.biobasket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

 class ItemListRecycleAdapter(private val Items : ArrayList<ListItem>,private val listener : ItemClicked) : RecyclerView.Adapter<ItemListRecycleAdapter.ItemListViewHolder>() {

    class ItemListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView : ImageView = itemView.findViewById(R.id.listItemImage)
        val cardView : CardView = itemView.findViewById(R.id.listCardView)
        val price : TextView = itemView.findViewById(R.id.priceText)
        val name : TextView = itemView.findViewById(R.id.titleText)
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
         return ItemListViewHolder(
             LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
         )
     }

     override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
         holder.cardView.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.anim_recyclerview)
         holder.imageView.setImageResource(Items[position].getImage())
         holder.price.text = "Rs. ${Items[position].getPrice()}"
         holder.name.text = Items[position].getName()
         holder.cardView.setOnClickListener { listener.onItemClicked(position)}
     }

     override fun getItemCount(): Int {
         return Items.size
     }
 }

interface ItemClicked{
    fun onItemClicked(item : Int)
}