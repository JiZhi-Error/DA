package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

/* access modifiers changed from: package-private */
public class ReflectConstructor {
    private Class<?> mClass;
    private Constructor<?> mConstructor;
    private Class<?>[] mParameterTypes;

    public ReflectConstructor() {
    }

    public ReflectConstructor(Class<?> cls, Class<?>... clsArr) {
        AppMethodBeat.i(154602);
        init(cls, clsArr);
        AppMethodBeat.o(154602);
    }

    public boolean init(Class<?> cls, Class<?>... clsArr) {
        AppMethodBeat.i(154603);
        this.mClass = cls;
        this.mParameterTypes = clsArr;
        this.mConstructor = null;
        if (this.mClass == null) {
            AppMethodBeat.o(154603);
            return false;
        }
        try {
            this.mConstructor = this.mClass.getConstructor(this.mParameterTypes);
        } catch (NoSuchMethodException e2) {
            try {
                this.mConstructor = this.mClass.getDeclaredConstructor(this.mParameterTypes);
                this.mConstructor.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
        }
        if (this.mConstructor != null) {
            AppMethodBeat.o(154603);
            return true;
        }
        AppMethodBeat.o(154603);
        return false;
    }

    public Object newInstance(Object... objArr) {
        AppMethodBeat.i(154604);
        if (this.mConstructor == null) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(toString());
            AppMethodBeat.o(154604);
            throw unsupportedOperationException;
        }
        try {
            Object newInstance = this.mConstructor.newInstance(objArr);
            AppMethodBeat.o(154604);
            return newInstance;
        } catch (IllegalAccessException e2) {
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(e2);
            AppMethodBeat.o(154604);
            throw rejectedExecutionException;
        } catch (InstantiationException e3) {
            RejectedExecutionException rejectedExecutionException2 = new RejectedExecutionException(e3);
            AppMethodBeat.o(154604);
            throw rejectedExecutionException2;
        } catch (IllegalArgumentException e4) {
            AppMethodBeat.o(154604);
            throw e4;
        } catch (InvocationTargetException e5) {
            RuntimeException runtimeException = new RuntimeException(e5.getCause());
            AppMethodBeat.o(154604);
            throw runtimeException;
        }
    }

    public boolean isNull() {
        return this.mConstructor == null;
    }

    public String toString() {
        AppMethodBeat.i(154605);
        if (this.mConstructor != null) {
            String constructor = this.mConstructor.toString();
            AppMethodBeat.o(154605);
            return constructor;
        }
        String str = "";
        if (this.mClass != null) {
            str = str + this.mClass.toString();
        }
        AppMethodBeat.o(154605);
        return str;
    }
}
