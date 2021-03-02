package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TXCCommonUtil {
    private static final String TAG = "TXCCommonUtil";
    private static String mAppID = "";
    private static String mStrAppVersion = "";
    private static String mUserId = "";
    public static String pituLicencePath = "YTFaceSDK.licence";
    private static Context sApplicationContext = null;

    private static native String nativeGetConfigCenterKey();

    private static native int nativeGetSDKID();

    private static native String nativeGetSDKVersion();

    static {
        AppMethodBeat.i(14697);
        f.f();
        AppMethodBeat.o(14697);
    }

    public static int[] getSDKVersion() {
        AppMethodBeat.i(14681);
        String[] split = nativeGetSDKVersion().split("\\.");
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                iArr[i2] = Integer.parseInt(split[i2]);
            } catch (NumberFormatException e2) {
                TXCLog.e(TAG, "parse version failed.", e2);
                iArr[i2] = 0;
            }
        }
        AppMethodBeat.o(14681);
        return iArr;
    }

    public static String getSDKVersionStr() {
        AppMethodBeat.i(14682);
        String nativeGetSDKVersion = nativeGetSDKVersion();
        AppMethodBeat.o(14682);
        return nativeGetSDKVersion;
    }

    public static int getSDKID() {
        AppMethodBeat.i(14683);
        int nativeGetSDKID = nativeGetSDKID();
        AppMethodBeat.o(14683);
        return nativeGetSDKID;
    }

    public static String getConfigCenterKey() {
        AppMethodBeat.i(182420);
        String nativeGetConfigCenterKey = nativeGetConfigCenterKey();
        AppMethodBeat.o(182420);
        return nativeGetConfigCenterKey;
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        AppMethodBeat.i(14684);
        String str2 = null;
        if (str != null && str.length() > 0 && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
            str2 = str.substring(lastIndexOf + 1);
        }
        AppMethodBeat.o(14684);
        return str2;
    }

    public static void setAppContext(Context context) {
        AppMethodBeat.i(222084);
        if (context == null) {
            AppMethodBeat.o(222084);
            return;
        }
        sApplicationContext = context.getApplicationContext();
        AppMethodBeat.o(222084);
    }

    public static Context getAppContext() {
        return sApplicationContext;
    }

    public static void sleep(int i2) {
        AppMethodBeat.i(14685);
        try {
            Thread.sleep((long) i2);
            AppMethodBeat.o(14685);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(14685);
        }
    }

    public static String getStreamIDByStreamUrl(String str) {
        String str2;
        AppMethodBeat.i(14686);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(14686);
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str2 = str.substring(0, indexOf);
        } else {
            str2 = str;
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(14686);
            return null;
        }
        int lastIndexOf = str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf != -1) {
            str2 = str2.substring(lastIndexOf + 1);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(14686);
            return null;
        }
        int indexOf2 = str2.indexOf(".");
        if (indexOf2 != -1) {
            str2 = str2.substring(0, indexOf2);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(14686);
            return null;
        }
        AppMethodBeat.o(14686);
        return str2;
    }

    public static String getAppNameByStreamUrl(String str) {
        String str2;
        AppMethodBeat.i(14687);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(14687);
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str2 = str.substring(0, indexOf);
        } else {
            str2 = str;
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(14687);
            return null;
        }
        int lastIndexOf = str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf != -1) {
            str2 = str2.substring(0, lastIndexOf);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(14687);
            return null;
        }
        int lastIndexOf2 = str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf2 != -1) {
            str2 = str2.substring(lastIndexOf2 + 1);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(14687);
            return null;
        }
        AppMethodBeat.o(14687);
        return str2;
    }

    public static void setAppVersion(String str) {
        mStrAppVersion = str;
    }

    public static void setPituLicencePath(String str) {
        pituLicencePath = str;
    }

    public static String getAppVersion() {
        return mStrAppVersion;
    }

    public static void setAppID(String str) {
        mAppID = str;
    }

    public static String getAppID() {
        return mAppID;
    }

    public static String getUserId() {
        return mUserId;
    }

    public static void setUserId(String str) {
        mUserId = str;
    }

    public static String getMD5(String str) {
        AppMethodBeat.i(14688);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (byte b2 : digest) {
                int i2 = b2;
                if (b2 < 0) {
                    i2 = b2 + 256;
                }
                if (i2 < 16) {
                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                stringBuffer.append(Integer.toHexString(i2 == 1 ? 1 : 0));
            }
            str = stringBuffer.toString();
            AppMethodBeat.o(14688);
        } catch (Exception e2) {
            AppMethodBeat.o(14688);
        }
        return str;
    }

    public static byte[] getMD5(byte[] bArr) {
        AppMethodBeat.i(14689);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            AppMethodBeat.o(14689);
            return digest;
        } catch (Exception e2) {
            AppMethodBeat.o(14689);
            return null;
        }
    }

    public static void saveString(String str, String str2) {
        AppMethodBeat.i(14690);
        Context context = sApplicationContext;
        if (context == null) {
            AppMethodBeat.o(14690);
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("TXCCommonConfig", 0).edit();
            edit.putString(str, str2);
            edit.commit();
            AppMethodBeat.o(14690);
        } catch (Exception e2) {
            TXCLog.e(TAG, "save string failed", e2);
            AppMethodBeat.o(14690);
        }
    }

    public static String loadString(String str) {
        String str2;
        AppMethodBeat.i(14691);
        Context context = sApplicationContext;
        if (context == null) {
            AppMethodBeat.o(14691);
            return "";
        }
        try {
            str2 = context.getSharedPreferences("TXCCommonConfig", 0).getString(str, "");
        } catch (Exception e2) {
            str2 = "";
            TXCLog.e(TAG, "load string failed.", e2);
        }
        AppMethodBeat.o(14691);
        return str2;
    }

    public static void saveUInt64(String str, long j2) {
        AppMethodBeat.i(14692);
        Context context = sApplicationContext;
        if (context == null) {
            AppMethodBeat.o(14692);
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("TXCCommonConfig", 0).edit();
            edit.putLong(str, j2);
            edit.commit();
            AppMethodBeat.o(14692);
        } catch (Exception e2) {
            TXCLog.e(TAG, "save uint64 failed.", e2);
            AppMethodBeat.o(14692);
        }
    }

    public static long loadUInt64(String str) {
        long j2 = 0;
        AppMethodBeat.i(14693);
        Context context = sApplicationContext;
        if (context == null) {
            AppMethodBeat.o(14693);
        } else {
            try {
                j2 = context.getSharedPreferences("TXCCommonConfig", 0).getLong(str, 0);
            } catch (Exception e2) {
                TXCLog.e(TAG, "load uint64 failed.", e2);
            }
            AppMethodBeat.o(14693);
        }
        return j2;
    }

    public static void zip(ArrayList<String> arrayList, String str) {
        ZipOutputStream zipOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream2 = null;
        AppMethodBeat.i(14694);
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(str)));
            try {
                zipOutputStream.setComment("LiteAV log");
                Iterator<String> it = arrayList.iterator();
                FileInputStream fileInputStream2 = null;
                while (it.hasNext()) {
                    File file = new File(it.next());
                    try {
                        if (file.length() == 0 || file.length() > 8388608) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e2) {
                            }
                        } else {
                            fileInputStream = new FileInputStream(file);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read != -1) {
                                        zipOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e3) {
                                            fileInputStream2 = fileInputStream;
                                        }
                                    }
                                }
                                fileInputStream.close();
                                fileInputStream2 = fileInputStream;
                            } catch (Exception e4) {
                                e = e4;
                                try {
                                    TXCLog.e(TAG, "zip failed.", e);
                                    try {
                                        fileInputStream.close();
                                        fileInputStream2 = fileInputStream;
                                    } catch (Exception e5) {
                                        fileInputStream2 = fileInputStream;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e6) {
                                    }
                                    AppMethodBeat.o(14694);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        fileInputStream = fileInputStream2;
                        TXCLog.e(TAG, "zip failed.", e);
                        fileInputStream.close();
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        fileInputStream.close();
                        AppMethodBeat.o(14694);
                        throw th;
                    }
                }
                try {
                    zipOutputStream.close();
                    AppMethodBeat.o(14694);
                } catch (Exception e8) {
                    AppMethodBeat.o(14694);
                }
            } catch (FileNotFoundException e9) {
                zipOutputStream2 = zipOutputStream;
                try {
                    TXCLog.w(TAG, "zip log error");
                    try {
                        zipOutputStream2.close();
                        AppMethodBeat.o(14694);
                    } catch (Exception e10) {
                        AppMethodBeat.o(14694);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipOutputStream = zipOutputStream2;
                    try {
                        zipOutputStream.close();
                    } catch (Exception e11) {
                    }
                    AppMethodBeat.o(14694);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream.close();
                AppMethodBeat.o(14694);
                throw th;
            }
        } catch (FileNotFoundException e12) {
            TXCLog.w(TAG, "zip log error");
            zipOutputStream2.close();
            AppMethodBeat.o(14694);
        } catch (Throwable th6) {
            th = th6;
            zipOutputStream = null;
            zipOutputStream.close();
            AppMethodBeat.o(14694);
            throw th;
        }
    }

    public static String getLogUploadPath() {
        AppMethodBeat.i(14695);
        if (sApplicationContext == null) {
            AppMethodBeat.o(14695);
            return "";
        }
        File externalFilesDir = sApplicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            AppMethodBeat.o(14695);
            return "";
        }
        String str = externalFilesDir.getAbsolutePath() + "/log/tencent/liteav";
        AppMethodBeat.o(14695);
        return str;
    }

    public static int getGateway() {
        int i2;
        AppMethodBeat.i(222085);
        if (sApplicationContext == null) {
            AppMethodBeat.o(222085);
            return 0;
        }
        try {
            i2 = ((WifiManager) sApplicationContext.getSystemService("wifi")).getDhcpInfo().gateway;
        } catch (Exception e2) {
            TXCLog.e(TAG, "getGateway error ", e2);
            i2 = 0;
        }
        AppMethodBeat.o(222085);
        return i2;
    }

    public static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.i(222086);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.o(222086);
            return true;
        }
        AppMethodBeat.o(222086);
        return false;
    }

    public static String getAppPackageName() {
        AppMethodBeat.i(14696);
        String c2 = f.c(sApplicationContext);
        AppMethodBeat.o(14696);
        return c2;
    }

    public static String getAppFilePath() {
        AppMethodBeat.i(222087);
        String str = "/sdcard/liteav";
        if (sApplicationContext != null) {
            str = sApplicationContext.getFilesDir().getAbsolutePath();
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(222087);
        return str;
    }

    public static final String getDeviceInfo() {
        AppMethodBeat.i(259874);
        try {
            String str = Build.BRAND + "_" + Build.MODEL + "_" + Build.VERSION.RELEASE;
            AppMethodBeat.o(259874);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(259874);
            return "unknown_device";
        }
    }
}
