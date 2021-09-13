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

import java.util.*;

import ir.mirrajabi.searchdialog.*;
import retrofit2.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Utils.*;

public class NewWalletRechargeFragment extends BaseFragment {

    private AppCompatTextView tvPlayerName;
    private AppCompatEditText etDescription;
    private AppCompatEditText etAmount;
    private String[] transactions = new String[]{"Select Transaction Type", "Credit", "Debit"};
    private Preference preference;
    private AppCompatButton btnSubmit;
    private String selectedTransactionType = "";
    private Integer selectedPlayer = -1;
    private ArrayList<PlayerNameIdModel> playerNameIdModelArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_new_wallet_recharge , container, false);
    }

    @Override
    protected void initializeComponent(View view) {
        preference = new Preference(requireContext());
        final TextView tvHeaderTitle = view.findViewById(R.id.header_tv_title);
        tvHeaderTitle.setText(getString(R.string.newWalletRechargeRequest));
        ImageView header_iv_back = view.findViewById(R.id.header_iv_back);
        tvPlayerName = view.findViewById(R.id.tvPlayerName);
        Spinner transactionType = view.findViewById(R.id.tvType);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        etDescription = view.findViewById(R.id.etDescription);
        etAmount = view.findViewById(R.id.etAmount);
        AppCompatEditText tvRechargedBy = view.findViewById(R.id.tvRechargedBy);
        tvRechargedBy.setText(String.valueOf(preference.getUserId()));
        tvRechargedBy.setEnabled(false);

        header_iv_back.setOnClickListener(v -> popBackStackFragment());
        btnSubmit.setOnClickListener(this);
        tvPlayerName.setOnClickListener(v->showPlayerId());

        callGetPlayerListApi();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.spinner_adapter_custom_item, transactions);
        adapter.setDropDownViewResource(R.layout.spinner_custom_item);
        transactionType.setAdapter(adapter);
        transactionType.setOnItemSelectedListener(transactionTypeListener);
        transactionType.setSelection(0);

    }

    private void showPlayerId() {
        if (playerNameIdModelArrayList != null && playerNameIdModelArrayList.size() > 0) {
            SimpleSearchDialogCompat<PlayerNameIdModel> simpleSearchDialogCompatForSerial = new SimpleSearchDialogCompat<>(requireActivity(), "Select Player",
                    "find serial?", null, playerNameIdModelArrayList, (dialog, item, position) -> {
                selectedPlayer = item.getValue();
                String[] splits = item.getTitle().split("-");
                tvPlayerName.setText(splits[0].trim());
                dialog.dismiss();
            });

            simpleSearchDialogCompatForSerial.show();
        }
    }

    private AdapterView.OnItemSelectedListener transactionTypeListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String itemAtPosition = (String) parent.getItemAtPosition(position);
            if (position != 0) {
                selectedTransactionType = itemAtPosition;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void callGetPlayerListApi() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            APIInterface apiInterface = getAPIInterface();
            Call<PlayerNameModel> newTicketTransactionCall = apiInterface.listPlayerAPI("");

            newTicketTransactionCall.enqueue(new Callback<PlayerNameModel>() {
                @Override
                public void onResponse(Call<PlayerNameModel> call, Response<PlayerNameModel> response) {
                    showLoading(false);
                    PlayerNameModel playerNameModel = response.body();
                    if (playerNameModel != null) {
                        Meta meta = playerNameModel.getMeta();
                        assert meta != null;
                        if (meta.getCode().equals("200")) {
                            ArrayList<PlayerNameData> playerNameModelData = playerNameModel.getData();
                            playerNameIdModelArrayList = new ArrayList<>();
                            for (PlayerNameData playerNameData: playerNameModelData){
                                String displayValue = playerNameData.getName().concat(" - ").concat(playerNameData.getMobileNo());
                                playerNameIdModelArrayList.add(new PlayerNameIdModel(displayValue, playerNameData.getId()));
                            }
                            tvPlayerName.setHint("Select player");
                        } else {
                            playerNameIdModelArrayList.clear();
                            selectedPlayer = -1;
                            tvPlayerName.setHint("No players found.");
                            Utils.showSnackBar(getView(), meta.getMessage(), true, getActivity());
                        }
                    } else {
                        Utils.showSnackBar(getView(), response.errorBody().toString(), true, getActivity());
                    }
                }

                @Override
                public void onFailure(Call<PlayerNameModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), t.getMessage(), true, getActivity());
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == btnSubmit) {
            if (validationCheck()) {
                callWalletRechargeRequest();
                Log.d(TAG, "onClick: validation passed");
            }
        }
    }

    private void callWalletRechargeRequest() {
        if (NetworkUtils.isOnline(getActivity(), true, false)) {
            showLoading(true);
            APIInterface apiInterface = getAPIInterface();
            Call<NewWalletRechargeModel> newTicketTransactionCall = apiInterface.walletRechargeApi(preference.getUserId(),
                    selectedPlayer, Objects.requireNonNull(etAmount.getText()).toString(),
                    selectedTransactionType, Objects.requireNonNull(etDescription.getText()).toString());

            newTicketTransactionCall.enqueue(new Callback<NewWalletRechargeModel>() {
                @Override
                public void onResponse(Call<NewWalletRechargeModel> call, Response<NewWalletRechargeModel> response) {
                    showLoading(false);
                    NewWalletRechargeModel newWalletRechargeModel = response.body();
                    if (newWalletRechargeModel != null) {
                        Meta meta = newWalletRechargeModel.getMeta();
                        assert meta != null;
                        if (meta.getCode().equals("200")) {
                            replaceFragment(R.id.activity_home_fl_container, requireActivity().getSupportFragmentManager(), new WalletRechargeFragment(), true, false);
                        } else {
                            Utils.showSnackBar(getView(), meta.getMessage(), true, getActivity());
                        }
                    } else {
                        Utils.showSnackBar(getView(), response.message(), true, getActivity());
                    }
                }

                @Override
                public void onFailure(Call<NewWalletRechargeModel> call, Throwable t) {
                    showLoading(false);
                    Utils.showSnackBar(getView(), t.getMessage(), true, getActivity());
                }
            });
        }
    }

    private boolean validationCheck() {
        if (selectedPlayer == -1) {
            Utils.showSnackBar(getView(), "Please select player", true, getActivity());
            return false;
        }
        if (TextUtils.isEmpty(Objects.requireNonNull(etAmount.getText()).toString())) {
            Utils.showSnackBar(getView(), "Please enter amount", true, getActivity());
            return false;
        } else if (TextUtils.isEmpty(selectedTransactionType.trim())) {
            Utils.showSnackBar(getView(), "Please select the transaction type", true, getActivity());
            return false;
        }
        return true;
    }
}
