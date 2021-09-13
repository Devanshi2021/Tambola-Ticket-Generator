package com.devanshi.tambola.ticketgenerator.app.fragment;

import android.app.*;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;

import com.devanshi.tambola.ticketgenerator.app.*;
import com.devanshi.tambola.ticketgenerator.app.utils.*;


public class DrawerFragment extends BaseFragment {


    private Preference preference;
    private TextView tvUser;
    private LinearLayout llDashboard;
    private LinearLayout llTicketTransaction;
    private LinearLayout llClaimRequest;
    private LinearLayout llWalletRecharge;
    private LinearLayout llLogout;

    /**
     * Contains last clicked time
     */
    private long lastClickedTime = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_drawer, container, false);
    }

    @Override
    protected void initializeComponent(View view) {
        preference = new Preference(requireActivity());
        tvUser = view.findViewById(R.id.tvUser);
        tvUser.setText(preference.getUserFirstName());
        llDashboard = view.findViewById(R.id.llDashboard);
        llTicketTransaction = view.findViewById(R.id.llTicketTransaction);
        llClaimRequest = view.findViewById(R.id.llClaimRequest);
        llWalletRecharge = view.findViewById(R.id.llWalletRecharge);
        llLogout = view.findViewById(R.id.llLogout);

        llDashboard.setOnClickListener(this);
        llTicketTransaction.setOnClickListener(this);
        llClaimRequest.setOnClickListener(this);
        llWalletRecharge.setOnClickListener(this);
        llLogout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        /*
         * Logic to Prevent the Launch of the Fragment Twice if User makes
         * the Tap(Click) very Fast.
         */
        if (SystemClock.elapsedRealtime() - lastClickedTime < Constants.MAX_CLICK_INTERVAL) {

            return;
        }
        lastClickedTime = SystemClock.elapsedRealtime();
        closeDrawer();

        if (v == llDashboard) {
            showWebDialog();
        } else if (v == llTicketTransaction) {
            TicketTransactionFragment ticketTransactionFragment = new TicketTransactionFragment();
            replaceFragment(R.id.activity_home_fl_container, requireActivity().getSupportFragmentManager(), ticketTransactionFragment, true, false);
        } else if (v == llClaimRequest){
            ClaimRequestFragment claimRequestFragment = new ClaimRequestFragment();
            replaceFragment(R.id.activity_home_fl_container, requireActivity().getSupportFragmentManager(), claimRequestFragment, true, false);
        } else if (v == llWalletRecharge){
            WalletRechargeFragment walletRechargeFragment = new WalletRechargeFragment();
            replaceFragment(R.id.activity_home_fl_container, requireActivity().getSupportFragmentManager(), walletRechargeFragment, true, false);
        } else if (v == llLogout) {
            preference.clearAllPreferenceData();
            requireActivity().recreate();
        }
    }

    private void showWebDialog() {
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.webview_layout_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        WebView webview = dialog.findViewById(R.id.wb_webview);
        ImageView btnCloseDialog = dialog.findViewById(R.id.btnCloseDialog);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webview.setInitialScale(0);
        webview.setVerticalScrollBarEnabled(true);
        webview.setHorizontalScrollBarEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.loadUrl("http://142.93.214.248/jayastudio/public/index.php/dashboard");
        btnCloseDialog.setOnClickListener(v -> {
            dialog.dismiss();
            });
        dialog.show();
    }


}
