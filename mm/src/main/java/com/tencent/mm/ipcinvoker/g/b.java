package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b {
    public static <T> T c(String str, Class<?> cls) {
        AppMethodBeat.i(158831);
        if (str == null || str.length() == 0) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.o(158831);
            return null;
        } else if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            AppMethodBeat.o(158831);
            return null;
        } else {
            try {
                Class<?> cls2 = Class.forName(str);
                if (!cls.isAssignableFrom(cls2)) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls, cls2);
                    AppMethodBeat.o(158831);
                    return null;
                }
                Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                T t = (T) declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.o(158831);
                return t;
            } catch (ClassNotFoundException e2) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.o(158831);
                return null;
            } catch (IllegalAccessException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.o(158831);
                return null;
            } catch (InstantiationException e4) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.o(158831);
                return null;
            } catch (NoSuchMethodException e5) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e5);
                AppMethodBeat.o(158831);
                return null;
            } catch (InvocationTargetException e6) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e6);
                AppMethodBeat.o(158831);
                return null;
            }
        }
    }

    public static <T> T j(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(158832);
        if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.o(158832);
            return null;
        } else if (cls2 == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            AppMethodBeat.o(158832);
            return null;
        } else {
            try {
                if (!cls2.isAssignableFrom(cls)) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls2, cls);
                    AppMethodBeat.o(158832);
                    return null;
                }
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                T t = (T) declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.o(158832);
                return t;
            } catch (IllegalAccessException e2) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.o(158832);
                return null;
            } catch (InstantiationException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.o(158832);
                return null;
            } catch (NoSuchMethodException e4) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.o(158832);
                return null;
            } catch (InvocationTargetException e5) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e5);
                AppMethodBeat.o(158832);
                return null;
            }
        }
    }

    public static <T> T ac(Class<?> cls) {
        T t = null;
        AppMethodBeat.i(158833);
        if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.o(158833);
        } else {
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                t = (T) declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.o(158833);
            } catch (IllegalAccessException e2) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.o(158833);
                return t;
            } catch (InstantiationException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.o(158833);
                return t;
            } catch (NoSuchMethodException e4) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.o(158833);
                return t;
            } catch (InvocationTargetException e5) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e5);
                AppMethodBeat.o(158833);
                return t;
            }
        }
        return t;
    }
}
