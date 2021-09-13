package com.devanshi.tambola.ticketgenerator.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.*;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.*;
import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.model.*;

import java.util.*;

/**
 * Holds the view for Product List
 */
public class TicketListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<ListTicketData> listTicketDataArrayList;
    private Context context;
    private productEditClick productEditClick;
    private boolean editUpdate;


    public TicketListAdapter(final Context context, final ArrayList<ListTicketData> listTicketDataArrayList, final productEditClick productEditClick, final boolean editUpdate) {
        this.listTicketDataArrayList = listTicketDataArrayList;
        this.context = context;
        this.productEditClick = productEditClick;
        this.editUpdate = editUpdate;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart_product, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ListTicketData model = listTicketDataArrayList.get(position);
        final ItemViewHolder mvh = (ItemViewHolder) holder;
        mvh.tvId.setText(context.getString(R.string.str_id, model.getId()));
        mvh.tvSerialIndexId.setText(context.getString(R.string.str_serial_id, model.getSerialIndexId()));
        mvh.tvFromSerialNo.setText(context.getString(R.string.str_from_serial, model.getFromSerialNo()));
        mvh.tvToSerialNo.setText(context.getString(R.string.str_to_serial, model.getToSerialNo()));
        mvh.tvColumnId.setText(context.getString(R.string.str_column_id,model.getColumnId()));
        mvh.tvCreatedAt.setText(context.getString(R.string.str_created_at, "09-07-2020 21:43"));
        mvh.tvUpdateAt.setText(context.getString(R.string.str_update_at, "09-07-2020 21:43"));
        mvh.tvAlphabetSerialIndex.setText(context.getString(R.string.str_alphabet_serial_index, model.getAlpabetSerialIndex()));
        mvh.tvTicketColumnTitle.setText(context.getString(R.string.str_column_title, model.getTicketColumnTitle()));

        mvh.tvUpdate.setOnClickListener(v->productEditClick.onClickTicketEdit(position, model));

        if (model.getImage().startsWith("http://")) {
            Glide.with(context).load(model.getImage()).into(mvh.ivImage);
        } else {
            Glide.with(context).load("http://18.222.76.43/jayastudio/public/storage/"+model.getImage()).into(mvh.ivImage);
        }

    }

    @Override
    public int getItemCount() {
        return listTicketDataArrayList.size();
    }

    public void refrestAdapter(ArrayList<ListTicketData> listTicketDataArrayList) {
        this.listTicketDataArrayList = listTicketDataArrayList;
        notifyDataSetChanged();
    }

    /**
     * Product item view holder
     */
    private class ItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvId;
        AppCompatTextView tvSerialIndexId;
        AppCompatTextView tvFromSerialNo;
        AppCompatTextView tvToSerialNo;
        AppCompatTextView tvColumnId;
        AppCompatTextView tvUpdateAt;
        AppCompatTextView tvCreatedAt;
        AppCompatTextView tvAlphabetSerialIndex;
        AppCompatTextView tvTicketColumnTitle;
        TextView tvUpdate;
        TextView tvDelete;
        AppCompatImageView ivImage;


        ItemViewHolder(View view) {
            super(view);
            ivImage = view.findViewById(R.id.ivImage);
            tvId = view.findViewById(R.id.tvId);
            tvSerialIndexId = view.findViewById(R.id.tvSerialIndexId);
            tvFromSerialNo = view.findViewById(R.id.tvFromSerialNo);
            tvToSerialNo = view.findViewById(R.id.tvToSerialNo);
            tvColumnId = view.findViewById(R.id.tvColumnId);
            tvUpdateAt = view.findViewById(R.id.tvUpdateAt);
            tvCreatedAt = view.findViewById(R.id.tvCreatedAt);
            tvAlphabetSerialIndex = view.findViewById(R.id.tvAlphabetSerialIndex);
            tvTicketColumnTitle = view.findViewById(R.id.tvTicketColumnTitle);
            tvUpdate = view.findViewById(R.id.tvUpdate);
            tvDelete = view.findViewById(R.id.tvDelete);
            if (editUpdate){
                tvUpdate.setVisibility(View.VISIBLE);
                tvDelete.setVisibility(View.VISIBLE);
            }
        }
    }

    public interface productEditClick{
        void onClickTicketEdit(int position, ListTicketData listTicketData);
        void onClickTicketDelete(int position, ListTicketData listTicketData);
    }
}