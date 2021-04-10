package com.example.naat_practica.ui.login.mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginEntity {
    class Request {
        @SerializedName("grant_type")
        @Expose
        var grant_type: String? = null
        @SerializedName("username")
        @Expose
        var username: String? = null
        @SerializedName("password")
        @Expose
        var password: String? = null
    }
    class Response {
        @SerializedName("access_token")
        @Expose
        var access_token: String? = null
        @SerializedName("refresh_token")
        @Expose
        var refresh_token: String? = null
        @SerializedName("expires_in")
        @Expose
        var expires_in: Int? = null
        @SerializedName("scope")
        @Expose
        var scope: String? = null
        @SerializedName("jti")
        @Expose
        var jti: String? = null
        @SerializedName("success")
        @Expose
        var success: Boolean? = null
        @SerializedName("error")
        @Expose
        var error: String? = null
        @SerializedName("message")
        @Expose
        var message: String? = null
    }
}