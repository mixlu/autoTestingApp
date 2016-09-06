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
 * 这个页面是检测页面的第二个tab-车辆详细信息的类
 * Created by qinlu on 8/2/16.
 */
public class InspectTabFragment2 extends Fragment{

    EditText transportationNum;
    EditText VIN;
    EditText makeModel;
    EditText org;
    EditText engineNum;
    EditText seatsNum;
    EditText registerDate;
    EditText baseWeight;
    EditText wholeWeight;

    private Spinner vehicleTypeSpinner;
    private Spinner stateSpinner;
    private Spinner headlightTypeSpinner;
    private Spinner fuelTypeSpinner;
    private Spinner brakeSystemTypeSpinner;
    private Spinner driveWheelSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.tab_inspection_2, container, false);

        transportationNum = (EditText) v.findViewById(R.id.transportation_number_txt);
        VIN = (EditText) v.findViewById(R.id.vin_text);
        makeModel = (EditText) v.findViewById(R.id.make_model_text);
        org = (EditText) v.findViewById(R.id.organization_text);
        engineNum = (EditText) v.findViewById(R.id.engine_no_text);
        seatsNum = (EditText) v.findViewById(R.id.seats_number_text);
        registerDate = (EditText) v.findViewById(R.id.register_date_text);
        baseWeight = (EditText) v.findViewById(R.id.base_weight_text);
        wholeWeight = (EditText) v.findViewById(R.id.whole_weight_text);

        return v;
    }

}

