package com.example.spaceteam.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.spaceteam.R
import com.example.spaceteam.databinding.TitleFragmentBinding

class TitleFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater,
            R.layout.title_fragment,container,false)

        binding.goButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_roomFragment)
        }
        return binding.root
    }

}