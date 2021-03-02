package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class a<T> {
    private Object QLN;
    private Method mMethod;

    public a(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(206117);
        this.QLN = obj;
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                this.mMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable th) {
            }
        }
        if (this.mMethod == null) {
            new Throwable("MB ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(206117);
    }

    public a(String str, String str2, Class<?>... clsArr) {
        Class<?> cls;
        AppMethodBeat.i(206118);
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            cls = null;
        }
        this.QLN = null;
        while (cls != Object.class) {
            try {
                this.mMethod = cls.getDeclaredMethod(str2, clsArr);
            } catch (Throwable th2) {
            }
            cls = cls.getSuperclass();
        }
        AppMethodBeat.o(206118);
    }

    public final T invoke(Object... objArr) {
        AppMethodBeat.i(206119);
        try {
            this.mMethod.setAccessible(true);
            T t = (T) this.mMethod.invoke(this.QLN, objArr);
            AppMethodBeat.o(206119);
            return t;
        } catch (Throwable th) {
            AppMethodBeat.o(206119);
            return null;
        }
    }
}
