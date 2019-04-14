package com.levi.smarttracker.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.levi.smarttracker.R
import com.levi.smarttracker.mvp.LoginMVP
import com.levi.smarttracker.root.App
import com.levi.smarttracker.util.PermissionUtil.requestPermission
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by levip on 19/03/2019.
 */

class LoginActivity:
        AppCompatActivity(), LoginMVP.View {

    @JvmField @BindView(R.id.login_username) var usernameEdt: EditText? = null
    @JvmField @BindView(R.id.login_password) var passwordEdt: EditText? = null
    @JvmField @BindView(R.id.login_btn) var loginBtn: Button? = null

    @JvmField @Inject var presenter: LoginMVP.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        (application as App).component!!.inject(this)
        ButterKnife.bind(this)
        requestPermission(applicationContext, this, Manifest.permission.ACCESS_FINE_LOCATION)
        requestPermission(applicationContext, this, Manifest.permission.READ_PHONE_STATE)

        loginBtn!!.setOnClickListener {
            presenter!!.login()
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

    override fun showErrorMessage() {
        Toast.makeText(this, "Username or Password are Incorrect", Toast.LENGTH_SHORT).show()
    }

}