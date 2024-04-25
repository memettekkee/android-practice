package com.dicoding.retrofit_practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.retrofit_practice.databinding.ResponseItemBinding

class Adapter(var postsList: ArrayList<Response>) : RecyclerView.Adapter<Adapter.ResponseViewHolder>() {
    inner class ResponseViewHolder(val adapterBinding: ResponseItemBinding) : RecyclerView.ViewHolder(adapterBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val binding = ResponseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResponseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        holder.adapterBinding.tvId.text = postsList[position].id.toString()
        holder.adapterBinding.tvTitle.text = postsList[position].title
        holder.adapterBinding.tvBody.text = postsList[position].body
    }
}