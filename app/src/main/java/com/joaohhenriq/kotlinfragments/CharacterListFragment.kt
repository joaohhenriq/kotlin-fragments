package com.joaohhenriq.kotlinfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_list.view.*

class CharacterListFragment : Fragment() {

    private lateinit var names: Array<String>
    private lateinit var descriptions: Array<String>
    private lateinit var images: IntArray

    companion object {
        fun newInstance() = CharacterListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val activity = activity as Context
        val recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CharacterListAdapter()

        return view
    }

    internal inner class CharacterListAdapter: RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
            )

        override fun getItemCount() = names.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val character = CharacterModel(
                names[position],
                descriptions[position],
                images[position]
            )
            holder.bind(character)
        }
    }

    internal inner class ViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(character: CharacterModel) {
            with(itemView) {
                itemView.list_img.setImageResource(character.imageResId)
                itemView.list_name.text = character.name
            }
        }
    }

}