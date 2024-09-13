package com.example.recycler_view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.recycler_view.databinding.FragmentDetalisBinding


class Fragment_Detalis : Fragment() {
   lateinit var binding: FragmentDetalisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentDetalisBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.user=UserData(arguments?.getString("name").toString(),arguments?.getString("mail").toString(),arguments?.getString("phone").toString())
        binding.userdata=arguments?.getSerializable("userdata",UserData::class.java)
    }


}