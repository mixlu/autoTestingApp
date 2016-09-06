package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Toast;
=======
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;
>>>>>>> 769e7afeaa4f5d7339547a34dfbdf680e3dbb8f7

/**
 * 这个页面是检测页面的第二个tab-车辆详细信息的类
 * Created by qinlu on 8/2/16.
 */
public class InspectTabFragment2 extends Fragment{
    boolean isLoaded = false;
    String platePrefix;
    String plateNum;
    String plateType;
    CarBasicInfoModel reveivedCar;
    private InspectionDataBaseAdapter dbManager;

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
<<<<<<< HEAD
        View v = inflater.inflate(R.layout.tab_inspection_2, container, false);

        dbManager = new InspectionDataBaseAdapter(this.getActivity());
        dbManager.open();

        reveivedCar = (CarBasicInfoModel) container.getTag();
        if (reveivedCar != null) {
            platePrefix = reveivedCar.getPrefix();
            plateNum = reveivedCar.getNumber();
            plateType = reveivedCar.getType();
        }
        return v;
    }
    /*
     * 如果用户点击这个tab
     * 根据第一个tab里输入的车辆信息去数据库寻找是否此机动车已经在数据库里存在
     * 如果存在，则自动填好此tab的相应信息
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible() && !isLoaded) {
            if (reveivedCar != null) {
                // Check if database existed the auto already
                if(dbManager.isVehicleExisted(reveivedCar)){
                    Toast.makeText(this.getActivity(), "Auto Filled", Toast.LENGTH_SHORT).show();
                    // auto fill all the info
                }
            }
            if (!isVisibleToUser) {
                Log.d(this.getActivity().toString(), "not visible anymore");
            }
        }
    }

    private void fillData(){

=======
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
>>>>>>> 769e7afeaa4f5d7339547a34dfbdf680e3dbb8f7
    }

}

