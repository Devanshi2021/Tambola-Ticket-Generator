package com.devanshi.tambola.ticketgenerator.app.adapter;

import android.content.*;
import android.os.*;
import android.text.*;
import android.view.*;

import androidx.annotation.*;
import androidx.appcompat.widget.*;
import androidx.recyclerview.widget.*;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.model.*;

import java.util.*;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * Holds the view for Product List
 */
public class WalletRechargeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<WalletRechargeData> walletRechargeDataArrayList;
    private ArrayList<WalletRechargeData> filteredWalletRechargeDataArrayList;
    private Context context;


    public WalletRechargeListAdapter(final Context context, final ArrayList<WalletRechargeData> listTicketDataArrayList) {
        this.walletRechargeDataArrayList = listTicketDataArrayList;
        this.filteredWalletRechargeDataArrayList = listTicketDataArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wallet_recharge, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final WalletRechargeData model = filteredWalletRechargeDataArrayList.get(position);
        final ItemViewHolder mvh = (ItemViewHolder) holder;
        mvh.tvPlayerName.setText(context.getString(R.string.str_player_id, model.getPalyerName()));
        mvh.tvAmount.setText(context.getString(R.string.str_amount, model.getAmount()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mvh.tvDescription.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            mvh.tvDescription.setHyphenationFrequency(Layout.HYPHENATION_FREQUENCY_FULL);
        }
        mvh.tvDescription.setText(model.getDescription());
        mvh.tvType.setText(context.getString(R.string.type,model.getType()));
        mvh.tvRechargedBy.setText(context.getString(R.string.recharged_by_wallet, model.getRechargedByName()));
        mvh.tvCreatedAt.setText(context.getString(R.string.recharged_at, model.getCreatedAt()));
    }

    @Override
    public int getItemCount() {
        return filteredWalletRechargeDataArrayList.size();
    }

    public void refreshAdapter(ArrayList<WalletRechargeData> listTicketDataArrayList) {
        this.walletRechargeDataArrayList = listTicketDataArrayList;
        this.filteredWalletRechargeDataArrayList = listTicketDataArrayList;
        notifyDataSetChanged();
    }

    String searchString = "";
    public void setFilter(CharSequence charSequence){
        searchString = charSequence.toString();
        if (searchString.isEmpty()) {
            filteredWalletRechargeDataArrayList = walletRechargeDataArrayList;
        } else {
            ArrayList<WalletRechargeData> filteredList = new ArrayList<>();
            for (WalletRechargeData row : walletRechargeDataArrayList) {
                /*if (row.getPlayerName().toLowerCase().contains(searchString.toLowerCase())
                        || row.getTransactionId().contains(searchString)
                        || row.getId().toString().contains(searchString)
                        || row.getCreatedByName().contains(searchString)) {
                    filteredList.add(row);
                }*/
            }
            filteredWalletRechargeDataArrayList = filteredList;
        }
        notifyDataSetChanged();
    }

    /**
     * Product item view holder
     */
    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvPlayerName;
        AppCompatTextView tvAmount;
        AppCompatTextView tvDescription;
        AppCompatTextView tvType;
        AppCompatTextView tvRechargedBy;
        AppCompatTextView tvCreatedAt;


        ItemViewHolder(View view) {
            super(view);
            tvPlayerName = view.findViewById(R.id.tvPlayerName);
            tvAmount = view.findViewById(R.id.tvAmount);
            tvDescription = view.findViewById(R.id.tvDescriptionValue);
            tvType = view.findViewById(R.id.tvType);
            tvRechargedBy = view.findViewById(R.id.tvRechargedBy);
            tvCreatedAt = view.findViewById(R.id.tvCreatedAt);
        }
    }
}