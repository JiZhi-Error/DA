package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.b.a;

public class m implements InvocationHandler {
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(147718);
        Class<?> returnType = method.getReturnType();
        if (returnType.equals(Integer.TYPE)) {
            AppMethodBeat.o(147718);
            return 0;
        } else if (returnType.equals(Long.TYPE)) {
            AppMethodBeat.o(147718);
            return 0L;
        } else if (returnType.equals(Double.TYPE)) {
            Double valueOf = Double.valueOf(0.0d);
            AppMethodBeat.o(147718);
            return valueOf;
        } else if (returnType.equals(Float.TYPE)) {
            Float valueOf2 = Float.valueOf(0.0f);
            AppMethodBeat.o(147718);
            return valueOf2;
        } else if (returnType.equals(Short.TYPE)) {
            AppMethodBeat.o(147718);
            return 0;
        } else if (returnType.equals(Byte.TYPE)) {
            AppMethodBeat.o(147718);
            return 0;
        } else if (returnType.equals(Character.TYPE)) {
            AppMethodBeat.o(147718);
            return 0;
        } else if (returnType.equals(Boolean.TYPE)) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(147718);
            return bool;
        } else if (returnType.equals(Boolean.class)) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(147718);
            return bool2;
        } else if (returnType.isInterface()) {
            AppMethodBeat.o(147718);
            return null;
        } else {
            AppMethodBeat.o(147718);
            return null;
        }
    }

    public static <I> I g(final String str, Class<I> cls) {
        AppMethodBeat.i(176786);
        AnonymousClass1 r0 = new m() {
            /* class com.tencent.mm.plugin.appbrand.utils.m.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.utils.m, java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                AppMethodBeat.i(176785);
                Log.i(str, "dummy invoke method(%s) args(%s)", method.getName(), a.toString(objArr, "NULL"));
                Object invoke = m.super.invoke(obj, method, objArr);
                AppMethodBeat.o(176785);
                return invoke;
            }
        };
        I cast = cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, r0));
        AppMethodBeat.o(176786);
        return cast;
    }
}
