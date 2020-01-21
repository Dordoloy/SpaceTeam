package com.example.spaceteam.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.spaceteam.Config
import com.example.spaceteam.R
import com.example.spaceteam.databinding.GameFragmentBinding
import com.example.spaceteam.model.Event
import com.example.spaceteam.model.EventType
import com.example.spaceteam.model.UIElement
import com.example.spaceteam.serviceWeb.WebSocketConnection
import kotlinx.android.synthetic.main.game_fragment.*

/**
 * Fragment of game
 */
class GameFragment: Fragment() {

    private lateinit var viewModel: GameViewModel

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
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(
            inflater,
            R.layout.game_fragment, container, false
        )

        binding.finishButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_scoreFragment)
        }

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        viewModel.event.observe(this, Observer { event ->
            Log.d(Config.TAG, "---${event}")
            observeEvent(event)
        })

        return binding.root
    }

    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            try {
                val event =
                    WebSocketConnection.parser.fromJson(it.getString("gameStarted")) as Event.GameStarted
                generateInterface(event.uiElementList)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d(Config.TAG, "can't generate buttons")
            }
        }
    }

    private fun finishGame(event: Event.GameOver) {
        view!!.findNavController().navigate(R.id.action_gameFragment_to_scoreFragment)
    }


    private fun observeEvent(event: Event) {
        when (event.type) {
            EventType.NEXT_LEVEL -> nextLevel(event as Event.NextLevel)
            EventType.NEXT_ACTION -> updateAction(event as Event.NextAction)
            EventType.GAME_OVER -> finishGame(event as Event.GameOver)
            else -> return
        }
    }

    private fun updateAction(event: Event.NextAction) {
        textViewAction.text = event.action.sentence
    }

    private fun nextLevel(event: Event.NextLevel) {
        generateInterface(event.uiElementList)
    }

    private fun generateInterface(uiElements: List<UIElement>) {
    }

}