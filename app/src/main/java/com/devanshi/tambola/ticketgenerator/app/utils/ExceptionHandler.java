package com.devanshi.tambola.ticketgenerator.app.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import static android.os.Environment.getExternalStorageDirectory;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler{
    private Thread.UncaughtExceptionHandler defaultUEH;
    private Activity app;

    public ExceptionHandler(Activity app){
        this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        this.app = app;
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        StackTraceElement[] arr = e.getStackTrace();
        String report = e.toString() + "\n\n";
        report += "--------- Stack trace ---------\n\n";
        for (StackTraceElement stackTraceElement : arr) {
            report += "    " + stackTraceElement.toString() + "\n";
        }
        report += "-------------------------------\n\n";

        // If the exception was thrown in a background thread inside
        // AsyncTask, then the actual exception can be found with getCause

        report += "--------- Cause ---------\n\n";
        Throwable cause = e.getCause();
        if (cause != null) {
            report += cause.toString() + "\n\n";
            arr = cause.getStackTrace();
            for (StackTraceElement stackTraceElement: arr) {
                report += "    " + stackTraceElement.toString() + "\n";
            }
        }
        report += "-------------------------------\n\n";

        try {

            File sdCard = getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath() + "/jaya/crashlog");
            dir.mkdirs();
            Calendar cal = Calendar.getInstance();
            File file = new File(dir, "crashlog_"+cal.get(Calendar.DATE)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR)+"_"+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+".txt");
            Log.d(Constants.TAG,file.getName()+" generated");

            FileOutputStream f = new FileOutputStream(file);
            f.write(report.getBytes());
            f.flush();
            f.close();
            Toast.makeText(app.getApplicationContext(),file.getAbsolutePath()+" generated",Toast.LENGTH_LONG).show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        defaultUEH.uncaughtException(t, e);
    }
}
