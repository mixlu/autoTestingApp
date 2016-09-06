package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

    }
}

