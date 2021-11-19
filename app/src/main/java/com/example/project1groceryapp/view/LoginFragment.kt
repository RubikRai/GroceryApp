package com.example.project1groceryapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project1groceryapp.R
import com.example.project1groceryapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding:FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater,container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonNeedAnAccount.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout_login, SignupFragment())?.addToBackStack("backToSignUp")?.commit()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}