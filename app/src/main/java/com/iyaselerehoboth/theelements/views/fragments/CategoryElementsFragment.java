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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.adapters.ElementsAdapter;
import com.iyaselerehoboth.theelements.data.SessionManager;
import com.iyaselerehoboth.theelements.data.room.TheElementsDatabase;
import com.iyaselerehoboth.theelements.data.room.tables.Elements;
import com.iyaselerehoboth.theelements.databinding.FragmentCategoryElementsBinding;

import java.util.List;

public class CategoryElementsFragment extends Fragment {
    FragmentCategoryElementsBinding binding;
    SessionManager session;
    TheElementsDatabase db;
    ElementsAdapter adapter;
    String category, sub_category;

    public CategoryElementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_elements, container, false);
        session = new SessionManager(getActivity());
        db = TheElementsDatabase.getInstance(getActivity().getApplicationContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get category and subcategory from shared preferences.
        category = session.GET_FILTER_CATEGORY();
        sub_category = session.GET_FILTER_SUB_CATEGORY();

        adapter = new ElementsAdapter(getActivity(), getSubCategoryElementsList(category, sub_category), element -> {
            //Navigate to details view
            CategoryElementsFragmentDirections.ActionCategoryElementsFragmentToElementDetailsFragment action
                    = CategoryElementsFragmentDirections.actionCategoryElementsFragmentToElementDetailsFragment();
            action.setAtomicNumber(element.getAtomic_number());
            Navigation.findNavController(view).navigate(action);
        });

        binding.rcCategoryElements.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rcCategoryElements.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public List<Elements> getSubCategoryElementsList(String category, String sub_category) {
        switch (category) {
            case "block":
                if (sub_category.equals("Others")) {
                    return db.getElementsDao().getSubElementsBlocksNull();
                }
                return db.getElementsDao().getSubElementsBlocks(sub_category);

            case "bonding_type":
                if (sub_category.equals("Others")) {
                    return db.getElementsDao().getSubElementsBondingTypeNUll();
                }
                return db.getElementsDao().getSubElementsBondingType(sub_category);

            case "crystal_structure":
                if (sub_category.equals("Others")) {
                    return db.getElementsDao().getSubElementsCrystalStructureNull();
                }
                return db.getElementsDao().getSubElementsCrystalStructure(sub_category);

            case "group_block":
                if (sub_category.equals("Others")) {
                    return db.getElementsDao().getSubElementsGroupBlockNull();
                }
                return db.getElementsDao().getSubElementsGroupBlock(sub_category);

            case "magnetic_ordering":
                if (sub_category.equals("Others")) {
                    return db.getElementsDao().getSubElementsMagneticNull();
                }
                return db.getElementsDao().getSubElementsMagnetic(sub_category);

            case "period":
                if (sub_category.equals("Others")) {
                    return db.getElementsDao().getSubElementsPeriodNull();
                }
                return db.getElementsDao().getSubElementsPeriod(sub_category);
        }
        return null;
    }
}