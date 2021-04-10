package com.example.naat_practica.ui.login.data.repository

import com.example.naat_practica.ui.login.mvvm.model.LoginEntity
import io.reactivex.Observable

interface ILoginRepository {
    fun login(user: String?, password: String?): Observable<LoginEntity.Response>
}