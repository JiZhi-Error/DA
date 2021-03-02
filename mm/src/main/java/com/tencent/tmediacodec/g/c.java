package com.tencent.tmediacodec.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c {
    public static final Class<?>[] SmY = new Class[0];
    public static final Object[] SmZ = new Object[0];

    private static Field m(Class<?> cls, String str) {
        AppMethodBeat.i(190191);
        Field field = null;
        try {
            field = cls.getDeclaredField(str);
        } catch (NoSuchFieldException e2) {
            Class<? super Object> superclass = cls.getSuperclass();
            while (field == null && superclass != null) {
                try {
                    field = superclass.getDeclaredField(str);
                } catch (NoSuchFieldException e3) {
                    superclass = superclass.getSuperclass();
                }
            }
        }
        AppMethodBeat.o(190191);
        return field;
    }

    public static Field k(Class<?> cls, String str) {
        AppMethodBeat.i(190192);
        Field m = m(cls, str);
        AppMethodBeat.o(190192);
        return m;
    }
}
