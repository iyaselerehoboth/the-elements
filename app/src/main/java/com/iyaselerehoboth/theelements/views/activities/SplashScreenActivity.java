package com.iyaselerehoboth.theelements.views.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.databinding.ActivitySplashscreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    ActivitySplashscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splashscreen);

        binding.btnBegin.setOnClickListener(view -> {
            //Do Something
            startActivity(new Intent(this, HomePageActivity.class));
        });
    }
}