// Generated by Dagger (https://dagger.dev).
package com.example.android.dagger.registration;

import com.example.android.dagger.user.UserManager;

import javax.inject.Provider;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RegistrationViewModel_Factory implements Factory<RegistrationViewModel> {
  private final Provider<UserManager> userManagerProvider;

  public RegistrationViewModel_Factory(Provider<UserManager> userManagerProvider) {
    this.userManagerProvider = userManagerProvider;
  }

  @Override
  public RegistrationViewModel get() {
    return newInstance(userManagerProvider.get());
  }

  public static RegistrationViewModel_Factory create(Provider<UserManager> userManagerProvider) {
    return new RegistrationViewModel_Factory(userManagerProvider);
  }

  public static RegistrationViewModel newInstance(UserManager userManager) {
    return new RegistrationViewModel(userManager);
  }
}
