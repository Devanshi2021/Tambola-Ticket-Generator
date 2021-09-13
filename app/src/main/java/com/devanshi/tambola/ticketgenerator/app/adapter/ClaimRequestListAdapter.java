package com.devanshi.tambola.ticketgenerator.app.adapter;

import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;
import androidx.appcompat.widget.*;
import androidx.recyclerview.widget.*;

import com.bumptech.glide.*;
import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.util.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Constants.*;

/**
 * Holds the view for Product List
 */
public class ClaimRequestListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<ClaimListData> listClaimDataArrayList;
    private ArrayList<ClaimListData> filteredListClaimDataArrayList;
    private Context context;
    private productEditClick productEditClick;
    private boolean editUpdate;


    public ClaimRequestListAdapter(final Context context, final ArrayList<ClaimListData> listTicketDataArrayList, final productEditClick productEditClick, final boolean editUpdate) {
        this.listClaimDataArrayList = listTicketDataArrayList;
        this.filteredListClaimDataArrayList = listTicketDataArrayList;
        this.context = context;
        this.productEditClick = productEditClick;
        this.editUpdate = editUpdate;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_claim_request, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final ClaimListData model = filteredListClaimDataArrayList.get(position);
        final ItemViewHolder mvh = (ItemViewHolder) holder;
        mvh.tvId.setText(context.getString(R.string.str_id, model.getId()));
        mvh.tvGameId.setText(context.getString(R.string.game_id, model.getGameId()));
        mvh.tvTransactionId.setText(context.getString(R.string.transaction_id, model.getTransactionId()));
        mvh.tvClaimType.setText(context.getString(R.string.claim_type,model.getClaimType()));
        mvh.tvClaimStatus.setText(context.getString(R.string.claim_status, model.getClaimStatus()));
        mvh.tvDownload.setOnClickListener(v->{
            Log.d(TAG, "onBindViewHolder");
            Utils.downloadFile(context, model.getClaimTicketImage());
        });

        mvh.tvShare.setOnClickListener(v->{
            productEditClick.onShareClick(model);
        });
        Glide.with(context).load(model.getClaimTicketImage()).into(mvh.ivImage);

        /*String playerName = mvh.tvGameId.getText().toString();
        String transactionId = mvh.tvTransactionId.getText().toString();
        String ticketId = mvh.tvId.getText().toString();
        String createdBy = mvh.tvClaimType.getText().toString();

        if (playerName.toLowerCase().indexOf(searchString.toLowerCase(), positionColon(playerName)) > -1){
            int startPos = playerName.toLowerCase().indexOf(searchString.toLowerCase(), positionColon(playerName));
            int endPos = startPos + searchString.length();
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(playerName);
            spanString.setSpan(new ForegroundColorSpan(Color.RED),
                    startPos,
                    endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvGameId.setText(spanString);
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
            Spannable spanString = Spannable.Factory.getInstance().newSpannable(mvh.tvClaimtype.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mvh.tvClaimtype.setText(spanString);
        }*/

    }

    private int positionColon(String strings){
        return strings.indexOf(':')+1;
    }

    @Override
    public int getItemCount() {
        return filteredListClaimDataArrayList.size();
    }

    public void refrestAdapter(ArrayList<ClaimListData> listTicketDataArrayList) {
        this.listClaimDataArrayList = listTicketDataArrayList;
        this.filteredListClaimDataArrayList = listTicketDataArrayList;
        notifyDataSetChanged();
    }

    String searchString = "";
    public void setFilter(CharSequence charSequence){
        searchString = charSequence.toString();
        if (searchString.isEmpty()) {
            filteredListClaimDataArrayList = listClaimDataArrayList;
        } else {
            ArrayList<ClaimListData> filteredList = new ArrayList<>();
            for (ClaimListData row : listClaimDataArrayList) {
                /*if (row.getPlayerName().toLowerCase().contains(searchString.toLowerCase())
                        || row.getTransactionId().contains(searchString)
                        || row.getId().toString().contains(searchString)
                        || row.getCreatedByName().contains(searchString)) {
                    filteredList.add(row);
                }*/
            }
            filteredListClaimDataArrayList = filteredList;
        }
        notifyDataSetChanged();
    }

    /**
     * Product item view holder
     */
    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvId;
        AppCompatTextView tvGameId;
        AppCompatTextView tvTransactionId;
        AppCompatTextView tvClaimType;
        AppCompatTextView tvClaimStatus;
        TextView tvDownload, tvShare;
        AppCompatImageView ivImage;


        ItemViewHolder(View view) {
            super(view);
            ivImage = view.findViewById(R.id.imageView);
            tvId = view.findViewById(R.id.tvId);
            tvGameId = view.findViewById(R.id.tvGameId);
            tvTransactionId = view.findViewById(R.id.tvTransactionId);
            tvClaimType = view.findViewById(R.id.tvClaimType);
            tvClaimStatus = view.findViewById(R.id.tvClaimStatus);
            tvDownload = view.findViewById(R.id.tvDownload);
            tvShare = view.findViewById(R.id.tvShare);
        }
    }

    public interface productEditClick{
        void onShareClick(ClaimListData claimListData);
    }
}