package com.alberto.marvel.common.view.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.alberto.marvel.MApplication;
import com.alberto.marvel.R;
import com.alberto.marvel.injection.component.ActivityComponent;
import com.alberto.marvel.injection.component.ApplicationComponent;
import com.alberto.marvel.injection.component.DaggerActivityComponent;
import com.alberto.marvel.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;
    private Dialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        initializeInjector();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MApplication) getApplication()).getApplicationComponent();
    }

    private void initializeInjector() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void showProgressDialog() {
        dismissProgressDialog();
        progressDialog = new Dialog(this);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.dialog_progress);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
