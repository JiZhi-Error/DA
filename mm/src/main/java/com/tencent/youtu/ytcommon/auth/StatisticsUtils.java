package com.tencent.youtu.ytcommon.auth;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StatisticsUtils {
    public static String getDeviceUid(Context context) {
        AppMethodBeat.i(73344);
        if (context.getPackageName().startsWith("com.tencent")) {
            AppMethodBeat.o(73344);
            return "com.tencent";
        }
        String imei = getIMEI(context.getApplicationContext());
        String macAddr = getMacAddr(context.getApplicationContext());
        boolean z = !TextUtils.isEmpty(macAddr);
        if (z) {
            macAddr = macAddr.replaceAll(":", "");
        }
        StringBuilder append = new StringBuilder().append(imei);
        if (!z) {
            macAddr = "";
        }
        String md5 = toMD5(encryptUid(append.append(macAddr).toString()));
        AppMethodBeat.o(73344);
        return md5;
    }

    public static String getMacAddr(Context context) {
        String str;
        WifiInfo connectionInfo;
        AppMethodBeat.i(73345);
        if (context == null) {
            AppMethodBeat.o(73345);
            return null;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            str = null;
        } else {
            str = connectionInfo.getMacAddress();
        }
        AppMethodBeat.o(73345);
        return str;
    }

    public static String getIMEI(Context context) {
        String str;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(73346);
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string) || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null) {
            str = string;
        } else {
            str = telephonyManager.getDeviceId();
        }
        AppMethodBeat.o(73346);
        return str;
    }

    public static String toMD5(String str) {
        String str2;
        AppMethodBeat.i(73347);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73347);
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            str2 = new BigInteger(1, instance.digest()).toString(16);
            while (str2.length() < 32) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str2));
            }
        } catch (NoSuchAlgorithmException e2) {
            str2 = "";
        }
        AppMethodBeat.o(73347);
        return str2;
    }

    private static char getChar(byte b2, int i2) {
        AppMethodBeat.i(73348);
        char offset = (char) (b2 - getOffset(i2 & 1));
        AppMethodBeat.o(73348);
        return offset;
    }

    private static byte getOffset(int i2) {
        return (byte) (i2 == 0 ? 65 : 97);
    }

    private static String encryptUid(String str) {
        AppMethodBeat.i(73349);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73349);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            sb.append(charAt + (charAt % length));
        }
        sb.reverse();
        String sb2 = sb.toString();
        AppMethodBeat.o(73349);
        return sb2;
    }

    private StatisticsUtils() {
    }
}
