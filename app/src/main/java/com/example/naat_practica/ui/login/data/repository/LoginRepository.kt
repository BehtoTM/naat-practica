package com.example.naat_practica.ui.login.data.repository

import com.example.naat_practica.ui.login.data.api.LoginApi
import com.example.naat_practica.ui.login.mvvm.model.LoginEntity
import com.example.naat_practica.utils.encryptSHA256
import io.reactivex.Observable
import javax.inject.Inject

class LoginRepository @Inject constructor(): ILoginRepository {

    private val api = LoginApi.Builder().build()

    override fun login(user: String?, password: String?): Observable<LoginEntity.Response> {
        val grantType  = "password"
        val ecnryptPass = password?.encryptSHA256()
        val oauth       = "Basic Wm1Ga0xXTXlZeTF3YjNKMFlXdz06TWpoa04yUTNNbUppWVRWbVpHTTBObVl4Wm"

        return api.login(grantType, user, ecnryptPass, oauth)
    }
}