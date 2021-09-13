package com.devanshi.tambola.ticketgenerator.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.model.CustomerModel;

import java.util.ArrayList;

/**
 * Purpose:
 * This adapter is link with ListView object that display list on the screen
 */
public class CustomerCartAdapter extends ArrayAdapter<CustomerModel> {

    private Context mContext;
    private ArrayList<CustomerModel> maritalStatusModels;
    private LayoutInflater inflater;

    public CustomerCartAdapter(Context context, int resource, ArrayList<CustomerModel> maritalStatusModels) {
        super(context, resource, maritalStatusModels);
        this.mContext = context;
        this.maritalStatusModels = maritalStatusModels;
        inflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return maritalStatusModels.size();
    }

    @Override
    public CustomerModel getItem(int position) {
        return maritalStatusModels.get(position);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_common_list_item, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        mViewHolder.txtProvinceName.setText("" + getItem(position).getName());

        return convertView;
    }


    private class MyViewHolder {
        private AppCompatTextView txtProvinceName;


        public MyViewHolder(View item) {
            txtProvinceName = (AppCompatTextView) item.findViewById(R.id.row_list_name);
        }
    }

}
