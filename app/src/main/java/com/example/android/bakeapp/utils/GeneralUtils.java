package com.example.android.bakeapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * This class has general purpose utilities methods to check for device states, permission and others
 */
public final class  GeneralUtils {

    public GeneralUtils() {
    }

    /***
     * Checks if device has Internet Connection
     * @param context  the activity or fragment where this method is used
     * @return a boolean indicating if device is connected
     */
    public static boolean hasInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) return true;
        else return false;
    }


    /**
     * Calculates the width in dp of the device
     */
    public static double getCalculatedMinSize(Context context) {
        int deviceDensityDpi = context.getResources().getDisplayMetrics().densityDpi;
        double c1 = 160 / context.getResources().getDisplayMetrics().densityDpi;
        return context.getResources().getDisplayMetrics().widthPixels * (c1); //dpCalculated
    }

}
