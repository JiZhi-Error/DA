package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.plugin.expt.hellhound.a.g.e;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c implements com.tencent.mm.plugin.expt.b.c {
    private static c sIw;

    private c() {
    }

    public static c cPU() {
        AppMethodBeat.i(122091);
        if (sIw == null) {
            synchronized (c.class) {
                try {
                    sIw = new c();
                } catch (Throwable th) {
                    AppMethodBeat.o(122091);
                    throw th;
                }
            }
        }
        c cVar = sIw;
        AppMethodBeat.o(122091);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final void gk(String str, String str2) {
        AppMethodBeat.i(122092);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(122092);
            return;
        }
        Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", Integer.valueOf(hashCode()), str, str2);
        cbn cbn = new cbn();
        cbn.businessId = str;
        cbn.value = str2;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(500, cbn);
        AppMethodBeat.o(122092);
    }

    public static void gs(String str, String str2) {
        AppMethodBeat.i(122094);
        Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", str, str2);
        kp kpVar = new kp();
        kpVar.dPH.dPI = str;
        kpVar.dPH.dPJ = str2;
        EventCenter.instance.publish(kpVar);
        AppMethodBeat.o(122094);
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final void aa(String str, String str2, String str3) {
        AppMethodBeat.i(122095);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(122095);
            return;
        }
        Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", Integer.valueOf(hashCode()), str, str2, str3);
        Log.i("HABBYGE-MALI.AsyncBizCollector", "collectBizData: %s, %s, %s", str, str2, str3);
        cbn cbn = new cbn();
        cbn.businessId = str3;
        cbn.value = str2;
        cbn.dataPath = str;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(502, cbn);
        AppMethodBeat.o(122095);
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final String cMD() {
        AppMethodBeat.i(169347);
        String cPV = d.cPV();
        Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", cPV);
        AppMethodBeat.o(169347);
        return cPV;
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final String cME() {
        AppMethodBeat.i(184373);
        String cPR = b.cPO().cPR();
        AppMethodBeat.o(184373);
        return cPR;
    }

    public static void gt(String str, String str2) {
        AppMethodBeat.i(122096);
        Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", str, str2);
        kr krVar = new kr();
        krVar.dPL.dPI = str;
        krVar.dPL.dPM = str2;
        EventCenter.instance.publish(krVar);
        AppMethodBeat.o(122096);
    }

    public static void gu(String str, String str2) {
        AppMethodBeat.i(122097);
        Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", str, str2);
        kq kqVar = new kq();
        kqVar.dPK.dPI = str;
        kqVar.dPK.sessionId = str2;
        EventCenter.instance.publish(kqVar);
        AppMethodBeat.o(122097);
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final Map<String, Boolean> cMF() {
        AppMethodBeat.i(184374);
        e cQV = e.cQV();
        if (cQV.sDg == null) {
            AppMethodBeat.o(184374);
            return null;
        }
        Map<String, Boolean> map = cQV.sDg.sBj;
        if (map == null || map.isEmpty()) {
            Map<String, com.tencent.mm.plugin.expt.hellhound.a.a.c> map2 = cQV.sDg.sBi;
            if (map2 == null || map2.isEmpty()) {
                AppMethodBeat.o(184374);
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.tencent.mm.plugin.expt.hellhound.a.a.c> entry : map2.entrySet()) {
                if (entry != null) {
                    hashMap.put(entry.getKey(), Boolean.valueOf(entry.getValue().sBK.isAd));
                }
            }
            if (hashMap.isEmpty()) {
                AppMethodBeat.o(184374);
                return null;
            }
            AppMethodBeat.o(184374);
            return hashMap;
        }
        AppMethodBeat.o(184374);
        return map;
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final String cMG() {
        AppMethodBeat.i(220557);
        String str = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw + "_" + com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx;
        AppMethodBeat.o(220557);
        return str;
    }

    @Override // com.tencent.mm.plugin.expt.b.c
    public final void aoe(String str) {
        AppMethodBeat.i(122093);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(501, str);
        AppMethodBeat.o(122093);
    }
}
