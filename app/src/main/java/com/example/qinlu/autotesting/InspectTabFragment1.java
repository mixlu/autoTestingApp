package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 这个页面是检测页面的第一个tab-车辆基本信息的类
 * Created by qinlu on 8/2/16.
 */
public class InspectTabFragment1 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_inspection_1, container, false);
    }
}
