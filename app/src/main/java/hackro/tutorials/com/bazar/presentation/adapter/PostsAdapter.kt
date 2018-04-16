package com.reservamos.viajes.presentation.adapter.providersDetail



import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import hackro.tutorials.com.bazar.R

import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.presentation.presenter.PresenterMain

open class PostsAdapter(var presenter  : PresenterMain) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var listPost: List<DataItem?>? =  emptyList()


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_card_post, parent, false)
        return PostViewHolder(view, presenter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val postViewHolder = holder as PostViewHolder
        postViewHolder.render(listPost!!.get(position)!!)
    }


    override fun getItemCount(): Int {
        return listPost!!.size
    }


      fun  addListPosts(listPost: List<DataItem?>?){
        this.listPost = listPost
        notifyDataSetChanged()
    }

}