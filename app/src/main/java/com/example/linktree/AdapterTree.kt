package com.example.linktree

import android.content.Intent
import android.net.Uri
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTree(
    private val listTree : List<ModelTree>,
    private val listener : OnAdapterListener
) : RecyclerView.Adapter<AdapterTree.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameLogo : TextView = view.findViewById(R.id.textLogo)
        val logo : ImageView = view.findViewById(R.id.logo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tree = listTree[position]
        holder.nameLogo.text = tree.name
        holder.logo.setImageResource(tree.image)
        holder.itemView.setOnClickListener{
            listener.Onclick(tree)
        }
    }

    override fun getItemCount(): Int {
      return listTree.size
    }

    interface OnAdapterListener{
        fun Onclick(tree: ModelTree)
    }

}