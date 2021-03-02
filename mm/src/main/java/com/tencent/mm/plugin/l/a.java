package com.tencent.mm.plugin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import java.util.List;

public final class a {
    private static List<C1455a> yOP;
    private static String yOQ;

    /* renamed from: com.tencent.mm.plugin.l.a$a  reason: collision with other inner class name */
    public static class C1455a {
        public String mRa;
        public int yOR;
        public SKBuiltinBuffer_t yOS;
    }

    public static synchronized void z(String str, List<C1455a> list) {
        synchronized (a.class) {
            yOQ = str;
            yOP = list;
        }
    }

    public static synchronized List<C1455a> aDm(String str) {
        List<C1455a> list;
        synchronized (a.class) {
            AppMethodBeat.i(116063);
            if (str == null || !str.equals(yOQ)) {
                list = null;
                AppMethodBeat.o(116063);
            } else {
                list = yOP;
                AppMethodBeat.o(116063);
            }
        }
        return list;
    }
}
