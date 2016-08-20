package com.example.qinlu.autotesting;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by qinlu on 8/14/16.
 * Used for add/remove items in some settings pages
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Model> itemModelList;
    public CustomAdapter(Context context, ArrayList<Model> modelList) {
        this.context = context;
        this.itemModelList = modelList;
    }
    @Override
    public int getCount() {
        return itemModelList.size();
    }
    @Override
    public Object getItem(int position) {
        return itemModelList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = null;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.template_people, null);
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            ImageView imgRemove = (ImageView) convertView.findViewById(R.id.imgRemove);
            Model m = itemModelList.get(position);
            tvName.setText(m.getName());
//             click listiner for remove button
            imgRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemModelList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
        return convertView;
    }
}