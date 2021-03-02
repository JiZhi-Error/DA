package com.tencent.matrix.report;

import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/matrix/report/MatrixFinderReporter;", "", "()V", "ID_KEY", "", "KV_ID", "getDeviceLevelIndex", "level", "", "getDeviceLevelSnsIndex", "isAddressScene", "", "scene", "isCareScene", "isChattingScene", "isFinderScene", "isFinderTlScene", "isSnsTlScene", "onAnr", "", "onFPS", "content", "Lorg/json/JSONObject;", "plugin-report_release"})
public final class e {
    public static final e cWi = new e();

    private e() {
    }

    public static boolean eD(String str) {
        p.h(str, "scene");
        return n.nm(str, "SnsTimeLineUI");
    }

    public static boolean eE(String str) {
        p.h(str, "scene");
        return n.a((CharSequence) str, (CharSequence) "Finder", false);
    }

    public static boolean eF(String str) {
        p.h(str, "scene");
        return n.nm(str, "ChattingUIFragment") || n.nm(str, "ChattingUI");
    }

    public static boolean eG(String str) {
        p.h(str, "scene");
        return n.nm(str, "AddressUIFragment");
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0013 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int eH(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2021012075: goto L_0x0021;
                case 2035172: goto L_0x0016;
                case 2217378: goto L_0x000a;
                default: goto L_0x0007;
            }
        L_0x0007:
            r0 = 20
        L_0x0009:
            return r0
        L_0x000a:
            java.lang.String r0 = "HIGH"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
        L_0x0013:
            r0 = 10
            goto L_0x0009
        L_0x0016:
            java.lang.String r0 = "BEST"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0009
        L_0x0021:
            java.lang.String r0 = "MIDDLE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            goto L_0x0013
            switch-data {-2021012075->0x0021, 2035172->0x0016, 2217378->0x000a, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.report.e.eH(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int eI(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2021012075: goto L_0x001f;
                case 2035172: goto L_0x0014;
                case 2217378: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            r0 = 6
        L_0x0008:
            return r0
        L_0x0009:
            java.lang.String r0 = "HIGH"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
        L_0x0012:
            r0 = 3
            goto L_0x0008
        L_0x0014:
            java.lang.String r0 = "BEST"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0008
        L_0x001f:
            java.lang.String r0 = "MIDDLE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            goto L_0x0012
            switch-data {-2021012075->0x001f, 2035172->0x0014, 2217378->0x0009, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.report.e.eI(java.lang.String):int");
    }
}
