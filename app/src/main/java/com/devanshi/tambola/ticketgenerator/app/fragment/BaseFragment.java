package com.devanshi.tambola.ticketgenerator.app.fragment;


import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.activity.BaseActivity;
import com.devanshi.tambola.ticketgenerator.app.activity.HomeActivity;
import com.devanshi.tambola.ticketgenerator.app.utils.Constants;
import com.devanshi.tambola.ticketgenerator.app.utils.MyProgressDialog;
import com.devanshi.tambola.ticketgenerator.app.utils.Preference;
import com.devanshi.tambola.ticketgenerator.app.utils.Utils;

import java.util.Objects;


/**
 * Base class for all the fragments used, manages common feature needed in the most of the fragments
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {


    protected final String TAG = this.getClass().getSimpleName();

    private Preference preference;

    /**
     * Initialize the components for Fragment's view
     *
     * @param view A View inflated into Fragment
     */
    protected abstract void initializeComponent(View view);//to initialize the fragments components

    /**
     * Contains last clicked time
     */
    private long lastClickedTime = 0;

    /**
     * Shows progress indication in screens
     */
    protected ProgressBar pbProgress;

    /**
     * EmptyView Layout
     */
    private LinearLayout llEmptyView;

    private MyProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preference = new Preference(Objects.requireNonNull(getContext()));
        progressDialog=new MyProgressDialog(getActivity(),getString(R.string.msg_loading),false);
        pbProgress = view.findViewById(R.id.layout_pb_progress);

        llEmptyView =  view.findViewById(R.id.layout_empty_view_ll_main);

        if (llEmptyView != null) {
            llEmptyView.setVisibility(View.GONE);
            llEmptyView.setOnClickListener(this);
        }

        /*
      Drawer menu image button
     */
        final AppCompatImageView ibMenu = view.findViewById(R.id.header_ib_menu);
        final AppCompatImageView ibBack = view.findViewById(R.id.header_iv_back);


        if (ibMenu != null) {
            ibMenu.setOnClickListener(this);
        }
        if (ibBack != null) {
            ibBack.setOnClickListener(this);
        }


        initializeComponent(view);
    }

    /**
     * Sets visibility of empty view
     */
    protected void setProgress(final boolean isVisible) {
        if (pbProgress != null) {
            if (isVisible) {
                pbProgress.setVisibility(View.VISIBLE);
            } else {
                pbProgress.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Sets visibility of empty view
     */
    protected void showLoading(final boolean isVisible) {
        if (progressDialog != null) {
            if (isVisible) {
                progressDialog.show();
            } else {
                progressDialog.hide();
            }
        }
    }

    /**
     * Sets visibility of empty view
     */
    protected void setEmptyView(final boolean isVisible) {
        if (llEmptyView != null) {
            if (isVisible) {
                llEmptyView.setVisibility(View.VISIBLE);
            } else {
                llEmptyView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Set empty data message
     */
    protected void setEmptyViewMessage(final String message) {
        if (llEmptyView != null && !TextUtils.isEmpty(message)) {
            final TextView tvEmpty = (TextView) llEmptyView.findViewById(R.id.layout_empty_view_tv_message);
            if (tvEmpty != null) {
                tvEmpty.setText(message);
            }
        }
    }

    /**
     * NEW METHOD
     * <p>
     * Adds the Fragment into layout container
     *
     * @param container               Resource id of the layout in which Fragment will be added
     * @param currentFragment         Current loaded Fragment to be hide
     * @param nextFragment            New Fragment to be loaded into container
     * @param requiredAnimation       true if screen transition animation is required
     * @param commitAllowingStateLoss true if commitAllowingStateLoss is needed
     * @return true if new Fragment added successfully into container, false otherwise
     * @throws ClassCastException    Throws exception if getActivity() is not an instance of BaseActivity
     * @throws IllegalStateException Exception if Fragment transaction is invalid
     */
    protected boolean addFragment(final int container, final Fragment currentFragment, final Fragment nextFragment, final boolean requiredAnimation, final boolean commitAllowingStateLoss) throws ClassCastException, IllegalStateException {
        if (getActivity() != null) {
            if (getActivity() instanceof BaseActivity) {
                return ((BaseActivity) getActivity()).addFragment(container, currentFragment, nextFragment, requiredAnimation, commitAllowingStateLoss);
            } else {
                throw new ClassCastException(BaseActivity.class.getName() + " can not be cast into " + getActivity().getClass().getName());
            }
        }
        return false;
    }

    /**
     * @param container               Resource id of the layout in which Fragment will be added
     * @param fragmentManager         Activity fragment manager
     * @param nextFragment            New Fragment to be loaded into container
     * @param requiredAnimation       true if screen transition animation is required
     * @param commitAllowingStateLoss true if commitAllowingStateLoss is needed
     * @return true if new Fragment added successfully into container, false otherwise
     * @throws ClassCastException    Throws exception if getActivity() is not an instance of BaseActivity
     * @throws IllegalStateException Exception if Fragment transaction is invalid
     */
    protected boolean replaceFragment(final int container, final FragmentManager fragmentManager, final Fragment nextFragment, final boolean requiredAnimation, final boolean commitAllowingStateLoss) throws ClassCastException, IllegalStateException {
        if (getActivity() != null) {
            if (getActivity() instanceof BaseActivity) {
                return ((BaseActivity) getActivity()).replaceFragment(container, fragmentManager, nextFragment, requiredAnimation, commitAllowingStateLoss);
            } else {
                throw new ClassCastException(BaseActivity.class.getName() + " can not be cast into " + getActivity().getClass().getName());
            }
        }
        return false;
    }


    @Override
    public void onClick(View v) {

        Utils.hideSoftKeyBoard(getActivity(), v);
        /*
         * Logic to Prevent the Launch of the Fragment Twice if User makes
         * the Tap(Click) very Fast.
         */
        if (SystemClock.elapsedRealtime() - lastClickedTime < Constants.MAX_CLICK_INTERVAL) {

            return;
        }
        lastClickedTime = SystemClock.elapsedRealtime();
        switch (v.getId()) {
            case R.id.header_ib_menu:

                openDrawer();

                break;

            case R.id.header_iv_back:
                preference.setScannedItemId("0");
                popBackStackFragment();
                break;

            case R.id.layout_empty_view_ll_main:

                break;
        }
    }

    /**
     *  Pop back the fragment
     */
    protected void popBackStackFragment(){
        Log.d(TAG, "popBackStackFragment: "+getFragmentManager().getBackStackEntryCount());
        for (int i = getFragmentManager().getBackStackEntryCount()-1; i>=0;i--){
            Log.d(TAG, "popBackStackFragment: "+getFragmentManager().getBackStackEntryAt(i).getName());
        }
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            getActivity().onBackPressed();
        }
    }

    /**
     * Opens the navigation drawer menu
     */
    private void openDrawer() {
        if (getActivity() != null && getActivity() instanceof HomeActivity) {
            ((HomeActivity) getActivity()).openDrawer();
        }
    }

    /**
     * Close the navigation drawer menu
     */
    protected void closeDrawer() {
        if (getActivity() != null && getActivity() instanceof HomeActivity) {
            ((HomeActivity) getActivity()).closeDrawer();
        }
    }
}