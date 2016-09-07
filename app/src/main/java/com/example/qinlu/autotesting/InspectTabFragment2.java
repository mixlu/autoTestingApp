package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private EditText VIN;
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
        View v = inflater.inflate(R.layout.tab_inspection_2, container, false);

        dbManager = new InspectionDataBaseAdapter(this.getActivity());
        dbManager.open();

        reveivedCar = (CarBasicInfoModel) container.getTag();
        setReceivedCar();
        transportationNum = (EditText) v.findViewById(R.id.transportation_number_txt);
        transportationNum.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String transportNum= transportationNum.getText().toString();
                    if (TextUtils.isEmpty(transportNum)) {
                        transportationNum.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidTransportNum(transportNum)){
                        transportationNum.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        VIN = (EditText) v.findViewById(R.id.vin_text);
        VIN.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
//                    Toast.makeText(getActivity(), "Not focus on VIN", Toast.LENGTH_SHORT).show();
                    String vinNum = VIN.getText().toString();
                    if (TextUtils.isEmpty(vinNum)) {
                        VIN.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidVIN(vinNum)){
                        VIN.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        makeModel = (EditText) v.findViewById(R.id.make_model_text);
        makeModel.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String makModelStr = makeModel.getText().toString();
                    if (TextUtils.isEmpty(makModelStr)) {
                        makeModel.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidMakModel(makModelStr)){
                        makeModel.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        org = (EditText) v.findViewById(R.id.organization_text);
        org.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String orgStr = org.getText().toString();
                    if (TextUtils.isEmpty(orgStr)) {
                        org.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidOrg(orgStr)){
                        org.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        engineNum = (EditText) v.findViewById(R.id.engine_no_text);
        engineNum.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String engineNumStr = engineNum.getText().toString();
                    if (TextUtils.isEmpty(engineNumStr)) {
                        engineNum.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidEngineNum(engineNumStr)){
                        engineNum.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        seatsNum = (EditText) v.findViewById(R.id.seats_number_text);
        seatsNum.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String seatsNumStr = seatsNum.getText().toString();
                    if (TextUtils.isEmpty(seatsNumStr)) {
                        seatsNum.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidSeatsNumStr(seatsNumStr)){
                        seatsNum.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        registerDate = (EditText) v.findViewById(R.id.register_date_text);
        registerDate.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String registerDateStr = registerDate.getText().toString();
                    if (TextUtils.isEmpty(registerDateStr)) {
                        org.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidRegisterDate(registerDateStr)){
                        registerDate.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        baseWeight = (EditText) v.findViewById(R.id.base_weight_text);
        baseWeight.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String baseWeightStr = baseWeight.getText().toString();
                    if (TextUtils.isEmpty(baseWeightStr)) {
                        baseWeight.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidBaseWeight(baseWeightStr)){
                        baseWeight.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        wholeWeight = (EditText) v.findViewById(R.id.whole_weight_text);
        wholeWeight.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String wholeWeightStr = wholeWeight.getText().toString();
                    if (TextUtils.isEmpty(wholeWeightStr)) {
                        wholeWeight.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidWholeWeight(wholeWeightStr)){
                        wholeWeight.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
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
            if (isValidReceivedCar()) {
                // Check if database existed the auto already
                if(dbManager.isVehicleExisted(reveivedCar)){
                    Toast.makeText(this.getActivity(), "Auto Filled", Toast.LENGTH_SHORT).show();
                    VehicleModel veh = dbManager.getVehInfo(reveivedCar);
                    this.autoFillPage(veh);
                }
            }
            if (!isVisibleToUser) {
                Log.d(this.getActivity().toString(), "not visible anymore");
            }
        }
    }
    /*
     * 检查是否从上一个tab收到了汽车基本信息
     * 如果收到了，取其基本信息
     */
    private void setReceivedCar() {
        if (this.reveivedCar != null) {
            this.platePrefix = reveivedCar.getPrefix();
            this.plateNum = reveivedCar.getNumber();
            this.plateType = reveivedCar.getType();
        }
    }
    /*
     * 验证从上一个tab收到的车辆基本信息是否是合法的
     */
    private boolean isValidReceivedCar() {
        if(this.reveivedCar == null ||
                this.platePrefix.isEmpty() ||
                this.plateNum.isEmpty() ||
                this.plateType.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
     * @params veh - 车辆详细信息
     * 这个方法根据车辆详细信息自动填充所有输入框
     */
    private void autoFillPage(VehicleModel veh){

    }
}

