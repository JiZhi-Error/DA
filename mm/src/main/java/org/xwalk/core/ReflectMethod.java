package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

public class ReflectMethod {
    protected Object[] mArguments;
    protected Class<?> mClass;
    protected Object mInstance;
    protected Method mMethod;
    protected String mName;
    protected Class<?>[] mParameterTypes;

    public ReflectMethod() {
    }

    public ReflectMethod(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(154606);
        init(obj, null, str, clsArr);
        AppMethodBeat.o(154606);
    }

    public ReflectMethod(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(154607);
        init(null, cls, str, clsArr);
        AppMethodBeat.o(154607);
    }

    public boolean init(Object obj, Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(154608);
        this.mInstance = obj;
        if (cls == null) {
            cls = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls;
        this.mName = str;
        this.mParameterTypes = clsArr;
        this.mMethod = null;
        if (this.mClass == null) {
            AppMethodBeat.o(154608);
            return false;
        }
        try {
            this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
        } catch (NoSuchMethodException e2) {
            for (Class<?> cls2 = this.mClass; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    this.mMethod = cls2.getDeclaredMethod(this.mName, this.mParameterTypes);
                    this.mMethod.setAccessible(true);
                    break;
                } catch (NoSuchMethodException e3) {
                }
            }
        }
        if (this.mMethod != null) {
            AppMethodBeat.o(154608);
            return true;
        }
        AppMethodBeat.o(154608);
        return false;
    }

    public Object invoke(Object... objArr) {
        AppMethodBeat.i(154609);
        if (this.mMethod == null) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(toString());
            AppMethodBeat.o(154609);
            throw unsupportedOperationException;
        }
        try {
            Object invoke = this.mMethod.invoke(this.mInstance, objArr);
            AppMethodBeat.o(154609);
            return invoke;
        } catch (IllegalAccessException | NullPointerException e2) {
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(e2);
            AppMethodBeat.o(154609);
            throw rejectedExecutionException;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(154609);
            throw e3;
        } catch (InvocationTargetException e4) {
            RuntimeException runtimeException = new RuntimeException(e4.getCause());
            AppMethodBeat.o(154609);
            throw runtimeException;
        }
    }

    public boolean isNull() {
        return this.mMethod == null;
    }

    public String toString() {
        AppMethodBeat.i(154610);
        if (this.mMethod != null) {
            String method = this.mMethod.toString();
            AppMethodBeat.o(154610);
            return method;
        }
        String str = "";
        if (this.mClass != null) {
            str = str + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            str = str + this.mName;
        }
        AppMethodBeat.o(154610);
        return str;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }

    public Object[] getArguments() {
        return this.mArguments;
    }

    public void setArguments(Object... objArr) {
        this.mArguments = objArr;
    }

    public Object invokeWithArguments() {
        AppMethodBeat.i(154611);
        Object invoke = invoke(this.mArguments);
        AppMethodBeat.o(154611);
        return invoke;
    }
}
