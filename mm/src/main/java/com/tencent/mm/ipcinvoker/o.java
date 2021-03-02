package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.e;
import com.tencent.mm.ipcinvoker.h.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class o {
    private static final Map<String, e> hno = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(158758);
        AppMethodBeat.o(158758);
    }

    public static <T> T b(String str, Class<?> cls) {
        AppMethodBeat.i(158755);
        try {
            Class<?> cls2 = Class.forName(str);
            if (!cls.isAssignableFrom(cls2)) {
                b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls, cls2);
                AppMethodBeat.o(158755);
                return null;
            } else if (cls2.isAnnotationPresent(a.class)) {
                e eVar = hno.get(str);
                if (eVar == null) {
                    eVar = new e(cls2);
                    hno.put(str, eVar);
                }
                T t = (T) eVar.get();
                AppMethodBeat.o(158755);
                return t;
            } else {
                T t2 = (T) com.tencent.mm.ipcinvoker.g.b.c(str, cls);
                AppMethodBeat.o(158755);
                return t2;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(158755);
            return null;
        }
    }

    public static <T> T i(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(158756);
        try {
            if (!cls2.isAssignableFrom(cls)) {
                b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls2, cls);
                AppMethodBeat.o(158756);
                return null;
            } else if (cls.isAnnotationPresent(a.class)) {
                String name = cls.getName();
                e eVar = hno.get(name);
                if (eVar == null) {
                    eVar = new e(cls);
                    hno.put(name, eVar);
                }
                T t = (T) eVar.get();
                AppMethodBeat.o(158756);
                return t;
            } else {
                T t2 = (T) com.tencent.mm.ipcinvoker.g.b.j(cls, cls2);
                AppMethodBeat.o(158756);
                return t2;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(158756);
            return null;
        }
    }

    public static <T> T c(String str, Class<?> cls) {
        AppMethodBeat.i(158757);
        T t = (T) com.tencent.mm.ipcinvoker.g.b.c(str, cls);
        AppMethodBeat.o(158757);
        return t;
    }
}
