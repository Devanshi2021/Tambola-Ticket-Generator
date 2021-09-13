package com.devanshi.tambola.ticketgenerator.app.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devanshi.tambola.ticketgenerator.app.R;

public class CustomGridAdapter extends BaseAdapter {
    Context context;
    String[] claimTypes;
    LayoutInflater layoutInflater;
    int selectedPosition = -1;

    public CustomGridAdapter(Context context, String[] claimTypes){
        this.context = context;
        this.claimTypes = claimTypes;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return claimTypes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.claim_request_gridview_items, null);
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(claimTypes[position]);
        if (position == selectedPosition) {
            textView.setBackground(context.getDrawable(R.drawable.rounded_text));
        } else {
            textView.setBackground(context.getDrawable(R.drawable.roundedcorner_gray));
        }
        return convertView;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
        this.notifyDataSetChanged();
    }
}
