package com.devanshi.tambola.ticketgenerator.app.fragment;

import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;
import androidx.appcompat.widget.*;
import androidx.recyclerview.widget.*;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.adapter.*;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.Utils;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.util.*;

import retrofit2.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Utils.*;

public class WalletRechargeFragment extends BaseFragment {
    private Preference preference;
    private ImageView ivCart;
    private EditText editTextCustomerNumber;
    private LinearLayout llSearch;

    /**
     * Products adapter
     */
    private WalletRechargeListAdapter walletRechargeListAdapter;

    /**
     * Product array list
     */
    private ArrayList<WalletRechargeData> walletRechargeDataArrayList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_wallet_recharge, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        callGetWalletRechargeList();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void initializeComponent(View view) {
        final TextView tvHeaderTitle = view.findViewById(R.id.header_tv_title);
        AppCompatButton btnAddWalletRecharge = view.findViewById(R.id.btnAddWalletRecharge);
        tvHeaderTitle.setText(getString(R.string.walletRecharge));
        preference = new Preference(Objects.requireNonNull(getContext()));
        walletRechargeDataArrayList = new ArrayList<>();
        ivCart = view.findViewById(R.id.ivCart);
        ivCart.setVisibility(View.INVISIBLE);
        llSearch = view.findViewById(R.id.llSearch);
        editTextCustomerNumber = view.findViewById(R.id.editTextCustomerNumber);

        view.findViewById(R.id.clearSearch).setOnClickListener(v -> {
            editTextCustomerNumber.setText("");
            walletRechargeListAdapter.setFilter("");
            llSearch.setVisibility(View.GONE);
            ivCart.setVisibility(View.VISIBLE);
            if (NetworkUtils.isOnline(getActivity(), true, false)){
                btnAddWalletRecharge.setVisibility(View.VISIBLE);
            } else {
                btnAddWalletRecharge.setVisibility(View.GONE);
            }
        });

        btnAddWalletRecharge.setOnClickListener(v -> {
            preference.setPrevousFragmentForAddUpdate(Constants.ADD);
            requireFragmentManager().beginTransaction().replace(R.id.activity_home_fl_container, new NewWalletRechargeFragment(), NewWalletRechargeFragment.class.getSimpleName()).addToBackStack(NewTicketTransactionFragment.class.getSimpleName()).commit();
        });

        //Displays the best deal products
        RecyclerView walletRechargeRecyclerView = view.findViewById(R.id.recyclerview);

        int SPAN_2 = 1;
        GridLayoutManager gridManager = new GridLayoutManager(requireActivity(), SPAN_2);
        walletRechargeRecyclerView.setLayoutManager(gridManager);
        walletRechargeListAdapter = new WalletRechargeListAdapter(requireActivity(), walletRechargeDataArrayList);

        int spacing = getResources().getDimensionPixelSize(R.dimen.dimen_10); // 50px
        GridSpacingItemDecoration spacingItemDecoration = new GridSpacingItemDecoration(SPAN_2, spacing, true);

        walletRechargeRecyclerView.addItemDecoration(spacingItemDecoration);
        walletRechargeRecyclerView.setAdapter(walletRechargeListAdapter);
        editTextCustomerNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                walletRechargeListAdapter.setFilter(s);
                if (walletRechargeListAdapter.getItemCount()==0 && NetworkUtils.isOnline(getActivity(), true, false)) {
                    btnAddWalletRecharge.setVisibility(View.VISIBLE);
                } else {
                    btnAddWalletRecharge.setVisibility(View.GONE);
                }
            }
        });
    }

    private void callGetWalletRechargeList() {
        if (NetworkUtils.isOnline(requireActivity(), true, false)) {
            setProgress(true);
            Call<WalletRechargeModel> call = getAPIInterface().listWalletRechargeApi("");

            call.enqueue(new Callback<WalletRechargeModel>() {
                @Override
                public void onResponse(Call<WalletRechargeModel> call, Response<WalletRechargeModel> response) {
                    setProgress(false);
                    WalletRechargeModel walletRechargeModel = response.body();
                    if (walletRechargeModel == null){
                        Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                        return;
                    }
                    Meta meta = walletRechargeModel.getMeta();
                    if (meta.getCode().equals("200")){
                        walletRechargeDataArrayList = walletRechargeModel.getData();
                        walletRechargeListAdapter.refreshAdapter(walletRechargeDataArrayList);
                        setEmptyView(walletRechargeDataArrayList.isEmpty());
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                    }
                }

                @Override
                public void onFailure(Call<WalletRechargeModel> call, Throwable t) {
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                    t.printStackTrace();
                    setProgress(false);
                    setEmptyView(true);
                }
            });
        } else {
            setProgress(false);
            if (walletRechargeDataArrayList == null || walletRechargeDataArrayList.isEmpty()) {
                setEmptyView(true);
            } else {
                setEmptyView(false);
            }
        }
    }
}
