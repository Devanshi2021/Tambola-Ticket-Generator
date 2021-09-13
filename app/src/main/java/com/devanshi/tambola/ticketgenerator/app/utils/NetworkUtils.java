package com.devanshi.tambola.ticketgenerator.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.devanshi.tambola.ticketgenerator.app.R;

public class NetworkUtils {


    /**
     * Checks internet network connection.
     *
     * @param context    Activity context
     * @param message    if want to show connection message to user then true, false otherwise.
     * @param isSnackBar if want to show snackBar then true else shows alert dialog with buttons.
     * @return if network connectivity exists or is in the process of being established, false otherwise.
     */
    public static boolean isOnline(final Activity context, boolean message, boolean isSnackBar) {

        if (context != null && !context.isFinishing()) {
            if (isNetworkAvailable(context)) {
                new Preference(context).storeOfflineOrderArray("");
                return true;
            }

            if (!new Preference(context).canAppRunOffline()) {
                if (message) {
                    if (isSnackBar) {

                        Utils.showSnackBar(context.findViewById(android.R.id.content), context.getString(R.string.no_internet), true, context);

                    } else {
                        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                        dialog.setTitle(context.getString(R.string.app_name));
                        dialog.setCancelable(false);
                        dialog.setMessage(context.getString(R.string.no_internet));

                        dialog.setNeutralButton(context.getString(R.string.settings), new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {

                                dialog.dismiss();

                                Intent intent = new Intent("android.settings.SETTINGS");
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                            }
                        });
                        dialog.setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {

                                dialog.dismiss();
                                context.finish();
                            }
                        });
                        dialog.show();
                    }

                }
            }
        }
        return false;
    }

    /**
     * Checks the Network availability.
     *
     * @return true if internet available, false otherwise
     */
    public static boolean isNetworkAvailable(Context context) {

        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = cm != null ? cm.getActiveNetworkInfo() : null;

        return (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
    }
}
