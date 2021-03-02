package com.tencent.mm.plugin.crashfix.d.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Proxy;

public final class c {
    protected static Object qCW;

    public static Object dc(Object obj) {
        AppMethodBeat.i(145633);
        if (obj == null) {
            AppMethodBeat.o(145633);
            return null;
        }
        if (qCW == null) {
            try {
                ClassLoader classLoader = obj.getClass().getClassLoader();
                Class<?>[] interfaces = obj.getClass().getInterfaces();
                if (Build.VERSION.SDK_INT == 25) {
                    qCW = Proxy.newProxyInstance(classLoader, interfaces, new b(obj));
                } else {
                    qCW = Proxy.newProxyInstance(classLoader, interfaces, new a(obj));
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ProxyNotificationManager", e2.getMessage());
            }
        }
        Object obj2 = qCW;
        AppMethodBeat.o(145633);
        return obj2;
    }
}
