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
import com.example.spaceteam.Config
import com.example.spaceteam.R
import com.example.spaceteam.databinding.TitleFragmentBinding
import com.example.spaceteam.model.User
import com.example.spaceteam.model.UserPost
import com.example.spaceteam.serviceWeb.SpaceTeamService
import kotlinx.android.synthetic.main.title_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Title fragment
 */
class TitleFragment: Fragment() {

    var user: User? = null

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
                    Toast.makeText(context, pseudo, Toast.LENGTH_SHORT).show()
                    val userPost = UserPost(pseudo)

                    SpaceTeamService.retrofit.registerUser(userPost).enqueue(object : Callback<User?> {
                        override fun onFailure(call: Call<User?>, t: Throwable) {
                            Log.d(Config.TAG, "Sorry your registration has failed. Message : " + t.message)
                        }

                        override fun onResponse(call: Call<User?>, response: Response<User?>) {
                            if (response.code().toString() == "200") {
                                Log.d(Config.TAG, "body toString : " + response.body().toString())

                                user = response.body()

                                Log.d(Config.TAG, "user id : " + user?.id)

                                view.findNavController().navigate(R.id.action_titleFragment_to_roomFragment)

                            } else {
                                Log.d(Config.TAG, "Pseudo déjà utilisé, veuillez en choisir un autre")
                            }
                        }
                    })

                } catch (e: Exception) {
                    Log.i("DEBUG-27", e.toString())
                }
            }
        }
        return binding.root
    }
}