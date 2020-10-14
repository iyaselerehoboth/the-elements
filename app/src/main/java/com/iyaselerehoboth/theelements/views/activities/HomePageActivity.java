package com.iyaselerehoboth.theelements.views.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.databinding.ActivityHomePageBinding;

public class HomePageActivity extends AppCompatActivity {
    ActivityHomePageBinding binding;
    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        setUpNavigation();


    }

    public void setUpNavigation() {
        //Create top level destinations for the various home activities of the bottom nav view.
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.overviewFragment, R.id.categoryFragment, R.id.searchFragment).build();

        //Find the nav controller.
        navController = Navigation.findNavController(this, R.id.navHostFragment);

        //Setup the BottomNavView with the nav controller
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        //Setup the appbar/toolbar with the nav controller.
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

}