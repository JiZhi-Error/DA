package com.samsung.android.sdk.look;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemProperties;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Slook implements SsdkInterface {
    public static final int AIRBUTTON = 1;
    private static final int NOT_ASSIGN = -1;
    public static final int SMARTCLIP = 2;
    public static final int SPEN_BEZEL_INTERACTION = 5;
    public static final int SPEN_HOVER_ICON = 4;
    private static final String TAG = "Slook";
    public static final int WRITINGBUDDY = 3;
    private static int mVersionCode = -1;

    public static class VERSION_CODES {
        public static final int L1 = 1;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public final int getVersionCode() {
        AppMethodBeat.i(76230);
        if (mVersionCode != -1) {
            int i2 = mVersionCode;
            AppMethodBeat.o(76230);
            return i2;
        }
        try {
            mVersionCode = SystemProperties.getInt("ro.slook.ver", 0);
        } catch (Exception e2) {
            mVersionCode = 0;
        }
        int i3 = mVersionCode;
        AppMethodBeat.o(76230);
        return i3;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public final String getVersionName() {
        return "1.0.1";
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public final void initialize(Context context) {
        AppMethodBeat.i(76231);
        if (!SsdkVendorCheck.isSamsungDevice()) {
            SsdkUnsupportedException ssdkUnsupportedException = new SsdkUnsupportedException("This device is not samsung product.", 0);
            AppMethodBeat.o(76231);
            throw ssdkUnsupportedException;
        } else if (getVersionCode() <= 0) {
            SsdkUnsupportedException ssdkUnsupportedException2 = new SsdkUnsupportedException("This device is not supported.", 1);
            AppMethodBeat.o(76231);
            throw ssdkUnsupportedException2;
        } else {
            try {
                insertLog(context);
                AppMethodBeat.o(76231);
            } catch (SecurityException e2) {
                SecurityException securityException = new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
                AppMethodBeat.o(76231);
                throw securityException;
            }
        }
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public final boolean isFeatureEnabled(int i2) {
        AppMethodBeat.i(76232);
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (getVersionCode() > 0) {
                    boolean isFeatureEnabled = SlookImpl.isFeatureEnabled(i2);
                    AppMethodBeat.o(76232);
                    return isFeatureEnabled;
                }
                AppMethodBeat.o(76232);
                return false;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The type(" + i2 + ") is not supported.");
                AppMethodBeat.o(76232);
                throw illegalArgumentException;
        }
    }

    private void insertLog(Context context) {
        AppMethodBeat.i(76233);
        int i2 = -1;
        try {
            i2 = context.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 128).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (i2 <= 1) {
            AppMethodBeat.o(76233);
        } else if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            SecurityException securityException = new SecurityException();
            AppMethodBeat.o(76233);
            throw securityException;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", getClass().getPackage().getName());
            contentValues.put("feature", context.getPackageName() + "#" + getVersionCode());
            Intent intent = new Intent();
            intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent.putExtra("data", contentValues);
            intent.setPackage("com.samsung.android.providers.context");
            context.sendBroadcast(intent);
            AppMethodBeat.o(76233);
        }
    }
}
