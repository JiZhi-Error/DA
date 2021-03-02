package com.tencent.mm.sdk.vendor;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationTargetException;

public class Vivo {
    private static final String TAG = "MicroMsg.Vendor.Vivo";

    public static boolean vivohasCutOut(Context context) {
        AppMethodBeat.i(153484);
        if (context == null) {
            AppMethodBeat.o(153484);
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            boolean booleanValue = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            Log.d(TAG, "vivo hasCutOut: %s", Boolean.valueOf(booleanValue));
            AppMethodBeat.o(153484);
            return booleanValue;
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, "hasCutOut, ClassNotFoundException!!");
            Log.d(TAG, "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153484);
            return false;
        } catch (NoSuchMethodException e3) {
            Log.e(TAG, "hasCutOut, NoSuchMethodException!!");
            Log.d(TAG, "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153484);
            return false;
        } catch (IllegalAccessException e4) {
            Log.e(TAG, "hasCutOut, IllegalAccessException!!");
            Log.d(TAG, "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153484);
            return false;
        } catch (InvocationTargetException e5) {
            Log.e(TAG, "hasCutOut, InvocationTargetException!!");
            Log.d(TAG, "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153484);
            return false;
        } catch (Throwable th) {
            Log.d(TAG, "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153484);
            return false;
        }
    }

    public static boolean vivoSupportDarkMode() {
        boolean z;
        AppMethodBeat.i(214376);
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            z = ((Boolean) cls.getDeclaredMethod("isFeatureSupport", String.class).invoke(cls, "vivo.software.nightmode")).booleanValue();
        } catch (Exception e2) {
            Log.d(TAG, "vivo supportDarkMode Exception!:%s", e2);
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            z = false;
        }
        Log.d(TAG, "vivo supportDarkMode: %s", Boolean.valueOf(z));
        AppMethodBeat.o(214376);
        return z;
    }
}
