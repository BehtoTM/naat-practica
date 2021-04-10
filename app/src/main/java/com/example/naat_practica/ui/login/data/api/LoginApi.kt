package com.example.naat_practica.ui.login.data.api

import com.example.naat_practica.core.base.BaseService
import com.example.naat_practica.ui.login.data.api.LoginEndpoint.WS_LOGIN
import com.example.naat_practica.ui.login.mvvm.model.LoginEntity
import io.reactivex.Observable
import retrofit2.http.*

interface LoginApi {

    @POST(WS_LOGIN)
    @FormUrlEncoded
    fun login(@Field("grant_type") grant_type: String?,
              @Field("username") user: String?,
              @Field("password") password: String?,
              @Header("Authorization") oauth: String?): Observable<LoginEntity.Response>

    class Builder: BaseService<LoginApi>() {
        override fun build(): LoginApi {
            return builder.build().create(LoginApi::class.java)
        }
    }
}