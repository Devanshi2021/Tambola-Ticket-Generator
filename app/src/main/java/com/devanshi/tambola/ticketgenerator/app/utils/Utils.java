package com.devanshi.tambola.ticketgenerator.app.utils;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.*;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.devanshi.tambola.ticketgenerator.app.apis.*;


/**
 * Performs common utility operations.
 */
public class Utils {

    /**
     * Checks the Network availability.
     *
     * @return isNetAvailable: true id internet available, false otherwise
     */

    @SuppressWarnings("deprecation")
    public static boolean isNetworkAvailable(Context context) {

        boolean isNetAvailable = false;
        if (context != null) {
            final ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (mConnectivityManager != null) {

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    final NetworkInfo activeNetwork = mConnectivityManager.getActiveNetworkInfo();
                    if (activeNetwork != null) {
                        isNetAvailable = true;
                    }

                } else {
                    boolean wifiNetworkConnected = false;
                    boolean mobileNetworkConnected = false;

                    final NetworkInfo mobileInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    final NetworkInfo wifiInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                    if (mobileInfo != null) {
                        mobileNetworkConnected = mobileInfo.isConnected();
                    }
                    if (wifiInfo != null) {
                        wifiNetworkConnected = wifiInfo.isConnected();
                    }
                    isNetAvailable = (mobileNetworkConnected || wifiNetworkConnected);
                }
            }
        }
        return isNetAvailable;
    }

    /**
     * Displays alert dialog to show common messages.
     *
     * @param title   Title of the Dialog : Application's Name
     * @param message Message to be shown in the Dialog displayed
     * @param context Context of the Application, where the Dialog needs to be displayed
     */
    public static void displayDialog(final Context context, final String title, final String message) {

        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setCancelable(false);

        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(android.R.string.ok), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });
        if (!((Activity) context).isFinishing()) {

            alertDialog.show();
        }
    }


    /**
     * Validates the Email Id
     *
     * @param emailId email id to be verified
     * @return true valid email id, false invalid emailid
     */
    public static boolean isValidEmailId(final String emailId) {

        return !TextUtils.isEmpty(emailId) && Patterns.EMAIL_ADDRESS.matcher(emailId).matches();

    }

    /**
     * Validates the Url
     *
     * @param url email id to be verified
     * @return true valid email id, false invalid emailid
     */
    public static boolean isValidUrl(final String url) {
        return !TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches();
    }


    /**
     * Hide the soft keyboard from screen for edit text only
     *
     * @param context context of current visible activity
     * @param view    clicked view
     */
    public static void hideSoftKeyBoard(final Context context, final View view) {
        try {
            final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * Show soft keyboard on auto focus of edittext
     *
     * @param context context of current visible activity
     * @param view    focused view
     */
    public static void showKeyboard(final Context context, final View view) {
        final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * Returns android secure id.
     */
    @SuppressLint("HardwareIds")
    public static String getDeviceId(final Context context) {
        try {
            String deviceId = null;
            // 1 android ID - unreliable
            deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            if (deviceId == null) {
                // 2 compute DEVICE ID
                deviceId = "35" + // we make this look like a valid IMEI
                        Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10
                        + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10; // 13
            }
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }


    /**
     * Call snack bar which will disapper in 3-5 seconds
     *
     * @return Snack bar
     */
    public static Snackbar showSnackBar(final View view, String message, final boolean isError, final Context context) {
        if (view == null) {
            return null;
        }


        if (TextUtils.isEmpty(message)) {
            message = context.getString(R.string.err_msg);
        }

        final Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        final View snackBarView = snackbar.getView();
//        snackBarView.setBackgroundColor(ContextCompat.getColor(context, isError ? R.color.colorRed : R.color.colorGreen));
        snackBarView.setBackgroundColor(ContextCompat.getColor(context, isError ? R.color.colorRed : R.color.colorOrangeLight));
        final TextView textView = (TextView) snackBarView.findViewById(R.id.snackbar_text);
        textView.setMaxLines(5);
        snackbar.show();
        return snackbar;
    }

    /**
     * Called to check permission(In Android M and above versions only)
     *
     * @param permission, which we need to pass
     * @return true, if permission is granted else false
     */
    public static boolean checkForPermission(final Context context, final String permission) {
        int result = ContextCompat.checkSelfPermission(context, permission);
        //If permission is granted then it returns 0 as result
        return result == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Returns the device's DisplayMetrics
     */
    public static DisplayMetrics getDeviceMetrics(final Activity activity) {
        final DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    /**
     * Launch web page into third party app.
     */
    public static void openWebPage(final Activity activity, final String url) {
        if (activity != null && !TextUtils.isEmpty(url)) {
            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            }
        }
    }

    /**
     * Performs the share intent.
     */
    public static void shareItem(final Activity activity, final String url) {
        if (!TextUtils.isEmpty(url) && activity != null) {
            final Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, url);
            sendIntent.setType("text/plain");
            activity.startActivity(Intent.createChooser(sendIntent, activity.getString(R.string.lbl_share_url)));
        }
    }

    /**
     * Returns true if 80% scrolling is done.
     */
    private static boolean needLoadMore(int lastVisibleItemPosition, int totalItemCount) {
        final int max = (int) (totalItemCount * 0.8);
        return (lastVisibleItemPosition) >= max && lastVisibleItemPosition >= 0;
    }

    /**
     * Returns true if it need to load more items.
     */
    public static boolean needLoadMore(final GridLayoutManager layoutManager) {
        int totalItemCount = layoutManager.getItemCount();
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

        return needLoadMore(lastVisibleItemPosition, totalItemCount);
    }

    /**
     * Returns true if it need to load more items.
     */
    public static boolean needLoadMore(final LinearLayoutManager layoutManager) {
        int totalItemCount = layoutManager.getItemCount();
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

        return needLoadMore(lastVisibleItemPosition, totalItemCount);
    }

    /**
     * Cancels the running async task.
     */
    public static boolean cancelAsyncTask(final AsyncTask asyncTask) {
        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            asyncTask.cancel(true);
        }
        return false;
    }

    /**
     * Returns true if string is null.
     */
    public static boolean isNullString(final String string) {
        return TextUtils.isEmpty(string) || string.equalsIgnoreCase("null");
    }

    /**
     * Sets view height.
     */
    public static void setViewHeight(final Activity context, final View imageView) {
        final ViewGroup.LayoutParams params = imageView.getLayoutParams();

        final int deviceWidth = getDeviceMetrics(context).widthPixels;
        params.height = (int) (deviceWidth / 1.777); //left, top, right, bottom

        imageView.setLayoutParams(params);
    }

    /**
     * Inject the css style to HTML string.
     */
    public static String getFormattedHtml(final String html) {
        final String prefix = "<html><head><style type=\"text/css\">@font-face {font-family: Muli;src: url(\"file:///android_asset/Fonts/Muli-Regular.ttf\")}body {margin: 0; padding:0;background-color:white;font-family: Muli;font-size: 12px;line-height: 180%;}</style></head><body>";

        final String pas = "</body></html>";
        return prefix + html + pas;
    }

    /**
     * Set view color according to rate.
     */
    public static void setRatingTextViewColor(final Context context, final View view, final double ratings) {
        final GradientDrawable drawable = (GradientDrawable) view.getBackground();
        if (drawable != null) {

            if (ratings == 0) {
                drawable.setColor(ContextCompat.getColor(context, R.color.colorTextFiledLabel));
            } else if (ratings > 0 && ratings < 3) {
                drawable.setColor(ContextCompat.getColor(context, R.color.colorRed));
            } else if (ratings >= 3 && ratings < 4) {
                drawable.setColor(ContextCompat.getColor(context, R.color.colorOrangeLight));
            } else {
                drawable.setColor(ContextCompat.getColor(context, R.color.colorGreenLight));
            }
        }
    }

    /**
     * ^ : start of string
     * [ : beginning of character group
     * a-z : any lowercase letter
     * A-Z : any uppercase letter
     * 0-9 : any digit
     * _ : underscore
     * ] : end of character group
     * : zero or more of the given characters
     * $ : end of string
     */

    public static boolean isAlphaNumeric(String string) {
//        String pattern= "^[a-zA-Z0-9_]*$";
        String pattern = "^([0-9]+[a-zA-Z]+|[a-zA-Z]+[0-9]+)[0-9a-zA-Z]*$";
        return string.matches(pattern);
    }

    /**
     * Launches the Google Play Store App if available.
     */
    public static void launchGooglePlayStore(final Activity activity) {
        if (activity == null) {
            return;
        }
        final String appPackageName = activity.getPackageName(); // getPackageName() from Context or Activity object
        try {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public static APIInterface getAPIInterface(){
        return APIClient.getClient().create(APIInterface.class);
    }

    public static void downloadFile(Context context, String url){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE | DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        String[] splits = url.split("/");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,splits[splits.length-1]);
        assert downloadManager != null;
        downloadManager.enqueue(request);
    }

    public static String[] getUserClaimList(){
        return new String[]{
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
    }

    public static String[] getServerClaimList(){
        return new String[]{
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
    }
}
