package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class af {
    private static Class<?> aWC;
    private static Method gKG;
    private static Method gKH;

    static {
        AppMethodBeat.i(155827);
        aWC = null;
        gKG = null;
        gKH = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            aWC = cls;
            gKG = cls.getDeclaredMethod("get", String.class);
            gKH = aWC.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            gKG.setAccessible(true);
            gKH.setAccessible(true);
            AppMethodBeat.o(155827);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SystemProperties", e2, "", new Object[0]);
            AppMethodBeat.o(155827);
        }
    }

    public static String get(String str) {
        AppMethodBeat.i(155826);
        try {
            String str2 = (String) gKG.invoke(null, str);
            AppMethodBeat.o(155826);
            return str2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SystemProperties", e2, "", new Object[0]);
            AppMethodBeat.o(155826);
            return null;
        }
    }
}
