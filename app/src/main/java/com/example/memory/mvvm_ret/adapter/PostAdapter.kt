package com.example.memory.mvvm_ret.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memory.mvvm_ret.R
import com.example.memory.mvvm_ret.model.Post
import kotlinx.android.synthetic.main.raw_layout.view.*

/**
 * @author user
 * @date 14.08.2021
 */
class PostAdapter: RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.raw_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.userId_txt.text = myList[position].userId.toString()
        holder.itemView.id_txt.text = myList[position].id.toString()
        holder.itemView.title_txt.text = myList[position].title
        holder.itemView.body_txt.text = myList[position].body
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>) {
        myList = newList
        notifyDataSetChanged()
    }
}