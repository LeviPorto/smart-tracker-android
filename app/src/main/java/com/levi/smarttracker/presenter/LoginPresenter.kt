package com.levi.smarttracker.presenter

import android.content.Context
import com.levi.smarttracker.dto.TokenDTO
import com.levi.smarttracker.mvp.LoginMVP
import com.levi.smarttracker.util.PreferenceUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import com.levi.smarttracker.activity.TrackerActivity
import com.levi.smarttracker.dto.DeviceDTO
import com.levi.smarttracker.entity.Device
import com.levi.smarttracker.util.ImeiUtil.getImei


/**
 * Created by levip on 23/03/2019.
 */
class LoginPresenter (private val model: LoginMVP.Model, private val context : Context)  : LoginMVP.Presenter {

    private var view: LoginMVP.View? = null

    override fun login() {
        if (view!!.getUsername().trim() == "" || view!!.getPassword().trim() == "") {
            view!!.showErrorMessage()
        } else {
            model.loadUser(view!!.getUsername(), view!!.getPassword()).enqueue(object: Callback<TokenDTO> {
                override fun onResponse(call: Call<TokenDTO>, response: Response<TokenDTO>) {
                    PreferenceUtil.setStringPreference(context, "AUTH_TOKEN", response.body()!!.token)
                    PreferenceUtil.setIntegerPreference(context, "LOGGED_USER", response.body()!!.userId)
                    model.createDevice(DeviceDTO(getImei(context), response.body()!!.userId)).enqueue(object: Callback<Device> {

                        override fun onResponse(call: Call<Device>, response: Response<Device>) {
                            view!!.showSuccessfullyLoginMessage()
                            val intent = Intent(context, TrackerActivity::class.java)
                            context.startActivity(intent)
                        }

                        override fun onFailure(call: Call<Device>,
                                               t: Throwable?) {
                            view!!.showErrorMessage()
                        }

                    })
                }

                override fun onFailure(call: Call<TokenDTO>,
                                       t: Throwable?) {
                    view!!.showErrorMessage()
                }

            })

        }
    }

    override fun setView(view: LoginMVP.View) {
        this.view = view
    }

}