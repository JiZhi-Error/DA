package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class x {
    private static int drk = -1;
    private static int drl = -1;
    private static a drm;

    public interface a {
        void gz(String str);
    }

    public static void a(a aVar) {
        drm = aVar;
    }

    public static void a(int i2, long j2, int i3, String str, int i4, int i5, int i6) {
        int i7;
        int i8;
        AppMethodBeat.i(144122);
        if (drm != null) {
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Long.valueOf(j2);
            if (drk > 0) {
                i7 = drk;
            } else {
                XO();
                i7 = drk;
            }
            objArr[2] = Integer.valueOf(i7);
            if (drl > 0) {
                i8 = drl;
            } else {
                XO();
                i8 = drl;
            }
            objArr[3] = Integer.valueOf(i8);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = str;
            objArr[6] = Integer.valueOf(i4);
            objArr[7] = Integer.valueOf(i5);
            objArr[8] = Integer.valueOf(i6);
            String format = String.format("%d,%d,%d,%d,%d,%s,%d,%d,%d", objArr);
            Log.v("MicroMsg.V8GCReporter", "report str:%s", format);
            drm.gz(format);
        }
        AppMethodBeat.o(144122);
    }

    private static void XO() {
        AppMethodBeat.i(144123);
        String flags = V8.getFlags();
        Log.i("MicroMsg.V8GCReporter", "initV8GCSpaceSizeFromFlags : %s", flags);
        if (Util.isNullOrNil(flags)) {
            drk = 1;
            drl = 8;
            AppMethodBeat.o(144123);
            return;
        }
        String[] split = flags.split(" ", -1);
        for (int i2 = 0; i2 < split.length; i2++) {
            int e2 = e(split[i2], "--min_semi_space_size", 1);
            if (e2 != Integer.MIN_VALUE) {
                drk = e2;
            } else {
                int e3 = e(split[i2], "--max_semi_space_size", 8);
                if (e3 != Integer.MIN_VALUE) {
                    drl = e3;
                }
            }
        }
        AppMethodBeat.o(144123);
    }

    private static int e(String str, String str2, int i2) {
        AppMethodBeat.i(144124);
        String str3 = str2 + "=";
        if (str.indexOf(str3) >= 0) {
            int i3 = Util.getInt(str.replaceFirst(str3, ""), i2);
            AppMethodBeat.o(144124);
            return i3;
        }
        AppMethodBeat.o(144124);
        return Integer.MIN_VALUE;
    }
}
