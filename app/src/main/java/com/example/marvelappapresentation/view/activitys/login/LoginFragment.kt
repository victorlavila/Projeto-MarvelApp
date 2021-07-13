package com.example.marvelappapresentation.view.activitys.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.marvelappapresentation.R
import com.example.marvelappapresentation.databinding.FragmentLoginBinding
import com.example.marvelappapresentation.view.activitys.charactersFeature.HomeActivity


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btLoginContinue.isEnabled = false

        setView()

        return binding.root
    }

    private fun setView() {
        setupRegister()
        setupContinue()
        validateLogin()
    }

    private fun validateLogin() {
        validatEmail()
        validatPassword()
    }

    private fun validatPassword() {
        val password = binding.editPassword
        if(TextUtils.isEmpty(password.text.toString())){
            binding.btLoginContinue.isEnabled = true
        }
        if(password.text.toString().length > 3){
            binding.btLoginContinue.isEnabled = true
        }
    }

    private fun validatEmail() {
        val email = binding.editEmail
        if(TextUtils.isEmpty(email.text.toString())){
            binding.btLoginContinue.isEnabled = true
        }
    }

    private fun setupRegister() {
        binding.registerLogin.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_loginFragment_to_registerMemberFragment)
        }
    }

    private fun setupContinue() {
             binding.btLoginContinue.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }

    }

}