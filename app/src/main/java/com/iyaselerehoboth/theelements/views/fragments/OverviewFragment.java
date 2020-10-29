package com.iyaselerehoboth.theelements.views.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.iyaselerehoboth.theelements.BuildConfig;
import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.databinding.DialogAboutBinding;
import com.iyaselerehoboth.theelements.databinding.FragmentOverviewBinding;

public class OverviewFragment extends Fragment {
    FragmentOverviewBinding binding;

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.overview_options, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_about:
                displayAboutDialog();
                break;
            default:
                break;

        }
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.imgZoom.setDisplayType(ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        binding.imgZoom.setImageResource(R.drawable.periodic_elements_black);*/

        binding.pdfViewer.fromAsset("NaturalStatePeriodicTable.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .autoSpacing(false)
                .enableAntialiasing(true)
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .load();

    }

    public void displayAboutDialog() {
        DialogAboutBinding bindingDialog = DataBindingUtil
                .inflate(LayoutInflater.from(getActivity()), R.layout.dialog_about, null, false);

        Dialog dialog = new Dialog(getActivity(), R.style.Theme_MaterialComponents_Light_Dialog_Alert);
        dialog.setContentView(bindingDialog.getRoot());
        bindingDialog.mtvVersion.setText("v" + BuildConfig.VERSION_NAME);
        bindingDialog.mtvCopyrights.setText("Copyrights " + "\u00a9" + "2020. Iyasele Rehoboth \n All Rights Reserved.");
        /*bindingDialog.mtvFeatures.setText("1. View entire periodic table at a glance. \n" +
                "2. View different categories of the periodic elements. \n" +
                "3. Search and click to view full details of each element.");*/

        dialog.show();
    }
}