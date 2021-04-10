package com.example.naat_practica.ui.login.data.interactors

import com.example.naat_practica.ui.login.mvvm.model.LoginEntity
import io.reactivex.Observable

interface ILoginInteractor {
    fun login(user: String?, password: String?): Observable<LoginEntity.Response>
}