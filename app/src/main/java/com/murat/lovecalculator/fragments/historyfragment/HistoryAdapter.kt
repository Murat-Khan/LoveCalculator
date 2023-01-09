package com.murat.lovecalculator.fragments.historyfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murat.lovecalculator.databinding.HistoryItemBinding
import com.murat.lovecalculator.remote.LoveModel

class HistoryAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    private val loveModel = arrayListOf<LoveModel>()




    fun addAll(list : ArrayList<LoveModel>){
        this.loveModel.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
       return HistoryHolder(HistoryItemBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false))
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.onBind(loveModel[position])
    }

    override fun getItemCount(): Int {
       return loveModel.size
    }

   inner class HistoryHolder(private val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(model: LoveModel) {
            binding.percentage.text = model.percentage
            binding.tvFirstName.text = model.fistName
            binding.tvSecondName.text = model.secondName
            binding.root.setOnClickListener {
                listener.onItemClick(model)

            }



        }

    }

    interface OnItemClickListener{
        fun onItemClick(model: LoveModel)


    }
}