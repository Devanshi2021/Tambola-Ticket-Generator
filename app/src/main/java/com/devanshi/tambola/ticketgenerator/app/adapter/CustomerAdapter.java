package com.devanshi.tambola.ticketgenerator.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.model.CustomerModel;

import java.util.ArrayList;

/**
 * Holds the view for Product List
 */
public class CustomerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {


    private ArrayList<CustomerModel> customerModelArrayList;
    private OnItemClick onItemClick;
    private Context context;
    private customerClick customerClick;
    private ArrayList<CustomerModel> filteredCustomerModelArrayList;
    private boolean editContact;



    public CustomerAdapter(final Context context, final ArrayList<CustomerModel> customerModelArrayList, final OnItemClick onItemClick, final customerClick customerClick, final Boolean editContact) {
        this.customerModelArrayList = customerModelArrayList;
        this.filteredCustomerModelArrayList = customerModelArrayList;
        this.context = context;
        this.onItemClick = onItemClick;
        this.customerClick = customerClick;
        this.editContact = editContact;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_customer_item, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final CustomerModel model = filteredCustomerModelArrayList.get(position);

        final ItemViewHolder mvh = (ItemViewHolder) holder;

        if (editContact) {
            mvh.tvUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customerClick.onClickCustomer(position, model);
                }
            });
        } else {
            mvh.tvUpdate.setVisibility(View.GONE);
            mvh.llcust.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customerClick.onClickCustomer(position, model);
                }
            });
        }
        String customerName = filteredCustomerModelArrayList.get(position).getName();
        String customerMobile = filteredCustomerModelArrayList.get(position).getContact_no();
        mvh.tvName.setText(customerName);
        mvh.tvMobile.setText(customerMobile);
        if (customerName.toLowerCase().contains(searchString.toLowerCase())){
            int startPos = customerName.toLowerCase().indexOf(searchString.toLowerCase());
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(customerName);
            spanString.setSpan(new ForegroundColorSpan(Color.RED),
                    startPos,
                    endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvName.setText(spanString);
        }

        if (customerMobile.contains(searchString)){
            int startPos = customerMobile.indexOf(searchString);
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(mvh.tvMobile.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvMobile.setText(spanString);
        }

        mvh.ivCompanyLogo.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {
        return filteredCustomerModelArrayList.size();
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();

        final int position = (int) v.getTag();
        switch (id) {

            case R.id.ivMinus:
                if (onItemClick != null) {
                    onItemClick.onClickEdit(position);
                }
                break;

            case R.id.ivPlus:
                if (onItemClick != null) {
                    onItemClick.onClickDelete(position);
                }
                break;
        }
    }

    public void addValue(ArrayList<CustomerModel> customerModelArrayList) {
        this.customerModelArrayList=customerModelArrayList;
        this.filteredCustomerModelArrayList = customerModelArrayList;
        notifyDataSetChanged();
    }

    String searchString = "";
    public void setFilter(CharSequence charSequence){
        searchString = charSequence.toString();
        if (searchString.isEmpty()) {
            filteredCustomerModelArrayList = customerModelArrayList;
        } else {
            ArrayList<CustomerModel> filteredList = new ArrayList<>();
            for (CustomerModel row : customerModelArrayList) {
                if (row.getName().toLowerCase().contains(searchString.toLowerCase()) || row.getContact_no().contains(searchString)) {
                    filteredList.add(row);
                }
            }
            filteredCustomerModelArrayList = filteredList;
        }
        notifyDataSetChanged();
    }

    /**
     * Product item view holder
     */
    private class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvMobile;
        TextView tvUpdate;
        AppCompatImageView ivCompanyLogo;
        LinearLayoutCompat llcust;



        ItemViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            ivCompanyLogo = view.findViewById(R.id.ivCompanyLogo);
            tvMobile = view.findViewById(R.id.tvMobile);
            tvUpdate = view.findViewById(R.id.tvUpdate);
            llcust = view.findViewById(R.id.llcust);

        }
    }


    public interface OnItemClick {
        void onClickEdit(int position);
        void onClickDelete(int position);

    }

    public interface customerClick{
        void onClickCustomer(int position, CustomerModel customerModel);
    }


}