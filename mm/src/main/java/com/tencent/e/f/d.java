package com.tencent.e.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public final class d {
    public static String getIMEI(Context context) {
        String str;
        AppMethodBeat.i(138464);
        try {
            Log.d("DeviceUtil", "READ_PHONE_STATE.getDeviceId, %s", Util.getStack());
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            h.ez("getIMEI: ".concat(String.valueOf(th)));
            str = "";
        }
        AppMethodBeat.o(138464);
        return str;
    }

    public static String kY(Context context) {
        String str;
        AppMethodBeat.i(138465);
        try {
            Log.d("DeviceUtil", "READ_PHONE_STATE.getSubscriberId, %s", Util.getStack());
            str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            h.ez("getIMSI: ".concat(String.valueOf(th)));
            str = "";
        }
        AppMethodBeat.o(138465);
        return str;
    }

    public static int getSDKVersion() {
        AppMethodBeat.i(138466);
        try {
            int parseInt = Integer.parseInt(Build.VERSION.SDK);
            AppMethodBeat.o(138466);
            return parseInt;
        } catch (Throwable th) {
            h.ez("getSDKVersion: ".concat(String.valueOf(th)));
            AppMethodBeat.o(138466);
            return 0;
        }
    }

    public static String kZ(Context context) {
        AppMethodBeat.i(138467);
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            AppMethodBeat.o(138467);
            return string;
        } catch (Throwable th) {
            h.ez("getAndroidId: ".concat(String.valueOf(th)));
            AppMethodBeat.o(138467);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099 A[SYNTHETIC, Splitter:B:34:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e A[SYNTHETIC, Splitter:B:37:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9 A[SYNTHETIC, Splitter:B:43:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ae A[SYNTHETIC, Splitter:B:46:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String DO(boolean r8) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.e.f.d.DO(boolean):java.lang.String");
    }

    public static String hkQ() {
        FileInputStream fileInputStream;
        StringBuilder sb;
        AppMethodBeat.i(138469);
        String str = "";
        try {
            fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            sb = new StringBuilder("");
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                            h.eA(th);
                        }
                    }
                } catch (Throwable th2) {
                    h.eA(th2);
                }
            }
            bufferedReader.close();
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                h.eA(th3);
            }
            str = sb.toString();
            AppMethodBeat.o(138469);
        } catch (Throwable th4) {
            h.eA(th4);
            AppMethodBeat.o(138469);
        }
        return str;
        fileInputStream.close();
        str = sb.toString();
        AppMethodBeat.o(138469);
        return str;
        str = sb.toString();
        AppMethodBeat.o(138469);
        return str;
    }

    public enum a {
        CONN_WIFI,
        CONN_CMWAP,
        CONN_CMNET,
        CONN_NONE;

        public static a valueOf(String str) {
            AppMethodBeat.i(138462);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(138462);
            return aVar;
        }

        static {
            AppMethodBeat.i(138463);
            AppMethodBeat.o(138463);
        }
    }

    public static a la(Context context) {
        AppMethodBeat.i(138470);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !(activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
            a aVar = a.CONN_NONE;
            AppMethodBeat.o(138470);
            return aVar;
        } else if (activeNetworkInfo.getType() == 1) {
            a aVar2 = a.CONN_WIFI;
            AppMethodBeat.o(138470);
            return aVar2;
        } else if (activeNetworkInfo.getType() != 0) {
            a aVar3 = a.CONN_NONE;
            AppMethodBeat.o(138470);
            return aVar3;
        } else if (Proxy.getDefaultHost() == null && Proxy.getHost(context) == null) {
            a aVar4 = a.CONN_CMNET;
            AppMethodBeat.o(138470);
            return aVar4;
        } else {
            a aVar5 = a.CONN_CMWAP;
            AppMethodBeat.o(138470);
            return aVar5;
        }
    }

    public static String bqd(String str) {
        String str2;
        AppMethodBeat.i(138471);
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            method.setAccessible(true);
            str2 = (String) method.invoke(null, str);
            if (str2 == null) {
                str2 = "";
            }
        } catch (Throwable th) {
            str2 = "";
            h.ez(" getBuildPropByReflect: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.o(138471);
        return str2;
    }
}
