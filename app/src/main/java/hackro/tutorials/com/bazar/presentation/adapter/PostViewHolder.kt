package com.reservamos.viajes.presentation.adapter.providersDetail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import hackro.tutorials.com.bazar.R
import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.presentation.PresenterMain
import android.graphics.Typeface
import android.util.Log
import hackro.tutorials.com.bazar.presentation.Utils


internal class PostViewHolder(view: View, private val presenter: PresenterMain) : RecyclerView.ViewHolder(view) {

    private  var product : ImageView
    private  var datePost : TextView
    private  var txtTitle : TextView
    //private  var txtDescription : TextView
    private  var txtPrice : TextView
    private var utils : Utils

    init {
        utils = Utils()
        product= itemView.findViewById(R.id.icon_product)
        datePost = itemView.findViewById(R.id.txt_date)
        txtTitle = itemView.findViewById(R.id.txt_title)
        txtPrice = itemView.findViewById(R.id.txt_price)
        //txtDescription = itemView.findViewById(R.id.txt_description)
    }

    fun render(dataItem: DataItem) {
        renderMainPhoto(dataItem.fullPicture)
        renderCreatedTime(dataItem.createdTime!!)
        renderName(dataItem.name)
        if(dataItem.message!=null){
            renderTitle(utils.getTitle(dataItem.message!!))
            renderPrice(utils.getPrice(dataItem.message))
            renderLocalitation(utils.getLocalitation(dataItem.message))
            renderDescription(utils.getDescription(dataItem.message))
        }

    }

    private fun renderLocalitation(localitation: String) {}

    private fun renderPrice(price: String) {

        txtPrice.text = price
    }

    private fun renderTitle(title: String) {
        Log.e("titlos:",title)
        txtTitle.text = title
    }

    private fun renderDescription(description: String?) {
        //txtDescription.text = description
    }

    private fun renderName(name: String?) {txtTitle.text = name}

    private fun renderCreatedTime(createdTime: String) {
        datePost.text = utils.formatDate(createdTime)
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


}