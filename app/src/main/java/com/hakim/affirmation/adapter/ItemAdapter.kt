package com.hakim.affirmation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hakim.affirmation.R
import com.hakim.affirmation.model.Affirmation

class ItemAdapter {
    class ItemAdapter(
        private val context: Context,
        private val dataset: List<Affirmation>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        // Each data item is just an Affirmation object.
        class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.item_title)
        }

        /**
         * Create new views (invoked by the layout manager)
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            // create a new view
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

            return ItemViewHolder(adapterLayout)
        }

        /**
         * Replace the contents of a view (invoked by the layout manager)
         */
        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = dataset[position]
            holder.textView.text = context.resources.getString(item.stringResourceId)
        }

        /**
         * Return the size of your dataset (invoked by the layout manager)
         */
        override fun getItemCount() = dataset.size
    }
}