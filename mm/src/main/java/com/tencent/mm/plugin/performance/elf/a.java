package com.tencent.mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a {
    public static HashMap<Class, AbstractProcessChecker> map = new HashMap<>();

    static {
        AppMethodBeat.i(124995);
        AppMethodBeat.o(124995);
    }

    public static <T extends AbstractProcessChecker> T aU(Class<? extends AbstractProcessChecker> cls) {
        AppMethodBeat.i(124994);
        if (map.containsKey(cls)) {
            T t = (T) map.get(cls);
            AppMethodBeat.o(124994);
            return t;
        }
        try {
            T t2 = (T) ((AbstractProcessChecker) cls.newInstance());
            map.put(cls, t2);
            AppMethodBeat.o(124994);
            return t2;
        } catch (IllegalAccessException | InstantiationException e2) {
            AppMethodBeat.o(124994);
            return null;
        }
    }
}
