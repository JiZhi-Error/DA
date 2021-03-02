package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;

public final class a {
    private static final c sIS = new c() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.f.g.a.AnonymousClass1 */

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(184386);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(184386);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    };
    private static volatile boolean sIT = false;

    public static boolean arb(String str) {
        AppMethodBeat.i(122266);
        String aqn = b.aqn(str);
        if ("124".equals(aqn) || "109".equals(aqn)) {
            AppMethodBeat.o(122266);
            return true;
        }
        AppMethodBeat.o(122266);
        return false;
    }

    public static void arc(String str) {
        AppMethodBeat.i(169363);
        if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoR(str)) {
            AppMethodBeat.o(169363);
            return;
        }
        Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, startMonitor: %s", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("goBack", "()V"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(hashMap, sIS);
        AppMethodBeat.o(169363);
    }

    public static void ard(String str) {
        AppMethodBeat.i(169364);
        if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoR(str)) {
            AppMethodBeat.o(169364);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS);
        AppMethodBeat.o(169364);
    }

    public static void cQK() {
        AppMethodBeat.i(169365);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("goBack", "()V"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.b(hashMap, sIS);
        AppMethodBeat.o(169365);
    }

    static {
        AppMethodBeat.i(169369);
        AppMethodBeat.o(169369);
    }

    public static void Dx(long j2) {
        AppMethodBeat.i(184387);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.ScanSessionHandler", "baseScanUIGoBack, session End !!");
            AppMethodBeat.o(184387);
            return;
        }
        Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, baseScanUIGoBack: %s", cQo.sessionId);
        if (arb(cQo.sessionId)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(cQo, j2);
        }
        AppMethodBeat.o(184387);
    }

    public static void y(String str, int i2, long j2) {
        AppMethodBeat.i(220594);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            AppMethodBeat.o(220594);
            return;
        }
        Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, curSession: %s, %s", cQo.sessionId, str);
        if (arb(cQo.sessionId)) {
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
                c(cQo, aoE, i2, j2);
            } else if (!sIT) {
                sIT = true;
                c(cQo, aoE, i2, j2);
                AppMethodBeat.o(220594);
                return;
            } else {
                sIT = false;
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(cQo, j2);
                AppMethodBeat.o(220594);
                return;
            }
        }
        AppMethodBeat.o(220594);
    }

    private static void c(cyl cyl, String str, int i2, long j2) {
        AppMethodBeat.i(220595);
        if (cyl == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(220595);
            return;
        }
        if (arb(cyl.sessionId)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(cyl, str, i2, j2);
        }
        AppMethodBeat.o(220595);
    }
}
