package com.example.spaceteam.screens.score

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spaceteam.screens.title.TitleFragment

class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Navigates back to game when button is pressed
        viewModel.eventPlayAgain.observe(this, Observer { playAgain ->
            if (playAgain) {
//                startActivity(Intent(this, TitleFragment::class.java))
                Log.d("DEBUG-27", "work")
            }
        })

        return null
    }
}