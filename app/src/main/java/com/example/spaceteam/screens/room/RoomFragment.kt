package com.example.spaceteam.screens.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.spaceteam.R
import com.example.spaceteam.databinding.RoomFragmentBinding
import com.example.spaceteam.serviceWeb.ISpaceTeamService
import com.example.spaceteam.serviceWeb.SpaceTeamService

/**
 * Fragment of a room
 */
class RoomFragment: Fragment() {

    /**
     * called on the creation of fragment
     *
     * @param inflater:LayoutInflater
     * @param container: ViewGroup?
     * @param savedInstanceState:Bundle?
     *
     * @return View?
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<RoomFragmentBinding>(inflater,
            R.layout.room_fragment,container,false)

        binding.playButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_roomFragment_to_gameFragment)
        }

        binding.quitButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_roomFragment_to_titleFragment)
        }

        return binding.root
    }

}