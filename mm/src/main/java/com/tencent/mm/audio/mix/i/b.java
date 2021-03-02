package com.tencent.mm.audio.mix.i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private static final String SYS_INFO;
    private static a dxY;
    private static a dxZ;
    private static int level = 6;

    public interface a {
    }

    static {
        AppMethodBeat.i(136967);
        AnonymousClass1 r0 = new a() {
            /* class com.tencent.mm.audio.mix.i.b.AnonymousClass1 */
            private Handler handler = new Handler(Looper.getMainLooper());

            {
                AppMethodBeat.i(136960);
                AppMethodBeat.o(136960);
            }
        };
        dxY = r0;
        dxZ = r0;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            Log.printErrStackTrace("mix.Log", th, "", new Object[0]);
        }
        SYS_INFO = sb.toString();
        AppMethodBeat.o(136967);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(136964);
        Log.e(str, str2, objArr);
        AppMethodBeat.o(136964);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(136965);
        Log.i(str, str2, objArr);
        AppMethodBeat.o(136965);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(136966);
        Log.printErrStackTrace(str, th, str2, objArr);
        AppMethodBeat.o(136966);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(136961);
        Log.e(str, str2, null);
        AppMethodBeat.o(136961);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(136962);
        Log.i(str, str2, null);
        AppMethodBeat.o(136962);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(136963);
        Log.d(str, str2, null);
        AppMethodBeat.o(136963);
    }
}
