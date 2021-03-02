package com.tencent.f.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<Type> {
    private Class<?> dfe;
    private String dff;
    private Field mField;
    private boolean mInit;

    public a(Class<?> cls, String str) {
        AppMethodBeat.i(183484);
        if (cls == null || str == null || str.length() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
            AppMethodBeat.o(183484);
            throw illegalArgumentException;
        }
        this.dfe = cls;
        this.dff = str;
        AppMethodBeat.o(183484);
    }

    private synchronized void prepare() {
        AppMethodBeat.i(183485);
        if (this.mInit) {
            AppMethodBeat.o(183485);
        } else {
            for (Class<?> cls = this.dfe; cls != null; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(this.dff);
                    declaredField.setAccessible(true);
                    this.mField = declaredField;
                    break;
                } catch (Exception e2) {
                }
            }
            this.mInit = true;
            AppMethodBeat.o(183485);
        }
    }

    public final synchronized Type get() {
        Type ayk;
        AppMethodBeat.i(183486);
        ayk = ayk();
        AppMethodBeat.o(183486);
        return ayk;
    }

    private synchronized Type ayk() {
        Type type;
        AppMethodBeat.i(183487);
        prepare();
        if (this.mField == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
            AppMethodBeat.o(183487);
            throw noSuchFieldException;
        }
        try {
            type = (Type) this.mField.get(null);
            AppMethodBeat.o(183487);
        } catch (ClassCastException e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
            AppMethodBeat.o(183487);
            throw illegalArgumentException;
        }
        return type;
    }

    public final synchronized boolean eE(Object obj) {
        boolean R;
        AppMethodBeat.i(183488);
        R = R(obj, null);
        AppMethodBeat.o(183488);
        return R;
    }

    private synchronized boolean R(Object obj, Type type) {
        AppMethodBeat.i(183489);
        prepare();
        if (this.mField == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("Method " + this.dff + " is not exists.");
            AppMethodBeat.o(183489);
            throw noSuchFieldException;
        }
        this.mField.set(obj, type);
        AppMethodBeat.o(183489);
        return true;
    }

    public final synchronized boolean eF(Type type) {
        boolean R;
        AppMethodBeat.i(183490);
        R = R(null, type);
        AppMethodBeat.o(183490);
        return R;
    }
}
