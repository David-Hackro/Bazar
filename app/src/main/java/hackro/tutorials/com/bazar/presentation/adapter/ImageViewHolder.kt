package com.reservamos.viajes.presentation.adapter.providersDetail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import hackro.tutorials.com.bazar.R
import hackro.tutorials.com.bazar.presentation.presenter.PresenterDetailItem


internal class ImageViewHolder(view: View, private val presenter: PresenterDetailItem) : RecyclerView.ViewHolder(view) {

    private  var product : ImageView


    init {
        product= itemView.findViewById(R.id.icon_product)
    }

    fun render(url: String) {
        onItemOnClick(url)
        renderMainPhoto(url)
    }


    private fun renderMainPhoto(fullPicture: String?) {
        if(fullPicture == null || fullPicture.equals("")){
            Glide.with(getContext())
                    .load(R.mipmap.no_available_image)
                    .into(product)
        }else{
            Glide.with(getContext())
                    .load(fullPicture)
                    .into(product)
        }
    }

    private fun getContext(): Context {
        return itemView.context
    }

    private fun onItemOnClick(dataItem: String) {
        itemView.setOnClickListener { presenter.onItemOnClick(dataItem) }
    }


}