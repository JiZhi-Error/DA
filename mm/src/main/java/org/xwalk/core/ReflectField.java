package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;

public class ReflectField {
    private Class<?> mClass;
    private Field mField;
    private Object mInstance;
    private String mName;

    public ReflectField() {
    }

    public ReflectField(Object obj, String str) {
        AppMethodBeat.i(157215);
        init(obj, null, str);
        AppMethodBeat.o(157215);
    }

    public ReflectField(Class<?> cls, String str) {
        AppMethodBeat.i(157216);
        init(null, cls, str);
        AppMethodBeat.o(157216);
    }

    public boolean init(Object obj, Class<?> cls, String str) {
        AppMethodBeat.i(157217);
        this.mInstance = obj;
        if (cls == null) {
            cls = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls;
        this.mName = str;
        this.mField = null;
        if (this.mClass == null) {
            AppMethodBeat.o(157217);
            return false;
        }
        try {
            this.mField = this.mClass.getField(this.mName);
        } catch (NoSuchFieldException e2) {
            for (Class<?> cls2 = this.mClass; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    this.mField = cls2.getDeclaredField(this.mName);
                    this.mField.setAccessible(true);
                    break;
                } catch (NoSuchFieldException e3) {
                }
            }
        }
        if (this.mField != null) {
            AppMethodBeat.o(157217);
            return true;
        }
        AppMethodBeat.o(157217);
        return false;
    }

    public Object get() {
        AppMethodBeat.i(157218);
        if (this.mField == null) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(toString());
            AppMethodBeat.o(157218);
            throw unsupportedOperationException;
        }
        try {
            Object obj = this.mField.get(this.mInstance);
            AppMethodBeat.o(157218);
            return obj;
        } catch (IllegalAccessException | NullPointerException e2) {
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(e2);
            AppMethodBeat.o(157218);
            throw rejectedExecutionException;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(157218);
            throw e3;
        } catch (ExceptionInInitializerError e4) {
            RuntimeException runtimeException = new RuntimeException(e4);
            AppMethodBeat.o(157218);
            throw runtimeException;
        }
    }

    public boolean isNull() {
        return this.mField == null;
    }

    public String toString() {
        AppMethodBeat.i(157219);
        if (this.mField != null) {
            String field = this.mField.toString();
            AppMethodBeat.o(157219);
            return field;
        }
        String str = "";
        if (this.mClass != null) {
            str = str + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            str = str + this.mName;
        }
        AppMethodBeat.o(157219);
        return str;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }
}
