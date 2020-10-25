package com.iyaselerehoboth.theelements.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.adapters.ElementsAdapter;
import com.iyaselerehoboth.theelements.data.SessionManager;
import com.iyaselerehoboth.theelements.data.room.TheElementsDatabase;
import com.iyaselerehoboth.theelements.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {
    FragmentSearchBinding binding;
    SessionManager session;
    TheElementsDatabase db;
    ElementsAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        session = new SessionManager(getActivity());
        db = TheElementsDatabase.getInstance(getActivity().getApplicationContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.svElement.setOnQueryTextListener(this);

        binding.svElement.setOnClickListener(v -> {
            binding.svElement.setIconified(false);
        });

        db.getElementsDao().getAllElements().observe(getViewLifecycleOwner(), elementsList -> {

            adapter = new ElementsAdapter(getActivity(), elementsList, element -> {
                //Navigate to single view
            });

            binding.rvElements.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvElements.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        try {
            adapter.getFilter().filter(s.toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}