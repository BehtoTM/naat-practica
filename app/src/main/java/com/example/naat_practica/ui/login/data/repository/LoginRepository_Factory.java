// Generated by Dagger (https://dagger.dev).
package com.example.naat_practica.ui.login.data.repository;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginRepository_Factory implements Factory<LoginRepository> {
  @Override
  public LoginRepository get() {
    return newInstance();
  }

  public static LoginRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LoginRepository newInstance() {
    return new LoginRepository();
  }

  private static final class InstanceHolder {
    private static final LoginRepository_Factory INSTANCE = new LoginRepository_Factory();
  }
}
