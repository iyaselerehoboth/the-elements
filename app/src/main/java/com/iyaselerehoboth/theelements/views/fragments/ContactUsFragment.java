package com.iyaselerehoboth.theelements.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.databinding.FragmentContactUsBinding;


public class ContactUsFragment extends Fragment {
    FragmentContactUsBinding binding;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_us, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.mtvProfileName.setText("Iyasele Rehoboth");
        binding.mtvProfileRole.setText("Mobile Developer");
        binding.mtvAboutMe.setText("Hi," + "\n" +
                "I am a mobile applications software developer based in Lagos, Nigeria. " +
                "Proficient in Native Android development (Java & Kotlin), Git, Material Design, Android Architecture Components, Database management, Writing and Consumption of Web APIs & general Back-end development." +
                "When I am not coding, I am either reading, visiting friends or playing video games (and sleeping)");
    }
}