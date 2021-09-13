package com.devanshi.tambola.ticketgenerator.app.fragment;

import android.os.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.appcompat.widget.*;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.adapter.*;
import com.devanshi.tambola.ticketgenerator.app.apis.*;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.Utils;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.io.*;
import java.util.*;

import ir.mirrajabi.searchdialog.*;
import retrofit2.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Utils.*;

public class NewTicketTransactionFragment extends BaseFragment implements CustomerAdapter.OnItemClick, CustomerAdapter.customerClick {

    private GridSpacingItemDecoration spacingItemDecoration;
    private int ticketId = -1;
    private AppCompatTextView tvTime1, tvTime2, tvTime3, tvTime4, tvTime5, tvTime6, tvTime7, tvTime8, tvGpay, tvPaytm, tvUPI, tvOther;
    private AppCompatEditText etAmount;
    private AppCompatButton btnSubmit;
    private AppCompatTextView tvTicketSerial;
    private AppCompatTextView tvTicketColumn;
    private AppCompatEditText tvTicketPlayer;
    private AppCompatTextView tvTicketId;
    private ArrayList<TicketSerialData> ticketSerialDataArrayList;
    private int ticketSerialId = -1;
    private ArrayList<TicketColumnData> ticketColumnDataArrayList;
    private int ticketColumnId = -1;
    private ArrayList<TicketTransactionTicketIdModel> ticketTransactionTicketIdModelArrayList;
    private String ticketStatus = "";
    Preference preference;
    String selectedTime = "";
    String paymentMethod = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_new_ticket_transaction, container, false);
    }

    @Override
    protected void initializeComponent(View view) {
        final TextView tvHeaderTitle = view.findViewById(R.id.header_tv_title);
        tvHeaderTitle.setText(getString(R.string.newTicketTransaction));

        ImageView header_iv_back = view.findViewById(R.id.header_iv_back);
        header_iv_back.setOnClickListener(v->popBackStackFragment());

        preference = new Preference(requireActivity());

        tvTicketPlayer = view.findViewById(R.id.tvTicketPlayer);
        tvTicketSerial = view.findViewById(R.id.tvTicketSerial);
        tvTicketSerial.setOnClickListener(v->showTicketSerialDialog());
        etAmount = view.findViewById(R.id.etAmount);
        tvTicketColumn = view.findViewById(R.id.tvTicketColumn);
        tvTicketColumn.setOnClickListener(v->showTicketColumnDialog());
        tvTicketId = view.findViewById(R.id.tvTicketId);
        tvTicketId.setOnClickListener(v->showTicketIdDialog());
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        tvTime1 = view.findViewById(R.id.tvTime1);
        tvTime1.setOnClickListener(this);
        tvTime2 = view.findViewById(R.id.tvTime2);
        tvTime2.setOnClickListener(this);
        tvTime3 = view.findViewById(R.id.tvTime3);
        tvTime3.setOnClickListener(this);
        tvTime4 = view.findViewById(R.id.tvTime4);
        tvTime4.setOnClickListener(this);
        tvTime5 = view.findViewById(R.id.tvTime5);
        tvTime5.setOnClickListener(this);
        tvTime6 = view.findViewById(R.id.tvTime6);
        tvTime6.setOnClickListener(this);
        tvTime7 = view.findViewById(R.id.tvTime7);
        tvTime7.setOnClickListener(this);
        tvTime8 = view.findViewById(R.id.tvTime8);
        tvTime8.setOnClickListener(this);
        tvGpay = view.findViewById(R.id.tvGpay);
        tvGpay.setOnClickListener(this);
        tvPaytm = view.findViewById(R.id.tvPaytm);
        tvPaytm.setOnClickListener(this);
        tvUPI = view.findViewById(R.id.tvUPI);
        tvUPI.setOnClickListener(this);
        tvOther = view.findViewById(R.id.tvOther);
        tvOther.setOnClickListener(this);


        callGetTicketSerialList();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == btnSubmit) {
            if (validationCheck()) {
               callAddTransactionApi();
                Log.d(TAG, "onClick: validation passed");
            }
        } else if (v==tvTime1){
          selectedTime = "14:30";
          tvTime1.setBackgroundResource(R.drawable.rounded_text);
          tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
          tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
          tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
          tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
          tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
          tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
          tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime2){
            selectedTime = "15:00";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.rounded_text);
            tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime3){
            selectedTime = "15:30";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime3.setBackgroundResource(R.drawable.rounded_text);
            tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime4){
            selectedTime = "17:00";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime4.setBackgroundResource(R.drawable.rounded_text);
            tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime5){
            selectedTime = "17:30";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime5.setBackgroundResource(R.drawable.rounded_text);
            tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime6){
            selectedTime = "21:30";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime6.setBackgroundResource(R.drawable.rounded_text);
            tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime7){
            selectedTime = "22:00";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime7.setBackgroundResource(R.drawable.rounded_text);
            tvTime8.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvTime8){
            selectedTime = "22:30";
            tvTime1.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime2.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime3.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime4.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime5.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime6.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime7.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvTime8.setBackgroundResource(R.drawable.rounded_text);
        } else if (v==tvGpay){
            paymentMethod = "Google Pay";
            tvGpay.setBackgroundResource(R.drawable.rounded_text);
            tvPaytm.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvUPI.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvOther.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvPaytm){
            paymentMethod = "Paytm";
            tvGpay.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvPaytm.setBackgroundResource(R.drawable.rounded_text);
            tvUPI.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvOther.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvUPI){
            paymentMethod = "UPI";
            tvGpay.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvPaytm.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvUPI.setBackgroundResource(R.drawable.rounded_text);
            tvOther.setBackgroundResource(R.drawable.roundedcorner_gray);
        } else if (v==tvOther){
            paymentMethod = "Others";
            tvPaytm.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvUPI.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvGpay.setBackgroundResource(R.drawable.roundedcorner_gray);
            tvOther.setBackgroundResource(R.drawable.rounded_text);
        }
    }

    private void callAddTransactionApi() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            APIInterface apiInterface = getAPIInterface();
            Call<NewTicketTransactionRespModel> newTicketTransactionCall = apiInterface.addTicketTransaction(tvTicketPlayer.getText().toString(), ticketSerialId, ticketColumnId, ticketId, preference.getUserId(),
                    selectedTime, Objects.requireNonNull(etAmount.getText()).toString(),
//                    Objects.requireNonNull(etTransactionID.getText()).toString(), ticketStatus);
                    "", paymentMethod);

            newTicketTransactionCall.enqueue(new Callback<NewTicketTransactionRespModel>() {
                @Override
                public void onResponse(Call<NewTicketTransactionRespModel> call, Response<NewTicketTransactionRespModel> response) {
                    showLoading(false);
                    NewTicketTransactionRespModel newTicketTransactionRespModel = response.body();
                    assert newTicketTransactionRespModel != null;
                    Meta meta = newTicketTransactionRespModel.getMeta();
                    if (meta.getCode().equals("200")) {
                        NewTicketTransactionData newTicketTransactionData = newTicketTransactionRespModel.getData();
//                        Utils.downloadFile(requireActivity(), newTicketTransactionData.getImage());
                        replaceFragment(R.id.activity_home_fl_container, requireActivity().getSupportFragmentManager(), new TicketTransactionFragment(), true, false);
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, getActivity());
                    }
                }

                @Override
                public void onFailure(Call<NewTicketTransactionRespModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), t.getMessage(), true, getActivity());
                }
            });
        }
    }

    private boolean validationCheck() {
        if (TextUtils.isEmpty(tvTicketPlayer.getText().toString().trim())) {
            Utils.showSnackBar(getView(), "Please select the player", true, getActivity());
            return false;
        }if (TextUtils.isEmpty(tvTicketSerial.getText().toString().trim())) {
            Utils.showSnackBar(getView(), "Please select the ticket serial index", true, getActivity());
            return false;
        }else if (TextUtils.isEmpty(tvTicketColumn.getText().toString().trim())) {
            Utils.showSnackBar(getView(), "Please select the ticket column", true, getActivity());
            return false;
        } else if (TextUtils.isEmpty(tvTicketId.getText().toString().trim())) {
            Utils.showSnackBar(getView(), "Please select the ticket", true, getActivity());
            return false;
        } else if (TextUtils.isEmpty(Objects.requireNonNull(etAmount.getText()).toString().trim())) {
            Utils.showSnackBar(getView(), "Please enter \'Amount\'", true, getActivity());
            return false;
        }/* else if (TextUtils.isEmpty(Objects.requireNonNull(etTransactionID.getText()).toString().trim())) {
            Utils.showSnackBar(getView(), "Please enter \'Transaction ID\'", true, getActivity());
            return false;
        }*/ else if (TextUtils.isEmpty(selectedTime.trim())) {
            Utils.showSnackBar(getView(), "Please select the Game On", true, getActivity());
            return false;
        }else if (TextUtils.isEmpty(paymentMethod.trim())) {
            Utils.showSnackBar(getView(), "Please select the Paid By", true, getActivity());
            return false;
        }
        return true;

    }

    /**
     * show list of Employee number dialog
     */
    private void showTicketSerialDialog() {
        if (ticketSerialDataArrayList != null && ticketSerialDataArrayList.size() > 0) {
            SimpleSearchDialogCompat<TicketSerialData> simpleSearchDialogCompatForSerial = new SimpleSearchDialogCompat<>(requireActivity(), "Select Ticket Serial...",
                    "find serial?", null, ticketSerialDataArrayList, (dialog, item, position) -> {
                ticketSerialId = item.getId();
                tvTicketSerial.setText(item.getTitle());
                if (ticketColumnDataArrayList != null)
                    ticketColumnDataArrayList.clear();
                dialog.dismiss();
                callGetTicketColumnList(ticketSerialId);
                ticketColumnId = -1;
                ticketId = -1;
                tvTicketColumn.setText("");
                tvTicketId.setText("");
            });

            simpleSearchDialogCompatForSerial.show();
        }
    }

    private void callGetTicketSerialList() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            Call<TicketSerialModel> call = getAPIInterface().listTicketSerialApi("");

            call.enqueue(new Callback<TicketSerialModel>() {
                @Override
                public void onResponse(Call<TicketSerialModel> call, Response<TicketSerialModel> response) {
                    showLoading(false);
                    TicketSerialModel ticketSerialModel = response.body();
                    assert ticketSerialModel != null;
                    Meta meta = ticketSerialModel.getMeta();
                    if (meta.getCode().equals("200")) {
                        ticketSerialDataArrayList = ticketSerialModel.getData();
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                    }
                }

                @Override
                public void onFailure(Call<TicketSerialModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                }
            });
        }
    }

    /**
     * show list of Employee number dialog
     */
    private void showTicketColumnDialog() {
        if (ticketColumnDataArrayList != null && ticketColumnDataArrayList.size() > 0) {
            SimpleSearchDialogCompat<TicketColumnData> simpleSearchDialogCompatForColumn = new SimpleSearchDialogCompat<>(requireActivity(), "Select Ticket Column...",
                    "find column?", null, ticketColumnDataArrayList, (dialog, item, position) -> {
                ticketColumnId = item.getId();
                tvTicketColumn.setText(item.getTitle());
                dialog.dismiss();
                if (ticketTransactionTicketIdModelArrayList != null)
                    ticketTransactionTicketIdModelArrayList.clear();
                callGetTicketList();
                ticketId = -1;
                tvTicketId.setText("");
            });
            simpleSearchDialogCompatForColumn.show();
        }
    }

    private void callGetTicketList() {
        if (NetworkUtils.isOnline(requireActivity(), true, false)) {
            showLoading(true);
            Call<ListTicketModel> call = getAPIInterface().listTicketForTicketTransactionApi(ticketSerialId, ticketColumnId);

            call.enqueue(new Callback<ListTicketModel>() {
                @Override
                public void onResponse(Call<ListTicketModel> call, Response<ListTicketModel> response) {
                    if (response.code() == 200) {
                        ListTicketModel listTicketModel = response.body();
                        Meta meta = Objects.requireNonNull(listTicketModel).getMeta();
                        if (meta.getCode().equals("200")) {
                            ArrayList<ListTicketData> ticketDataArrayList = listTicketModel.getListTicketData();
                            ticketTransactionTicketIdModelArrayList = new ArrayList<>();
                            tvTicketId.setHint("Ticket Id");
                            for (ListTicketData listTicketData : ticketDataArrayList) {
                                String displayValue = listTicketData.getId().toString().concat(" - From ").concat(listTicketData.getFromSerialNo().toString()).concat(" to ").concat(listTicketData.getToSerialNo().toString());
                                ticketTransactionTicketIdModelArrayList.add(new TicketTransactionTicketIdModel(displayValue, listTicketData.getId()));
                            }
                            ticketId = -1;
                            tvTicketId.setHint("Ticket Id");
                            showLoading(false);
                        } else {
                            tvTicketId.setHint(meta.getMessage());
                            Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                            showLoading(false);
                        }
                    } else {
                        ticketTransactionTicketIdModelArrayList.clear();
                        ticketId = -1;
                        tvTicketId.setHint("No tickets found.");
                        Utils.showSnackBar(getView(), getString(R.string.alert_common_error).concat("Error-").concat(String.valueOf(response.code())), true, requireActivity());
                        showLoading(false);
                    }
                }

                @Override
                public void onFailure(Call<ListTicketModel> call, Throwable t) {
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                    t.printStackTrace();
                    setProgress(false);
                    setEmptyView(true);
                }
            });
        }
    }

    private void callGetTicketColumnList(int ticketSerialId) {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            Call<TicketColumnModel> call = getAPIInterface().listTicketColumnApi(ticketSerialId);

            call.enqueue(new Callback<TicketColumnModel>() {
                @Override
                public void onResponse(Call<TicketColumnModel> call, Response<TicketColumnModel> response) {
                    showLoading(false);
                    TicketColumnModel ticketColumnModel = response.body();
                    assert ticketColumnModel != null;
                    Meta meta = ticketColumnModel.getMeta();
                    if (meta.getCode().equals("200")) {
                        ticketColumnDataArrayList = ticketColumnModel.getData();
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                    }
                }

                @Override
                public void onFailure(Call<TicketColumnModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                }
            });
        }
    }


    private void showTicketIdDialog() {
        if (ticketTransactionTicketIdModelArrayList != null && ticketTransactionTicketIdModelArrayList.size() > 0) {
            SimpleSearchDialogCompat<TicketTransactionTicketIdModel> simpleSearchDialogCompatForSerial = new SimpleSearchDialogCompat<>(requireActivity(), "Select Ticket Serial...",
                    "find serial?", null, ticketTransactionTicketIdModelArrayList, (dialog, item, position) -> {
                ticketId = item.getValue();
                tvTicketId.setText(item.getTitle());
                dialog.dismiss();
            });

            simpleSearchDialogCompatForSerial.show();
        }
    }

    @Override
    public void onClickEdit(int position) {

    }

    @Override
    public void onClickDelete(int position) {

    }

    @Override
    public void onClickCustomer(int position, CustomerModel customerModel) {
        Log.d(TAG, "onClickCustomer: "+position);
//        tvTicketPlayer.setText(customerModel.getName());
//        playerId = customerModel.getId();
//        rlCustomerView.setVisibility(View.GONE);
//        rlCartView.setVisibility(View.VISIBLE);
    }

    /*private void callGetPlayerList() {
        rlCustomerView.setVisibility(View.GONE);
        rlCartView.setVisibility(View.VISIBLE);
        editTextCustomerNumber.setText("");
        if (customerAdapter == null){
            customerAdapter = new CustomerAdapter(getActivity(), customerModelArrayList, this, this,false);
            rvCustomer.addItemDecoration(spacingItemDecoration);
            rvCustomer.setAdapter(customerAdapter);
        }

        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            customerModelArrayList.clear();
            setProgress(true);

            APIInterface apiInterface = Utils.getAPIInterface();
            Call<CustomerRespModel> playerListApi = apiInterface.getPlayerListApi("");

            playerListApi.enqueue(new Callback<CustomerRespModel>() {
                @Override
                public void onResponse(Call<CustomerRespModel> call, Response<CustomerRespModel> response) {
                    setProgress(false);
                    CustomerRespModel customerRespModel = response.body();
                    if (customerRespModel.getMeta().getCode().equals("200")){
                        Log.d(TAG, "onResponse: niraj");
                        customerModelArrayList = customerRespModel.getData();
                        customerAdapter.addValue(customerModelArrayList);
                        callGetTicketSerialList();
                    }else {
                        Utils.showSnackBar(getView(), customerRespModel.getMeta().getMessage(), true, getActivity());
                    }
                }

                @Override
                public void onFailure(Call<CustomerRespModel> call, Throwable t) {
                    setProgress(false);
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                }
            });
        }
    }*/

    /** Create a File for saving an image or video
     * @param s*/
    private  File getOutputMediaFile(String s){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/Tambola_Ticket_Generator"
                + "/Tickets");

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }
        // Create a media file name
        File mediaFile;
        String mImageName=s+".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }
}
