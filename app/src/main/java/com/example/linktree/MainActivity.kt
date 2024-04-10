package com.example.linktree

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ListTreeAdapter()
    }

    fun ListTreeAdapter() {
        val listTree = listOf<ModelTree>(
            ModelTree(1, "Instagram", R.drawable.ig, "https://www.instagram.com/improvetheinterface?igsh=MWxkb2FrbzZlZXIxdQ=="),
            ModelTree(2, "WhatsApp", R.drawable.wa,"https://www.whatsapp.com"),
            ModelTree(3, "Youtube", R.drawable.yt, "https://www.youtube.com"),
            ModelTree(4, "Website", R.drawable.web, "https://www.google.com")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = AdapterTree(listTree, object : AdapterTree.OnAdapterListener{
            override fun Onclick(tree: ModelTree) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tree.url))
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
    }
}


