package com.example.biobasket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CategoryRecycleAdapter(private val categoryItem : ArrayList<CategoryItem>,private val listener : CategoryClicked) : RecyclerView.Adapter<CategoryRecycleAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.categoryItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       holder.imageView.setImageResource(categoryItem[position].getImage())
        holder.imageView.setOnClickListener { listener.onCategoryClicked(position) }
    }

    override fun getItemCount(): Int {
       return categoryItem.size
    }
}

interface CategoryClicked{
    fun onCategoryClicked(item : Int)
}