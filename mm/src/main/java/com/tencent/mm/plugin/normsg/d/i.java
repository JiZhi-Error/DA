package com.tencent.mm.plugin.normsg.d;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class i {
    private static final LruCache<String, LruCache<String, Field>> AGr = new LruCache<>(50);
    private static final LruCache<String, LruCache<String, Method>> AGs = new LruCache<>(50);
    private static final LruCache<String, LruCache<String, Constructor<?>>> AGt = new LruCache<>(50);

    static {
        AppMethodBeat.i(149105);
        AppMethodBeat.o(149105);
    }

    public static Class<?> findClass(String str) {
        AppMethodBeat.i(149095);
        try {
            Class<?> cls = Class.forName(str);
            AppMethodBeat.o(149095);
            return cls;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(149095);
            throw aVar;
        }
    }

    public static <T> T d(Object obj, String str) {
        AppMethodBeat.i(149096);
        try {
            T t = (T) j(obj.getClass(), str).get(obj);
            AppMethodBeat.o(149096);
            return t;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(149096);
            throw aVar;
        }
    }

    public static <T> T jh(String str, String str2) {
        AppMethodBeat.i(149097);
        T t = (T) i(findClass(str), str2);
        AppMethodBeat.o(149097);
        return t;
    }

    private static <T> T i(Class<?> cls, String str) {
        AppMethodBeat.i(149098);
        try {
            T t = (T) j(cls, str).get(null);
            AppMethodBeat.o(149098);
            return t;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(149098);
            throw aVar;
        }
    }

    public static <T> void c(Object obj, String str, T t) {
        AppMethodBeat.i(149099);
        try {
            j(obj.getClass(), str).set(obj, t);
            AppMethodBeat.o(149099);
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(149099);
            throw aVar;
        }
    }

    public static <T> T b(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(149100);
        try {
            T t = (T) d(obj.getClass(), str, clsArr).invoke(obj, objArr);
            AppMethodBeat.o(149100);
            return t;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(149100);
            throw aVar;
        }
    }

    public static <T> T a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(149101);
        T t = (T) b(findClass(str), str2, clsArr, objArr);
        AppMethodBeat.o(149101);
        return t;
    }

    public static <T> T b(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(149102);
        try {
            T t = (T) d(cls, str, clsArr).invoke(null, objArr);
            AppMethodBeat.o(149102);
            return t;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(149102);
            throw aVar;
        }
    }

    public static Class<?>[] b(Class<?>... clsArr) {
        return clsArr;
    }

    private static Field j(Class<?> cls, String str) {
        LruCache<String, Field> lruCache;
        AppMethodBeat.i(149103);
        LruCache<String, Field> lruCache2 = AGr.get(cls.getName());
        if (lruCache2 == null) {
            LruCache<String, Field> lruCache3 = new LruCache<>(30);
            AGr.put(cls.getName(), lruCache3);
            lruCache = lruCache3;
        } else {
            lruCache = lruCache2;
        }
        Field field = lruCache.get(str);
        if (field != null) {
            AppMethodBeat.o(149103);
        } else {
            while (true) {
                try {
                    field = cls.getDeclaredField(str);
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    lruCache.put(str, field);
                    AppMethodBeat.o(149103);
                } catch (Throwable th) {
                    if (cls.getSuperclass() == null || cls == Object.class) {
                        AppMethodBeat.o(149103);
                        throw th;
                    }
                    cls = cls.getSuperclass();
                }
            }
            AppMethodBeat.o(149103);
            throw th;
        }
        return field;
    }

    private static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        LruCache<String, Method> lruCache;
        AppMethodBeat.i(149104);
        LruCache<String, Method> lruCache2 = AGs.get(cls.getName());
        if (lruCache2 == null) {
            LruCache<String, Method> lruCache3 = new LruCache<>(30);
            AGs.put(cls.getName(), lruCache3);
            lruCache = lruCache3;
        } else {
            lruCache = lruCache2;
        }
        String str2 = str + "#" + (clsArr != null ? Arrays.toString(clsArr) : "[]");
        Method method = lruCache.get(str2);
        if (method != null) {
            AppMethodBeat.o(149104);
        } else {
            while (true) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    lruCache.put(str2, method);
                    AppMethodBeat.o(149104);
                } catch (Throwable th) {
                    if (cls.getSuperclass() == null || cls == Object.class) {
                        AppMethodBeat.o(149104);
                        throw th;
                    }
                    cls = cls.getSuperclass();
                }
            }
        }
        return method;
    }

    public static class a extends RuntimeException {
        a(Throwable th) {
            super(th);
        }
    }
}
