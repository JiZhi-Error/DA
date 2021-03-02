package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public class TPNativeLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARN = 3;
    private static final String TAG = "PlayerCore";
    private static ITPNativeLogCallback mLogCallback = null;

    public static void setLogCallback(ITPNativeLogCallback iTPNativeLogCallback) {
        mLogCallback = iTPNativeLogCallback;
    }

    public static void printLog(int i2, String str) {
        AppMethodBeat.i(189777);
        printLog(i2, TAG, str);
        AppMethodBeat.o(189777);
    }

    public static void printLog(int i2, String str, String str2) {
        AppMethodBeat.i(189778);
        if (mLogCallback != null) {
            mLogCallback.onPrintLog(i2, str, str2);
            AppMethodBeat.o(189778);
            return;
        }
        printLogDefault(i2, str, str2);
        AppMethodBeat.o(189778);
    }

    public static void printLogDefault(int i2, String str, String str2) {
    }

    @TPMethodCalledByNative
    private static void onPrintLog(int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        int i5 = 0;
        AppMethodBeat.i(189779);
        try {
            String str = new String(bArr, 0, i3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String str2 = new String(bArr2, 0, i4, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            switch (i2) {
                case 0:
                    i5 = 4;
                    break;
                case 1:
                    i5 = 3;
                    break;
                case 2:
                    i5 = 2;
                    break;
                case 3:
                    i5 = 1;
                    break;
            }
            printLog(i5, str, str2);
            AppMethodBeat.o(189779);
        } catch (Exception e2) {
            printLog(4, e2.getMessage());
            AppMethodBeat.o(189779);
        }
    }
}
