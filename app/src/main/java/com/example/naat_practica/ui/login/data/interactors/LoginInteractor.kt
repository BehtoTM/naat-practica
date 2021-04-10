package com.example.naat_practica.ui.login.data.interactors

import com.example.naat_practica.ui.login.mvvm.model.LoginEntity
import com.example.naat_practica.ui.login.data.repository.LoginRepository
import io.reactivex.Observable
import javax.inject.Inject

class LoginInteractor @Inject constructor(val loginRepo: LoginRepository): ILoginInteractor {

    override fun login(user: String?, password: String?): Observable<LoginEntity.Response> =
        loginRepo.login(user, password)
}