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
import com.levi.smarttracker.mvp.SignUpMVP
import com.levi.smarttracker.root.App
import javax.inject.Inject

class SignUpActivity : AppCompatActivity(), SignUpMVP.View, ClickHelper {

    @JvmField @BindView(R.id.sign_up_username) var usernameEdt: EditText? = null
    @JvmField @BindView(R.id.sign_up_password) var passwordEdt: EditText? = null
    @JvmField @BindView(R.id.sign_up_email) var emailEdt: EditText? = null

    @JvmField @BindView(R.id.sign_up_btn) var signUpBtn: Button? = null

    @JvmField @Inject var presenter: SignUpMVP.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)
        (application as App).component!!.inject(this)
        ButterKnife.bind(this)

        setOnClick()

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

    override fun getEmail(): String {
        return emailEdt!!.text.toString()
    }

    override fun showSuccessfullySignUpMessage() {
        Toast.makeText(this, "User was created!", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorSignUpMessage() {
        Toast.makeText(this, "Error during create user", Toast.LENGTH_SHORT).show()
    }

    override fun changeToLoginActivity() {
        applicationContext.startActivity(Intent(applicationContext, LoginActivity::class.java))
    }

    override fun setOnClick() {
        signUpBtn!!.setOnClickListener{
            presenter!!.registerUser()
        }
    }
}