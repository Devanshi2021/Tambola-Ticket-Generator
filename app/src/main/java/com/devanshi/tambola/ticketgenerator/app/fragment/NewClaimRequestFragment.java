package com.devanshi.tambola.ticketgenerator.app.fragment;

import android.os.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.appcompat.widget.*;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.apis.*;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.Utils;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.io.*;
import java.util.*;

import ir.mirrajabi.searchdialog.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Utils.*;

import retrofit2.*;

public class NewClaimRequestFragment extends BaseFragment {

    private int ticketId = -1;
    private AppCompatEditText tvGameId;
    private String strClaimType = "";
    private AppCompatTextView tvTransactionId;
    private AppCompatButton btnSubmit;
    private ArrayList<ClaimRequestData> claimTypeArrayList;
    private String claimType = "";
    private ArrayList<ClaimTransactionListData> transactionIdArrayList;
    private String transactionId = "";
    private GridView llClaimType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_new_claim_request, container, false);
    }

    @Override
    protected void initializeComponent(View view) {
        final TextView tvHeaderTitle = view.findViewById(R.id.header_tv_title);
        tvHeaderTitle.setText(getString(R.string.newClaimRequest));

        ImageView header_iv_back = view.findViewById(R.id.header_iv_back);
        header_iv_back.setOnClickListener(v -> popBackStackFragment());

        tvGameId = view.findViewById(R.id.tvGameId);
        llClaimType = view.findViewById(R.id.llClaimType);
        fillClaimTypeList();
        tvTransactionId = view.findViewById(R.id.tvTransactionId);
        tvTransactionId.setOnClickListener(v -> showTransactionList());
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        callGetGameId();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == btnSubmit) {
            if (validationCheck()) {
                callAddClaimRequestApi();
                Log.d(TAG, "onClick: validation passed");
            }
        }
    }

    private void callAddClaimRequestApi() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            APIInterface apiInterface = getAPIInterface();
            Call<ClaimResponseModel> newTicketTransactionCall = apiInterface.addClaimRequest(tvGameId.getText().toString().trim(),
                    claimType, transactionId);

            newTicketTransactionCall.enqueue(new Callback<ClaimResponseModel>() {
                @Override
                public void onResponse(Call<ClaimResponseModel> call, Response<ClaimResponseModel> response) {
                    showLoading(false);
                    ClaimResponseModel claimResponseModel = response.body();
                    if (claimResponseModel != null) {
                        Meta meta = claimResponseModel.getMeta();
                        assert meta != null;
                        if (meta.getCode().equals("200")) {
                            replaceFragment(R.id.activity_home_fl_container, requireActivity().getSupportFragmentManager(), new ClaimRequestFragment(), true, false);
                        } else {
                            Utils.showSnackBar(getView(), meta.getMessage(), true, getActivity());
                        }
                    } else {
                        try {
                            Utils.showSnackBar(getView(), response.raw().body().bytes().toString(), true, getActivity());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ClaimResponseModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), t.getMessage(), true, getActivity());
                }
            });
        }
    }

    private boolean validationCheck() {
        if (TextUtils.isEmpty(Objects.requireNonNull(tvGameId.getText()).toString().trim())) {
            Utils.showSnackBar(getView(), "Please try again later due to no game Id", true, getActivity());
            return false;
        }
        if (TextUtils.isEmpty(claimType.trim())) {
            Utils.showSnackBar(getView(), "Please select the claim type", true, getActivity());
            return false;
        } else if (TextUtils.isEmpty(tvTransactionId.getText().toString().trim())) {
            Utils.showSnackBar(getView(), "Please select the transaction Id", true, getActivity());
            return false;
        }
        return true;
    }

    /**
     * show list of Employee number dialog
     */
    private void fillClaimTypeList() {
        if (claimTypeArrayList != null && claimTypeArrayList.size() > 0) {
            CustomGridAdapter customAdapter = new CustomGridAdapter(requireContext(), userClaim);
            llClaimType.setAdapter(customAdapter);
            llClaimType.setOnItemClickListener((parent, view, position, id) -> {
                if (!userClaim[position].equalsIgnoreCase(" ")) {
                    claimType = serverClaim[position];
                    Log.d(TAG, "fillClaimTypeList: selected item " + claimType);
                    customAdapter.setSelectedPosition(position);
                }
            });
        }
    }

    private void callGetGameId() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            Call<GameIdModel> call = getAPIInterface().gameIdRequestApi("");

            call.enqueue(new Callback<GameIdModel>() {
                @Override
                public void onResponse(Call<GameIdModel> call, Response<GameIdModel> response) {
                    showLoading(false);
                    GameIdModel gameIdModel = response.body();
                    assert gameIdModel != null;
                    Meta meta = gameIdModel.getMeta();
                    if (meta.getCode().equalsIgnoreCase("200")) {
                        tvGameId.setText(String.valueOf(gameIdModel.getData().get(0).getGameId()));
                        addListingDetails();
                        fillClaimTypeList();
                        callGetTransactionList();
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                    }
                }

                @Override
                public void onFailure(Call<GameIdModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                }
            });
        }
    }

    /**
     * show list of Employee number dialog
     */
    private void showTransactionList() {
        if (transactionIdArrayList != null && transactionIdArrayList.size() > 0) {
            SimpleSearchDialogCompat<ClaimTransactionListData> simpleSearchDialogCompatForColumn = new SimpleSearchDialogCompat<>(requireActivity(), "Select Transaction Id...",
                    "find transaction ID?", null, transactionIdArrayList, (dialog, item, position) -> {
                transactionId = String.valueOf(item.getTokenId());
                tvTransactionId.setText(item.getTitle());
                dialog.dismiss();
            });
            simpleSearchDialogCompatForColumn.show();
        }
    }

    private void callGetTransactionList() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            Call<ClaimTransactionListModel> call = getAPIInterface().getClaimTransactionList("");

            call.enqueue(new Callback<ClaimTransactionListModel>() {
                @Override
                public void onResponse(Call<ClaimTransactionListModel> call, Response<ClaimTransactionListModel> response) {
                    showLoading(false);
                    ClaimTransactionListModel ticketColumnModel = response.body();
                    assert ticketColumnModel != null;
                    Meta meta = ticketColumnModel.getMeta();
                    if (meta.getCode().equals("200")) {
                        transactionIdArrayList = ticketColumnModel.getData();
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                    }
                }

                @Override
                public void onFailure(Call<ClaimTransactionListModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                }
            });
        }
    }

    String[] userClaim, serverClaim;

    private void addListingDetails() {
        if (claimTypeArrayList == null) {
            claimTypeArrayList = new ArrayList<>();
        } else {
            claimTypeArrayList.clear();
        }
        userClaim = new String[]{
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "10", "11", "12",
                "13", "14", "15", "16",
                "17", "18", "FH", " ",
                "1-2ka4", "4,2ka1", "Drum", "Dandiy",
                "Brunch", "BreakF", "Lunch", "Dinner",
                "AbTak", "RemNo", "Young", "Old",
                "Jaldi7", "Jaldi9", "Jaldi10", "",
                "Rail T", "RainD", "SandV", "Stumps",
                "Trips", "RevTrip", "Twins", "RevTwi",
                "BullE", "Bull S1", "Bull S2", "Bull S3",
                "SplitD", "SD S1", "SD S2", "SD S3",
                "SplitC", "SC S1", "SC S2", "SC S3",
                "SplitL", "SL S1", "SL S2", "SL S3",
                "BL 1", "BL 2", "BL 3", "BL 4",
                "BL 5", "BL 6", "BL 7", "BL 8",
                "BL 9", "BL 10", "BL 11", "BL 12",
                "BL 13", "BL 14", "BL 15", "BL 16",
                "BL 17", "BL 18", " ", " ",
                "FH 1", "FH 2", "FH 3", "FH 4",
                "FH 5", "FH 6", "FH 7", "FH 8",
                "FH 9", "FH 10", "FH 11", "FH 12",
                "FH 13", "FH 14", "FH 15", "FH 16",
                "FH 17", "FH 18", " ", " "
        };
        serverClaim = new String[]{
                "first_line", "second_line", "third_line", "fourth_line",
                "fifth_line", "sixth_line", "seventh_line", "eightth_line",
                "nineth_line", "tenth_line", "eleventh_line", "twelveth_line",
                "thirteenth_line", "fourteen_line", "fifteen_line", "sixteen_line",
                "seventeen_line", "eighteen_line", "fullhouse", " ",
                "1_2_KA_4", "4_2_KA_1", "drum", "dandiya",
                "brunch", "breakfast", "lunch", "dinner",
                "abTakChhapan", "remaining_num", "young", "old",
                "jaldi_7", "jaldi_9", "jaldi_10", "",
                "railway_track", "rain_drop", "sandwich", "stumps",
                "triplets", "rev_triplets", "twins", "rev_twins",
                "bull_eye", "bull_eye_s1", "bull_eye_s2", "bull_eye_s3",
                "split_dandiya", "split_dandiya_s1", "split_corner_s2", "split_corner_s3",
                "split_corner", "split_corner_s1", "split_corner_s2", "split_corner_s3",
                "split_line", "split_line_s1", "split_line_s2", "split_line_s3",
                "block_1", "block_2", "block_3", "block_4",
                "block_5", "block_6", "block_7", "block_8",
                "block_9", "block_10", "block_11", "block_12",
                "block_13", "block_14", "block_15", "block_16",
                "block_17", "block_18", " ", " ",
                "fullhouse_1", "fullhouse_2", "fullhouse_3", "fullhouse_4",
                "fullhouse_5", "fullhouse_6", "fullhouse_7", "fullhouse_8",
                "fullhouse_9", "fullhouse_10", "fullhouse_11", "fullhouse_12",
                "fullhouse_13", "fullhouse_14", "fullhouse_15", "fullhouse_16",
                "fullhouse_17", "fullhouse_18", " ", " "
        };


        // claimTypeArrayList.add(new ClaimRequestData("Bulls Eye", "bull_eye"));
        //claimTypeArrayList.add(new ClaimRequestData("Bulls Eye S1", "bull_eye_s1"));
        //claimTypeArrayList.add(new ClaimRequestData("Bulls Eye S2", "bull_eye_s2"));
        //claimTypeArrayList.add(new ClaimRequestData("Bulls Eye S3", "bull_eye_s3"));
        //claimTypeArrayList.add(new ClaimRequestData("Bulls Eye S4", "bull_eye_s4"));

        //claimTypeArrayList.add(new ClaimRequestData("Split Dandiya", "split_dandiya"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Dandiya S1", "split_dandiya_s1"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Dandiya S2", "split_dandiya_s2"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Dandiya S3", "split_dandiya_s3"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Dandiya S4", "split_dandiya_s4"));

        // claimTypeArrayList.add(new ClaimRequestData("Split Corner", "split_corner"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Corner S1", "split_corner_s1"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Corner S2", "split_corner_s2"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Corner S3", "split_corner_s3"));
        //claimTypeArrayList.add(new ClaimRequestData("Split Corner S4", "split_corner_s4"));

        claimTypeArrayList.add(new ClaimRequestData("Split Line", "split_line"));
        claimTypeArrayList.add(new ClaimRequestData("Split Line S1", "split_line_s1"));
        claimTypeArrayList.add(new ClaimRequestData("Split Line S2", "split_line_s2"));
        claimTypeArrayList.add(new ClaimRequestData("Split Line S3", "split_line_s3"));
        claimTypeArrayList.add(new ClaimRequestData("Split Line S4", "split_line_s4"));

        claimTypeArrayList.add(new ClaimRequestData("Block 1", "block_1"));
        claimTypeArrayList.add(new ClaimRequestData("Block 2", "block_2"));
        claimTypeArrayList.add(new ClaimRequestData("Block 3", "block_3"));
        claimTypeArrayList.add(new ClaimRequestData("Block 4", "block_4"));
        claimTypeArrayList.add(new ClaimRequestData("Block 5", "block_5"));
        claimTypeArrayList.add(new ClaimRequestData("Block 6", "block_6"));
        claimTypeArrayList.add(new ClaimRequestData("Block 7", "block_7"));
        claimTypeArrayList.add(new ClaimRequestData("Block 8", "block_8"));
        claimTypeArrayList.add(new ClaimRequestData("Block 9", "block_9"));
        claimTypeArrayList.add(new ClaimRequestData("Block 10", "block_10"));
        claimTypeArrayList.add(new ClaimRequestData("Block 11", "block_11"));
        claimTypeArrayList.add(new ClaimRequestData("Block 12", "block_12"));
        claimTypeArrayList.add(new ClaimRequestData("Block 13", "block_13"));
        claimTypeArrayList.add(new ClaimRequestData("Block 14", "block_14"));
        claimTypeArrayList.add(new ClaimRequestData("Block 15", "block_15"));
        claimTypeArrayList.add(new ClaimRequestData("Block 16", "block_16"));
        claimTypeArrayList.add(new ClaimRequestData("Block 17", "block_17"));
        claimTypeArrayList.add(new ClaimRequestData("Block 18", "block_18"));
        claimTypeArrayList.add(new ClaimRequestData("1", "first_line"));
        claimTypeArrayList.add(new ClaimRequestData("2", "second_line"));
        claimTypeArrayList.add(new ClaimRequestData("3", "third_line"));
        claimTypeArrayList.add(new ClaimRequestData("4", "fourth_line"));
        claimTypeArrayList.add(new ClaimRequestData("5", "fifth_line"));
        claimTypeArrayList.add(new ClaimRequestData("6", "sixth_line"));
        claimTypeArrayList.add(new ClaimRequestData("7", "seventh_line"));
        claimTypeArrayList.add(new ClaimRequestData("8", "eightth_line"));
        claimTypeArrayList.add(new ClaimRequestData("9", "nineth_line"));
        claimTypeArrayList.add(new ClaimRequestData("10", "tenth_line"));
        claimTypeArrayList.add(new ClaimRequestData("11", "eleventh_line"));
        claimTypeArrayList.add(new ClaimRequestData("12", "twelveth_line"));
        claimTypeArrayList.add(new ClaimRequestData("13", "thirteenth_line"));
        claimTypeArrayList.add(new ClaimRequestData("14", "fourteen_line"));
        claimTypeArrayList.add(new ClaimRequestData("15", "fifteen_line"));
        claimTypeArrayList.add(new ClaimRequestData("16", "sixteen_line"));
        claimTypeArrayList.add(new ClaimRequestData("17", "seventeen_line"));
        claimTypeArrayList.add(new ClaimRequestData("18", "eighteen_line"));

        //claimTypeArrayList.add(new ClaimRequestData("Full House", "fullhouse"));

        claimTypeArrayList.add(new ClaimRequestData("House T1", "fullhouse_1"));
        claimTypeArrayList.add(new ClaimRequestData("House T2", "fullhouse_2"));
        claimTypeArrayList.add(new ClaimRequestData("House T3", "fullhouse_3"));
        claimTypeArrayList.add(new ClaimRequestData("House T4", "fullhouse_4"));
        claimTypeArrayList.add(new ClaimRequestData("House T5", "fullhouse_5"));
        claimTypeArrayList.add(new ClaimRequestData("House T6", "fullhouse_6"));
        claimTypeArrayList.add(new ClaimRequestData("House T7", "fullhouse_7"));
        claimTypeArrayList.add(new ClaimRequestData("House T8", "fullhouse_8"));
        claimTypeArrayList.add(new ClaimRequestData("House T9", "fullhouse_9"));
        claimTypeArrayList.add(new ClaimRequestData("House T10", "fullhouse_10"));
        claimTypeArrayList.add(new ClaimRequestData("House T11", "fullhouse_11"));
        claimTypeArrayList.add(new ClaimRequestData("House T12", "fullhouse_12"));
        claimTypeArrayList.add(new ClaimRequestData("House T13", "fullhouse_13"));
        claimTypeArrayList.add(new ClaimRequestData("House T14", "fullhouse_14"));
        claimTypeArrayList.add(new ClaimRequestData("House T15", "fullhouse_15"));
        claimTypeArrayList.add(new ClaimRequestData("House T16", "fullhouse_16"));
        claimTypeArrayList.add(new ClaimRequestData("House T17", "fullhouse_17"));
        claimTypeArrayList.add(new ClaimRequestData("House T18", "fullhouse_18"));
        claimTypeArrayList.add(new ClaimRequestData("House T19", "fullhouse_19"));
        claimTypeArrayList.add(new ClaimRequestData("House T20", "fullhouse_20"));
        claimTypeArrayList.add(new ClaimRequestData("House T21", "fullhouse_21"));
        claimTypeArrayList.add(new ClaimRequestData("House T22", "fullhouse_22"));
        claimTypeArrayList.add(new ClaimRequestData("House T23", "fullhouse_23"));
        claimTypeArrayList.add(new ClaimRequestData("House T24", "fullhouse_24"));

        //claimTypeArrayList.add(new ClaimRequestData("1 2 Ka 4", "1_2_KA_4"));
        //claimTypeArrayList.add(new ClaimRequestData("4 2 Ka 1", "4_2_KA_1"));
        //claimTypeArrayList.add(new ClaimRequestData("Ab Tak Chhapan 56", "abTakChhapan"));
        //claimTypeArrayList.add(new ClaimRequestData("Brunch", "brunch"));
        //claimTypeArrayList.add(new ClaimRequestData("Dinner", "dinner"));
        //claimTypeArrayList.add(new ClaimRequestData("Breakfast", "breakfast"));
        //claimTypeArrayList.add(new ClaimRequestData("Lunch", "lunch"));
        //claimTypeArrayList.add(new ClaimRequestData("Young", "young"));
        //claimTypeArrayList.add(new ClaimRequestData("Old", "old"));
        //claimTypeArrayList.add(new ClaimRequestData("Remaining Num", "remaining_num"));

        //claimTypeArrayList.add(new ClaimRequestData("Drum", "drum"));
        //claimTypeArrayList.add(new ClaimRequestData("Dandiya", "dandiya"));
        //claimTypeArrayList.add(new ClaimRequestData("Jaldi 7", "jaldi_7"));
        //claimTypeArrayList.add(new ClaimRequestData("Jaldi 9", "jaldi_9"));
        //claimTypeArrayList.add(new ClaimRequestData("Jaldi 10", "jaldi_10"));
        //claimTypeArrayList.add(new ClaimRequestData("Railway Track", "railway_track"));
        //claimTypeArrayList.add(new ClaimRequestData("Rain Drop", "rain_drop"));
        //claimTypeArrayList.add(new ClaimRequestData("Sandwich", "sandwich"));
        //claimTypeArrayList.add(new ClaimRequestData("Stumps", "stumps"));
        // claimTypeArrayList.add(new ClaimRequestData("Triplets", "triplets"));
        //claimTypeArrayList.add(new ClaimRequestData("Rev Triplets", "rev_triplets"));
        //claimTypeArrayList.add(new ClaimRequestData("Twins", "twins"));
        //claimTypeArrayList.add(new ClaimRequestData("Rev Twins", "rev_twins"));


    }

}
