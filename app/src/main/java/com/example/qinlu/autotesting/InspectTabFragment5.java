package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qinlu on 8/18/2016.
 */
public class InspectTabFragment5 extends Fragment {

    private InspectionDataBaseAdapter dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_inspection_5, container, false);
//        TextView mStartTestButton = (TextView) v.findViewById(R.id.start_test_button);
//        mStartTestButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addPreTestReportToDB();
//                generateSummary();
//            }
//        });
        return v;
    }

    private void addPreTestReportToDB() {

    }

    private void generateSummary() {

    }

    private void updateTestReportToDB() {

    }
}