package com.reservamos.viajes.presentation.adapter.providersDetail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.presentation.PresenterMain



internal class PostViewHolder(view: View, private val presenter: PresenterMain) : RecyclerView.ViewHolder(view) {

    //private  var product : ImageView

    init {
       // product= itemView.findViewById(R.id.icon_product)

    }

    fun render(dataItem: DataItem) {
        renderMainPhoto(dataItem.fullPicture)
    }

    private fun renderMainPhoto(fullPicture: String?) {

        //Glide.with(getContext())
          //      .load(fullPicture).into(product)
    }

    private fun getContext(): Context {
        return itemView.context
    }


}