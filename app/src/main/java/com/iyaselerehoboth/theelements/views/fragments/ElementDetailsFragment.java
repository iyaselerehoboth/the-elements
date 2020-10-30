package com.iyaselerehoboth.theelements.views.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.iyaselerehoboth.theelements.R;
import com.iyaselerehoboth.theelements.data.SessionManager;
import com.iyaselerehoboth.theelements.data.room.TheElementsDatabase;
import com.iyaselerehoboth.theelements.data.room.tables.Elements;
import com.iyaselerehoboth.theelements.databinding.FragmentElementDetailsBinding;

import java.util.Objects;

public class ElementDetailsFragment extends Fragment {
    FragmentElementDetailsBinding binding;
    SessionManager session;
    TheElementsDatabase db;

    public ElementDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_element_details, container, false);
        session = new SessionManager(getActivity());
        db = TheElementsDatabase.getInstance(getActivity().getApplicationContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            Integer atomic_no = ElementDetailsFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getAtomicNumber();
            Log.d("CHECK", "Atomic Number =======> " + atomic_no);
            Elements theElement = db.getElementsDao().getElementDetails(atomic_no);
            Log.d("CHECK", "Selected Data: =========> " + theElement.getAtomic_number() + " " + theElement.getName());
            setUpViews(theElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpViews(Elements selected) {
        //Set all views.

        binding.symbolLayout.setBackgroundColor(Color.parseColor("#" + selected.getCpk_hex_color()));

        /**
         * Set the icon values first
         */
        binding.mtvIconAtomicMass.setText(selected.getAtomic_mass());
        binding.mtvIconAtomicNo.setText(String.valueOf(selected.getAtomic_number()));
        binding.mtvIconName.setText(selected.getName());
        binding.mtvIconSymbol.setText(selected.getSymbol());

        /**
         * Set the remaining values now.
         */
        binding.mtvAtomicMass.setText(selected.getAtomic_mass());
        binding.mtvAtomicRadius.setText(String.valueOf(selected.getAtomic_radius()));
        binding.mtvBlock.setText(selected.getBlock());
        binding.mtvBoilingPoint.setText(selected.getCustomBoilingPoint());
        binding.mtvBondingType.setText(selected.getBonding_type());
        binding.mtvCrystalStructure.setText(selected.getCrystal_structure());
        binding.mtvDensity.setText(selected.getDensity());
        binding.mtvElectronAffinity.setText(String.valueOf(selected.getElectron_affinity()));
        binding.mtvElectroNegativity.setText(selected.getElectronegativity());
        binding.mtvElectronicConfiguration.setText(selected.getElectronic_configuration());
        binding.mtvGroupBlock.setText(selected.getGroup_block());
        binding.mtvMagneticOrdering.setText(selected.getMagnetic_ordering());
        binding.mtvMeltingPoint.setText(selected.getCustomMeltingPoint());
        binding.mtvOxidationState.setText(selected.getOxidation_states());
        binding.mtvStandardState.setText(selected.getCustomStandardState());
        binding.mtvYear.setText(selected.getYear_discovered() + " AD");

        binding.mtvIsotopes.setText(Html.fromHtml(selected.getIsotopes(), Html.FROM_HTML_MODE_LEGACY));
        binding.mtvHistory.setText(Html.fromHtml(selected.getHistory(), Html.FROM_HTML_MODE_LEGACY));


        Log.d("CHECK", "Standard State: ========> " + selected.getCustomStandardState());

        Log.d("CHECK", "Year: ========> " + selected.getYear_discovered());

        Log.d("CHECK", "Isotopes: ========> " + selected.getIsotopes());

        Log.d("CHECK", "History: ========> " + selected.getHistory());
    }
}