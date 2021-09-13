package com.devanshi.tambola.ticketgenerator.app.adapter;

import androidx.annotation.*;
import android.content.*;
import android.graphics.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.appcompat.widget.*;
import androidx.recyclerview.widget.*;

import com.bumptech.glide.*;
import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.util.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Constants.TAG;

/**
 * Holds the view for Product List
 */
public class TicketTransactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<TicketTransactionData> listTicketDataArrayList;
    private ArrayList<TicketTransactionData> filteredlistTicketDataArrayList;
    private Context context;
    private productEditClick productEditClick;
    private boolean editUpdate;


    public TicketTransactionListAdapter(final Context context, final ArrayList<TicketTransactionData> listTicketDataArrayList, final productEditClick productEditClick, final boolean editUpdate) {
        this.listTicketDataArrayList = listTicketDataArrayList;
        this.filteredlistTicketDataArrayList = listTicketDataArrayList;
        this.context = context;
        this.productEditClick = productEditClick;
        this.editUpdate = editUpdate;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ticket_transaction, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final TicketTransactionData model = filteredlistTicketDataArrayList.get(position);
        final ItemViewHolder mvh = (ItemViewHolder) holder;
        mvh.tvId.setText(context.getString(R.string.str_id, model.getId()));
        mvh.tvPlayerName.setText(context.getString(R.string.str_player_id, model.getPlayerName()));
        mvh.tvTicketColumnTitle.setText(context.getString(R.string.str_column_title, model.getTicketColumnTitle()));
        mvh.tvCreatedById.setText(context.getString(R.string.str_created_by_id,model.getCreatedByName()));
        mvh.tvAmount.setText(context.getString(R.string.str_amount, model.getAmount()));
        mvh.tvTransactionId.setText(context.getString(R.string.str_transaction_id, model.getTransactionId()));
        mvh.tvGameOn.setText(context.getString(R.string.str_game_on, model.getGameOn()));
        mvh.tvPayedBy.setText(context.getString(R.string.str_paid_by, model.getPayedBy()));
        mvh.tvAlphabetSerialIndex.setText(context.getString(R.string.str_alphabet_serial_index, model.getAlpabetSerialIndex()));
        mvh.tvDownload.setOnClickListener(v->{
            Log.d(TAG, "onBindViewHolder");
            Utils.downloadFile(context, model.getImage());
        });

        mvh.tvShare.setOnClickListener(v->{
            productEditClick.onShareClick(model.getImage());
        });
        Glide.with(context).load(model.getImage()).into(mvh.ivImage);

        String playerName = mvh.tvPlayerName.getText().toString();
        String transactionId = mvh.tvTransactionId.getText().toString();
        String ticketId = mvh.tvId.getText().toString();
        String createdBy = mvh.tvCreatedById.getText().toString();

        if (playerName.toLowerCase().indexOf(searchString.toLowerCase(), positionColon(playerName)) > -1){
            int startPos = playerName.toLowerCase().indexOf(searchString.toLowerCase(), positionColon(playerName));
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(playerName);
            spanString.setSpan(new ForegroundColorSpan(Color.RED),
                    startPos,
                    endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvPlayerName.setText(spanString);
        }

        if (transactionId.indexOf(searchString, positionColon(transactionId)) > -1){
            int startPos = transactionId.indexOf(searchString, positionColon(transactionId));
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(mvh.tvTransactionId.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvTransactionId.setText(spanString);
        }

        if (ticketId.indexOf(searchString, positionColon(ticketId)) > -1){
            int startPos = ticketId.indexOf(searchString, positionColon(ticketId));
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(mvh.tvId.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvId.setText(spanString);
        }

        if (createdBy.indexOf(searchString, positionColon(createdBy)) > -1){
            int startPos = createdBy.indexOf(searchString, positionColon(createdBy));
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(mvh.tvCreatedById.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvCreatedById.setText(spanString);
        }

    }

    private int positionColon(String strings){
        return strings.indexOf(':')+1;
    }

    @Override
    public int getItemCount() {
        return filteredlistTicketDataArrayList.size();
    }

    public void refrestAdapter(ArrayList<TicketTransactionData> listTicketDataArrayList) {
        this.listTicketDataArrayList = listTicketDataArrayList;
        this.filteredlistTicketDataArrayList = listTicketDataArrayList;
        notifyDataSetChanged();
    }

    String searchString = "";
    public void setFilter(CharSequence charSequence){
        searchString = charSequence.toString();
        if (searchString.isEmpty()) {
            filteredlistTicketDataArrayList = listTicketDataArrayList;
        } else {
            ArrayList<TicketTransactionData> filteredList = new ArrayList<>();
            for (TicketTransactionData row : listTicketDataArrayList) {
                if (row.getPlayerName().toLowerCase().contains(searchString.toLowerCase())
                        || row.getTransactionId().contains(searchString)
                        || row.getId().toString().contains(searchString)
                        || row.getCreatedByName().contains(searchString)) {
                    filteredList.add(row);
                }
            }
            filteredlistTicketDataArrayList = filteredList;
        }
        notifyDataSetChanged();
    }

    /**
     * Product item view holder
     */
    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvId;
        AppCompatTextView tvPlayerName;
        AppCompatTextView tvTicketColumnTitle;
        AppCompatTextView tvCreatedById;
        AppCompatTextView tvAmount;
        AppCompatTextView tvTransactionId;
        AppCompatTextView tvGameOn;
        AppCompatTextView tvPayedBy;
        AppCompatTextView tvAlphabetSerialIndex;
        TextView tvDelete, tvDownload, tvShare;
        AppCompatImageView ivImage;


        ItemViewHolder(View view) {
            super(view);
            ivImage = view.findViewById(R.id.imageView);
            tvId = view.findViewById(R.id.tvId);
            tvPlayerName = view.findViewById(R.id.tvPlayerName);
            tvTicketColumnTitle = view.findViewById(R.id.tvTicketColumnTitle);
            tvCreatedById = view.findViewById(R.id.tvCreatedByName);
            tvAmount = view.findViewById(R.id.tvAmount);
            tvTransactionId = view.findViewById(R.id.tvTransactionId);
            tvGameOn = view.findViewById(R.id.tvGameOn);
            tvPayedBy = view.findViewById(R.id.tvPayedBy);
            tvAlphabetSerialIndex = view.findViewById(R.id.tvAlphabetSerialIndex);
            tvDelete = view.findViewById(R.id.tvDelete);
            tvDownload = view.findViewById(R.id.tvDownload);
            tvShare = view.findViewById(R.id.tvShare);
        }
    }

    public interface productEditClick{
        void onClickTicketDelete(int position, TicketTransactionData listTicketData);
        void onShareClick(String path);
    }
}