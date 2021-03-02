package com.tencent.mm.danmaku.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c {
    public static Object b(Class<?> cls, String str, Object obj) {
        AppMethodBeat.i(241783);
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            AppMethodBeat.o(241783);
            return obj2;
        } catch (Exception e2) {
            AppMethodBeat.o(241783);
            return null;
        }
    }
}
