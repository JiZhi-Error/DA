package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i2, Activity activity, int i3) {
        AppMethodBeat.i(10943);
        Dialog errorDialog = getErrorDialog(i2, activity, i3, null);
        AppMethodBeat.o(10943);
        return errorDialog;
    }

    @Deprecated
    public static Dialog getErrorDialog(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10944);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i2)) {
            i2 = 18;
        }
        Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, i2, i3, onCancelListener);
        AppMethodBeat.o(10944);
        return errorDialog;
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, Context context, int i3) {
        AppMethodBeat.i(10951);
        PendingIntent errorPendingIntent = GooglePlayServicesUtilLight.getErrorPendingIntent(i2, context, i3);
        AppMethodBeat.o(10951);
        return errorPendingIntent;
    }

    @VisibleForTesting
    @Deprecated
    public static String getErrorString(int i2) {
        AppMethodBeat.i(10949);
        String errorString = GooglePlayServicesUtilLight.getErrorString(i2);
        AppMethodBeat.o(10949);
        return errorString;
    }

    public static Context getRemoteContext(Context context) {
        AppMethodBeat.i(10954);
        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
        AppMethodBeat.o(10954);
        return remoteContext;
    }

    public static Resources getRemoteResource(Context context) {
        AppMethodBeat.i(10953);
        Resources remoteResource = GooglePlayServicesUtilLight.getRemoteResource(context);
        AppMethodBeat.o(10953);
        return remoteResource;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(10950);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
        AppMethodBeat.o(10950);
        return isGooglePlayServicesAvailable;
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        AppMethodBeat.i(10952);
        boolean isUserRecoverableError = GooglePlayServicesUtilLight.isUserRecoverableError(i2);
        AppMethodBeat.o(10952);
        return isUserRecoverableError;
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i2, Activity activity, int i3) {
        AppMethodBeat.i(10948);
        boolean showErrorDialogFragment = showErrorDialogFragment(i2, activity, i3, null);
        AppMethodBeat.o(10948);
        return showErrorDialogFragment;
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10945);
        boolean showErrorDialogFragment = showErrorDialogFragment(i2, activity, null, i3, onCancelListener);
        AppMethodBeat.o(10945);
        return showErrorDialogFragment;
    }

    public static boolean showErrorDialogFragment(int i2, Activity activity, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10946);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i2)) {
            i2 = 18;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            boolean showErrorDialogFragment = instance.showErrorDialogFragment(activity, i2, i3, onCancelListener);
            AppMethodBeat.o(10946);
            return showErrorDialogFragment;
        }
        Dialog zza = GoogleApiAvailability.zza(activity, i2, DialogRedirect.getInstance(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i2, "d"), i3), onCancelListener);
        if (zza == null) {
            AppMethodBeat.o(10946);
            return false;
        }
        GoogleApiAvailability.zza(activity, zza, GMS_ERROR_DIALOG, onCancelListener);
        AppMethodBeat.o(10946);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i2, Context context) {
        AppMethodBeat.i(10947);
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i2) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i2)) {
            instance.zza(context);
            AppMethodBeat.o(10947);
            return;
        }
        instance.showErrorNotification(context, i2);
        AppMethodBeat.o(10947);
    }
}
