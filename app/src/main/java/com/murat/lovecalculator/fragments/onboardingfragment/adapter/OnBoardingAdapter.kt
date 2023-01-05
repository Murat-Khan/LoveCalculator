package com.murat.lovecalculator.fragments.onboardingfragment.adapter



import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.murat.lovecalculator.databinding.ItemOnBoardingBinding
import com.murat.lovecalculator.fragments.onboardingfragment.model.OnBoard
import com.murat.lovecalculator.utils.loadImage


class OnBoardingAdapter : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val arrayList = arrayListOf<OnBoard>(
        OnBoard("https://st4.depositphotos.com/3369547/28342/v/450/depositphotos_283424150-stock-illustration-beautiful-woman-with-balloons-hearts.jpg","It's Funs and Many More", ""),
        OnBoard("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUbmVNBMvlsJ6VHj9M9eCSrsZiYPBTvKIU2w&usqp=CAU","Have a good time", "You should the time to help those who need you"),
        OnBoard("https://pockurl.com/img/jpg/couple.png","Cherishing love", "It is now longer possible for you to cherish love"),
        OnBoard("https://www.nicepng.com/png/full/12-120757_girl-balloon-heart-love-kid-person-balloons-svg.png","Have a breakup?", "We have made the correction for you don't worry Maybe someone is waiting for you "),
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
       return OnBoardingViewHolder(
          ItemOnBoardingBinding.inflate(
           LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
       holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int = arrayList.size

    inner class OnBoardingViewHolder(private var binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun onBind(onBoard: OnBoard){
            /* binding.btnStarted.isVisible = adapterPosition == arrayList.lastIndex
            binding.skip.isVisible = adapterPosition != arrayList.lastIndex*/
            binding.onBoardTitle.text = onBoard.title
            binding.onBoardDesc.text = onBoard.desc
            binding.onBordImage.loadImage(onBoard.image)


           /* onBoard.image?.let { binding.onBordImage.setAnimation(it) }*/

        }
        }


}