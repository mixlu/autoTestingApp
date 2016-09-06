package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by qinlu on 8/4/16.
 */
public class InspectTabFragment3 extends Fragment{

    private Spinner emissionSpinner;
    private Spinner exteriorSpinner;
    private Spinner commanderSpinner;

    private InspectionDataBaseAdapter dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.tab_inspection_3, container, false);

        dbManager = new InspectionDataBaseAdapter(this.getActivity());
        dbManager.open();

        this.setUpEmissionSpinner(v);
        this.setUpExteriorSpinner(v);
        this.setUpCommanderSpinner(v);
        return v;
    }

    private void setUpEmissionSpinner(View v){
        List<String> emissions = dbManager.getEmission();
        emissionSpinner = (Spinner) v.findViewById(R.id.emission_spinner);
        ArrayAdapter<String> emissionAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, emissions);
        emissionAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        emissionSpinner.setAdapter(emissionAdapter);
    }

    public void setUpExteriorSpinner(View v) {
        List<String> exteriors = dbManager.getExterior();
        exteriorSpinner = (Spinner) v.findViewById(R.id.exterior_spinner);

        ArrayAdapter<String> exteriorAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, exteriors);
        exteriorAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        exteriorSpinner.setAdapter(exteriorAdapter);
    }

    public void setUpCommanderSpinner(View v) {
        List<String> commanders = dbManager.getCommander();
        commanderSpinner = (Spinner) v.findViewById(R.id.commander_spinner);

        ArrayAdapter<String> commanderAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, commanders);
        commanderAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        commanderSpinner.setAdapter(commanderAdapter);
    }

}

