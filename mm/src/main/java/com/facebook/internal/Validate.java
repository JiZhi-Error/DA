package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    private static final String CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG = Validate.class.getName();

    static {
        AppMethodBeat.i(18029);
        AppMethodBeat.o(18029);
    }

    public static void notNull(Object obj, String str) {
        AppMethodBeat.i(18005);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException("Argument '" + str + "' cannot be null");
            AppMethodBeat.o(18005);
            throw nullPointerException;
        }
        AppMethodBeat.o(18005);
    }

    public static <T> void notEmpty(Collection<T> collection, String str) {
        AppMethodBeat.i(18006);
        if (collection.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Container '" + str + "' cannot be empty");
            AppMethodBeat.o(18006);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(18006);
    }

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        AppMethodBeat.i(18007);
        notNull(collection, str);
        for (T t : collection) {
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Container '" + str + "' cannot contain null values");
                AppMethodBeat.o(18007);
                throw nullPointerException;
            }
        }
        AppMethodBeat.o(18007);
    }

    public static void containsNoNullOrEmpty(Collection<String> collection, String str) {
        AppMethodBeat.i(18008);
        notNull(collection, str);
        for (String str2 : collection) {
            if (str2 == null) {
                NullPointerException nullPointerException = new NullPointerException("Container '" + str + "' cannot contain null values");
                AppMethodBeat.o(18008);
                throw nullPointerException;
            } else if (str2.length() == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Container '" + str + "' cannot contain empty values");
                AppMethodBeat.o(18008);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(18008);
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        AppMethodBeat.i(18009);
        containsNoNulls(collection, str);
        notEmpty(collection, str);
        AppMethodBeat.o(18009);
    }

    public static void runningOnUiThread() {
        AppMethodBeat.i(18010);
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            FacebookException facebookException = new FacebookException("This method should be called from the UI thread");
            AppMethodBeat.o(18010);
            throw facebookException;
        }
        AppMethodBeat.o(18010);
    }

    public static void notNullOrEmpty(String str, String str2) {
        AppMethodBeat.i(18011);
        if (Utility.isNullOrEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument '" + str2 + "' cannot be null or empty");
            AppMethodBeat.o(18011);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(18011);
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        AppMethodBeat.i(18012);
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    AppMethodBeat.o(18012);
                    return;
                }
            } else if (obj == null) {
                AppMethodBeat.o(18012);
                return;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
        AppMethodBeat.o(18012);
        throw illegalArgumentException;
    }

    public static void sdkInitialized() {
        AppMethodBeat.i(18013);
        if (!FacebookSdk.isInitialized()) {
            FacebookSdkNotInitializedException facebookSdkNotInitializedException = new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
            AppMethodBeat.o(18013);
            throw facebookSdkNotInitializedException;
        }
        AppMethodBeat.o(18013);
    }

    public static String hasAppID() {
        AppMethodBeat.i(18014);
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId == null) {
            IllegalStateException illegalStateException = new IllegalStateException("No App ID found, please set the App ID.");
            AppMethodBeat.o(18014);
            throw illegalStateException;
        }
        AppMethodBeat.o(18014);
        return applicationId;
    }

    public static String hasClientToken() {
        AppMethodBeat.i(18015);
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken == null) {
            IllegalStateException illegalStateException = new IllegalStateException("No Client Token found, please set the Client Token.");
            AppMethodBeat.o(18015);
            throw illegalStateException;
        }
        AppMethodBeat.o(18015);
        return clientToken;
    }

    public static void hasInternetPermissions(Context context) {
        AppMethodBeat.i(18016);
        hasInternetPermissions(context, true);
        AppMethodBeat.o(18016);
    }

    public static void hasInternetPermissions(Context context, boolean z) {
        AppMethodBeat.i(18017);
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1 || !z) {
            AppMethodBeat.o(18017);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
        AppMethodBeat.o(18017);
        throw illegalStateException;
    }

    public static boolean hasWiFiPermission(Context context) {
        AppMethodBeat.i(18018);
        boolean hasPermission = hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
        AppMethodBeat.o(18018);
        return hasPermission;
    }

    public static boolean hasChangeWifiStatePermission(Context context) {
        AppMethodBeat.i(18019);
        boolean hasPermission = hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
        AppMethodBeat.o(18019);
        return hasPermission;
    }

    public static boolean hasLocationPermission(Context context) {
        AppMethodBeat.i(18020);
        if (hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            AppMethodBeat.o(18020);
            return true;
        }
        AppMethodBeat.o(18020);
        return false;
    }

    public static boolean hasBluetoothPermission(Context context) {
        AppMethodBeat.i(18021);
        if (!hasPermission(context, "android.permission.BLUETOOTH") || !hasPermission(context, "android.permission.BLUETOOTH_ADMIN")) {
            AppMethodBeat.o(18021);
            return false;
        }
        AppMethodBeat.o(18021);
        return true;
    }

    public static boolean hasPermission(Context context, String str) {
        AppMethodBeat.i(18022);
        if (context.checkCallingOrSelfPermission(str) == 0) {
            AppMethodBeat.o(18022);
            return true;
        }
        AppMethodBeat.o(18022);
        return false;
    }

    public static void hasFacebookActivity(Context context) {
        AppMethodBeat.i(18023);
        hasFacebookActivity(context, true);
        AppMethodBeat.o(18023);
    }

    public static void hasFacebookActivity(Context context, boolean z) {
        AppMethodBeat.i(18024);
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        if (activityInfo != null || !z) {
            AppMethodBeat.o(18024);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
        AppMethodBeat.o(18024);
        throw illegalStateException;
    }

    public static void checkCustomTabRedirectActivity(Context context) {
        AppMethodBeat.i(18025);
        checkCustomTabRedirectActivity(context, true);
        AppMethodBeat.o(18025);
    }

    public static void checkCustomTabRedirectActivity(Context context, boolean z) {
        AppMethodBeat.i(18026);
        if (hasCustomTabRedirectActivity(context) || !z) {
            AppMethodBeat.o(18026);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON);
        AppMethodBeat.o(18026);
        throw illegalStateException;
    }

    public static boolean hasCustomTabRedirectActivity(Context context) {
        boolean z;
        AppMethodBeat.i(18027);
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = null;
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
            list = packageManager.queryIntentActivities(intent, 64);
        }
        if (list != null) {
            z = false;
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                    AppMethodBeat.o(18027);
                    return false;
                }
                z = true;
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(18027);
        return z;
    }

    public static void hasContentProvider(Context context) {
        AppMethodBeat.i(18028);
        notNull(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String concat = CONTENT_PROVIDER_BASE.concat(String.valueOf(hasAppID));
            if (packageManager.resolveContentProvider(concat, 0) == null) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, concat));
                AppMethodBeat.o(18028);
                throw illegalStateException;
            }
        }
        AppMethodBeat.o(18028);
    }
}
