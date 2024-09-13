package com.example.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.databinding.ItemLayoutBinding

class UserDataAdaptor(val UserDataList:MutableList<UserData>,
    val onItemClick:(UserData)->Unit
):
    RecyclerView.Adapter<UserDataAdaptor.UserDataHolder>() {
   inner class UserDataHolder(val binding:ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bindData(UserData:UserData){
            binding.userdata= UserData
            binding.butDetalis.setOnClickListener{
                onItemClick(UserData)
            }
            binding.butDelete.setOnClickListener{
                onItemClick(UserData)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataHolder {
        val binding=ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserDataHolder (binding)
    }

    override fun onBindViewHolder(holder: UserDataHolder, position: Int) {
        holder.bindData(UserDataList[position])
    }
    override fun getItemCount()=UserDataList.size

    fun addPerson(person: UserData) {
        UserDataList.size
        notifyItemInserted(UserDataList.size - 1)

    }

    companion object {

        fun addPerson(newPerson: UserData) {

        }
    }
}