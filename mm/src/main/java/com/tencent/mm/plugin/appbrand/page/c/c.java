package com.tencent.mm.plugin.appbrand.page.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface c {
    void MV();

    void Nj();

    void Nk();

    b Nl();

    public enum b {
        SHOWN,
        HIDDEN;

        public static b valueOf(String str) {
            AppMethodBeat.i(135319);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(135319);
            return bVar;
        }

        static {
            AppMethodBeat.i(135320);
            AppMethodBeat.o(135320);
        }
    }

    public static class a {
        public static c y(ac acVar) {
            AppMethodBeat.i(135317);
            if (acVar.kEb.getStatusBar() == null) {
                AnonymousClass1 r0 = new m() {
                    /* class com.tencent.mm.plugin.appbrand.page.c.c.a.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.utils.m, java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        AppMethodBeat.i(176696);
                        Log.i("Luggage.WXA.IPageStatusBarHelper.Dummy", "dummy invoke method(%s) args(%s)", method.getName(), org.apache.commons.b.a.toString(objArr, "NULL"));
                        Object invoke = super.invoke(obj, method, objArr);
                        AppMethodBeat.o(176696);
                        return invoke;
                    }
                };
                c cVar = (c) Proxy.newProxyInstance(c.class.getClassLoader(), new Class[]{c.class}, r0);
                AppMethodBeat.o(135317);
                return cVar;
            } else if (Build.VERSION.SDK_INT < 21 || ((com.tencent.luggage.sdk.config.a) acVar.av(com.tencent.luggage.sdk.config.a.class)).cyh) {
                b bVar = new b(acVar);
                AppMethodBeat.o(135317);
                return bVar;
            } else {
                a aVar = new a(acVar);
                AppMethodBeat.o(135317);
                return aVar;
            }
        }
    }
}
