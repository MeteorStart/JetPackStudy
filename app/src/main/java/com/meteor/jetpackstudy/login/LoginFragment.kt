package com.meteor.jetpackstudy.login


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.meteor.jetpackstudy.main.MainActivity
import com.meteor.jetpackstudy.R
import com.meteor.jetpackstudy.databinding.FragmentLoginBinding
import com.meteor.jetpackstudy.login.viewModel.LoginModel
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    lateinit var loginModel: LoginModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginModel = LoginModel("", "", context!!)
        binding.model = loginModel
        binding.activity = activity
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }

        txt_cancel.setOnClickListener {
            activity?.onBackPressed()
        }

        val name = arguments?.getString("name")
        if (name.isNullOrEmpty()){
            loginModel.mName.set(name)
        }
    }

}
