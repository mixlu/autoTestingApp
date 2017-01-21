package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qinlu.autotesting.model.VehicleModel;

/**
 * 这个页面是检测页面的第二个tab-车辆详细信息的类
 * Created by qinlu on 8/2/16.
 */
public class InspectTabFragment2 extends Fragment{
    boolean isLoaded = false;
    private InspectionDataBaseAdapter dbManager;
    public CarBasicInfoModel reveivedCar;

    private EditText transportationNum;
    private EditText VIN;
    private EditText makeModel;
    private EditText owner;
    private EditText engineNum;
    private EditText seatsNum;
    private EditText registerDate;
    private EditText baseWeight;
    private EditText wholeWeight;
    private Button saveVehBtn;

    public String platePrefix;
    public String plateNum;
    public String plateType;
    public String transportNum;
    public String vinNum;
    public String makeModelStr;
    public String ownerStr;
    public String engineNumStr;
    public String seatsNumInt;
    public String registerDateStr;
    public String baseWeightStr;
    public String wholeWeightStr;

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
                    transportNum= transportationNum.getText().toString();
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
                    vinNum = VIN.getText().toString();
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
                    makeModelStr = makeModel.getText().toString();
                    if (TextUtils.isEmpty(makeModelStr)) {
                        makeModel.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidMakModel(makeModelStr)){
                        makeModel.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        owner = (EditText) v.findViewById(R.id.owner_text);
        owner.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    ownerStr = owner.getText().toString();
                    if (TextUtils.isEmpty(ownerStr)) {
                        owner.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidOrg(ownerStr)){
                        owner.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        engineNum = (EditText) v.findViewById(R.id.engine_no_text);
        engineNum.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    engineNumStr = engineNum.getText().toString();
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
            //        seatsNumInt = Integer.valueOf(seatsNumStr);
                }
            }
        }));
        registerDate = (EditText) v.findViewById(R.id.register_date_text);
        registerDate.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    registerDateStr = registerDate.getText().toString();
                    if (TextUtils.isEmpty(registerDateStr)) {
                        registerDate.setError(getString(R.string.error_field_required));
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
                    baseWeightStr = baseWeight.getText().toString();
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
                    wholeWeightStr = wholeWeight.getText().toString();
                    if (TextUtils.isEmpty(wholeWeightStr)) {
                        wholeWeight.setError(getString(R.string.error_field_required));
                    } else if (!Checker.isValidWholeWeight(wholeWeightStr)){
                        wholeWeight.setError(getString(R.string.invalid_input));
                    }
                }
            }
        }));
        saveVehBtn = (Button) v.findViewById(R.id.save_veh);
        saveVehBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveVehcle();
            }
            // TODO: 添加车辆保存逻辑
            private void saveVehcle() {
                VehicleModel curVeh = new VehicleModel();
                curVeh.setPlateNumber(plateNum);
                curVeh.setPlatePrefix(platePrefix);
                curVeh.setPlateType(plateType);
                curVeh.setEngineNumber(engineNum.getText().toString());
                curVeh.setMakeModel(makeModel.getText().toString());
                curVeh.setVinNumber(VIN.getText().toString());
                curVeh.setOwner(owner.getText().toString());
                curVeh.setRegisterDate(registerDate.getText().toString());
                curVeh.setFuelType(fuelTypeSpinner.getSelectedItem().toString());
//                curVeh.setSeatNumber(seatsNumStr);
                //dbManager.insertVehicle(curVeh);
                Toast.makeText(getActivity(), "车辆信息已保存", Toast.LENGTH_SHORT).show();
            }
        });
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
                VehicleModel veh = dbManager.getVehInfo(reveivedCar);
                if (veh != null) {
                    Toast.makeText(this.getActivity(), "正在加载车辆详细信息，请确认车辆信息是否正确", Toast.LENGTH_SHORT).show();
                    this.autoFillPage(veh);
                }
            } else {
                Toast.makeText(this.getActivity(), "第一个页面的车辆基本信息还未完成", Toast.LENGTH_SHORT).show();
            }

            //TODO: Only for debug, can be deleted
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
            Toast.makeText(getActivity(), "Got car from Tab1", Toast.LENGTH_SHORT).show();
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
    // TODO: finish the method
    private void autoFillPage(VehicleModel veh){
        // TODO: Add precondition check

    }
}

