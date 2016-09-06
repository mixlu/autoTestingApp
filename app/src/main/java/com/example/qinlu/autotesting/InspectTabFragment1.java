package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个页面是检测页面的第一个tab-车辆基本信息的类
 * Created by qinlu on 8/2/16.
 * platePrefix - 车牌前缀
 * plateNum - 车牌号码
 * plateTypes - 号牌种类
 */
public class InspectTabFragment1 extends Fragment{

    EditText plateNum;

    private Spinner platePrefixSpinner;
    private Spinner plateTypeSpinner;

    private InspectionDataBaseAdapter dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.tab_inspection_1, container, false);

        dbManager = new InspectionDataBaseAdapter(this.getActivity());
        dbManager.open();

        this.setUpPlatePrefixSpinner(v);
        this.setUpPlateTypeSpinner(v);
        plateNum= (EditText) v.findViewById(R.id.plate_number_text);
        return v;
    }

    private void setUpPlatePrefixSpinner(View v){
        List<String> platePrefixData = dbManager.getPlatePrefix();
        platePrefixSpinner = (Spinner) v.findViewById(R.id.plate_prefix_spinner);
        ArrayAdapter<String> platePrefixAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, platePrefixData);
        platePrefixAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        platePrefixSpinner.setAdapter(platePrefixAdapter);
    }

    public void setUpPlateTypeSpinner(View v) {
        List<String> plateTypes = dbManager.getPlateType();
        plateTypeSpinner = (Spinner) v.findViewById(R.id.plate_type_spinner);

        ArrayAdapter<String> plateTypeAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, plateTypes);
        plateTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        plateTypeSpinner.setAdapter(plateTypeAdapter);
    }
}
