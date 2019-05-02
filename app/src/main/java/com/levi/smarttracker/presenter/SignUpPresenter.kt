package com.levi.smarttracker.presenter

import com.levi.smarttracker.dto.UserDTO
import com.levi.smarttracker.entity.User
import com.levi.smarttracker.mvp.SignUpMVP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpPresenter(private val model : SignUpMVP.Model) : SignUpMVP.Presenter {

    private var view: SignUpMVP.View? = null

    override fun registerUser() {
        if (view!!.getUsername().trim() == "" || view!!.getPassword().trim() == "" || view!!.getEmail().trim() == "") {
            view!!.showErrorSignUpMessage()
        } else{
            model.createUser(UserDTO(view!!.getUsername(), view!!.getPassword(), view!!.getEmail())).enqueue(object: Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    view!!.showSuccessfullySignUpMessage()
                    view!!.changeToLoginActivity()
                }

                override fun onFailure(call: Call<User>,
                                       t: Throwable?) {
                    view!!.showErrorSignUpMessage()
                }

            })
        }
    }

    override fun setView(view: SignUpMVP.View) {
        this.view = view
    }
}