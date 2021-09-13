package com.devanshi.tambola.ticketgenerator.app.fragment;

import android.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;
import androidx.appcompat.widget.*;
import androidx.core.content.*;
import androidx.recyclerview.widget.*;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.activity.*;
import com.devanshi.tambola.ticketgenerator.app.adapter.*;
import com.devanshi.tambola.ticketgenerator.app.model.*;
import com.devanshi.tambola.ticketgenerator.app.utils.Utils;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.io.*;
import java.util.*;

import retrofit2.*;

import static com.devanshi.tambola.ticketgenerator.app.utils.Utils.*;

public class ClaimRequestFragment extends BaseFragment implements ClaimRequestListAdapter.productEditClick {
    private Preference preference;
    private ImageView ivCart;
    private EditText editTextCustomerNumber;
    private LinearLayout llSearch;
    private String fileExtension = null;
    private String textToShare = null;
    private String rightCall = "✅";
    private String wrongCall = "❌";

    /**
     * Products adapter
     */
    private ClaimRequestListAdapter claimListAdapter;

    /**
     * Product array list
     */
    private ArrayList<ClaimListData> claimListDataArrayList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_claim_request, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        callGetClaimList();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private BroadcastReceiver downloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (fileExtension != null && textToShare != null) {
                File imageFileToShare = new File(requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES),"share."+ fileExtension);
                Uri imageUri = FileProvider.getUriForFile(requireContext(), "com.devanshi.tambola.ticketgenerator.provider",
                        imageFileToShare);
                Intent sharingIntent = new Intent(Intent.ACTION_SEND).setDataAndType(imageUri, requireActivity().getContentResolver().getType(imageUri));
                sharingIntent.setPackage(HomeActivity.packageName);
                sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                List<ResolveInfo> resolveInfoList = requireActivity().getPackageManager().queryIntentActivities(sharingIntent, PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo resolveInfo : resolveInfoList){
                    String packageName = resolveInfo.activityInfo.packageName;
                    requireActivity().grantUriPermission(packageName, imageUri,
                            Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                }

                sharingIntent.putExtra(Intent.EXTRA_TEXT,textToShare);
                sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                requireActivity().unregisterReceiver(downloadComplete);
                startActivityForResult(Intent.createChooser(sharingIntent,"Share using"), 201);
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fileExtension = null;
        textToShare = null;
    }

    @Override
    protected void initializeComponent(View view) {
        final TextView tvHeaderTitle = view.findViewById(R.id.header_tv_title);
        AppCompatButton btnAddClaimRequest = view.findViewById(R.id.btnAddClaimRequest);
        tvHeaderTitle.setText(getString(R.string.claim_request));
        preference = new Preference(Objects.requireNonNull(getContext()));
        claimListDataArrayList = new ArrayList<>();
        ivCart = view.findViewById(R.id.ivCart);
        ivCart.setVisibility(View.INVISIBLE);
        llSearch = view.findViewById(R.id.llSearch);
        editTextCustomerNumber = view.findViewById(R.id.editTextCustomerNumber);

        view.findViewById(R.id.clearSearch).setOnClickListener(v -> {
            editTextCustomerNumber.setText("");
            claimListAdapter.setFilter("");
            llSearch.setVisibility(View.GONE);
            ivCart.setVisibility(View.VISIBLE);
            if (NetworkUtils.isOnline(getActivity(), true, false)){
                btnAddClaimRequest.setVisibility(View.VISIBLE);
            } else {
                btnAddClaimRequest.setVisibility(View.GONE);
            }
        });

        /*ivCart.setOnClickListener(v -> {
            btnAddTicket.setVisibility(View.GONE);
            llSearch.setVisibility(View.VISIBLE);
            editTextCustomerNumber.setText("");
            ivCart.setVisibility(View.GONE);
        });*/

        btnAddClaimRequest.setOnClickListener(v -> {
            preference.setPrevousFragmentForAddUpdate(Constants.ADD);
            requireFragmentManager().beginTransaction().replace(R.id.activity_home_fl_container, new NewClaimRequestFragment(), NewTicketTransactionFragment.class.getSimpleName()).addToBackStack(NewTicketTransactionFragment.class.getSimpleName()).commit();
        });

        //Displays the best deal products
        RecyclerView claimRequestsRecyclerview = view.findViewById(R.id.recyclerviewTicket);

        int SPAN_2 = 1;
        GridLayoutManager gridManager = new GridLayoutManager(requireActivity(), SPAN_2);
        claimRequestsRecyclerview.setLayoutManager(gridManager);
        claimListAdapter = new ClaimRequestListAdapter(requireActivity(), claimListDataArrayList, this, true);

        int spacing = getResources().getDimensionPixelSize(R.dimen.dimen_10); // 50px
        GridSpacingItemDecoration spacingItemDecoration = new GridSpacingItemDecoration(SPAN_2, spacing, true);

        claimRequestsRecyclerview.addItemDecoration(spacingItemDecoration);
        claimRequestsRecyclerview.setAdapter(claimListAdapter);
        editTextCustomerNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                claimListAdapter.setFilter(s);
                if (claimListAdapter.getItemCount()==0 && NetworkUtils.isOnline(getActivity(), true, false)) {
                    btnAddClaimRequest.setVisibility(View.VISIBLE);
                } else {
                    btnAddClaimRequest.setVisibility(View.GONE);
                }
            }
        });
//        callGetClaimList();
    }

    private void callGetClaimList() {
        if (NetworkUtils.isOnline(requireActivity(), true, false)) {
            setProgress(true);
            Call<ClaimListModel> call = getAPIInterface().listClaimRequestApi("");

            call.enqueue(new Callback<ClaimListModel>() {
                @Override
                public void onResponse(Call<ClaimListModel> call, Response<ClaimListModel> response) {
                    setProgress(false);
                    ClaimListModel listTicketModel = response.body();
                    if (listTicketModel == null){
                        Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                        return;
                    }
                    Meta meta = listTicketModel.getMeta();
                    if (meta.getCode().equals("200")){
                        claimListDataArrayList = listTicketModel.getData();
                        claimListAdapter.refrestAdapter(claimListDataArrayList);
                        setEmptyView(claimListDataArrayList.isEmpty());
                    } else {
                        Utils.showSnackBar(getView(), meta.getMessage(), true, requireActivity());
                    }
                }

                @Override
                public void onFailure(Call<ClaimListModel> call, Throwable t) {
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                    t.printStackTrace();
                    setProgress(false);
                    setEmptyView(true);
                }
            });
        } else {
            setProgress(false);
            if (claimListDataArrayList == null || claimListDataArrayList.isEmpty()) {
                setEmptyView(true);
            } else {
                setEmptyView(false);
            }
        }
    }

    @Override
    public void onShareClick(ClaimListData claimListData) {
        if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            requireActivity().registerReceiver(downloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
            String url = claimListData.getClaimTicketImage();
            int extensionPosition = url.indexOf(".", url.length()-5)+1;
            String extension = url.substring(extensionPosition);
            File file = new File(requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share."+extension);
            if (file.exists()){
                boolean delete = file.delete();
                if (!delete) {
                    Utils.showSnackBar(getView(), getString(R.string.alert_common_error), true, requireActivity());
                    return;
                }
            }
            DownloadManager downloadManager = (DownloadManager) requireActivity().getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
            request.setDestinationInExternalFilesDir(requireActivity(), Environment.DIRECTORY_PICTURES, "share."+extension);
            assert downloadManager != null;
            downloadManager.enqueue(request);
            fileExtension = extension;
            if (claimListData.getClaimStatus().equalsIgnoreCase("WrongCall")){
                textToShare = claimListData.getClaimType().concat(" ").concat(wrongCall);
            } else {
                textToShare = claimListData.getClaimType().concat(" ").concat(rightCall);
            }
        } else {
            requestPermissions(
                    new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},200);
        }
    }
}
