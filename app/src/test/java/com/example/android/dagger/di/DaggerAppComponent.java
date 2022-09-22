// Generated by Dagger (https://dagger.dev).
package com.example.android.dagger.di;

import android.content.Context;

import com.example.android.dagger.login.LoginActivity_MembersInjector;
import com.example.android.dagger.main.MainActivity_MembersInjector;
import com.example.android.dagger.registration.RegistrationActivity_MembersInjector;
import com.example.android.dagger.registration.RegistrationViewModel_Factory;
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment_MembersInjector;
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment_MembersInjector;
import com.example.android.dagger.settings.SettingsActivity_MembersInjector;
import com.example.android.dagger.storage.SharedPreferencesStorage_Factory;
import com.example.android.dagger.user.UserDataRepository_Factory;
import com.example.android.dagger.user.UserManager_Factory;
import com.example.dagger2.MainActivity;
import com.example.dagger2.MainViewModel;
import com.example.dagger2.di.AppComponent;
import com.example.dagger2.di.user.UserComponent;
import com.example.dagger2.login.LoginActivity;
import com.example.dagger2.login.LoginComponent;
import com.example.dagger2.login.LoginViewModel;
import com.example.registration.RegistrationActivity;
import com.example.registration.RegistrationComponent;
import com.example.registration.RegistrationViewModel;
import com.example.registration.enterdetails.EnterDetailsFragment;
import com.example.registration.enterdetails.EnterDetailsViewModel;
import com.example.registration.termsandconditions.TermsAndConditionsFragment;
import com.example.settings.SettingsActivity;
import com.example.settings.SettingsViewModel;
import com.example.storage.SharedPreferencesStorage;
import com.example.usage.UserDataRepository;
import com.example.usage.UserManager;
import javax.inject.Provider;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
        "unchecked",
        "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private final DaggerAppComponent appComponent = this;

  private Provider<Context> contextProvider;

  private Provider<SharedPreferencesStorage> sharedPreferencesStorageProvider;

  private Provider<UserComponent.Factory> userComponentFactoryProvider;

  private Provider<UserManager> userManagerProvider;

  private DaggerAppComponent(Context contextParam) {

    initialize(contextParam);

  }

  public static AppComponent.Factory factory() {
    return new Factory();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Context contextParam) {
    this.contextProvider = InstanceFactory.create(contextParam);
    this.sharedPreferencesStorageProvider = SharedPreferencesStorage_Factory.create(contextProvider);
    this.userComponentFactoryProvider = new Provider<UserComponent.Factory>() {
      @Override
      public UserComponent.Factory get() {
        return new UserComponentFactory(appComponent);
      }
    };
    this.userManagerProvider = DoubleCheck.provider(UserManager_Factory.create((Provider) sharedPreferencesStorageProvider, userComponentFactoryProvider));
  }

  @Override
  public RegistrationComponent.Factory registrationComponent() {
    return new RegistrationComponentFactory(appComponent);
  }

  @Override
  public LoginComponent.Factory loginComponent() {
    return new LoginComponentFactory(appComponent);
  }

  @Override
  public UserManager userManager() {
    return userManagerProvider.get();
  }

  private static final class Factory implements AppComponent.Factory {
    @Override
    public AppComponent create(Context context) {
      Preconditions.checkNotNull(context);
      return new DaggerAppComponent(context);
    }
  }

  private static final class RegistrationComponentFactory implements RegistrationComponent.Factory {
    private final DaggerAppComponent appComponent;

    private RegistrationComponentFactory(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public RegistrationComponent create() {
      return new RegistrationComponentImpl(appComponent);
    }
  }

  private static final class LoginComponentFactory implements LoginComponent.Factory {
    private final DaggerAppComponent appComponent;

    private LoginComponentFactory(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public LoginComponent create() {
      return new LoginComponentImpl(appComponent);
    }
  }

  private static final class UserComponentFactory implements UserComponent.Factory {
    private final DaggerAppComponent appComponent;

    private UserComponentFactory(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public UserComponent create() {
      return new UserComponentImpl(appComponent);
    }
  }

  private static final class RegistrationComponentImpl implements RegistrationComponent {
    private final DaggerAppComponent appComponent;

    private final RegistrationComponentImpl registrationComponentImpl = this;

    private Provider<RegistrationViewModel> registrationViewModelProvider;

    private RegistrationComponentImpl(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.registrationViewModelProvider = DoubleCheck.provider(RegistrationViewModel_Factory.create(appComponent.userManagerProvider));
    }

    @Override
    public void inject(RegistrationActivity activity) {
      injectRegistrationActivity(activity);
    }

    @Override
    public void inject(EnterDetailsFragment fragment) {
      injectEnterDetailsFragment(fragment);
    }

    @Override
    public void inject(TermsAndConditionsFragment fragment) {
      injectTermsAndConditionsFragment(fragment);
    }

    private RegistrationActivity injectRegistrationActivity(RegistrationActivity instance) {
      RegistrationActivity_MembersInjector.injectRegistrationViewModel(instance, registrationViewModelProvider.get());
      return instance;
    }

    private EnterDetailsFragment injectEnterDetailsFragment(EnterDetailsFragment instance) {
      EnterDetailsFragment_MembersInjector.injectRegistrationViewModel(instance, registrationViewModelProvider.get());
      EnterDetailsFragment_MembersInjector.injectEnterDetailsViewModel(instance, new EnterDetailsViewModel());
      return instance;
    }

    private TermsAndConditionsFragment injectTermsAndConditionsFragment(
            TermsAndConditionsFragment instance) {
      TermsAndConditionsFragment_MembersInjector.injectRegistrationViewModel(instance, registrationViewModelProvider.get());
      return instance;
    }
  }

  private static final class LoginComponentImpl implements LoginComponent {
    private final DaggerAppComponent appComponent;

    private final LoginComponentImpl loginComponentImpl = this;

    private LoginComponentImpl(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;


    }

    private LoginViewModel loginViewModel() {
      return new LoginViewModel(appComponent.userManagerProvider.get());
    }

    @Override
    public void inject(LoginActivity activity) {
      injectLoginActivity(activity);
    }

    private LoginActivity injectLoginActivity(LoginActivity instance) {
      LoginActivity_MembersInjector.injectLoginViewModel(instance, loginViewModel());
      return instance;
    }
  }

  private static final class UserComponentImpl implements UserComponent {
    private final DaggerAppComponent appComponent;

    private final UserComponentImpl userComponentImpl = this;

    private Provider<UserDataRepository> userDataRepositoryProvider;

    private UserComponentImpl(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;

      initialize();

    }

    private MainViewModel mainViewModel() {
      return new MainViewModel(userDataRepositoryProvider.get());
    }

    private SettingsViewModel settingsViewModel() {
      return new SettingsViewModel(userDataRepositoryProvider.get(), appComponent.userManagerProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.userDataRepositoryProvider = DoubleCheck.provider(UserDataRepository_Factory.create(appComponent.userManagerProvider));
    }

    @Override
    public void inject(MainActivity activity) {
      injectMainActivity(activity);
    }

    @Override
    public void inject(SettingsActivity activity) {
      injectSettingsActivity(activity);
    }

    private MainActivity injectMainActivity(MainActivity instance) {
      MainActivity_MembersInjector.injectMainViewModel(instance, mainViewModel());
      return instance;
    }

    private SettingsActivity injectSettingsActivity(SettingsActivity instance) {
      SettingsActivity_MembersInjector.injectSettingsViewModel(instance, settingsViewModel());
      return instance;
    }
  }
}
