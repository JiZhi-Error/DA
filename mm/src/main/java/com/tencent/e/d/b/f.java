package com.tencent.e.d.b;

import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f {
    private static Field k(Class<?> cls, String str) {
        AppMethodBeat.i(138367);
        if (cls == null) {
            AppMethodBeat.o(138367);
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField == null) {
                AppMethodBeat.o(138367);
                return null;
            }
            declaredField.setAccessible(true);
            AppMethodBeat.o(138367);
            return declaredField;
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(138367);
            return null;
        }
    }

    private static Class<?> bqc(String str) {
        Class<?> cls;
        AppMethodBeat.i(138368);
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(138368);
            return null;
        }
        if (cls == null) {
            AppMethodBeat.o(138368);
            return null;
        }
        AppMethodBeat.o(138368);
        return cls;
    }

    public static Object c(Class<?> cls, String str, Object obj) {
        AppMethodBeat.i(138369);
        try {
            Field k = k(cls, str);
            if (k == null) {
                AppMethodBeat.o(138369);
                return null;
            }
            Object obj2 = k.get(obj);
            AppMethodBeat.o(138369);
            return obj2;
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(138369);
            return null;
        }
    }

    public static Object nH(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(138370);
        try {
            obj = c(bqc(str), str2, null);
            AppMethodBeat.o(138370);
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(138370);
        }
        return obj;
    }

    private static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(138371);
        if (cls != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (declaredMethod == null) {
                        AppMethodBeat.o(138371);
                        return null;
                    }
                    declaredMethod.setAccessible(true);
                    AppMethodBeat.o(138371);
                    return declaredMethod;
                }
            } catch (Throwable th) {
                h.w(th);
                AppMethodBeat.o(138371);
                return null;
            }
        }
        AppMethodBeat.o(138371);
        return null;
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        AppMethodBeat.i(138372);
        try {
            Method e2 = e(bqc(str), str2, clsArr);
            AppMethodBeat.o(138372);
            return e2;
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(138372);
            return null;
        }
    }
}
