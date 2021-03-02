package com.tencent.wework.api.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class ReflecterHelper {
    public static Object newInstance(String str) {
        AppMethodBeat.i(106557);
        Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance(null);
        AppMethodBeat.o(106557);
        return newInstance;
    }
}
