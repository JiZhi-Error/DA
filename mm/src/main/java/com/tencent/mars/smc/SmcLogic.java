package com.tencent.mars.smc;

import com.tencent.mars.Mars;
import java.util.ArrayList;

public class SmcLogic {
    private static final String TAG = "mars.SmcLogic";
    private static ICallBack callBack = null;

    public static class BaseInfo {
        public String deviceBrand;
        public String deviceModel;
        public String languageVer;
        public String osName;
        public String osVersion;
    }

    public interface ICallBack {
        boolean OnSelfMonitorOpLogReady(byte[] bArr);

        String getKVCommPath();

        BaseInfo getKVCommReqBaseInfo();

        int getSingleReportBufSizeB();

        void onReportDataReady(byte[] bArr, byte[] bArr2, int i2, String str);

        boolean onRequestGetStrategy(byte[] bArr, int i2);
    }

    public static native void OnPluginMsg(long j2, long j3, long j4, long j5, long j6, long j7);

    public static native void OnReportResp(int i2, int i3, byte[] bArr, int i4);

    public static native void OnStrategyResp(int i2, int i3, byte[] bArr, int i4);

    public static native void SetDebugFlag(boolean z);

    public static native void SetMonitorId(boolean z, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native ArrayList<String> getLoadLibraries();

    public static native ArrayList<Integer> getStrategyVersions();

    public static native void onCreate();

    public static native void reportIDKey(long j2, long j3, long j4, boolean z);

    public static native void reportListIDKey(IDKey[] iDKeyArr, boolean z);

    public static native void setTimeZone(int i2);

    public static native void setUin(long j2);

    public static native void writeImportKvData(long j2, String str, boolean z, boolean z2);

    public static native void writeImportKvDataWithType(long j2, long j3, String str, boolean z, boolean z2);

    public static native void writeImportKvPbData(long j2, byte[] bArr, boolean z);

    public static native void writeImportKvPbDataWithType(long j2, long j3, byte[] bArr, boolean z);

    public static native void writeKvData(long j2, String str, boolean z, boolean z2);

    public static native void writeKvDataWithIsolate(long j2, String str, boolean z, boolean z2, String str2);

    public static native void writeKvDataWithType(long j2, long j3, String str, boolean z, boolean z2);

    public static native void writeKvPbData(long j2, byte[] bArr, boolean z);

    public static native void writeKvPbDataWithType(long j2, long j3, byte[] bArr, boolean z);

    static {
        ArrayList<String> arrayList;
        try {
            arrayList = getLoadLibraries();
        } catch (UnsatisfiedLinkError e2) {
            arrayList = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(arrayList, TAG);
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    private static void onReportDataReady(byte[] bArr, byte[] bArr2, int i2, String str) {
        if (callBack != null) {
            callBack.onReportDataReady(bArr, bArr2, i2, str);
        }
    }

    private static boolean onRequestGetStrategy(byte[] bArr, int i2) {
        if (callBack == null) {
            return false;
        }
        return callBack.onRequestGetStrategy(bArr, i2);
    }

    private static boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        if (callBack == null) {
            return false;
        }
        return callBack.OnSelfMonitorOpLogReady(bArr);
    }

    private static int getSingleReportBufSizeB() {
        if (callBack == null) {
            return 0;
        }
        return callBack.getSingleReportBufSizeB();
    }

    private static BaseInfo getKVCommReqBaseInfo() {
        if (callBack == null) {
            return new BaseInfo();
        }
        return callBack.getKVCommReqBaseInfo();
    }

    private static String getKVCommPath() {
        if (callBack == null) {
            return "";
        }
        return callBack.getKVCommPath();
    }
}
