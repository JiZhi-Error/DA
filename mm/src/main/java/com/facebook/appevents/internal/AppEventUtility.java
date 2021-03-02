package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppEventUtility {
    private static final String regex = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";

    public static void assertIsNotMainThread() {
    }

    public static void assertIsMainThread() {
    }

    public static double normalizePrice(String str) {
        double d2 = 0.0d;
        AppMethodBeat.i(17596);
        try {
            Matcher matcher = Pattern.compile(regex, 8).matcher(str);
            if (matcher.find()) {
                d2 = NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(matcher.group(0)).doubleValue();
                AppMethodBeat.o(17596);
            } else {
                AppMethodBeat.o(17596);
            }
        } catch (ParseException e2) {
            AppMethodBeat.o(17596);
        }
        return d2;
    }

    public static String bytesToHex(byte[] bArr) {
        AppMethodBeat.i(17597);
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(17597);
        return stringBuffer2;
    }

    public static boolean isEmulator() {
        AppMethodBeat.i(17598);
        if (Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || "google_sdk".equals(Build.PRODUCT))) {
            AppMethodBeat.o(17598);
            return true;
        }
        AppMethodBeat.o(17598);
        return false;
    }

    private static boolean isMainThread() {
        AppMethodBeat.i(17599);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(17599);
            return true;
        }
        AppMethodBeat.o(17599);
        return false;
    }

    public static String getAppVersion() {
        AppMethodBeat.i(17600);
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            String str = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            AppMethodBeat.o(17600);
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(17600);
            return "";
        }
    }
}
