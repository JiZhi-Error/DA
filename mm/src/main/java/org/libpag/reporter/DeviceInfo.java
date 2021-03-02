package org.libpag.reporter;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceInfo {
    private static final String TAG = "MobileBase-DeviceInfo";

    public static String getRomFingerprint(Context context) {
        AppMethodBeat.i(237030);
        String str = Build.FINGERPRINT;
        if (TextUtils.isEmpty(str)) {
            str = "Android";
        }
        AppMethodBeat.o(237030);
        return str;
    }

    public static String getDeviceName() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return "fail";
        }
    }

    public static int getApiLevelInt() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            return -1;
        }
    }

    public static String getBrand() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            return "fail";
        }
    }
}
