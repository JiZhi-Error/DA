package com.tencent.matrix.mrs.core;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.g.c;
import java.util.TimeZone;

public final class MrsLogic {
    private static final String TAG = "MrsLogic";
    private static PhoneInfo phoneInfo;
    private static MrsCallback strategyCaller = null;

    public static class PhoneInfo {
        public String deviceBrand;
        public String deviceModel;
        public String languageVer;
        public String osName;
        public String osVersion;
    }

    public static native void collectData(String str, byte[] bArr);

    public static native boolean isNeed2Report(String str);

    static native void onCrash();

    static native void onCreate();

    static native void onDestroy();

    public static native void onForeground(boolean z);

    public static native void onStrategyResp(int i2, int i3, byte[] bArr);

    private static native void setClientVersion(long j2);

    private static native void setDebugFlag(boolean z);

    static native void setPhoneInfo(PhoneInfo phoneInfo2);

    private static native void setPublishType(long j2);

    private static native void setRevision(String str);

    public static native void setTimeZone(int i2);

    public static native void setUin(long j2);

    public static native void uploadMatrixIssue(MatrixUploadIssue matrixUploadIssue);

    private MrsLogic() {
    }

    public static void init(long j2, String str, boolean z, long j3) {
        onCreate();
        onForeground(true);
        setTimeZone(TimeZone.getDefault().getRawOffset() / 3600000);
        setClientVersion(j2);
        setRevision(str);
        setDebugFlag(z);
        setPhoneInfo(getPhoneInfo());
        setPublishType(j3);
    }

    private static String replayUnderlineWithDoc(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("_", "-");
    }

    private static String limitRevision(String str) {
        return (!TextUtils.isEmpty(str) && str.length() > 7) ? str.substring(0, 7) : str;
    }

    private static PhoneInfo getPhoneInfoInternal() {
        PhoneInfo phoneInfo2 = new PhoneInfo();
        phoneInfo2.deviceModel = replayUnderlineWithDoc(Build.MODEL);
        phoneInfo2.deviceBrand = replayUnderlineWithDoc(Build.BRAND);
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            str = Build.BRAND;
        }
        phoneInfo2.osName = replayUnderlineWithDoc(str);
        phoneInfo2.osVersion = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
        phoneInfo2.languageVer = "";
        return phoneInfo2;
    }

    public static void setStrategyCaller(MatrixStrategyCaller matrixStrategyCaller) {
        strategyCaller = matrixStrategyCaller;
    }

    public static PhoneInfo getPhoneInfo() {
        if (phoneInfo == null) {
            phoneInfo = getPhoneInfoInternal();
        }
        return phoneInfo;
    }

    static String getPublicSharePath() {
        try {
            if (strategyCaller != null) {
                return strategyCaller.getPublicSharePath();
            }
            throw new RuntimeException("getPublicSharePath, but strategyCaller is null");
        } catch (Exception e2) {
            c.printErrStackTrace(TAG, e2, "jni callback exception", new Object[0]);
            return null;
        }
    }

    static boolean onRequestGetMrsStrategy(byte[] bArr) {
        try {
            if (strategyCaller != null) {
                return strategyCaller.onRequestGetMrsStrategy(bArr);
            }
            throw new RuntimeException("onRequestGetMrsStrategy, but strategyCaller is null");
        } catch (Exception e2) {
            c.printErrStackTrace(TAG, e2, "jni callback exception", new Object[0]);
            return false;
        }
    }

    static void onStrategyNotify(String str) {
    }

    static String getHost(MatrixUploadDataSlice matrixUploadDataSlice) {
        if (strategyCaller != null) {
            return strategyCaller.getHost(matrixUploadDataSlice);
        }
        c.w(TAG, "callback is null", new Object[0]);
        return "";
    }

    static String getUrl(MatrixUploadDataSlice matrixUploadDataSlice) {
        if (strategyCaller != null) {
            return strategyCaller.getUrl(matrixUploadDataSlice);
        }
        c.w(TAG, "callback is null", new Object[0]);
        return "";
    }

    static String getCryptKey(MatrixUploadDataSlice matrixUploadDataSlice) {
        if (strategyCaller == null) {
            return "";
        }
        return strategyCaller.getCryptKey(matrixUploadDataSlice);
    }
}
