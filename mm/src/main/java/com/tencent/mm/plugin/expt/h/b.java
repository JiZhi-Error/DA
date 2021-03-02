package com.tencent.mm.plugin.expt.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static b sLn;
    private String sLl = null;
    private String sLm = null;

    public static b cRI() {
        AppMethodBeat.i(215259);
        if (sLn == null) {
            sLn = new b();
        }
        b bVar = sLn;
        AppMethodBeat.o(215259);
        return bVar;
    }

    protected b() {
    }

    public final MultiProcessMMKV cRJ() {
        AppMethodBeat.i(215260);
        d.cRY();
        int uin = d.getUin();
        if (uin == 0) {
            AppMethodBeat.o(215260);
            return null;
        }
        String str = uin + "_WxExptAppIdMmkv";
        if (!Util.isEqual(this.sLl, str)) {
            Log.i("MicroMsg.ExptAppManager", "%s get exptId mmkv change uin old[%s] new[%s]", info(), this.sLl, str);
            this.sLl = str;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.sLl);
        AppMethodBeat.o(215260);
        return mmkv;
    }

    public MultiProcessMMKV cRK() {
        AppMethodBeat.i(215261);
        d.cRY();
        int uin = d.getUin();
        if (uin == 0) {
            AppMethodBeat.o(215261);
            return null;
        }
        String str = uin + "_WxExptAppKeyMmkv";
        if (!Util.isEqual(this.sLm, str)) {
            Log.i("MicroMsg.ExptAppManager", "%s get exptKey mmkv change uin old[%s] new[%s]", info(), this.sLm, str);
            this.sLm = str;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.sLm);
        AppMethodBeat.o(215261);
        return mmkv;
    }

    public final boolean removeAll() {
        AppMethodBeat.i(215262);
        try {
            cRJ().clear().commit();
            cRK().clear().commit();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(215262);
        return true;
    }

    public final List<a> cRL() {
        AppMethodBeat.i(215263);
        ArrayList arrayList = new ArrayList();
        MultiProcessMMKV cRJ = cRJ();
        if (cRJ == null) {
            AppMethodBeat.o(215263);
        } else {
            String[] allKeys = cRJ.allKeys();
            if (allKeys != null && allKeys.length > 0) {
                for (String str : allKeys) {
                    String string = cRJ.getString(str, "");
                    if (!Util.isNullOrNil(string)) {
                        a aVar = new a();
                        if (aVar.TN(string)) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            AppMethodBeat.o(215263);
        }
        return arrayList;
    }

    public final a HA(int i2) {
        AppMethodBeat.i(215264);
        MultiProcessMMKV cRJ = cRJ();
        if (cRJ == null) {
            AppMethodBeat.o(215264);
            return null;
        }
        String string = cRJ.getString(String.valueOf(i2), "");
        if (!Util.isNullOrNil(string)) {
            a aVar = new a();
            if (aVar.TN(string)) {
                AppMethodBeat.o(215264);
                return aVar;
            }
        }
        AppMethodBeat.o(215264);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r6, java.lang.String r7, com.tencent.mm.pointers.PString r8) {
        /*
            r5 = this;
            r4 = 215265(0x348e1, float:3.0165E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r1 = 0
            int r0 = r5.ari(r6)
            if (r0 <= 0) goto L_0x003f
            com.tencent.mm.plugin.expt.h.a r2 = r5.HA(r0)
            if (r2 == 0) goto L_0x003f
            boolean r0 = r2.isReady()
            if (r0 == 0) goto L_0x003f
            java.util.HashMap r0 = r2.cRH()
            if (r0 == 0) goto L_0x003f
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x003f
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            r8.value = r0
            java.lang.String r0 = r8.value
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 != 0) goto L_0x003f
            int r0 = r2.sLf
        L_0x0037:
            if (r0 > 0) goto L_0x003b
            r8.value = r7
        L_0x003b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x003f:
            r0 = r1
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.h.b.a(java.lang.String, java.lang.String, com.tencent.mm.pointers.PString):int");
    }

    private int ari(String str) {
        int i2 = 0;
        AppMethodBeat.i(215266);
        try {
            i2 = cRK().getInt(str, 0);
            AppMethodBeat.o(215266);
        } catch (Exception e2) {
            AppMethodBeat.o(215266);
        }
        return i2;
    }

    private String info() {
        AppMethodBeat.i(215267);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(215267);
        return sb;
    }
}
