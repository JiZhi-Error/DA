package com.tencent.mars.magicbox;

public class IPxxLogic {
    private static ICallBack callBack = null;

    public interface ICallBack {
        String getCrashFilePath(int i2);

        String getUploadLogExtrasInfo(String str);

        void recoverLinkAddrs();

        void setNewDnsDebugHostInfo(String str, int i2);

        void uploadLogFail();

        void uploadLogResponse(long j2, long j3);

        void uploadLogSuccess();
    }

    public static native void onIPxx(String str, int i2);

    public static native void setHost(String str);

    public static native void uploadFile(String str, int i2, long j2, String str2);

    public static native void uploadLog(int i2, int[] iArr, boolean z, long j2, String str);

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    private static String getUploadLogExtrasInfo(String str) {
        if (callBack == null) {
            return null;
        }
        return callBack.getUploadLogExtrasInfo(str);
    }

    private static void setNewDnsDebugHostInfo(String str, int i2) {
        if (callBack != null) {
            callBack.setNewDnsDebugHostInfo(str, i2);
        }
    }

    private static String getCrashFilePath(int i2) {
        if (callBack == null) {
            return null;
        }
        return callBack.getCrashFilePath(i2);
    }

    public static void uploadLogResponse(long j2, long j3) {
        if (callBack != null) {
            callBack.uploadLogResponse(j2, j3);
        }
    }

    public static void uploadLogFail() {
        if (callBack != null) {
            callBack.uploadLogFail();
        }
    }

    public static void uploadLogSuccess() {
        if (callBack != null) {
            callBack.uploadLogSuccess();
        }
    }

    public static void recoverLinkAddrs() {
        if (callBack != null) {
            callBack.recoverLinkAddrs();
        }
    }
}
