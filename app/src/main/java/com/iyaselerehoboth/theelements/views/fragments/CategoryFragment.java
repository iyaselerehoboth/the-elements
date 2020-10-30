package com.iyaselerehoboth.theelements.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.data.SessionManager;
import com.iyaselerehoboth.theelements.databinding.FragmentCategoryBinding;

public class CategoryFragment extends Fragment {
    FragmentCategoryBinding binding;
    SessionManager session;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);
        session = new SessionManager(getActivity().getApplicationContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBlock.setOnClickListener(v -> {
            navigateToSubCategory("block", v);
        });

        binding.btnBondingType.setOnClickListener(v1 -> {
            navigateToSubCategory("bonding_type", v1);
        });

        binding.btnCrystalStructure.setOnClickListener(v2 -> {
            navigateToSubCategory("crystal_structure", v2);
        });

        binding.btnGroupBlock.setOnClickListener(v3 -> {
            navigateToSubCategory("group_block", v3);
        });

        binding.btnMagneticOrdering.setOnClickListener(v4 -> {
            navigateToSubCategory("magnetic_ordering", v4);
        });

        binding.btnPeriod.setOnClickListener(v5 -> {
            navigateToSubCategory("period", v5);
        });
    }

    public void navigateToSubCategory(String category, View view) {
        //Pass the argument to the next fragment using Type-safe arg navigation plugin.
        CategoryFragmentDirections.ActionCategoryFragmentToSubCategoryFragment action =
                CategoryFragmentDirections.actionCategoryFragmentToSubCategoryFragment();
        action.setCategory(category);
        Navigation.findNavController(view).navigate(action);
    }
}