package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
public final class zzabn implements PrivilegedExceptionAction<Unsafe> {
    zzabn() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.security.PrivilegedExceptionAction
    public final /* synthetic */ Unsafe run() {
        AppMethodBeat.i(40215);
        Field[] declaredFields = Unsafe.class.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                Unsafe unsafe = (Unsafe) Unsafe.class.cast(obj);
                AppMethodBeat.o(40215);
                return unsafe;
            }
        }
        AppMethodBeat.o(40215);
        return null;
    }
}
