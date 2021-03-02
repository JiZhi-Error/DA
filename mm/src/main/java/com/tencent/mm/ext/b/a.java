package com.tencent.mm.ext.b;

import android.content.Context;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

public final class a {
    private static Boolean ifHUAWEI = null;
    private static String systemName = null;

    public static boolean huaweihasCutOut(Context context) {
        AppMethodBeat.i(197903);
        if (context == null) {
            AppMethodBeat.o(197903);
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            boolean booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.valueOf(booleanValue));
            AppMethodBeat.o(197903);
            return booleanValue;
        } catch (ClassNotFoundException e2) {
            b.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197903);
            return false;
        } catch (NoSuchMethodException e3) {
            b.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197903);
            return false;
        } catch (IllegalAccessException e4) {
            b.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197903);
            return false;
        } catch (InvocationTargetException e5) {
            b.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!", new Object[0]);
            b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197903);
            return false;
        } catch (Throwable th) {
            b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(197903);
            return false;
        }
    }
}
