package com.tencent.tmassistantsdk.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DownloadHelper {
    public static final int PHONE = 1;
    public static final float SAVE_FATOR = 1.5f;
    public static final long SAVE_LENGTH = 104857600;
    public static final int SDCARD = 2;
    public static final String TAG = DownloadHelper.class.getSimpleName();
    public static final int UNKNOWN = 0;

    static {
        AppMethodBeat.i(101959);
        AppMethodBeat.o(101959);
    }

    public static PowerManager.WakeLock getWakeLock() {
        return null;
    }

    public static String correctURL(String str) {
        AppMethodBeat.i(101946);
        String trim = str.replace("\r", "").replace("\n", "").trim();
        String str2 = new String(trim);
        try {
            Uri parse = Uri.parse(trim);
            String lastPathSegment = parse.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                str2 = str2.replace(lastPathSegment, URLEncoder.encode(parse.getLastPathSegment()).replace("+", "%20"));
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(101946);
        return str2;
    }

    public static String genAPKFileName(String str) {
        AppMethodBeat.i(101947);
        if (str.contains(".apk")) {
            String trim = str.trim().substring(str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP) + 1).trim();
            if (trim.contains("?")) {
                trim = trim.substring(0, trim.lastIndexOf("?"));
            }
            if (!TextUtils.isEmpty(trim)) {
                TMLog.i(TAG, "file name = ".concat(String.valueOf(trim)));
                String renameAPKFileName = renameAPKFileName(trim);
                AppMethodBeat.o(101947);
                return renameAPKFileName;
            }
        }
        AppMethodBeat.o(101947);
        return null;
    }

    public static String decodeFileName(String str) {
        AppMethodBeat.i(101948);
        if (str != null) {
            String decode = URLDecoder.decode(str);
            AppMethodBeat.o(101948);
            return decode;
        }
        AppMethodBeat.o(101948);
        return null;
    }

    public static String correctFileName(String str) {
        AppMethodBeat.i(101949);
        String replace = str.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace(FilePathGenerator.ANDROID_DIR_SEP, "_").replace("\\", "_").replace("\"", "_");
        AppMethodBeat.o(101949);
        return replace;
    }

    public static String renameAPKFileName(String str) {
        String str2;
        AppMethodBeat.i(101950);
        if (str == null) {
            AppMethodBeat.o(101950);
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str.length() - 1) {
            AppMethodBeat.o(101950);
            return str;
        }
        String[] strArr = {str.substring(0, lastIndexOf), str.substring(lastIndexOf, str.length())};
        int i2 = 0;
        do {
            if (i2 == 0) {
                str2 = str;
            } else {
                str2 = strArr[0] + "(" + i2 + ")" + strArr[1];
            }
            i2++;
        } while (new o(TMAssistantFile.getSavePathRootDir() + FilePathGenerator.ANDROID_DIR_SEP + str2).exists());
        AppMethodBeat.o(101950);
        return str2;
    }

    public static boolean isValidURL(String str) {
        boolean z = false;
        AppMethodBeat.i(101951);
        try {
            new URI(correctURL(str));
            z = true;
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "", new Object[0]);
        }
        AppMethodBeat.o(101951);
        return z;
    }

    public static String generateFileNameFromURL(String str, String str2) {
        AppMethodBeat.i(101952);
        String calcMD5AsString = GlobalUtil.calcMD5AsString(str);
        if (TextUtils.isEmpty(calcMD5AsString)) {
            calcMD5AsString = Integer.toString(Math.abs(str.hashCode()));
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("application/vnd.android.package-archive")) {
                str3 = ".apk";
            } else if (str2.equals("application/tm.android.apkdiff")) {
                str3 = ".diff";
            } else if (str2.equals("resource/tm.android.unknown")) {
                str3 = ".other";
            }
        }
        String str4 = calcMD5AsString + str3;
        AppMethodBeat.o(101952);
        return str4;
    }

    public static synchronized String getNetStatus() {
        String str;
        synchronized (DownloadHelper.class) {
            AppMethodBeat.i(101953);
            Context context = GlobalUtil.getInstance().getContext();
            if (context == null) {
                str = "";
                AppMethodBeat.o(101953);
            } else {
                try {
                    if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                        str = "";
                        AppMethodBeat.o(101953);
                    } else {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            str = "";
                            AppMethodBeat.o(101953);
                        } else if (activeNetworkInfo.getType() == 1) {
                            str = "wifi";
                            AppMethodBeat.o(101953);
                        } else {
                            String extraInfo = activeNetworkInfo.getExtraInfo();
                            if (extraInfo == null) {
                                str = "";
                                AppMethodBeat.o(101953);
                            } else {
                                str = extraInfo.toLowerCase();
                                TMLog.v(TAG, "netInfo  =  ".concat(String.valueOf(str)));
                                AppMethodBeat.o(101953);
                            }
                        }
                    }
                } catch (Exception e2) {
                    str = "";
                    AppMethodBeat.o(101953);
                }
            }
        }
        return str;
    }

    public static boolean isNetworkConncted() {
        boolean z;
        AppMethodBeat.i(101954);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            TMLog.w(TAG, "GlobalUtil.getInstance().getContext() == null.");
            AppMethodBeat.o(101954);
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            z = activeNetworkInfo.isAvailable();
        } else {
            z = false;
        }
        AppMethodBeat.o(101954);
        return z;
    }

    public static boolean isDownloadFileExisted(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(101955);
        try {
            if (new o(TMAssistantFile.getSaveFilePath(generateFileNameFromURL(str, str2))).exists()) {
                z = true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.o(101955);
            throw th;
        }
        AppMethodBeat.o(101955);
        return z;
    }

    public static boolean isDownloadFileExisted(String str) {
        boolean z = false;
        AppMethodBeat.i(101956);
        if (str == null) {
            AppMethodBeat.o(101956);
        } else {
            try {
                if (new o(TMAssistantFile.getSaveFilePath(str)).exists()) {
                    z = true;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(101956);
                throw th;
            }
            AppMethodBeat.o(101956);
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007c, code lost:
        if (r2 >= 0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002f, code lost:
        if (r2 < 0) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSpaceEnough(java.lang.String r13, long r14) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.downloadservice.DownloadHelper.isSpaceEnough(java.lang.String, long):boolean");
    }

    public static int getStorePosition(String str) {
        AppMethodBeat.i(101958);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(101958);
            return 0;
        } else if (str != null && str.startsWith("/data")) {
            AppMethodBeat.o(101958);
            return 1;
        } else if (TMAssistantFile.isSDCardExistAndCanWrite()) {
            AppMethodBeat.o(101958);
            return 2;
        } else {
            AppMethodBeat.o(101958);
            return 0;
        }
    }
}
