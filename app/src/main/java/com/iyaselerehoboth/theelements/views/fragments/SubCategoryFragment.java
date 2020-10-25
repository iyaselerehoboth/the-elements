package com.iyaselerehoboth.theelements.views.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.adapters.SubCategoryAdapter;
import com.iyaselerehoboth.theelements.data.SessionManager;
import com.iyaselerehoboth.theelements.data.room.TheElementsDatabase;
import com.iyaselerehoboth.theelements.databinding.FragmentSubCategoryBinding;

import java.util.List;

public class SubCategoryFragment extends Fragment {
    FragmentSubCategoryBinding binding;
    SessionManager session;
    SubCategoryAdapter adapter;
    TheElementsDatabase db;

    public SubCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sub_category, container, false);
        session = new SessionManager(getActivity());
        db = TheElementsDatabase.getInstance(getActivity().getApplicationContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Receive arguments and init recycler.
        try {
            String passedCategory = SubCategoryFragmentArgs.fromBundle(getArguments()).getCategory();
            initSubCategoryRecycler(passedCategory);
        } catch (NullPointerException e) {
            Log.d("CHECK", "Null pointer from arguments passed");
            e.printStackTrace();
        }
    }

    public void initSubCategoryRecycler(String category) {
        adapter = new SubCategoryAdapter(getActivity(), getSubCategoryList(category), sub_category -> {
            //Set Category and sub-category to shared preferences.
            session.SET_FILTER_CATEGORY(category);
            session.SET_FILTER_SUB_CATEGORY(sub_category);
            Navigation.findNavController(getActivity(), R.id.navHostFragment).navigate(R.id.action_subCategoryFragment_to_categoryElementsFragment);
        });

        binding.rcvSubCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rcvSubCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public List<String> getSubCategoryList(String category) {
        switch (category) {
            case "block":
                return db.getElementsDao().getSubBlockCategories();
            case "bonding_type":
                return db.getElementsDao().getSubBondingTypeCategories();
            case "crystal_structure":
                return db.getElementsDao().getSubCrystalStructureCategories();
            case "group_block":
                return db.getElementsDao().getSubGroupBlockCategories();
            case "magnetic_ordering":
                return db.getElementsDao().getSubMagneticCategories();
            case "period":
                return db.getElementsDao().getSubPeriodCategories();
        }
        return null;
    }
}