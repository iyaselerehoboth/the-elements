package com.iyaselerehoboth.theelements.views.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.databinding.FragmentOverviewBinding;

import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;

public class OverviewFragment extends Fragment {
    FragmentOverviewBinding binding;

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imgZoom.setDisplayType(ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        binding.imgZoom.setImageResource(R.drawable.periodic_elements_black);

    }
}