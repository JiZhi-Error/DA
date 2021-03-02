package com.tencent.b.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s {
    static void Uf() {
        if (i.dfP != null) {
            h hVar = i.dfP;
        }
    }

    static void Ug() {
        if (i.dfP != null) {
            h hVar = i.dfP;
        }
    }

    public static void Uh() {
        if (i.dfP != null) {
            h hVar = i.dfP;
        }
    }

    static boolean eY(String str) {
        AppMethodBeat.i(87634);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.o(87634);
            return false;
        }
        AppMethodBeat.o(87634);
        return true;
    }

    static boolean eZ(String str) {
        AppMethodBeat.i(87635);
        if (str == null || str.trim().length() < 40) {
            AppMethodBeat.o(87635);
            return false;
        }
        AppMethodBeat.o(87635);
        return true;
    }

    static g a(g gVar, g gVar2) {
        AppMethodBeat.i(87636);
        if (gVar == null || gVar2 == null) {
            if (gVar != null) {
                AppMethodBeat.o(87636);
                return gVar;
            } else if (gVar2 != null) {
                AppMethodBeat.o(87636);
                return gVar2;
            } else {
                AppMethodBeat.o(87636);
                return null;
            }
        } else if (gVar.a(gVar2) >= 0) {
            AppMethodBeat.o(87636);
            return gVar;
        } else {
            AppMethodBeat.o(87636);
            return gVar2;
        }
    }

    static boolean b(g gVar, g gVar2) {
        AppMethodBeat.i(87637);
        if (gVar == null || gVar2 == null) {
            if (gVar == null && gVar2 == null) {
                AppMethodBeat.o(87637);
                return true;
            }
            AppMethodBeat.o(87637);
            return false;
        } else if (gVar.a(gVar2) == 0) {
            AppMethodBeat.o(87637);
            return true;
        } else {
            AppMethodBeat.o(87637);
            return false;
        }
    }

    static boolean checkPermission(Context context, String str) {
        boolean z = false;
        AppMethodBeat.i(87638);
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                z = true;
            }
        } catch (Throwable th) {
            Uh();
        }
        AppMethodBeat.o(87638);
        return z;
    }

    static boolean bt(Context context) {
        AppMethodBeat.i(87639);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"))) {
                AppMethodBeat.o(87639);
                return true;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(87639);
        return false;
    }

    static void a(JSONObject jSONObject, String str, String str2) {
        AppMethodBeat.i(87640);
        if (eY(str2)) {
            jSONObject.put(str, str2);
        }
        AppMethodBeat.o(87640);
    }

    static String decode(String str) {
        AppMethodBeat.i(87641);
        if (str == null) {
            AppMethodBeat.o(87641);
            return null;
        } else if (Build.VERSION.SDK_INT < 8) {
            AppMethodBeat.o(87641);
            return str;
        } else {
            try {
                String replace = new String(l.encrypt(Base64.decode(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), MimeTypeUtil.ContentType.DEFAULT_CHARSET).trim().replace("\t", "").replace("\n", "").replace("\r", "");
                AppMethodBeat.o(87641);
                return replace;
            } catch (Throwable th) {
                Uh();
                AppMethodBeat.o(87641);
                return str;
            }
        }
    }

    static String encode(String str) {
        AppMethodBeat.i(87642);
        if (str == null) {
            AppMethodBeat.o(87642);
            return null;
        } else if (Build.VERSION.SDK_INT < 8) {
            AppMethodBeat.o(87642);
            return str;
        } else {
            try {
                String replace = new String(Base64.encode(l.encrypt(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), MimeTypeUtil.ContentType.DEFAULT_CHARSET).trim().replace("\t", "").replace("\n", "").replace("\r", "");
                AppMethodBeat.o(87642);
                return replace;
            } catch (Throwable th) {
                Uh();
                AppMethodBeat.o(87642);
                return str;
            }
        }
    }

    static String bu(Context context) {
        AppMethodBeat.i(87643);
        try {
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    AppMethodBeat.o(87643);
                    return deviceId;
                }
            } else {
                Uf();
            }
        } catch (Throwable th) {
            Ug();
        }
        AppMethodBeat.o(87643);
        return "";
    }

    static String bv(Context context) {
        AppMethodBeat.i(87644);
        if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    AppMethodBeat.o(87644);
                    return "";
                }
                String macAddress = wifiManager.getConnectionInfo().getMacAddress();
                AppMethodBeat.o(87644);
                return macAddress;
            } catch (Exception e2) {
                "get wifi address error".concat(String.valueOf(e2));
                Uf();
                AppMethodBeat.o(87644);
                return "";
            }
        } else {
            Uf();
            AppMethodBeat.o(87644);
            return "";
        }
    }

    private static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiManager;
        AppMethodBeat.i(87645);
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            AppMethodBeat.o(87645);
            return null;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        AppMethodBeat.o(87645);
        return connectionInfo;
    }

    static String bw(Context context) {
        AppMethodBeat.i(87646);
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                String bssid = wifiInfo.getBSSID();
                AppMethodBeat.o(87646);
                return bssid;
            }
        } catch (Throwable th) {
            Ug();
        }
        AppMethodBeat.o(87646);
        return null;
    }

    static String bx(Context context) {
        AppMethodBeat.i(87647);
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                String ssid = wifiInfo.getSSID();
                AppMethodBeat.o(87647);
                return ssid;
            }
        } catch (Throwable th) {
            Ug();
        }
        AppMethodBeat.o(87647);
        return null;
    }

    static JSONArray by(Context context) {
        List<ScanResult> scanResults;
        AppMethodBeat.i(87648);
        try {
            if (!checkPermission(context, "android.permission.INTERNET") || !checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Uf();
                AppMethodBeat.o(87648);
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!(wifiManager == null || (scanResults = wifiManager.getScanResults()) == null || scanResults.size() <= 0)) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    /* class com.tencent.b.a.a.s.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
                        AppMethodBeat.i(87633);
                        int abs = Math.abs(scanResult.level);
                        int abs2 = Math.abs(scanResult2.level);
                        if (abs > abs2) {
                            AppMethodBeat.o(87633);
                            return 1;
                        } else if (abs == abs2) {
                            AppMethodBeat.o(87633);
                            return 0;
                        } else {
                            AppMethodBeat.o(87633);
                            return -1;
                        }
                    }
                });
                JSONArray jSONArray = new JSONArray();
                int i2 = 0;
                while (i2 < scanResults.size() && i2 < 10) {
                    ScanResult scanResult = scanResults.get(i2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bs", scanResult.BSSID);
                    jSONObject.put("ss", scanResult.SSID);
                    jSONArray.put(jSONObject);
                    i2++;
                }
                AppMethodBeat.o(87648);
                return jSONArray;
            }
            AppMethodBeat.o(87648);
            return null;
        } catch (Throwable th) {
            Ug();
        }
    }

    static String bz(Context context) {
        String path;
        String str = null;
        AppMethodBeat.i(87649);
        try {
            if (checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (!(externalStorageState == null || !externalStorageState.equals("mounted") || (path = Environment.getExternalStorageDirectory().getPath()) == null)) {
                    StatFs statFs = new StatFs(path);
                    str = String.valueOf(String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / TimeUtil.SECOND_TO_US)) + FilePathGenerator.ANDROID_DIR_SEP + String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / TimeUtil.SECOND_TO_US);
                    AppMethodBeat.o(87649);
                }
                AppMethodBeat.o(87649);
            } else {
                Uf();
                AppMethodBeat.o(87649);
            }
        } catch (Throwable th) {
            Uh();
        }
        return str;
    }

    static String Ui() {
        AppMethodBeat.i(87650);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            String str = String.valueOf(String.valueOf((((long) statFs.getAvailableBlocks()) * blockSize) / TimeUtil.SECOND_TO_US)) + FilePathGenerator.ANDROID_DIR_SEP + String.valueOf((((long) statFs.getBlockCount()) * blockSize) / TimeUtil.SECOND_TO_US);
            AppMethodBeat.o(87650);
            return str;
        } catch (Throwable th) {
            Ug();
            AppMethodBeat.o(87650);
            return "";
        }
    }

    static String bA(Context context) {
        String str;
        AppMethodBeat.i(87651);
        try {
            if (!checkPermission(context, "android.permission.INTERNET") || !checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Uf();
                str = null;
                AppMethodBeat.o(87651);
                return str;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                str = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (typeName.equalsIgnoreCase("WIFI")) {
                        str = "WIFI";
                    } else if (typeName.equalsIgnoreCase("MOBILE")) {
                        if (str == null) {
                            str = "MOBILE";
                        }
                    } else if (str == null) {
                        str = typeName;
                    }
                    AppMethodBeat.o(87651);
                    return str;
                }
            }
            str = null;
            AppMethodBeat.o(87651);
            return str;
        } catch (Throwable th) {
            str = null;
            Ug();
        }
    }
}
