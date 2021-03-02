package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a extends com.tencent.mm.plugin.backup.b.a {
    private static String END = "img";
    private static String oNQ = "icon_";
    private static String oNR = "iphone";
    private static String oNS = "android";
    private static String oNT = "s60v3";
    private static String oNU = "s60v5";
    private static a oRc;
    private Map<String, C0836a> oNW = null;

    public static C0836a agN(String str) {
        AppMethodBeat.i(21820);
        if (oRc == null) {
            oRc = new a();
        }
        a aVar = oRc;
        if (aVar.oNW == null) {
            aVar.cfY();
        }
        for (C0836a aVar2 : aVar.oNW.values()) {
            if (aVar2.oNY != null && aVar2.oNY.equals(str)) {
                AppMethodBeat.o(21820);
                return aVar2;
            }
        }
        AppMethodBeat.o(21820);
        return null;
    }

    public static C0836a agO(String str) {
        AppMethodBeat.i(21821);
        if (oRc == null) {
            a aVar = new a();
            oRc = aVar;
            a(aVar);
        }
        a aVar2 = oRc;
        if (aVar2.oNW == null) {
            aVar2.cfY();
        }
        C0836a aVar3 = aVar2.oNW.get(str);
        AppMethodBeat.o(21821);
        return aVar3;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oRc = null;
    }

    public a() {
        AppMethodBeat.i(21822);
        cfY();
        AppMethodBeat.o(21822);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081 A[SYNTHETIC, Splitter:B:26:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086 A[Catch:{ Exception -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac A[SYNTHETIC, Splitter:B:37:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A[Catch:{ Exception -> 0x00f0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cfY() {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.b.a.cfY():void");
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.a$a  reason: collision with other inner class name */
    public static class C0836a {
        public String oNX = "";
        public String oNY = "";
        public String oNZ = "";
        public String oOa = "";

        public C0836a() {
        }

        public C0836a(String str, String str2, String str3, String str4) {
            this.oNX = str;
            this.oNY = str2;
            this.oNZ = str3;
            this.oOa = str4;
        }

        public final String toString() {
            AppMethodBeat.i(21819);
            String str = this.oNX + " " + this.oNY + " " + this.oNZ + " " + this.oOa;
            AppMethodBeat.o(21819);
            return str;
        }
    }
}
