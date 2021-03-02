package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    public static void Dv(long j2) {
        AppMethodBeat.i(184375);
        String valueOf = String.valueOf(j2);
        int uin = b.getUin();
        if (uin != 0) {
            if (valueOf == null) {
                valueOf = "";
            }
            try {
                com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenPageFlRptChe_".concat(String.valueOf(uin)), valueOf);
                AppMethodBeat.o(184375);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDao", e2, "HellSessionReportCache.writeBackOfFlow", new Object[0]);
            }
        }
        AppMethodBeat.o(184375);
    }

    public static String cQu() {
        String string;
        AppMethodBeat.i(122156);
        int uin = b.getUin();
        if (uin == 0) {
            string = "-1";
        } else {
            string = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenPageFlRptChe_".concat(String.valueOf(uin)));
            if (string == null || string.isEmpty()) {
                string = null;
            }
        }
        String aqJ = d.aqJ(string);
        AppMethodBeat.o(122156);
        return aqJ;
    }
}
