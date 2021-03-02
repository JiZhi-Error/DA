package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.g.b;

public final class e implements i {
    private static int jSq = 20;
    private static int jSr = 20;
    private static int jSs = 20;
    private static long jSt = 4000000;
    private static long jSu = 200000;
    b jSi;
    public String jSv = "";
    public String jSw = "";

    public e() {
    }

    public e(String str, String str2) {
        this.jSv = str;
        this.jSw = str2;
    }

    public static int bmf() {
        AppMethodBeat.i(63326);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(jSq))).intValue();
        AppMethodBeat.o(63326);
        return intValue;
    }

    public static int bmg() {
        AppMethodBeat.i(63327);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(jSs))).intValue();
        AppMethodBeat.o(63327);
        return intValue;
    }

    public static long bmh() {
        AppMethodBeat.i(63328);
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(jSu))).longValue();
        AppMethodBeat.o(63328);
        return longValue;
    }

    public static int bmi() {
        AppMethodBeat.i(212940);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_AA_DEFAULT_INT, (Object) 2)).intValue();
        AppMethodBeat.o(212940);
        return intValue;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63329);
        Log.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            p pVar = ((com.tencent.mm.plugin.aa.model.cgi.i) qVar).jTl;
            Log.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s,response.default_mod:%s", Integer.valueOf(pVar.dDN), pVar.qwn, Integer.valueOf(pVar.jTs), Integer.valueOf(pVar.jTt), Integer.valueOf(pVar.jTu), Long.valueOf(pVar.jTv), Long.valueOf(pVar.jTw), pVar.jTx, pVar.jTy, Integer.valueOf(pVar.KBJ));
            if (pVar.dDN == 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(pVar.jTs));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_RECEIVER_NUM_INT, Integer.valueOf(pVar.jTt));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(pVar.jTu));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_TOTAL_AMOUNT_LONG, Long.valueOf(pVar.jTv));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(pVar.jTw));
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_AA_DEFAULT_INT, Integer.valueOf(pVar.KBJ));
                h.INSTANCE.idkeyStat(407, 33, 1, false);
                com.tencent.mm.vending.g.g.a(this.jSi, new e(pVar.jTy, pVar.jTx));
                AppMethodBeat.o(63329);
                return;
            }
            com.tencent.mm.vending.g.g.hdx().ej(Boolean.FALSE);
            h.INSTANCE.idkeyStat(407, 35, 1, false);
            AppMethodBeat.o(63329);
            return;
        }
        com.tencent.mm.vending.g.g.hdx().ej(Boolean.FALSE);
        h.INSTANCE.idkeyStat(407, 34, 1, false);
        AppMethodBeat.o(63329);
    }

    public static void a(n nVar) {
        AppMethodBeat.i(63330);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(nVar.jTs));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_RECEIVER_NUM_INT, Integer.valueOf(nVar.jTt));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(nVar.jTu));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_TOTAL_AMOUNT_LONG, Long.valueOf(nVar.jTv));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(nVar.jTw));
        AppMethodBeat.o(63330);
    }
}
