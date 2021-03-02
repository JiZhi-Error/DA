package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import java.lang.reflect.Field;

public final class a<FieldType> {
    private Class<?> dfe;
    private String dff;
    private Field mField;
    private boolean mInited;

    public a(Class<?> cls, String str) {
        AppMethodBeat.i(158827);
        if (str.length() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
            AppMethodBeat.o(158827);
            throw illegalArgumentException;
        }
        this.dfe = cls;
        this.dff = str;
        AppMethodBeat.o(158827);
    }

    private synchronized void prepare() {
        AppMethodBeat.i(158828);
        if (this.mInited) {
            AppMethodBeat.o(158828);
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
            this.mInited = true;
            AppMethodBeat.o(158828);
        }
    }

    private synchronized FieldType ayk() {
        FieldType fieldtype = null;
        synchronized (this) {
            AppMethodBeat.i(158829);
            prepare();
            if (this.mField == null) {
                b.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", this.dff);
                AppMethodBeat.o(158829);
            } else {
                try {
                    fieldtype = (FieldType) this.mField.get(null);
                    AppMethodBeat.o(158829);
                } catch (ClassCastException e2) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
                    AppMethodBeat.o(158829);
                    throw illegalArgumentException;
                }
            }
        }
        return fieldtype;
    }

    public final synchronized FieldType ayl() {
        FieldType fieldtype;
        AppMethodBeat.i(158830);
        fieldtype = null;
        try {
            fieldtype = ayk();
        } catch (NoSuchFieldException e2) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e2);
        } catch (IllegalAccessException e3) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e3);
        } catch (IllegalArgumentException e4) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e4);
        }
        AppMethodBeat.o(158830);
        return fieldtype;
    }
}
