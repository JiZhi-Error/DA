package com.tencent.liteav.basic.module;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TXCKeyPointReportProxy {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f412a;

        /* renamed from: b  reason: collision with root package name */
        public int f413b;

        /* renamed from: c  reason: collision with root package name */
        public int f414c;

        /* renamed from: d  reason: collision with root package name */
        public int f415d;

        /* renamed from: e  reason: collision with root package name */
        public String f416e;

        /* renamed from: f  reason: collision with root package name */
        public String f417f;

        /* renamed from: g  reason: collision with root package name */
        public String f418g;

        /* renamed from: h  reason: collision with root package name */
        public String f419h;
    }

    private static native void nativeInit(String str);

    private static native void nativeSendCacheReport();

    private static native void nativeSetBasicInfo(int i2, int i3);

    private static native void nativeSetCpu(int i2, int i3);

    private static native void nativeSetDeviceInfo(int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4);

    private static native void nativeSetErrorCode(int i2);

    private static native void nativeSetLocalQuality(int i2, int i3, int i4);

    private static native void nativeTagKeyPointEnd(int i2, int i3);

    private static native void nativeTagKeyPointStart(int i2);

    private static native void nativesetRemoteQuality(String str, int i2, long j2, int i3);

    public static void a(Context context) {
        AppMethodBeat.i(182421);
        if (context == null) {
            AppMethodBeat.o(182421);
            return;
        }
        File externalFilesDir = context.getApplicationContext().getExternalFilesDir(null);
        if (externalFilesDir == null) {
            AppMethodBeat.o(182421);
            return;
        }
        String str = externalFilesDir.getAbsolutePath() + "/txrtmp/ssoreport.txt";
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    TXCLog.e("TXCKeyPointReportProxy", "can not create sso file path");
                    AppMethodBeat.o(182421);
                    return;
                }
            } catch (Exception e2) {
                TXCLog.e("TXCKeyPointReportProxy", "create sso file exception:" + e2.toString());
            }
        }
        nativeInit(str);
        AppMethodBeat.o(182421);
    }

    public static void a() {
        AppMethodBeat.i(14427);
        nativeSendCacheReport();
        AppMethodBeat.o(14427);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(222019);
        nativeSetDeviceInfo(aVar.f412a, aVar.f413b, aVar.f414c, aVar.f415d, aVar.f416e, aVar.f417f, aVar.f418g, aVar.f419h);
        AppMethodBeat.o(222019);
    }

    public static void a(int i2, int i3) {
        AppMethodBeat.i(14430);
        nativeSetCpu(i2, i3);
        AppMethodBeat.o(14430);
    }

    public static void a(int i2) {
        AppMethodBeat.i(14431);
        nativeTagKeyPointStart(i2);
        AppMethodBeat.o(14431);
    }

    public static void b(int i2, int i3) {
        AppMethodBeat.i(14432);
        nativeTagKeyPointEnd(i2, i3);
        AppMethodBeat.o(14432);
    }

    public static void a(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(222020);
        nativesetRemoteQuality(str, i2, j2, i3);
        AppMethodBeat.o(222020);
    }

    public static void a(int i2, int i3, int i4) {
        AppMethodBeat.i(222021);
        nativeSetLocalQuality(i2, i3, i4);
        AppMethodBeat.o(222021);
    }

    public static void c(int i2, int i3) {
        AppMethodBeat.i(222022);
        nativeSetBasicInfo(i2, i3);
        AppMethodBeat.o(222022);
    }

    public static void b(int i2) {
        AppMethodBeat.i(222023);
        nativeSetErrorCode(i2);
        AppMethodBeat.o(222023);
    }
}
