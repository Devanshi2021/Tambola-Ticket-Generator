package com.devanshi.tambola.ticketgenerator.app.activity;

import androidx.appcompat.widget.*;
import androidx.constraintlayout.widget.*;

import android.content.*;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.apis.*;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.util.*;

import retrofit2.*;

public class LoginActivity extends BaseActivity {

    AppCompatEditText etUsername, etPassword;
    AppCompatButton btnSubmit;
    ConstraintLayout rootView;
    private MyProgressDialog progressDialog;
    Preference preference;

    /**
     * Returns the resource id of the layout which will be used for setContentView() for the Activity
     *
     * @return resource id of the xml layout
     */
    @Override
    protected int defineLayoutResource() {
        return R.layout.activity_login;
    }

    /**
     * Initialize the components on activity create
     */
    @Override
    protected void initializeComponents() {
        rootView = findViewById(R.id.rootView);
        etUsername = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        progressDialog = new MyProgressDialog(this, getString(R.string.msg_loading), false);
        preference = new Preference(this);
        btnSubmit.setOnClickListener(v -> {
            if (validationCheck()) {
                callLoginApi();
            }
        });
    }

    private void callLoginApi() {
        if (NetworkUtils.isOnline(this, true, false)) {
            showLoading(true);

            APIInterface apiInterface = Utils.getAPIInterface();
            Call<UserLoginModel> playerListApi = apiInterface.loginApi(Objects.requireNonNull(etUsername.getText()).toString(),
                    Objects.requireNonNull(etPassword.getText()).toString());

            playerListApi.enqueue(new Callback<UserLoginModel>() {
                @Override
                public void onResponse(Call<UserLoginModel> call, Response<UserLoginModel> response) {
                    showLoading(false);
                    UserLoginModel userLoginModel = response.body();
                    if (userLoginModel.getMeta().getCode().equals("200")) {
                        UserLoginData userLoginData = userLoginModel.getData();
                        preference.setUserId(userLoginData.getId());
                        preference.setUserType(userLoginData.getRoleId());
                        preference.setUserFirstName(userLoginData.getName());
                        preference.setUserEmail(userLoginData.getEmail());
                        //Avatar, emailVerifiedAt and Password not saved
                        preference.setTokenRegistered(userLoginData.getRememberToken());
                        preference.setUserSetting(userLoginData.getSettings());

                        startHomeActivity();

                    } else {
                        Utils.showSnackBar(rootView, userLoginModel.getMeta().getMessage(), true, getApplicationContext());
                    }
                }

                @Override
                public void onFailure(Call<UserLoginModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(rootView, getString(R.string.alert_common_error), true, getApplicationContext());
                }
            });
        }
    }

    private void startHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private boolean validationCheck() {
        if (Objects.requireNonNull(etUsername.getText()).toString().isEmpty()) {
            Utils.showSnackBar(rootView, "Email is required", true, this);
            return false;
        } else if (Objects.requireNonNull(etPassword.getText()).toString().isEmpty()) {
            Utils.showSnackBar(rootView, "Password is required", true, this);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sets visibility of empty view
     */
    protected void showLoading(final boolean isVisible) {
        if (progressDialog != null) {
            if (isVisible) {
                progressDialog.show();
            } else {
                progressDialog.hide();
            }
        }
    }
}
