package com.example.devopsapplicatioin.presenter.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.devopsapplicatioin.data.remote.model.mainItems
import com.example.devopsapplicatioin.databinding.AdapterMainitemBinding


class maintItemAdapter (private val fragment: Fragment): RecyclerView.Adapter<maintItemAdapter.ViewHolder>(){
    private var mainItems:List<mainItems> = listOf()
    private var itemWidth: Int = 0
    private var selectedItem = RecyclerView.NO_POSITION

    class ViewHolder(view: AdapterMainitemBinding): RecyclerView.ViewHolder(view.root){
        val name = view.txtMaintitemName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:AdapterMainitemBinding = AdapterMainitemBinding.inflate(LayoutInflater.from(fragment.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mainItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items= mainItems[position]
        holder.name.text= items.name

        val layoutParams = holder.itemView.layoutParams
        layoutParams.width = itemWidth
        holder.itemView.layoutParams = layoutParams

        holder.itemView.setOnClickListener{
            if(fragment is HomeFragment){
               // fragment.changeItems(items)
            }
        }
    }

    fun showMainItems(list:List<mainItems>){
        mainItems= list
        notifyDataSetChanged()
    }

    fun setItemWidth(width: Int) {
        this.itemWidth = width
        notifyDataSetChanged()
    }
}