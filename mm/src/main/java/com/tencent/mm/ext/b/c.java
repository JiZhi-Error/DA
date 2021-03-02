package com.tencent.mm.ext.b;

import android.content.Context;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

public final class c {
    public static boolean vivohasCutOut(Context context) {
        AppMethodBeat.i(197905);
        if (context == null) {
            AppMethodBeat.o(197905);
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            boolean booleanValue = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.valueOf(booleanValue));
            AppMethodBeat.o(197905);
            return booleanValue;
        } catch (ClassNotFoundException e2) {
            b.e("MicroMsg.Vendor.Vivo", "hasCutOut, ClassNotFoundException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197905);
            return false;
        } catch (NoSuchMethodException e3) {
            b.e("MicroMsg.Vendor.Vivo", "hasCutOut, NoSuchMethodException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197905);
            return false;
        } catch (IllegalAccessException e4) {
            b.e("MicroMsg.Vendor.Vivo", "hasCutOut, IllegalAccessException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197905);
            return false;
        } catch (InvocationTargetException e5) {
            b.e("MicroMsg.Vendor.Vivo", "hasCutOut, InvocationTargetException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197905);
            return false;
        } catch (Throwable th) {
            b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197905);
            return false;
        }
    }
}
