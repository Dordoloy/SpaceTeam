package com.example.spaceteam.screens.title

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.spaceteam.R
import com.example.spaceteam.databinding.TitleFragmentBinding
import com.example.spaceteam.model.*
import com.example.spaceteam.serviceWeb.SpaceTeamService
import com.example.spaceteam.serviceWeb.WebSocketConnection
import kotlinx.android.synthetic.main.title_fragment.*
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

/**
 * Title fragment
 */
class TitleFragment: Fragment() {
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
        val binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater,
            R.layout.title_fragment,container,false)

        binding.goButton.setOnClickListener { view : View ->

            var pseudo = pseudoName.text.toString()
            var roomName = roomName.text.toString()

            if (!pseudo.isNullOrEmpty() && !roomName.isNullOrEmpty()) {
                try {
                    //Toast.makeText(context, pseudo, Toast.LENGTH_SHORT).show()
                    val user = UserPost(pseudo)

                    SpaceTeamService.registerUser(user).enqueue(object: Callback<User> {
                        override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                            Log.i("DEBUG-27", t.toString())
                        }

                        override fun onResponse(call: retrofit2.Call<User>, response: Response<User>) {
                            val allUser = response.body()
                            if (allUser != null) {
                                TODO()
                            }
                        }

                    })

                    //WebSocketConnection().joinRoom(roomName, id)
                } catch (e: Exception) {
                    Log.i("DEBUG-27", e.toString())
                }
            }

            view.findNavController().navigate(R.id.action_titleFragment_to_roomFragment)
        }
        return binding.root
    }

}