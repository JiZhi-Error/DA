package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class co {
    public static int getInt(Object obj, int i2) {
        AppMethodBeat.i(150191);
        if (obj instanceof Integer) {
            try {
                i2 = ((Integer) obj).intValue();
                AppMethodBeat.o(150191);
            } catch (Exception e2) {
            }
            return i2;
        }
        AppMethodBeat.o(150191);
        return i2;
    }

    public static String c(Object obj, String str) {
        if (obj instanceof String) {
            try {
                return (String) obj;
            } catch (Exception e2) {
            }
        }
        return str;
    }

    public static boolean cg(Object obj) {
        AppMethodBeat.i(150192);
        if (obj instanceof Boolean) {
            try {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                AppMethodBeat.o(150192);
                return booleanValue;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(150192);
        return false;
    }
}
