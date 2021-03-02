package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static b lbh = new h();
    private static boolean lbi;
    private static final Set<String> lbj = new HashSet();

    static {
        AppMethodBeat.i(146105);
        AppMethodBeat.o(146105);
    }

    public static void WM(String str) {
        AppMethodBeat.i(146089);
        if (str.length() == 0) {
            AppMethodBeat.o(146089);
            return;
        }
        lbj.add(str);
        AppMethodBeat.o(146089);
    }

    public static void WN(String str) {
        AppMethodBeat.i(146090);
        if (str.length() == 0) {
            AppMethodBeat.o(146090);
            return;
        }
        lbj.remove(str);
        AppMethodBeat.o(146090);
    }

    public static boolean WO(String str) {
        AppMethodBeat.i(146091);
        if (str.length() == 0) {
            AppMethodBeat.o(146091);
            return false;
        }
        boolean contains = lbj.contains(str);
        AppMethodBeat.o(146091);
        return contains;
    }

    public static void gT(boolean z) {
        lbi = z;
    }

    public static boolean bzy() {
        return lbi;
    }

    private static boolean WP(String str) {
        AppMethodBeat.i(146092);
        if (!lbi || !lbj.contains(str)) {
            AppMethodBeat.o(146092);
            return false;
        }
        AppMethodBeat.o(146092);
        return true;
    }

    private static boolean WQ(String str) {
        AppMethodBeat.i(146093);
        if (!lbi) {
            AppMethodBeat.o(146093);
            return false;
        }
        CollectSession WJ = lbh.WJ(str);
        if (WJ == null) {
            AppMethodBeat.o(146093);
            return false;
        } else if (!lbj.contains(WJ.groupId)) {
            AppMethodBeat.o(146093);
            return false;
        } else {
            AppMethodBeat.o(146093);
            return true;
        }
    }

    public static void clear() {
        AppMethodBeat.i(146094);
        if (!lbi) {
            AppMethodBeat.o(146094);
            return;
        }
        lbh.clear();
        AppMethodBeat.o(146094);
    }

    public static void c(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(146095);
        if (!WP(str)) {
            AppMethodBeat.o(146095);
            return;
        }
        lbh.c(str, str2, str3, z);
        AppMethodBeat.o(146095);
    }

    public static void cQ(String str, String str2) {
        AppMethodBeat.i(146096);
        if (!WQ(str)) {
            AppMethodBeat.o(146096);
            return;
        }
        lbh.cQ(str, str2);
        AppMethodBeat.o(146096);
    }

    public static void a(CollectSession collectSession) {
        AppMethodBeat.i(146097);
        if (collectSession == null) {
            AppMethodBeat.o(146097);
        } else if (!WP(collectSession.groupId)) {
            AppMethodBeat.o(146097);
        } else {
            lbh.a(collectSession);
            AppMethodBeat.o(146097);
        }
    }

    public static CollectSession cP(String str, String str2) {
        AppMethodBeat.i(146098);
        if (!WQ(str)) {
            AppMethodBeat.o(146098);
            return null;
        }
        CollectSession cP = lbh.cP(str, str2);
        AppMethodBeat.o(146098);
        return cP;
    }

    public static void k(String str, String str2, boolean z) {
        AppMethodBeat.i(146099);
        if (!WQ(str)) {
            AppMethodBeat.o(146099);
            return;
        }
        lbh.k(str, str2, z);
        AppMethodBeat.o(146099);
    }

    public static CollectSession WJ(String str) {
        AppMethodBeat.i(146100);
        if (!WQ(str)) {
            AppMethodBeat.o(146100);
            return null;
        }
        CollectSession WJ = lbh.WJ(str);
        AppMethodBeat.o(146100);
        return WJ;
    }

    public static CollectSession WK(String str) {
        AppMethodBeat.i(146101);
        if (!lbi) {
            AppMethodBeat.o(146101);
            return null;
        }
        CollectSession WK = lbh.WK(str);
        AppMethodBeat.o(146101);
        return WK;
    }

    public static void print(String str) {
        AppMethodBeat.i(146102);
        if (!WQ(str)) {
            AppMethodBeat.o(146102);
            return;
        }
        lbh.print(str);
        AppMethodBeat.o(146102);
    }

    public static int cR(String str, String str2) {
        AppMethodBeat.i(146103);
        if (!WP(str)) {
            AppMethodBeat.o(146103);
            return 0;
        }
        int cR = lbh.cR(str, str2);
        AppMethodBeat.o(146103);
        return cR;
    }

    public static StringBuilder WL(String str) {
        AppMethodBeat.i(146104);
        if (!WP(str)) {
            StringBuilder sb = new StringBuilder();
            AppMethodBeat.o(146104);
            return sb;
        }
        StringBuilder WL = lbh.WL(str);
        AppMethodBeat.o(146104);
        return WL;
    }
}
