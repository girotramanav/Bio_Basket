package com.example.biobasket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter(private val context: Context,
                    private val sliderItem: ArrayList<SliderItem>) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

         private val imageView : RoundedImageView = itemView.findViewById(R.id.imageSlide)

        fun setImage(sliderItem : SliderItem){
            imageView.setImageResource(sliderItem.getImage())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(LayoutInflater.from(context).inflate(R.layout.item_slideimage,parent,false))
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {

        holder.setImage(sliderItem[position])
    }

    override fun getItemCount(): Int {
        return sliderItem.size
    }
}