package com.dhanesh.logoquiz.ui.home;

import android.os.Bundle;

import com.dhanesh.logoquiz.R;
import com.dhanesh.logoquiz.injection.Injection;
import com.dhanesh.logoquiz.ui.ViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class HomeActivity extends AppCompatActivity {

    private ViewModelFactory mViewModelFactory;
    private HomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModelFactory = Injection.provideViewModelFactory(this);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(HomeViewModel.class);
    }
}
