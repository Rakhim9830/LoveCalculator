package com.example.lovecalculator.Board


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.BoardItemBinding

class Adapter (private val onClick:() -> Unit): RecyclerView.Adapter<Adapter.OnBoardingViewHolder>() {
    private val data = arrayListOf(
          com.example.lovecalculator.Board.Model("HAVE A GOOD TIME","you should take the time to help those who need you", R.drawable.imagefirst),
          com.example.lovecalculator.Board.Model("CHERISHING LOVE","It is now no longer possible for ypu tp cherish love ", R.drawable.imagesecond),
          com.example.lovecalculator.Board.Model("HAVE A BREAK UP?","We have made to correction for you dont worry, Maybe someone is waiting for you!", R.drawable.imagethird),
          com.example.lovecalculator.Board.Model("","Its Funs And Many More", R.drawable.love),


    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(BoardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding:BoardItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(model: com.example.lovecalculator.Board.Model) {
            binding.titleBoard.text = model.title
            binding.descBoard.text = model.decs
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
        }

    }


}