package com.example.spaceteam.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.spaceteam.R
import com.example.spaceteam.databinding.GameFragmentBinding

class GameFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(inflater,
            R.layout.game_fragment,container,false)

        binding.finishButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_scoreFragment)
        }

        return binding.root
    }

}