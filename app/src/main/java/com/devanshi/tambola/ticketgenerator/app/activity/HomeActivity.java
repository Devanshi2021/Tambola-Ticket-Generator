package com.devanshi.tambola.ticketgenerator.app.activity;

import android.content.*;
import android.content.pm.*;
import android.util.*;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.devanshi.tambola.ticketgenerator.app.R;
import com.devanshi.tambola.ticketgenerator.app.fragment.*;
import com.devanshi.tambola.ticketgenerator.app.utils.*;

import java.util.*;

public class HomeActivity extends BaseActivity {

    /**
     * Left navigation drawer which can be managed by menu icon
     */
    private DrawerLayout drawerLayout;
    /**
     * Fragment to be loaded in Navigation Drawer menu
     */
    private DrawerFragment drawerFragment;

    public static String packageName = "";

    @Override
    protected int defineLayoutResource() {
        return R.layout.act_main;
    }

    @Override
    protected void initializeComponents() {

        Preference preference = new Preference(this);
        if (preference.getUserId() == -1) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);
        /*To filter out System apps*/
        for (PackageInfo pi : installedPackages) {
            boolean b = isSystemPackage(pi);
            if (!b) {
                if (pi.packageName.contains("com.whatsapp")) {
                    packageName = pi.packageName;
                    Log.d("Niraj", "initializeComponents: " + packageName);
                    break;
                }

            }
        }

        replaceFragment(R.id.activity_home_fl_container, getSupportFragmentManager(), new TicketTransactionFragment(), false, false);
        replaceFragment(R.id.activity_home_navigationview, getSupportFragmentManager(), new DrawerFragment(), false, false);

        drawerLayout = findViewById(R.id.activity_home_drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    /**
     * Opens the Navigation Drawer
     */
    public void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    /**
     * Close the Navigation Drawer
     */
    public void closeDrawer() {
        drawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {


        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }
}
