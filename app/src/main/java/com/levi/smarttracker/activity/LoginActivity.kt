package com.levi.smarttracker.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.levi.smarttracker.R
import com.levi.smarttracker.helper.ClickHelper
import com.levi.smarttracker.mvp.LoginMVP
import com.levi.smarttracker.root.App
import com.levi.smarttracker.util.PermissionUtil.requestPermissions
import javax.inject.Inject

/**
 * Created by levip on 19/03/2019.
 */

class LoginActivity:
        AppCompatActivity(), LoginMVP.View, ClickHelper {

    @JvmField @BindView(R.id.login_username) var usernameEdt: EditText? = null
    @JvmField @BindView(R.id.login_password) var passwordEdt: EditText? = null
    @JvmField @BindView(R.id.login_enter_btn) var loginBtn: Button? = null
    @JvmField @BindView(R.id.login_sign_up_btn) var signUpBtn: Button? = null

    @JvmField @Inject var presenter: LoginMVP.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        (application as App).component!!.inject(this)
        ButterKnife.bind(this)

        requestPermissions(applicationContext, this)

        setOnClick()

    }

     override fun setOnClick() {
        loginBtn!!.setOnClickListener {
            presenter!!.login()
        }

         signUpBtn!!.setOnClickListener{
             changeToSignUpActivity()
         }
    }

    override fun onStart() {
        super.onStart()
        presenter!!.setView(this)
    }

    override fun getUsername(): String {
        return usernameEdt!!.text.toString()
    }

    override fun getPassword(): String {
        return passwordEdt!!.text.toString()
    }

    override fun showSuccessfullyLoginMessage() {
        Toast.makeText(this, "Logged Successfully!", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorLoginMessage() {
        Toast.makeText(this, "Username or Password are Incorrect", Toast.LENGTH_SHORT).show()
    }

    override fun changeToTrackerActivity() {
        applicationContext.startActivity(Intent(applicationContext, TrackerActivity::class.java))
    }

    override fun changeToSignUpActivity() {
        applicationContext.startActivity(Intent(applicationContext, SignUpActivity::class.java))
    }

}