package com.meteor.jetpackstudy.login.viewModel

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.meteor.jetpackstudy.login.SimpleWatcher
import com.meteor.jetpackstudy.main.MainActivity

/**
 * @author: X_Meteor
 * @description: 类描述
 * @version: V_1.0.0
 * @date: 2019/9/5 13:55
 * @company:
 * @email: lx802315@163.com
 */
class LoginModel constructor(name: String, pwd: String, context: Context) {

    val USER_NAME: String = "TeaOf"
    val USER_PWD: String = "123456"

    val mName = ObservableField<String>(name)
    val mPwd = ObservableField<String>(pwd)
    val context = context

    fun onNameChanged(s: CharSequence) {
        mName.set(s.toString())
    }

    fun onPwdChanged(s: CharSequence) {
        mPwd.set(s.toString())
    }

    fun login() {
        if (mName.get().equals(USER_NAME) && mPwd.get().equals(USER_PWD)) {
            Toast.makeText(context, "账号密码正确", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    // SimpleWatcher 是简化了的TextWatcher
    val nameWatcher = object : SimpleWatcher() {
        override fun afterTextChanged(s: Editable) {
            super.afterTextChanged(s)
            mName.set(s.toString())
        }
    }
    val pwdWatcher = object : SimpleWatcher() {
        override fun afterTextChanged(s: Editable) {
            super.afterTextChanged(s)
            mPwd.set(s.toString())
        }
    }

    @BindingAdapter("addTextChangedListener")
    fun addTextChangedListener(editText: EditText, simpleWatcher: SimpleWatcher) {
        editText.addTextChangedListener(simpleWatcher)
    }
}