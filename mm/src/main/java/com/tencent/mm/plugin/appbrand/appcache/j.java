package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface j {
    public static final int[] kKu = {0, 10002, 10102, 6};
    public static final int[] kKv = {1, 2, 999, 10000, 10001, 10100, 10101};

    public enum a {
        ;

        public static a valueOf(String str) {
            AppMethodBeat.i(123487);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(123487);
            return aVar;
        }

        public static boolean vP(int i2) {
            AppMethodBeat.i(123488);
            boolean contains = com.tencent.mm.compatible.loader.a.contains(j.kKu, i2);
            AppMethodBeat.o(123488);
            return contains;
        }

        public static boolean sE(int i2) {
            AppMethodBeat.i(123489);
            boolean contains = com.tencent.mm.compatible.loader.a.contains(j.kKv, i2);
            AppMethodBeat.o(123489);
            return contains;
        }

        public static boolean isValid(int i2) {
            AppMethodBeat.i(225275);
            if (com.tencent.mm.compatible.loader.a.contains(j.kKu, i2) || com.tencent.mm.compatible.loader.a.contains(j.kKv, i2)) {
                AppMethodBeat.o(225275);
                return true;
            }
            AppMethodBeat.o(225275);
            return false;
        }
    }
}
