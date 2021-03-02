package com.tencent.map.tools.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressLint({"MissingPermission"})
public class NetUtil {
    private static final int BUF_SIZE = 4096;
    private static final String CMWAP = "cmwap";
    private static final String CTWAP = "ctwap";
    public static final int DEFAULT_TIME_OUT = 10000;
    public static final String MAP_USER_AGENT = "QQ Map Mobile";
    private static final String NET_3G = "3gnet";
    public static final String STR_UserAgent = "androidsdk";
    public static final int TYPE_3GWAP = 3;
    public static final int TYPE_CMWAP = 1;
    public static final int TYPE_CTWAP = 4;
    public static final int TYPE_NET_WORK_DISABLED = 0;
    public static final int TYPE_OTHER_NET = 6;
    public static final int TYPE_UNIWAP = 2;
    public static final int TYPE_WIFI = 5;
    private static final String UNIWAP = "uniwap";
    private static final String WAP_3G = "3gwap";
    public static final String WIFI = "wifi";

    public static NetworkInfo getNetworkInfo(Context context) {
        AppMethodBeat.i(172930);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            AppMethodBeat.o(172930);
            return activeNetworkInfo;
        } catch (Exception e2) {
            AppMethodBeat.o(172930);
            return null;
        }
    }

    public static int getNetType(Context context) {
        AppMethodBeat.i(172931);
        int netType = getNetType(getNetworkInfo(context));
        AppMethodBeat.o(172931);
        return netType;
    }

    public static String getNetTypeStr(Context context) {
        AppMethodBeat.i(172932);
        String str = "";
        switch (getNetType(context)) {
            case 1:
                str = CMWAP;
                break;
            case 2:
                str = UNIWAP;
                break;
            case 3:
                str = WAP_3G;
                break;
            case 4:
                str = CTWAP;
                break;
            case 5:
                str = "wifi";
                break;
        }
        AppMethodBeat.o(172932);
        return str;
    }

    private static int getNetType(NetworkInfo networkInfo) {
        AppMethodBeat.i(180923);
        if (networkInfo == null || !networkInfo.isAvailable()) {
            AppMethodBeat.o(180923);
            return 0;
        }
        int type = networkInfo.getType();
        if (type == 1) {
            AppMethodBeat.o(180923);
            return 5;
        } else if (type != 0) {
            AppMethodBeat.o(180923);
            return 6;
        } else {
            String extraInfo = networkInfo.getExtraInfo();
            if (TextUtils.isEmpty(extraInfo)) {
                AppMethodBeat.o(180923);
                return 6;
            } else if (extraInfo.equalsIgnoreCase(CMWAP)) {
                AppMethodBeat.o(180923);
                return 1;
            } else if (extraInfo.equalsIgnoreCase(WAP_3G)) {
                AppMethodBeat.o(180923);
                return 3;
            } else if (extraInfo.equalsIgnoreCase(UNIWAP)) {
                AppMethodBeat.o(180923);
                return 2;
            } else if (extraInfo.equalsIgnoreCase(CTWAP)) {
                AppMethodBeat.o(180923);
                return 4;
            } else {
                AppMethodBeat.o(180923);
                return 3;
            }
        }
    }

    public static String getNetworkType(Context context) {
        AppMethodBeat.i(172933);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    AppMethodBeat.o(172933);
                    return "wifi";
                } else if (type == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                            AppMethodBeat.o(172933);
                            return "2g";
                        case 2:
                            AppMethodBeat.o(172933);
                            return "2g";
                        case 3:
                            AppMethodBeat.o(172933);
                            return "3g";
                        case 4:
                            AppMethodBeat.o(172933);
                            return "2g";
                        case 5:
                            AppMethodBeat.o(172933);
                            return "3g";
                        case 6:
                            AppMethodBeat.o(172933);
                            return "3g";
                        case 7:
                        default:
                            AppMethodBeat.o(172933);
                            return FacebookRequestErrorClassification.KEY_OTHER;
                        case 8:
                            AppMethodBeat.o(172933);
                            return "3g";
                    }
                } else {
                    AppMethodBeat.o(172933);
                    return FacebookRequestErrorClassification.KEY_OTHER;
                }
            } else {
                AppMethodBeat.o(172933);
                return "unknown";
            }
        } catch (Exception e2) {
            AppMethodBeat.o(172933);
            return "unknown";
        }
    }

    public static boolean isNetAvailable(Context context) {
        AppMethodBeat.i(172934);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (networkInfo != null) {
                boolean isAvailable = networkInfo.isAvailable();
                AppMethodBeat.o(172934);
                return isAvailable;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            for (NetworkInfo networkInfo2 : allNetworkInfo) {
                if (networkInfo2.isAvailable() && networkInfo2.isConnectedOrConnecting()) {
                    AppMethodBeat.o(172934);
                    return true;
                }
            }
            AppMethodBeat.o(172934);
            return false;
        } catch (Exception e2) {
        }
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.i(172935);
        if (getNetType(context) == 5) {
            AppMethodBeat.o(172935);
            return true;
        }
        AppMethodBeat.o(172935);
        return false;
    }

    public static boolean isMobile(Context context) {
        AppMethodBeat.i(172936);
        int netType = getNetType(context);
        if (netType == 0 || netType == 5) {
            AppMethodBeat.o(172936);
            return false;
        }
        AppMethodBeat.o(172936);
        return true;
    }

    public static final void safeClose(Closeable closeable) {
        AppMethodBeat.i(193593);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(193593);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(193593);
    }

    public static byte[] toBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Throwable th;
        AppMethodBeat.i(193594);
        if (inputStream == null) {
            AppMethodBeat.o(193594);
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        safeClose(byteArrayOutputStream);
                        AppMethodBeat.o(193594);
                        return byteArray;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                safeClose(byteArrayOutputStream2);
                AppMethodBeat.o(193594);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = null;
            safeClose(byteArrayOutputStream2);
            AppMethodBeat.o(193594);
            throw th;
        }
    }

    public static void writeBytesWithoutClose(byte[] bArr, OutputStream outputStream) {
        AppMethodBeat.i(193595);
        if (bArr == null || bArr.length == 0 || outputStream == null) {
            AppMethodBeat.o(193595);
            return;
        }
        try {
            outputStream.write(bArr);
            AppMethodBeat.o(193595);
        } catch (IOException e2) {
            AppMethodBeat.o(193595);
        }
    }
}
