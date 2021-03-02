package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

public class TPDLProxyLog {
    private static ITPDLProxyLogListener mLogListener;
    private static int mServiceType;

    public static void setLogListener(int i2, ITPDLProxyLogListener iTPDLProxyLogListener) {
        mServiceType = i2;
        mLogListener = iTPDLProxyLogListener;
    }

    public static void d(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(210153);
        if (mLogListener != null) {
            mLogListener.d(str, i2, str2, str3);
            AppMethodBeat.o(210153);
            return;
        }
        new StringBuilder("[").append(str2).append("][").append(str).append(":").append(i2).append("]");
        AppMethodBeat.o(210153);
    }

    public static void i(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(210154);
        if (mLogListener != null) {
            mLogListener.i(str, i2, str2, str3);
            AppMethodBeat.o(210154);
            return;
        }
        new StringBuilder("[").append(str2).append("][").append(str).append(":").append(i2).append("]");
        AppMethodBeat.o(210154);
    }

    public static void w(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(210155);
        if (mLogListener != null) {
            mLogListener.w(str, i2, str2, str3);
            AppMethodBeat.o(210155);
            return;
        }
        new StringBuilder("[").append(str2).append("][").append(str).append(":").append(i2).append("]");
        AppMethodBeat.o(210155);
    }

    public static void e(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(210156);
        if (mLogListener != null) {
            mLogListener.e(str, i2, str2, str3);
            AppMethodBeat.o(210156);
            return;
        }
        new StringBuilder("[").append(str2).append("][").append(str).append(":").append(i2).append("]");
        AppMethodBeat.o(210156);
    }
}
