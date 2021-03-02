package com.tencent.f.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class b {
    private String ZJ;
    private Class<?> dfe;
    private boolean mInit;
    private Method mMethod;
    private Class[] mParameterTypes;

    public b(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(183491);
        if (str.length() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
            AppMethodBeat.o(183491);
            throw illegalArgumentException;
        }
        this.dfe = cls;
        this.ZJ = str;
        this.mParameterTypes = clsArr;
        AppMethodBeat.o(183491);
    }

    private synchronized void prepare() {
        AppMethodBeat.i(183492);
        if (this.mInit) {
            AppMethodBeat.o(183492);
        } else {
            for (Class<?> cls = this.dfe; cls != null; cls = cls.getSuperclass()) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(this.ZJ, this.mParameterTypes);
                    declaredMethod.setAccessible(true);
                    this.mMethod = declaredMethod;
                    break;
                } catch (Exception e2) {
                }
            }
            this.mInit = true;
            AppMethodBeat.o(183492);
        }
    }

    public final synchronized <T> T invoke(Object obj, Object... objArr) {
        T t;
        AppMethodBeat.i(183493);
        t = (T) a(obj, objArr);
        AppMethodBeat.o(183493);
        return t;
    }

    private synchronized <T> T a(Object obj, Object... objArr) {
        T t;
        AppMethodBeat.i(183494);
        prepare();
        if (this.mMethod == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("Method " + this.ZJ + " is not exists.");
            AppMethodBeat.o(183494);
            throw noSuchFieldException;
        }
        t = (T) this.mMethod.invoke(obj, objArr);
        AppMethodBeat.o(183494);
        return t;
    }
}
