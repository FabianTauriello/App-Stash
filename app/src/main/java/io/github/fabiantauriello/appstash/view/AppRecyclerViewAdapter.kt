package io.github.fabiantauriello.appstash.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.fabiantauriello.appstash.R
import io.github.fabiantauriello.appstash.model.App
import kotlinx.android.synthetic.main.app_list_item.view.*

class AppRecyclerViewAdapter(private val apps: MutableList<App>)
    : RecyclerView.Adapter<AppRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var app: App

        fun bind(app: App) {
            this.app = app
            itemView.tv_app_name.text = app.name
        }
    }

    fun updateApps(apps: List<App>) {
        this.apps.clear()
        this.apps.addAll(apps)
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = apps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(apps[position])
    }

}