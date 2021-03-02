package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public final class e {
    private static LinkedHashMap<String, c> csf = new LinkedHashMap<>();
    private static Map<Class<? extends d>, Object> csg = new HashMap();

    static {
        AppMethodBeat.i(140311);
        a aVar = new a();
        Log.i("Luggage.Luggage", "plugin:[%s] installed", aVar.getName());
        csf.put(aVar.getName(), aVar);
        AppMethodBeat.o(140311);
    }

    public static <T extends b> T M(Class<T> cls) {
        AppMethodBeat.i(140305);
        if (cls == null) {
            AppMethodBeat.o(140305);
            return null;
        }
        ListIterator listIterator = new ArrayList(csf.values()).listIterator(csf.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar != null && cVar.KU() != null && cVar.KU().get(cls) != null) {
                T t = (T) cVar.KU().get(cls);
                AppMethodBeat.o(140305);
                return t;
            }
        }
        Log.w("Luggage.Luggage", "no customize found for [%s]", cls.getCanonicalName());
        AppMethodBeat.o(140305);
        return null;
    }

    public static <T extends b> void a(Class<T> cls, T t) {
        AppMethodBeat.i(140306);
        if (cls == null || t == null) {
            AppMethodBeat.o(140306);
            return;
        }
        csf.get("luggage-core").KU().put(cls, t);
        AppMethodBeat.o(140306);
    }

    public static <T extends d> void a(Class<T> cls, T t) {
        AppMethodBeat.i(140307);
        if (cls == null || t == null) {
            AppMethodBeat.o(140307);
            return;
        }
        csf.get("luggage-core").KV().put(cls, t);
        AppMethodBeat.o(140307);
    }

    public static <T extends d> T N(Class<T> cls) {
        AppMethodBeat.i(140308);
        T t = (T) O(cls);
        AppMethodBeat.o(140308);
        return t;
    }

    public static <T extends d> T O(Class<T> cls) {
        AppMethodBeat.i(140309);
        if (cls == null) {
            T t = (T) P(cls);
            AppMethodBeat.o(140309);
            return t;
        }
        ListIterator listIterator = new ArrayList(csf.values()).listIterator(csf.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar != null && cVar.KV() != null && cVar.KV().get(cls) != null) {
                T t2 = (T) cVar.KV().get(cls);
                AppMethodBeat.o(140309);
                return t2;
            }
        }
        Log.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", cls.getCanonicalName(), Boolean.TRUE);
        T t3 = (T) P(cls);
        AppMethodBeat.o(140309);
        return t3;
    }

    private static <T extends d> T P(Class<T> cls) {
        AppMethodBeat.i(140310);
        if (csg.get(cls) != null) {
            T t = (T) ((d) csg.get(cls));
            AppMethodBeat.o(140310);
            return t;
        }
        AnonymousClass1 r0 = new InvocationHandler() {
            /* class com.tencent.luggage.a.e.AnonymousClass1 */

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return null;
            }
        };
        T t2 = (T) ((d) Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{cls}, r0));
        csg.put(cls, t2);
        AppMethodBeat.o(140310);
        return t2;
    }
}
