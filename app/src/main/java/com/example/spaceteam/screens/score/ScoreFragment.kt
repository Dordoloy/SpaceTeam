package com.example.spaceteam.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.spaceteam.R
import com.example.spaceteam.databinding.ScoreFragmentBinding

/**
 * Score fragment
 */
class ScoreFragment : Fragment() {

    /**
     * called on the creation od fragment
     *
     * @param inflater:LayoutInflater
     * @param container:ViewGroup?
     * @param savedInstanceState:Bundle?
     *
     * @return View?
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.score_fragment, container, false)

        binding.quitButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
        }

        binding.playAgainButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_roomFragment)
        }
        return binding.root
    }
}