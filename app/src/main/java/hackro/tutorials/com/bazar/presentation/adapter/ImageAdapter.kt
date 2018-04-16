package com.reservamos.viajes.presentation.adapter.providersDetail



import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import hackro.tutorials.com.bazar.R

import hackro.tutorials.com.bazar.presentation.presenter.PresenterDetailItem

open class ImageAdapter(var presenter  : PresenterDetailItem) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var listImages: List<String?>? =  emptyList()


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view, presenter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val postViewHolder = holder as ImageViewHolder
        postViewHolder.render(listImages!!.get(position)!!)
    }


    override fun getItemCount(): Int {
        return listImages!!.size
    }


      fun  addListImages(listPost: List<String?>?){
        this.listImages = listPost
        notifyDataSetChanged()
    }

}