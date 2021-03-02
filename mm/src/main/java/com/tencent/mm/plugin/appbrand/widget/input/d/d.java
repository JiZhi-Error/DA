package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class d {
    private static int aJ(Class cls) {
        AppMethodBeat.i(131529);
        if (!cls.isEnum()) {
            AppMethodBeat.o(131529);
            return 0;
        }
        int i2 = 0;
        for (Object obj : cls.getEnumConstants()) {
            i2 = Math.max(((Enum) obj).name().length(), i2);
        }
        AppMethodBeat.o(131529);
        return i2;
    }

    static <T extends Enum> T h(String str, Class<T> cls) {
        AppMethodBeat.i(131530);
        int aJ = aJ(cls);
        if (Util.isNullOrNil(str) || str.length() > aJ) {
            AppMethodBeat.o(131530);
            return null;
        }
        String upperCase = str.toUpperCase();
        T[] enumConstants = cls.getEnumConstants();
        for (T t : enumConstants) {
            if (upperCase.equals(t.name())) {
                T t2 = t;
                AppMethodBeat.o(131530);
                return t2;
            }
        }
        AppMethodBeat.o(131530);
        return null;
    }

    public static Integer cG(Object obj) {
        AppMethodBeat.i(131531);
        if (obj == null) {
            AppMethodBeat.o(131531);
            return null;
        } else if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            AppMethodBeat.o(131531);
            return num;
        } else if (obj instanceof Number) {
            Integer valueOf = Integer.valueOf(((Number) obj).intValue());
            AppMethodBeat.o(131531);
            return valueOf;
        } else {
            if (obj instanceof String) {
                try {
                    Integer valueOf2 = Integer.valueOf((int) Double.parseDouble((String) obj));
                    AppMethodBeat.o(131531);
                    return valueOf2;
                } catch (NumberFormatException e2) {
                }
            }
            AppMethodBeat.o(131531);
            return null;
        }
    }
}
