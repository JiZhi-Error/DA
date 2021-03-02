package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class ObjectWrapper<T> extends IObjectWrapper.Stub {
    private final T zzabn;

    private ObjectWrapper(T t) {
        this.zzabn = t;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(5418);
        if (iObjectWrapper instanceof ObjectWrapper) {
            T t = ((ObjectWrapper) iObjectWrapper).zzabn;
            AppMethodBeat.o(5418);
            return t;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int length = declaredFields.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Field field2 = declaredFields[i2];
            if (!field2.isSynthetic()) {
                i3++;
            } else {
                field2 = field;
            }
            i2++;
            field = field2;
        }
        if (i3 != 1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(64).append("Unexpected number of IObjectWrapper declared fields: ").append(declaredFields.length).toString());
            AppMethodBeat.o(5418);
            throw illegalArgumentException;
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
            try {
                T t2 = (T) field.get(asBinder);
                AppMethodBeat.o(5418);
                return t2;
            } catch (NullPointerException e2) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Binder object is null.", e2);
                AppMethodBeat.o(5418);
                throw illegalArgumentException2;
            } catch (IllegalAccessException e3) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                AppMethodBeat.o(5418);
                throw illegalArgumentException3;
            }
        } else {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("IObjectWrapper declared field not private!");
            AppMethodBeat.o(5418);
            throw illegalArgumentException4;
        }
    }

    public static <T> IObjectWrapper wrap(T t) {
        AppMethodBeat.i(5417);
        ObjectWrapper objectWrapper = new ObjectWrapper(t);
        AppMethodBeat.o(5417);
        return objectWrapper;
    }
}
