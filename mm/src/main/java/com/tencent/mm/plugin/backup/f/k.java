package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k extends com.tencent.mm.plugin.backup.b.a {
    private static String END = "img";
    private static String oNQ = "icon_";
    private static String oNR = "iphone";
    private static String oNS = "android";
    private static String oNT = "s60v3";
    private static String oNU = "s60v5";
    private static k oNV;
    private Map<String, a> oNW = null;

    public static a agG(String str) {
        AppMethodBeat.i(21532);
        if (oNV == null) {
            oNV = new k();
        }
        k kVar = oNV;
        if (kVar.oNW == null) {
            kVar.cfY();
        }
        for (a aVar : kVar.oNW.values()) {
            if (aVar.oNY != null && aVar.oNY.equals(str)) {
                AppMethodBeat.o(21532);
                return aVar;
            }
        }
        AppMethodBeat.o(21532);
        return null;
    }

    public static a agH(String str) {
        AppMethodBeat.i(21533);
        if (oNV == null) {
            k kVar = new k();
            oNV = kVar;
            a(kVar);
        }
        k kVar2 = oNV;
        if (kVar2.oNW == null) {
            kVar2.cfY();
        }
        a aVar = kVar2.oNW.get(str);
        AppMethodBeat.o(21533);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oNV = null;
    }

    public k() {
        AppMethodBeat.i(21534);
        cfY();
        AppMethodBeat.o(21534);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.f.k.cfY():void");
    }

    public static class a {
        public String oNX = "";
        public String oNY = "";
        public String oNZ = "";
        public String oOa = "";

        public a() {
        }

        public a(String str, String str2, String str3, String str4) {
            this.oNX = str;
            this.oNY = str2;
            this.oNZ = str3;
            this.oOa = str4;
        }

        public final String toString() {
            AppMethodBeat.i(21531);
            String str = this.oNX + " " + this.oNY + " " + this.oNZ + " " + this.oOa;
            AppMethodBeat.o(21531);
            return str;
        }
    }
}
